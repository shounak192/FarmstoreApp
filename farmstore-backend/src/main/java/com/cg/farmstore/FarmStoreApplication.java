package com.cg.farmstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cg.farmstore.entities.Credentials;
import com.cg.farmstore.entities.UserType;
import com.cg.farmstore.service.AdminServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "FarmStore API", version = "1.0", description = "An online store to facilitate the farmers and suppliers to sell and buy the freshly grown items directly."))
public class FarmStoreApplication {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(FarmStoreApplication.class, args);
		AdminServiceImpl adminServiceImpl= applicationContext.getBean(AdminServiceImpl.class);
		adminServiceImpl.saveUser(new Credentials("farmstore_admin","password", UserType.ADMIN));
	}

}
