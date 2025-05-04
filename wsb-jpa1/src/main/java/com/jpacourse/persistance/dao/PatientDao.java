package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitTime, String visitDescription);

    List<PatientEntity> findByLastName(String lastName);
    List<PatientEntity> findWithMoreThanXVisits(long minVisits);
    List<PatientEntity> findByStatusLike(String statusPart);
    List<PatientEntity> findBornAfter(LocalDate date);
}
