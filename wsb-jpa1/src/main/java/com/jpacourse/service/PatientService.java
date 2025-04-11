package com.jpacourse.service;

import com.jpacourse.Repository.PatientRepository;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.PatientEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.jpacourse.mapper.PatientMapper;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientTO getPatientWithPastVisits(Long id) {
        Optional<PatientEntity> entityOptional = patientRepository.findById(id);
        return entityOptional.map(PatientMapper::mapToTO).orElse(null);
    }
}