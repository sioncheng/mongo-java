package mongojava.github.com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
