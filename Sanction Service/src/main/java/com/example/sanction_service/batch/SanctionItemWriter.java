package com.example.sanction_service.batch;

import com.example.sanction_service.model.SanctionEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SanctionItemWriter implements ItemWriter<SanctionEntity> {

    @PersistenceContext
    private EntityManager entityManager;

    private List<SanctionEntity> list = new ArrayList<>();

    @Override
    public void write(Chunk<? extends SanctionEntity> chunk) throws Exception {
        for (SanctionEntity entity : list) {
            entityManager.persist(entity);
        }
    }
}
