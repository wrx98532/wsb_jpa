package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.mapper.VisitMapper;
import com.jpacourse.persistance.entity.PatientEntity;

import java.util.List;

public class PatientMapper {

    // Metoda mapująca encję PatientEntity na obiekt PatientTO
    public static PatientTO toPatientTO(PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }

        // Mapowanie wizyt
        List<VisitTO> pastVisits = VisitMapper.toVisitTOList(patientEntity.getVisits());

        return new PatientTO(
                patientEntity.getFirstName(),
                patientEntity.getLastName(),
                patientEntity.getEmail(),
                patientEntity.getTelephoneNumber(),
                patientEntity.getPatientNumber(),
                patientEntity.getStatus(),
                patientEntity.getDateOfBirth(),
                pastVisits
        );
    }
}