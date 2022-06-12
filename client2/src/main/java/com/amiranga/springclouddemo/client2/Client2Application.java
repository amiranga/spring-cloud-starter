package com.amiranga.springclouddemo.client2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Client2Application {

	public static void main(String[] args) {
		SpringApplication.run(Client2Application.class, args);
	}

}


@FeignClient(name = "client")
interface ClientInterface {

	@RequestMapping("/client/makemelaugh")
	public String makemelaugh();
}

@RestController
class Client2HomeController {

	@Autowired
	ClientInterface clientInterface;

	@RequestMapping("/makemelaughfromclient")
	public String makemelaugh() {
		return clientInterface.makemelaugh();
	};
}