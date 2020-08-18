package br.com.vinicius.door;

import br.com.vinicius.door.configuration.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class DoorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoorApplication.class, args);
	}

}
