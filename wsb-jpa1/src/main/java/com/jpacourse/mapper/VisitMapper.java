package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.List;
import java.util.stream.Collectors;

public class VisitMapper {

    public static VisitTO mapToTO(VisitEntity entity) {
        if (entity == null) {
            return null;
        }

        String doctorFullName = entity.getDoctor().getFirstName() + " " + entity.getDoctor().getLastName();
        List<String> treatmentTypes = entity.getTreatments().stream()
                .map(t -> t.getType().toString())
                .collect(Collectors.toList());

        return new VisitTO(
                entity.getTime(),
                doctorFullName,
                treatmentTypes
        );
    }
}
