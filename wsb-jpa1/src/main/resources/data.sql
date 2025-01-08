INSERT INTO address (id, city, address_line1, address_line2, postal_code)
VALUES (1, 'New York', '123 Main St', 'Apt 4B', '62-030'),
       (2, 'Tokyo', '456 Ginza St', 'Building 7', '104-0061'),
       (3, 'London', '789 High St', 'Flat 12', 'SW1A 1AA'),
       (4, 'Sydney', '321 George St', '', '2000'),
       (5, 'Paris', '654 Rue de Rivoli', '2nd Floor', '75001'),
       (6, 'Berlin', '876 Alexanderplatz', '', '10178'),
       (7, 'Mumbai', '234 Marine Drive', 'Suite 15', '400001'),
       (8, 'Rio de Janeiro', '567 Avenida Atlântica', '', '22021-001'),
       (9, 'Cairo', '345 Tahrir Square', '', '11511'),
       (10, 'Cairo', '345 Tahrir Square', '', '11511');

INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES (1, 'John', 'Doe', '555-1231', 'johndoe@example.com', 'D001', 'SURGEON', 1),
       (2, 'Hiroshi', 'Tanaka', '555-1232', 'hiroshitanaka@example.com', 'D002', 'GP', 3),
       (3, 'Emily', 'Smith', '555-1233', 'emilysmith@example.com', 'D003', 'GP', 5),
       (4, 'Oliver', 'Jones', '555-1234', 'oliverjones@example.com', 'D004', 'DERMATOLOGIST', 7),
       (5, 'Sophie', 'Müller', '555-1235', 'sophiemüller@example.com', 'D005', 'OCULIST', 9);

INSERT INTO patient (id, version, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, registration_date)
VALUES (1, 0, 'John', 'Doe', '555-3211', 'johndoe@patient.com', 'P001', '1991-01-01', 2, '2024-01-01'),
       (2, 0, 'Hiroshi', 'Tanaka', '555-3212', 'hiroshitanaka@patient.com', 'P002', '1992-01-01', 4, '2024-01-02'),
       (3, 0, 'Emily', 'Smith', '555-3213', 'emilysmith@patient.com', 'P003', '1993-01-01', 6, '2024-01-03'),
       (4, 0, 'Oliver', 'Jones', '555-3214', 'oliverjones@patient.com', 'P004', '1994-01-01', 8, '2024-01-04'),
       (5, 0, 'Sophie', 'Müller', '555-3215', 'sophiemüller@patient.com', 'P005', '1995-01-01', 10, '2024-01-05'),
       (6, 0, 'Sophie', 'Jones', '555-3245', 'sophiejones@patient.com', 'P006', '1999-01-01', 4, '2024-01-06');

INSERT INTO visit (id, description, time, doctor_id, patient_id)
VALUES (1, 'Visit description 1', '2024-01-01 10:00:00', 1, 1),
       (2, 'Visit description 2', '2024-01-02 10:00:00', 2, 2),
       (3, 'Visit description 3', '2024-01-03 10:00:00', 3, 3),
       (4, 'Visit description 4', '2024-01-04 10:00:00', 4, 4),
       (5, 'Visit description 5', '2024-01-05 10:00:00', 5, 5),
       (6, 'Visit description 6', '2024-01-06 14:30:00', 2, 5),
       (7, 'Visit description 7', '2024-01-07 11:00:00', 3, 1);

INSERT INTO medical_treatment (id, description, type, visit_id)
VALUES (1, 'Treatment description 1', 'USG', 1),
       (2, 'Treatment description 1', 'RTG', 1),
       (3, 'Treatment description 2', 'USG', 2),
       (4, 'Treatment description 3', 'RTG', 3),
       (5, 'Treatment description 4', 'EKG', 4),
       (6, 'Treatment description 5', 'EKG', 5),
       (7, 'Treatment description 6', 'USG', 6),
       (8, 'Treatment description 7', 'USG', 7);
