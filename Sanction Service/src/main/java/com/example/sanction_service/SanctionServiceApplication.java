package com.example.sanction_service;

import com.example.sanction_service.batch.SanctionJob;
import com.example.sanction_service.batch.SanctionXmlToBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@SpringBootApplication
@EnableJpaRepositories("com.example.sanction_service.repository")
public class SanctionServiceApplication implements CommandLineRunner {
    @Autowired
    private SanctionJob sanctionXmlToBD;
    public static void main(String[] args) throws JAXBException, IOException {
        SpringApplication.run(SanctionServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sanctionXmlToBD.saxmethod();
    }
}
