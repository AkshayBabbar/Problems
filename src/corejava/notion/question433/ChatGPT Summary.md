To keep track of how many users are currently using a servlet-based web application running in a Tomcat server, we can use the concept of session tracking. In this approach, we will count the number of active sessions.

Here is how you can implement this:

### Step 1: Implement a `HttpSessionListener`

Create a class that implements `HttpSessionListener`. This listener will keep track of the session creation and destruction events.

#### SessionCounter.java
```java
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionCounter implements HttpSessionListener {

    private static final AtomicInteger activeSessions = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions.incrementAndGet();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions.decrementAndGet();
    }

    public static int getActiveSessions() {
        return activeSessions.get();
    }
}
```

### Step 2: Register the Listener in `web.xml`

You need to register the `SessionCounter` class as a listener in your `web.xml` file so that it can listen to session events.

#### web.xml
```xml
<web-app xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         version="2.5">
    
    <listener>
        <listener-class>com.example.SessionCounter</listener-class>
    </listener>
    
</web-app>
```

### Step 3: Display the Number of Active Sessions

You can now create a servlet that displays the number of active sessions by calling the `SessionCounter.getActiveSessions()` method.

#### ActiveUsersServlet.java
```java
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUsers")
public class ActiveUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int activeUsers = SessionCounter.getActiveSessions();
        resp.setContentType("text/plain");
        resp.getWriter().write("Number of active users: " + activeUsers);
    }
}
```

### Step 4: Configure the Servlet in `web.xml` (if not using annotations)

If you are not using annotations, you need to configure the servlet in the `web.xml` file.

#### web.xml
```xml
<web-app xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         version="2.5">
    
    <listener>
        <listener-class>com.example.SessionCounter</listener-class>
    </listener>
    
    <servlet>
        <servlet-name>ActiveUsersServlet</servlet-name>
        <servlet-class>com.example.ActiveUsersServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>ActiveUsersServlet</servlet-name>
        <url-pattern>/activeUsers</url-pattern>
    </servlet-mapping>
    
</web-app>
```

### Step 5: Testing the Implementation

Deploy the application on your Tomcat server and access the URL mapped to the `ActiveUsersServlet`. It should display the current number of active users.

### Notes

- **Thread Safety:** The use of `AtomicInteger` ensures that the increment and decrement operations on the session count are thread-safe.
- **Session Timeout:** The session count will automatically adjust based on the session timeout settings in your web application. When a session times out, the `sessionDestroyed` method will be called, decrementing the active session count.
- **Multiple Servers:** If your application is running in a clustered environment (multiple servers), you will need to consider a distributed approach to count the sessions across all nodes. This can be achieved using a distributed caching system like Redis or Hazelcast to maintain the session count.

This approach provides a simple yet effective way to track the number of active users in your web application.