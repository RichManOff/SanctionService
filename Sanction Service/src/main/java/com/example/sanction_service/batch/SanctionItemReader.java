package com.example.sanction_service.batch;

import com.example.sanction_service.model.Sanction;
import com.example.sanction_service.model.SanctionEntity;
import com.example.sanction_service.model.SanctionList;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.persistence.EntityManager;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@StepScope
public class SanctionItemReader implements ItemReader<SanctionEntity> {

    private final XmlMapper xmlMapper = new XmlMapper();

    private int index = 0;

    @Autowired
    private EntityManager entityManager;

    @Override
    public SanctionEntity read() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://www.un.org/securitycouncil/ru/sanctions/1988/materials");

        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();

        List<SanctionEntity> items = new ArrayList<>();

        if (entity != null) {
            SanctionList sanctions = xmlMapper.readValue(entity.getContent(), SanctionList.class);
            for (Sanction sanction : sanctions.getSanctionList()) {
                SanctionEntity sancEntity = new SanctionEntity();
                sancEntity.setName(sanction.getName());
                sancEntity.setSurname(sanction.getSurname());
                sancEntity.setDateOfBirth(sanction.getDateOfBirth());
                sancEntity.setNationality(sanction.getNationality());
                sancEntity.setSanctionStartDate(sanction.getSanctionStartDate());
                sancEntity.setSanctionEndDate(sanction.getSanctionEndDate());
                items.add(sancEntity);

                if (items.size() == 50) { // Save every 50 items
                    entityManager.getTransaction().begin();
                    for (SanctionEntity item : items) {
                        entityManager.persist(item);
                    }
                    entityManager.getTransaction().commit();
                    items.clear();
                }
            }
        }

        if (!items.isEmpty()) { // Save any remaining items
            entityManager.getTransaction().begin();
            for (SanctionEntity item : items) {
                entityManager.persist(item);
            }
            entityManager.getTransaction().commit();
        }

        if (index < items.size()) {
            return items.get(index++);
        } else {
            return null;
        }
    }
}

