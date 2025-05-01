package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    // Zaktualizowana metoda findById, która mapuje encję PatientEntity na PatientTO
    @Override
    public PatientTO findById(Long id) {
        // Pobieramy pacjenta z bazy danych
        PatientEntity patientEntity = patientDao.findOne(id);

        if (patientEntity == null) {
            return null; // Pacjent nie znaleziony
        }

        // Mapowanie encji na obiekt transferowy PatientTO
        return PatientMapper.toPatientTO(patientEntity);
    }

    @Override
    public void deletePatient(Long id) {
        patientDao.delete(id); // kaskada usunie wizyty
    }
}