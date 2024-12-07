INSERT INTO Address (id, city, address_line1, address_line2, postal_code)
VALUES (1, 'New York', '123 Main St', 'Apt 4B', '10001'),
       (2, 'Tokyo', '456 Ginza St', 'Building 7', '104-0061'),
       (3, 'London', '789 High St', 'Flat 12', 'SW1A 1AA'),
       (4, 'Sydney', '321 George St', '', '2000'),
       (5, 'Paris', '654 Rue de Rivoli', '2nd Floor', '75001'),
       (6, 'Berlin', '876 Alexanderplatz', '', '10178'),
       (7, 'Mumbai', '234 Marine Drive', 'Suite 15', '400001'),
       (8, 'Rio de Janeiro', '567 Avenida Atlântica', '', '22021-001'),
       (9, 'Cairo', '345 Tahrir Square', '', '11511'),
       (10, 'Cape Town', '678 Long St', '', '8001');

INSERT INTO Doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES (1, 'John', 'Doe', '555-1231', 'johndoe@example.com', 'D001', 'Specialization1', 1),
       (2, 'Hiroshi', 'Tanaka', '555-1232', 'hiroshitanaka@example.com', 'D002', 'Specialization2', 2),
       (3, 'Emily', 'Smith', '555-1233', 'emilysmith@example.com', 'D003', 'Specialization3', 3),
       (4, 'Oliver', 'Jones', '555-1234', 'oliverjones@example.com', 'D004', 'Specialization4', 4),
       (5, 'Sophie', 'Müller', '555-1235', 'sophiemüller@example.com', 'D005', 'Specialization5', 5),
       (6, 'Liam', 'Williams', '555-1236', 'liamwilliams@example.com', 'D006', 'Specialization6', 6),
       (7, 'Aarav', 'Patel', '555-1237', 'aaravpatel@example.com', 'D007', 'Specialization7', 7),
       (8, 'Beatriz', 'Silva', '555-1238', 'beatrizsilva@example.com', 'D008', 'Specialization8', 8),
       (9, 'Ahmed', 'Hassan', '555-1239', 'ahmedhassan@example.com', 'D009', 'Specialization9', 9),
       (10, 'Thandi', 'Nkosi', '555-12310', 'thandinkosi@example.com', 'D010', 'Specialization10', 10);

INSERT INTO Patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
VALUES (1, 'John', 'Doe', '555-3211', 'johndoe@patient.com', 'P001', '1991-01-01', 2),
       (2, 'Hiroshi', 'Tanaka', '555-3212', 'hiroshitanaka@patient.com', 'P002', '1992-01-01', 3),
       (3, 'Emily', 'Smith', '555-3213', 'emilysmith@patient.com', 'P003', '1993-01-01', 4),
       (4, 'Oliver', 'Jones', '555-3214', 'oliverjones@patient.com', 'P004', '1994-01-01', 5),
       (5, 'Sophie', 'Müller', '555-3215', 'sophiemüller@patient.com', 'P005', '1995-01-01', 6),
       (6, 'Liam', 'Williams', '555-3216', 'liamwilliams@patient.com', 'P006', '1996-01-01', 7),
       (7, 'Aarav', 'Patel', '555-3217', 'aaravpatel@patient.com', 'P007', '1997-01-01', 8),
       (8, 'Beatriz', 'Silva', '555-3218', 'beatrizsilva@patient.com', 'P008', '1998-01-01', 9),
       (9, 'Ahmed', 'Hassan', '555-3219', 'ahmedhassan@patient.com', 'P009', '1999-01-01', 10),
       (10, 'Thandi', 'Nkosi', '555-32110', 'thandinkosi@patient.com', 'P010', '2000-01-01', 1);

INSERT INTO Visit (id, description, time, doctor_id, patient_id)
VALUES (1, 'Visit description 1', '2024-01-01 10:00:00', 1, 1),
       (2, 'Visit description 2', '2024-01-02 10:00:00', 2, 2),
       (3, 'Visit description 3', '2024-01-03 10:00:00', 3, 3),
       (4, 'Visit description 4', '2024-01-04 10:00:00', 4, 4),
       (5, 'Visit description 5', '2024-01-05 10:00:00', 5, 5),
       (6, 'Visit description 6', '2024-01-06 10:00:00', 6, 6),
       (7, 'Visit description 7', '2024-01-07 10:00:00', 7, 7),
       (8, 'Visit description 8', '2024-01-08 10:00:00', 8, 8),
       (9, 'Visit description 9', '2024-01-09 10:00:00', 9, 9),
       (10, 'Visit description 10', '2024-01-10 10:00:00', 10, 10);

INSERT INTO MedicalTreatment (id, description, type, visit_id)
VALUES (1, 'Treatment description 1', 'Type1', 1),
       (2, 'Treatment description 2', 'Type2', 2),
       (3, 'Treatment description 3', 'Type3', 3),
       (4, 'Treatment description 4', 'Type4', 4),
       (5, 'Treatment description 5', 'Type5', 5),
       (6, 'Treatment description 6', 'Type6', 6),
       (7, 'Treatment description 7', 'Type7', 7),
       (8, 'Treatment description 8', 'Type8', 8),
       (9, 'Treatment description 9', 'Type9', 9),
       (10, 'Treatment description 10', 'Type10', 10);
