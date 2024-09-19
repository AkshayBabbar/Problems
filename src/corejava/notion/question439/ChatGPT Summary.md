### PUT vs. POST vs. PATCH in HTTP

HTTP defines several methods for interacting with resources on a server. Among them, `PUT`, `POST`, and `PATCH` are commonly used for creating and updating resources. Understanding the differences between these methods is crucial for designing RESTful APIs.

#### PUT

- **Purpose:** The `PUT` method is used to update a resource or create a resource if it does not exist.
- **Idempotency:** `PUT` is idempotent, meaning multiple identical `PUT` requests should have the same effect as a single request. This means that if you `PUT` the same resource multiple times, the state of the resource will be the same.
- **Full Update:** `PUT` generally requires the entire resource representation to be sent in the request body, even if only part of it is being updated.
- **Usage Example:**
    - URL: `/users/123`
    - Request Body:
      ```json
      {
        "id": 123,
        "name": "John Doe",
        "email": "john.doe@example.com"
      }
      ```

#### POST

- **Purpose:** The `POST` method is used to create a new resource. It can also be used to submit data to a resource for processing.
- **Non-Idempotency:** `POST` is not idempotent, meaning multiple identical `POST` requests may result in different effects, such as creating multiple resources.
- **Partial Data:** `POST` does not necessarily require the entire resource representation and can be used for partial data submission.
- **Usage Example:**
    - URL: `/users`
    - Request Body:
      ```json
      {
        "name": "John Doe",
        "email": "john.doe@example.com"
      }
      ```

#### PATCH

- **Purpose:** The `PATCH` method is used to apply partial modifications to a resource.
- **Idempotency:** `PATCH` is not necessarily idempotent, though it can be if the operations it performs are idempotent.
- **Partial Update:** `PATCH` allows updating only the fields that need to be modified rather than sending the entire resource.
- **Usage Example:**
    - URL: `/users/123`
    - Request Body:
      ```json
      {
        "email": "john.newemail@example.com"
      }
      ```

### Practical Example in Spring Boot

Here is how you might implement `PUT`, `POST`, and `PATCH` methods in a Spring Boot application.

#### Controller Example

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Logic to create a new user
        // Assume userService.save(user) returns the saved user with an ID
        User createdUser = userService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        // Logic to update a user
        // Assume userService.update(id, user) returns the updated user
        User updatedUser = userService.update(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> partiallyUpdateUser(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        // Logic to update part of a user
        // Assume userService.partialUpdate(id, updates) returns the updated user
        User updatedUser = userService.partialUpdate(id, updates);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
```

#### Service Example

```java
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    public User save(User user) {
        // Logic to save a user
        return user;
    }

    public User update(Long id, User user) {
        // Logic to update a user
        // For example, fetching user by id and updating fields
        return user;
    }

    public User partialUpdate(Long id, Map<String, Object> updates) {
        // Logic to partially update a user
        // For example, fetching user by id and updating only the provided fields
        return user;
    }
}
```

### Summary

- **PUT**: Use for full updates or creation if the resource does not exist. It is idempotent.
- **POST**: Use for creating new resources or submitting data to a resource. It is not idempotent.
- **PATCH**: Use for partial updates. It is not necessarily idempotent.

By choosing the appropriate HTTP method, you can design a RESTful API that is intuitive and follows standard practices.