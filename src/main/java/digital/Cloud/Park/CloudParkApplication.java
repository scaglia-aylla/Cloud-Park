package digital.Cloud.Park;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/")
public class CloudParkApplication {

	public static void main(String[] args) {

		SpringApplication.run(CloudParkApplication.class, args);
	}

}
