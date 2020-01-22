package com.carlos.muroMensajes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MuroDeMensajesApplication {	

	public static void main(String[] args) {
		SpringApplication.run(MuroDeMensajesApplication.class, args);
		
		Logger logger = LoggerFactory.getLogger("hola");
		
		logger.info("*************  STARTING  *****************");
		logger.info("Todo va bien");
	}

}
