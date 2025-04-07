package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public List<PatientTO> getAllPatientsWithPastVisits() {
        return patientRepository.findAll().stream()
                .map(patient -> patientMapper.toPatientTOWithPastVisits(patient))
                .toList();
    }
