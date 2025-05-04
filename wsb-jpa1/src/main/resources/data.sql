-- Addresses
INSERT INTO address (id, address_line1, address_line2, city, postal_code)
VALUES (1, 'Main St 1', '', 'CityA', '10000'),
       (2, 'Second St 2', '', 'CityB', '20000'),
       (3, 'Third St 3', '', 'CityC', '30000'),
       (4, 'Fourth St 4', '', 'CityD', '40000'),
       (5, 'Fifth Ave 5', '', 'CityE', '50000'),
       (6, 'Sixth Blvd 6', '', 'CityF', '60000'),
       (7, 'Seventh Rd 7', '', 'CityG', '70000'),
       (100, 'Test Patient Address', '', 'TestCity', '80000'),
       (101, 'Test Doctor Address', '', 'TestCity', '80001');

-- Doctors
INSERT INTO doctor (id, address_id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES (1, 1, 'Alice', 'Smith', '111111111', 'alice.smith@clinic.com', 'DOC001', 'GP'),
       (2, 2, 'Bob', 'Jones', '222222222', 'bob.jones@clinic.com', 'DOC002', 'DERMATOLOGIST'),
       (3, 3, 'Carol', 'White', '333333333', 'carol.white@clinic.com', 'DOC003', 'OCULIST'),
       (4, 4, 'David', 'Black', '444444444', 'david.black@clinic.com', 'DOC004', 'SURGEON'),
       (5, 5, 'Eve', 'Green', '555555555', 'eve.green@clinic.com', 'DOC005', 'GP'),
       (2001, 101, 'Gregory', 'House', '555123456', 'greg.house@hospital.com', 'DOC2001', 'GP');

-- Patients
INSERT INTO patient (id, first_name, last_name, address_id, telephone_number, email, patient_number, status, date_of_birth)
VALUES (1, 'John', 'Doe', 1, '123456789', 'john.doe@example.com', 'PAT001', 'active', '1980-01-01'),
       (2, 'Jane', 'Doe', 2, '987654321', 'jane.doe@example.com', 'PAT002', 'inactive', '1990-05-15'),
       (3, 'Jim', 'Beam', 3, '555555555', 'jim.beam@example.com', 'PAT003', 'active', '1975-12-31'),
       (4, 'Janet', 'Smith', 4, '444444444', 'janet.smith@example.com', 'PAT004', 'inactive', '2000-07-20'),
       (5, 'Jack', 'Daniels', 5, '666666666', 'jack.daniels@example.com', 'PAT005', 'active', '1985-03-10'),
       (6, 'Julia', 'Roberts', 6, '777777777', 'julia.roberts@example.com', 'PAT006', 'inactive', '1995-09-25'),
       (7, 'Jeremy', 'Clarkson', 7, '888888888', 'jeremy.clarkson@example.com', 'PAT007', 'active', '1970-11-11'),
       (8, 'Jessica', 'Alba', 1, '999999999', 'jessica.alba@example.com', 'PAT008', 'inactive', '2002-02-02'),
       (1001, 'Lisa', 'Cuddy', 100, '555987654', 'lisa.cuddy@hospital.com', 'PAT1001', 'active', '1980-05-12');

-- Visits
-- Visits (let DB generate IDs)
INSERT INTO visit (description, time, patient_id, doctor_id)
VALUES ('Checkup', '2023-01-01T10:00:00', 1, 1),
       ('Consultation', '2023-01-10T11:00:00', 1, 2),
       ('Follow-up', '2023-02-01T09:00:00', 1, 1),
       ('Dermatology', '2023-03-01T14:00:00', 2, 2),
       ('General', '2023-04-01T08:00:00', 3, 1),
       ('Annual', '2023-05-01T12:00:00', 3, 1),
       ('Special', '2023-06-01T15:00:00', 3, 2),
       ('Surgery', '2023-07-01T09:30:00', 4, 4),
       ('Eye Exam', '2023-08-01T10:30:00', 5, 3),
       ('Therapy', '2023-09-01T11:00:00', 6, 5),
       ('Consultation', '2023-10-01T12:00:00', 7, 1),
       ('Checkup', '2023-11-01T13:00:00', 8, 2),
       ('Follow-up', '2023-12-01T14:00:00', 1, 1),
       ('Dermatology', '2024-01-01T15:00:00', 2, 2),
       ('General', '2024-02-01T16:00:00', 3, 1),
       ('Annual', '2024-03-01T17:00:00', 3, 1),
       ('Special', '2024-04-01T18:00:00', 3, 2),
       ('Surgery', '2024-05-01T19:00:00', 4, 4),
       ('Eye Exam', '2024-06-01T20:00:00', 5, 3),
       ('Therapy', '2024-07-01T21:00:00', 6, 5),
       ('Initial Consultation', '2024-05-01T09:00:00', 1001, 2001);
