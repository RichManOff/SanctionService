package com.example.sanction_service.batch;

import com.example.sanction_service.model.SanctionEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class SanctionItemProcessor implements ItemProcessor<SanctionEntity, SanctionEntity> {

    @Override
    public SanctionEntity process(SanctionEntity entity) throws Exception {
        SanctionEntity processedEntity = new SanctionEntity();
        processedEntity.setName(entity.getName().toUpperCase());
        processedEntity.setSurname(entity.getSurname().toUpperCase());
        processedEntity.setDateOfBirth(entity.getDateOfBirth());
        processedEntity.setNationality(entity.getNationality().toUpperCase());
        processedEntity.setSanctionStartDate(entity.getSanctionStartDate());
        processedEntity.setSanctionEndDate(entity.getSanctionEndDate());
        return processedEntity;
    }
}
