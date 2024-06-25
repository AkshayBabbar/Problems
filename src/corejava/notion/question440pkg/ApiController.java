package src.corejava.notion.question440pkg;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

    @GetMapping("/created")
    public ResponseEntity<String> created() {
        return new ResponseEntity<>("Resource created", HttpStatus.CREATED);
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/bad-request")
    public ResponseEntity<String> badRequest() {
        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/internal-server-error")
    public ResponseEntity<String> internalServerError() {
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}