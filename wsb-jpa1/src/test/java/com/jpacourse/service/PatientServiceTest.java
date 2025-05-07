package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.dao.DoctorDao;
import com.jpacourse.persistance.dao.VisitDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Transactional
    @Test
    public void testDeletePatientShouldCascadeDeleteVisitsButNotDoctors() {
        // given
        Long patientId = 1001L; // Use an ID present in your test data
        Long doctorId = 2001L;  // Use an ID present in your test data

        // Ensure patient and visits exist before deletion
        PatientTO patient = patientService.findById(patientId);
        assertThat(patient).isNotNull();

        List<VisitEntity> visitsBefore = visitDao.findByPatientId(patientId);
        assertThat(visitsBefore).isNotEmpty();

        DoctorEntity doctorBefore = doctorDao.findOne(doctorId);
        assertThat(doctorBefore).isNotNull();

        // when
        patientService.deletePatient(patientId);

        // then
        PatientTO deletedPatient = patientService.findById(patientId);
        assertThat(deletedPatient).isNull();

        List<VisitEntity> visitsAfter = visitDao.findByPatientId(patientId);
        assertThat(visitsAfter).isEmpty();

        DoctorEntity doctorAfter = doctorDao.findOne(doctorId);
        assertThat(doctorAfter).isNotNull(); // Doctor should NOT be deleted
    }

    @Transactional
    @Test
    public void testFindByIdShouldReturnCorrectPatientTOIncludingExtraField() {
        // given
        Long patientId = 1001L; // Use an ID present in your test data

        // when
        PatientTO patient = patientService.findById(patientId);

        // then
        assertThat(patient).isNotNull();
        assertThat(patient.getId()).isEqualTo(patientId);
        // Check extra field (replace 'EXPECTED_VALUE' with your actual expected value)
        assertThat(patient.getStatus()).isEqualTo("EXPECTED_VALUE");

        // Check visits
        assertThat(patient.getPastVisits()).isNotNull();
        assertThat(patient.getPastVisits()).isNotEmpty();
        // Optionally, check visit details, doctor names, treatment types, etc.
    }
}
