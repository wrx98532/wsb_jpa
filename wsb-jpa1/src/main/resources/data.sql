insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, '11 Listopada 23', '  ', 'Gdańsk', '80-180');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (2, 'Różana 18', 'Poznań-Wilda', 'Poznań', '61-577');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (3, 'Śliska 29', 'Śródmieście', 'Warszawa', '00-127');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (4, 'Zawiła 6', 'Podgórze', 'Kraków', '30-442');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (5, 'Świderska 120', 'Bielany', 'Warszawa', '03-128');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (6, 'Wojska Polskiego 1', '  ', 'Głogów', '67-200');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (7, 'Chrobrego Bolesława 6', '  ', 'Gniezno', '62-200');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (8, 'Osiedle Poznańskie 45', '  ', 'Osiedle Poznańskie', '66-446');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (9, 'Okole 15', '  ', 'Stargard Gdański', '83-200');

--insert into Doctor (Address_ID, id,  first_Name, last_Name, telephone_Number, email, doctor_Number, specialization)
--            values (901, 101, 'Marek', 'Kowalski', '501777321', 'marek.kowalski@gmail.com','1','OCULIST');
--
--insert into Doctor (Address_ID, id, first_Name, last_Name, telephone_Number, email, doctor_Number, specialization)
--            values (902, 102, 'Tomasz', 'Guzikowski', '881223698', 'tomaszg123@gmail.com','2','SURGEON');
--
--insert into Doctor (Address_ID, id, first_Name, last_Name, telephone_Number, email, doctor_Number, specialization)
--            values (903, 103, 'Maria', 'Nowacka', '661452335', 'maria.nowacka@gmail.com','3','GP');
--
--insert into Doctor (Address_ID, id, first_Name, last_Name, telephone_Number, email, doctor_Number, specialization)
--            values (904, 104, 'Marek', 'Siodło', '505440002', 'mareksiodło2@gmail.com','4','DERMATOLOGIST');
--
--insert into Patient (date_of_birth, Address_ID, id, email, first_Name, last_Name, patient_Number, status, telephone_Number)
--            values ('1981-11-12', 905, 201, 'asiara1@onet.pl', 'Alicja', 'Siara', '1', 'Active', '505440002');
--
--insert into Patient (date_of_birth, Address_ID, id, email, first_Name, last_Name, patient_Number, status, telephone_Number)
--            values ('1979-10-31', 906, 202, 'asiarecki@wp.pl', 'Adam', 'Siarecki', '2', 'Active', '505001052');
--
--insert into Patient (date_of_birth, Address_ID, id, email, first_Name, last_Name, patient_Number, status, telephone_Number)
--            values ('1996-03-11', 907, 203, 'marcinp@wp.pl', 'Marcin', 'Pączek', '3', 'Active', '511123456');
--
--insert into Patient (date_of_birth, Address_ID, id, email, first_Name, last_Name, patient_Number, status, telephone_Number)
--            values ('1976-06-06', 908, 204, 'mateuszlisek@o2.pl', 'Mateusz', 'Lisek', '4', 'Active', '801778501');
--
--insert into Visit (Doctor_ID, id, Patient_ID, time, description)
--            values (101, 501, 201, '2025-04-10 09:00', 'Umówiona wizyta do dermatologa');
--
--insert into Visit (Doctor_ID, id, Patient_ID, time, description)
--            values (102, 502, 202, '2025-04-10 10:00', 'Umówiona wizyta do chirurga');
--
--insert into Medical_Treatment (id, Visit_ID, description, type)
--            values (801, 501, 'EKG', 'EKG');
--
--insert into Medical_Treatment (id, Visit_ID, description, type)
--            values (802, 501, 'RTG', 'RTG');
--
--insert into Medical_Treatment (id, Visit_ID, description, type)
--            values (803, 502, 'RTG', 'RTG');

-- Dodanie danych do tabeli Doctor (lekarze)
INSERT INTO Doctor (id, Address_ID, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES
    (1, 1, 'Anna', 'Kowalska', '123456789', 'anna.kowalska@example.com', 'DOC123', 'GP'),
    (2, 3, 'Jan', 'Nowak', '987654321', 'jan.nowak@example.com', 'DOC456', 'OCULIST'),
    (3, 2, 'Marek', 'Zieliński', '555666777', 'marek.zielinski@example.com', 'DOC789', 'DERMATOLOGIST');

-- Dodanie danych do tabeli Patient (pacjenci)
INSERT INTO Patient (id, first_name, last_name, Address_ID, telephone_number, email, patient_number, status, date_of_birth)
VALUES
    (1, 'Piotr', 'Szymanski',4, '123321123', 'piotr.szymanski@example.com', 'PAT123', 'active', '1985-07-15'),
    (2, 'Maria', 'Kowalska',6, '234432234', 'maria.kowalska@example.com', 'PAT456', 'active', '1992-02-20'),
    (3, 'Katarzyna', 'Wójcik',7, '345543345', 'katarzyna.wojcik@example.com', 'PAT789', 'active', '1987-10-25');

-- Dodanie wizyt do tabeli Visit (wizyty)
INSERT INTO Visit (description, time, patient_id, doctor_id)
VALUES
    ('Kontrola po operacji', '2023-03-15T10:00:00', 1, 2),  -- Piotr Szymanski, Jan Nowak
    ('Konsultacja kardiologiczna', '2023-03-20T12:30:00', 1, 1),  -- Piotr Szymanski, Anna Kowalska
    ('Dermatologiczna kontrola', '2023-04-01T09:00:00', 3, 3),  -- Katarzyna Wójcik, Marek Zieliński
    ('Rehabilitacja po kontuzji', '2023-04-05T15:00:00', 2, 2),  -- Maria Kowalska, Jan Nowak
    ('Przegląd ogólny', '2023-04-08T08:00:00', 2, 1);  -- Maria Kowalska, Anna Kowalska