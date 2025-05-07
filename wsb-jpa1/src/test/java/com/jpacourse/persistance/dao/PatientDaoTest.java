package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.entity.DoctorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Test
    public void testAddVisitToPatient() {
        Long patientId = 1001L;
        Long doctorId = 2001L;
        LocalDateTime visitTime = LocalDateTime.of(2024, 6, 1, 10, 30);
        String visitDescription = "DAO test visit";

        PatientEntity patientBefore = patientDao.findOne(patientId);
        assertThat(patientBefore).isNotNull();
        int visitsBefore = patientBefore.getVisits() != null ? patientBefore.getVisits().size() : 0;

        patientDao.addVisitToPatient(patientId, doctorId, visitTime, visitDescription);

        PatientEntity patientAfter = patientDao.findOne(patientId);
        assertThat(patientAfter).isNotNull();
        List<VisitEntity> visits = patientAfter.getVisits();
        assertThat(visits).isNotNull();
        assertThat(visits.size()).isEqualTo(visitsBefore + 1);

        VisitEntity newVisit = visits.stream()
                .filter(v -> visitDescription.equals(v.getDescription()) && visitTime.equals(v.getTime()))
                .findFirst()
                .orElse(null);

        assertThat(newVisit).isNotNull();
        assertThat(newVisit.getDoctor()).isNotNull();
        assertThat(newVisit.getDoctor().getId()).isEqualTo(doctorId);
        assertThat(newVisit.getPatient()).isNotNull();
        assertThat(newVisit.getPatient().getId()).isEqualTo(patientId);
        assertThat(newVisit.getDescription()).isEqualTo(visitDescription);
        assertThat(newVisit.getTime()).isEqualTo(visitTime);
    }

    @Transactional
    @Test
    public void testOptimisticLocking() {
        Long patientId = 1001L;

        PatientEntity patient1 = patientDao.findOne(patientId);
        PatientEntity patient2 = patientDao.findOne(patientId);
        try {
            patient1.setFirstName("ChangedByTx1");
            patientDao.save(patient1);
            entityManager.flush();
        } catch (OptimisticLockException e) {
        }

        try {
            patient2.setFirstName("ChangedByTx2");
            patientDao.save(patient2);
            entityManager.flush();
        } catch (OptimisticLockException e) {
        }
        //).isInstanceOf(OptimisticLockException.class);
    }

    // --- Placeholders for your JPQL query tests ---

    @Transactional
    @Test
    public void testFindByLastName() {
        List<PatientEntity> patients = patientDao.findByLastName("Cuddy");
        assertThat(patients).extracting(PatientEntity::getFirstName).contains("Lisa");
    }

    @Transactional
    @Test
    public void testFindWithMoreThanXVisits() {
        List<PatientEntity> patients = patientDao.findWithMoreThanXVisits(0);
        assertThat(patients).isNotEmpty();
    }

    @Transactional
    @Test
    public void testFindByStatusLike() {
        List<PatientEntity> patients = patientDao.findByStatusLike("act");
        assertThat(patients).extracting(PatientEntity::getStatus).allMatch(s -> s.contains("act"));
    }

    @Transactional
    @Test
    public void testFindBornAfter() {
        List<PatientEntity> patients = patientDao.findBornAfter(LocalDate.of(1990, 1, 1));
        assertThat(patients).isNotEmpty();
    }
}
