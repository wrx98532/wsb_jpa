package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    protected Class<PatientEntity> getDomainClass() {
        return PatientEntity.class;
    }

    @Autowired
    private DoctorDao doctorDao;

    @Override
    @Transactional
    public void addVisitToPatient(Long patientId, Long doctorId, LocalDateTime visitTime, String visitDescription) {
        PatientEntity patient = getOne(patientId);
        DoctorEntity doctor = doctorDao.findOne(doctorId);

        // Tworzymy wizytę
        VisitEntity visit = new VisitEntity();
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setTime(visitTime);
        visit.setDescription(visitDescription);

        // Dodajemy wizytę do pacjenta i wykonujemy merge
        patient.getVisits().add(visit);
        update(patient);  // Kaskadowe zapisywanie pacjenta
    }
}