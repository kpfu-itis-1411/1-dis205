create database dentalclinic;

create sequence patient_seq;
create sequence doctor_seq;
create sequence appointment_seq;
create sequence procedures_seq;

create table patient (
                        id bigint  primary key default nextval('patient_seq'),
                        name varchar(255) not null,
                        surname varchar(255) not null,
                        email varchar(255) not null,
                        dateofbirth date not null,
                        password varchar(255) not null
);

create table doctor (
                       id bigint primary key default nextval('doctor_seq'),
                       name varchar(255) not null,
                       surname varchar(255) not null,
                       email varchar(255) not null,
                       post varchar(255) not null,
                       password varchar(255) not null
);

create table appointment (
                             id bigint primary key default nextval('appointment_seq'),
                             name varchar(255) not null,
                             appointmentdate timestamp not null,
                             doctor_id bigint,
                             patient_id bigint,

                             constraint doctor_fk foreign key (doctor_id) references doctor(id),
                             constraint patient_fk foreign key (patient_id) references patient(id)
);


create table procedure (
                            id bigint primary key default nextval('procedures_seq'),
                            name varchar(255) not null,
                            price double precision not null,
                            time varchar(255) not null,
                            doctor_id bigint,
                            constraint doctor_fk foreign key (doctor_id) references doctor(id)
);

create table timeslot (
                           procrdurename varchar(255) not null,
                           freetime varchar(255) not null
);


insert into doctor (name,surname,email,post,password) values
                                           ('Alex', 'Ivanov', 'alexivanovdental@mail.ru', 'Orthodontist', 'doctorclinic'),
                                           ('Petr', 'Smirnov', 'petrsmirnovdental@mail.ru', 'Surgeon', 'doctorclinic'),
                                           ('Anastasia', 'Sidorova', 'anastasiasidorovadental@mail.ru', 'Pediatric dentist', 'doctorclinic'),
                                           ('Maria', 'Petrova', 'mariapetrovadental@mail.ru', 'Orthopedist', 'doctorclinic'),
                                            ('Admin', 'Admin', 'admin@mail.ru', 'Admin', 'doctorclinicadmin');


insert into procedure (name, price, time, doctor_id) values
                                               ('Tooth extraction', 7000, ,2),
                                               ('Examination', 800, ,3),
                                               ('Caries treatment', 2500, ,1),
                                               ('Installing braces', 300000, ,4);

