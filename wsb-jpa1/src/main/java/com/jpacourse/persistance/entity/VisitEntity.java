package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	// -------------------RELACJE-------------------

	//Relacja dwukierunkowa 1:wielu Doctor - Visit
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Doctor_ID", referencedColumnName = "ID")
	private DoctorEntity doctor;

	//Relacja dwukierunkowa 1:wielu Patient - Visit
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Patient_ID", referencedColumnName = "ID")
	private PatientEntity patient;

	// -------------------KONIEC RELACJI-------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
