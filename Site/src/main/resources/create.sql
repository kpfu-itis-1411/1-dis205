create database data_base;

create sequence client_seq;

create table client (
    id bigint  primary key default nextval('client_seq'),
    name varchar(255),
    username varchar(255) unique,
    password varchar(255),
    phone_number varchar(255)
);
create table subscriptions (
    id bigint  primary key default nextval('client_seq'),
    client_id bigint,
    friend_id bigint,
    constraint client_fk foreign key (client_id) references client(id),
    constraint frined_fk foreign key (friend_id) references client(id)
);
CREATE TABLE images (
    id SERIAL PRIMARY KEY,
    client_id BIGINT,
    data BYTEA,
    constraint client_fk foreign key (client_id) references client(id)
);
CREATE TABLE posts (
    id SERIAL PRIMARY KEY,
    client_id BIGINT,
    date date,
    message varchar(1000),
    constraint client_fk foreign key (client_id) references client(id)
);

insert into client (name, username, password, phone_number)
values ('Arseniy', 'arseniy', '12345678','+7918023456');
insert into subscriptions (client_id, friend_id)
values (1,3)