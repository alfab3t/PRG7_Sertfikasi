package id.co.prg7_sertfikasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Prg7SertfikasiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Prg7SertfikasiApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "Roni") String name) {
        return String.format("Hello %s!", name);
    }
}
