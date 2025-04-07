package com.jpacourse.mapper;

import com.jpacourse.dto.MedicalTreatmentTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class PatientMapper {

    public PatientTO toPatientTOWithPastVisits(PatientEntity entity) {
        return new PatientTO(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getDateOfBirth(),  // <- dodatkowe pole nie-string
                entity.getVisitEntities().stream()
                        .filter(v -> v.getTime().isBefore(LocalDateTime.now()))
                        .map(this::toVisitTO)
                        .toList()
        );
    }

    public VisitTO toVisitTO(VisitEntity entity) {
        return new VisitTO(
                entity.getTime(),
                entity.getDoctor().getFirstName() + " " + entity.getDoctor().getLastName(),
                entity.getMedicaltreatment().stream()
                        .map(this::toTreatmentTO)
                        .toList()
        );
    }

    public MedicalTreatmentTO toTreatmentTO(MedicalTreatmentEntity entity) {
        return new MedicalTreatmentTO(entity.getId(), entity.getType());
    }
}