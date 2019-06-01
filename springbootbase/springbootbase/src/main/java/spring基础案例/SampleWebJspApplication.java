package spring基础案例;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SampleWebJspApplication {

	public static void main(String[] args) {
		//启动了springboot程序，启动spring容器，启动内置的tomcat
		SpringApplication.run(SampleWebJspApplication.class, args);
	}

}