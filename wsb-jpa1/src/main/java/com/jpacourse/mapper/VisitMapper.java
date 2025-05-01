package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.entity.MedicalTreatmentEntity;

import java.util.List;
import java.util.stream.Collectors;

public class VisitMapper {

    // Metoda mapująca encję VisitEntity na obiekt VisitTO
    public static VisitTO toVisitTO(VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;  // Jeśli encja jest null, zwróć null
        }

        // Mapowanie listy typów leczenia (MedicalTreatmentEntity na String)
        List<String> treatments = visitEntity.getTreatments().stream()
                .map(treatment -> treatment.getType().name())  // Użycie .name() do konwersji enum na String
                .collect(Collectors.toList());  // Zbieranie do listy

        // Tworzenie i zwracanie nowego VisitTO z przekształconymi danymi
        return new VisitTO(
                visitEntity.getTime(),  // Czas wizyty
                visitEntity.getDoctor().getFirstName() + " " + visitEntity.getDoctor().getLastName(),  // Pełne imię i nazwisko lekarza
                treatments  // Lista typów leczenia
        );
    }

    // Metoda pomocnicza mapująca listę wizyt na listę VisitTO
    public static List<VisitTO> toVisitTOList(List<VisitEntity> visitEntities) {
        if (visitEntities == null) {
            return null;  // Jeśli lista wizyt jest null, zwróć null
        }
        // Mapowanie listy VisitEntity na listę VisitTO
        return visitEntities.stream()
                .map(VisitMapper::toVisitTO)
                .collect(Collectors.toList());
    }
}