### What is a Servlet?

A servlet is a Java programming language class that is used to extend the capabilities of servers that host applications accessed by means of a request-response programming model. Servlets are most commonly used to process or store a Java web application’s data.

#### Key Characteristics of Servlets:
1. **Server-Side Components:** Servlets run on the server side and handle client requests by generating responses dynamically.
2. **Request-Response Model:** They operate on the request-response model provided by the `HttpServlet` class. They can handle GET, POST, PUT, DELETE, and other HTTP methods.
3. **Platform-Independent:** They are platform-independent because they are written in Java.
4. **Lifecycle Methods:** The servlet lifecycle is managed by the servlet container (e.g., Apache Tomcat), which calls the following methods:
    - `init()`: Called once when the servlet is instantiated.
    - `service()`: Called every time the servlet handles a request. Depending on the HTTP method, it may delegate to `doGet()`, `doPost()`, etc.
    - `destroy()`: Called once when the servlet is being taken out of service.

#### Simple Servlet Example

```java
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("</body></html>");
    }
}
```

### What is ServletContext?

`ServletContext` is an interface that provides a way for servlets to communicate with the servlet container. It represents the web application context, and is used to share information between servlets and to access resources within the web application.

#### Key Features of ServletContext:
1. **Initialization Parameters:** It can access context-wide initialization parameters defined in the `web.xml` file.
2. **Attribute Sharing:** Servlets can share data with each other using attributes set in the `ServletContext`.
3. **Resource Access:** It provides methods to access resources (like HTML, CSS, and images) within the web application.
4. **Logging:** It can log messages, which are typically directed to the server’s log files.

#### ServletContext Methods:
- `getInitParameter(String name)`: Retrieves initialization parameters from the `web.xml`.
- `getAttribute(String name)`: Retrieves attributes shared between servlets.
- `setAttribute(String name, Object object)`: Sets attributes to share data between servlets.
- `getResource(String path)`: Returns the URL of a resource.
- `log(String message)`: Logs a message to the server’s log file.

#### Example Using ServletContext

Here's how you might use `ServletContext` in a servlet:

1. **web.xml** Configuration:
    ```xml
    <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 
                                 http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
             version="3.1">
        
        <context-param>
            <param-name>myContextParam</param-name>
            <param-value>Context Value</param-value>
        </context-param>
        
        <servlet>
            <servlet-name>contextServlet</servlet-name>
            <servlet-class>com.example.ContextServlet</servlet-class>
        </servlet>
        
        <servlet-mapping>
            <servlet-name>contextServlet</servlet-name>
            <url-pattern>/contextServlet</url-pattern>
        </servlet-mapping>
    </web-app>
    ```

2. **Servlet Code:**
    ```java
    import java.io.IOException;
    import java.io.PrintWriter;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.servlet.ServletContext;

    @WebServlet("/contextServlet")
    public class ContextServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ServletContext context = getServletContext();
            
            // Logging
            context.log("Handling GET request in ContextServlet");

            // Retrieving context parameter
            String contextParam = context.getInitParameter("myContextParam");

            // Setting an attribute
            context.setAttribute("sharedData", "This is shared data");

            // Writing response
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Context Parameter: " + contextParam + "</h1>");
            out.println("<h1>Shared Data: " + context.getAttribute("sharedData") + "</h1>");
            out.println("</body></html>");
        }
    }
    ```

### Summary

- **Servlet:** A Java class that handles HTTP requests and responses. It is used to build web applications.
- **ServletContext:** An interface that allows servlets to interact with the servlet container, share data, and access resources within the web application.

By using servlets and `ServletContext`, developers can create dynamic web applications that are both powerful and efficient.