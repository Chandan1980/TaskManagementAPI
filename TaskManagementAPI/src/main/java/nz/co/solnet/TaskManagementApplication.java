package nz.co.solnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Task Management API", version = "1.0", description = "Task Management Information"))
public class TaskManagementApplication {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TaskManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);

	}
}