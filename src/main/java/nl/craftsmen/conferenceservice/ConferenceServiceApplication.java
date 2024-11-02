package nl.craftsmen.conferenceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class ConferenceserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceserviceApplication.class, args);
	}

}

@RestController
class ConferenController {

	@GetMapping("/conferences")
	public List<String> getConferences() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Running on thread: " + Thread.currentThread());
		return List.of("devoxx", "j-fall", "javazone");
	}

}
