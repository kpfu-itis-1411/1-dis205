create database data_base;

create sequence client_seq;
create sequence posts_seq;
create sequence subscriptions_seq;
create sequence client_information_seq;
create sequence avatars_seq;

create table client (
    id bigint  primary key default nextval('client_seq'),
    name varchar(255),
    username varchar(255) unique,
    password varchar(255),
    phone_number varchar(255)
);
create table subscriptions (
    id bigint  primary key default nextval('subscriptions_seq'),
    client_id bigint,
    friend_id bigint,
    constraint client_fk foreign key (client_id) references client(id),
    constraint friend_fk foreign key (friend_id) references client(id)
);
CREATE TABLE avatars (
    id bigint  primary key default nextval('avatars_seq'),
    client_id BIGINT,
    data BYTEA,
    constraint client_fk foreign key (client_id) references client(id)
);
CREATE TABLE client_information (
    id bigint  primary key default nextval('client_information_seq'),
    client_id BIGINT,
    status varchar(500),
    birthdate varchar(100),
    about_me varchar(1000),
    constraint client_fk foreign key (client_id) references client(id)
);
CREATE TABLE posts (
    id bigint  primary key default nextval('posts_seq'),
    client_id BIGINT,
    date date,
    time timestamp,
    message varchar(1000),
    constraint client_fk foreign key (client_id) references client(id)
);

insert into client (name, username, password, phone_number)
values ('Administration', 'admin', 'Kasimov12','+77777777777');

insert into client_information (client_id, status, birthdate, about_me)
values ('1', 'no status', 'not specified','not specified');
insert into subscriptions (client_id, friend_id)
values (2,3);

insert into client_information (client_id, status, birthdate, about_me)
values (3, 'Мир прекрасен!', '12-03-2004', 'Very english girl');

DELETE FROM client
WHERE id = '2';


