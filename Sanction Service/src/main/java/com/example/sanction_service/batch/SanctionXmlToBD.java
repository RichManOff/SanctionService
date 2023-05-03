package com.example.sanction_service.batch;

import com.example.sanction_service.model.SanctionEntity;
import jakarta.persistence.*;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.*;

@Component
public class SanctionXmlToBD {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Transactional
    public void addSanctionToDb() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(SanctionEntity.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("xml/oqjp6en-dprk.xml");
            SanctionEntity sanctionEntity = (SanctionEntity) unmarshaller.unmarshal(inputStream);

            EntityManager entityManager = entityManagerFactory.createEntityManager();
            TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
            TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);

            entityManager.persist(sanctionEntity);

            transactionManager.commit(transactionStatus);
            entityManager.close();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }



}
