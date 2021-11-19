package com.bpkadlampungtengah.realisasidanpendapatandaerah;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Realisasi dan Pendapatan Daerah API", version = "1.0", description = "Informasi mengenai realisasi dan pendapatan daerah"))
public class RealisasidanpendapatandaerahApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealisasidanpendapatandaerahApplication.class, args);
	}

}
