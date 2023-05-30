package aston;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloServlet {
    @GetMapping
    public String helloWorld() {
        return "Hello world8!";
    }
}