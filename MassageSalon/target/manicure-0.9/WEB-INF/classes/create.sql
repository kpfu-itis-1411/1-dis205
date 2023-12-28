create database massageService;

create sequence client_seq;
create sequence service_seq;
create sequence visits_seq;

create table client (
                        id bigint  primary key default nextval('client_seq'),
                        name varchar(255),
                        phonenumber varchar(255),
                        password varchar(255)
);

create table service (
                         id bigint primary key default nextval('service_seq'),
                         name varchar(255),
                         price double precision
);

create table visits (
                        id bigint primary key default nextval('visits_seq'),
                        service_id bigint,
                        client_id bigint,
                        purchasedate timestamp,
                        constraint service_fk foreign key (service_id) references service(id),
                        constraint client_fk foreign key (client_id) references client(id)
);

insert into service (name,price) values
                                     ('Relaxing massage' , '3000'),
                                     ('Thai massage' , '4000'),
                                     ('Facial massage' , '2500'),
                                     ('Sports massage' , '3250'),
                                     ('Therapeutic massage' , '3500'),
                                     ('Childrens massage' ,'2750');

insert into client (name, phonenumber, password)
values ('admin', '+79871809010', '1234')