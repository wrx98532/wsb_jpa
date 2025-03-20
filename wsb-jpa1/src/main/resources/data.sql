insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, '11 Listopada 23', '  ', 'Gdańsk', '80-180');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (902, 'Różana 18', 'Poznań-Wilda', 'Poznań', '61-577');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (903, 'Śliska 29', 'Śródmieście', 'Warszawa', '00-127');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (904, 'Zawiła 6', 'Podgórze', 'Kraków', '30-442');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (905, 'Świderska 120', 'Bielany', 'Warszawa', '03-128');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (906, 'Wojska Polskiego 1', '  ', 'Głogów', '67-200');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (907, 'Chrobrego Bolesława 6', '  ', 'Gniezno', '62-200');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (908, 'Osiedle Poznańskie 45', '  ', 'Osiedle Poznańskie', '66-446');

insert into address (id, address_line1, address_line2, city, postal_code)
            values (909, 'Okole 15', '  ', 'Stargard Gdański', '83-200');

insert into Doctor (Address_ID, id,  first_Name, last_Name, telephone_Number, email, doctor_Number, specialization)
            values (901, 101, 'Marek', 'Kowalski', '501777321', 'marek.kowalski@gmail.com','1','OCULIST');

insert into Doctor (Address_ID, id, first_Name, last_Name, telephone_Number, email, doctor_Number, specialization)
            values (902, 102, 'Tomasz', 'Guzikowski', '881223698', 'tomaszg123@gmail.com','2','SURGEON');

insert into Doctor (Address_ID, id, first_Name, last_Name, telephone_Number, email, doctor_Number, specialization)
            values (903, 103, 'Maria', 'Nowacka', '661452335', 'maria.nowacka@gmail.com','3','GP');

insert into Doctor (Address_ID, id, first_Name, last_Name, telephone_Number, email, doctor_Number, specialization)
            values (904, 104, 'Marek', 'Siodło', '505440002', 'mareksiodło2@gmail.com','4','DERMATOLOGIST');

insert into Patient (date_of_birth, Addresss_ID, id, email, first_Name, last_Name, patient_Number, telephone_Number)
            values ('1981-11-12', 905, 201, 'asiara1@onet.pl', 'Alicja', 'Siara', '1', '505440002');

insert into Patient (date_of_birth, Addresss_ID, id, email, first_Name, last_Name, patient_Number, telephone_Number)
            values ('1979-10-31', 906, 202, 'asiarecki@wp.pl', 'Adam', 'Siarecki', '2', '505001052');

insert into Patient (date_of_birth, Addresss_ID, id, email, first_Name, last_Name, patient_Number, telephone_Number)
            values ('1996-03-11', 907, 203, 'marcinp@wp.pl', 'Marcin', 'Pączek', '3', '511123456');

insert into Patient (date_of_birth, Addresss_ID, id, email, first_Name, last_Name, patient_Number, telephone_Number)
            values ('1976-06-06', 908, 204, 'mateuszlisek@o2.pl', 'Mateusz', 'Lisek', '4', '801778501');

insert into Visit (Doctorr_ID, id, Patientt_ID, time, description)
            values (101, 501, 202, '2025-04-10 09:00', 'Umówiona wizyta do dermatologa');

insert into Visit (Doctorr_ID, id, Patientt_ID, time, description)
            values (102, 502, 202, '2025-04-10 10:00', 'Umówiona wizyta do chirurga');

insert into Medical_Treatment (id, Visit_ID, description, type)
            values (801, 501, 'EKG', 'EKG');

insert into Medical_Treatment (id, Visit_ID, description, type)
            values (802, 501, 'RTG', 'RTG');

insert into Medical_Treatment (id, Visit_ID, description, type)
            values (803, 502, 'RTG', 'RTG');