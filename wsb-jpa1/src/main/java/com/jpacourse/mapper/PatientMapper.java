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
import java.util.stream.Collectors;


@Component
public class PatientMapper {

    // Metoda mapująca z PatientEntity na PatientTO
    public static PatientTO mapToTO(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        List<VisitTO> pastVisits = entity.getVisits().stream()
                .filter(v -> v.getTime().isBefore(java.time.LocalDateTime.now())) // Tylko wizyty z przeszłości
                .map(visit -> {
                    // Mapowanie wizyty
                    String doctorFullName = visit.getDoctor().getFirstName() + " " + visit.getDoctor().getLastName();
                    List<String> treatmentTypes = visit.getTreatments().stream()
                            .map(t -> t.getType().toString()) // Pobranie typów leczenia
                            .collect(Collectors.toList());

                    return new VisitTO(
                            visit.getTime(),
                            doctorFullName,
                            treatmentTypes
                    );
                })
                .collect(Collectors.toList());

        return new PatientTO(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getTelephoneNumber(),
                entity.getPatientNumber(),
                entity.getDateOfBirth(),
                pastVisits
        );
    }
}