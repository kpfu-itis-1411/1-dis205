create database data_base;

create sequence client_seq;
create sequence posts_seq;

create sequence client_information_seq;
create sequence avatars_seq;
create sequence activity_seq;

create table client (
    id bigint  primary key default nextval('client_seq'),
    name varchar(255),
    username varchar(255) unique,
    password varchar(255),
    phone_number varchar(255)
);
create sequence subscriptions_seq;
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

CREATE TABLE activity (
        id bigint  primary key default nextval('activity_seq'),
        post_id BIGINT,
        likes int,
        dislikes int,
        constraint post_fk foreign key (post_id) references posts(id)
);
CREATE TABLE client_information (
    id bigint  primary key default nextval('client_information_seq'),
    client_id BIGINT,
    status varchar(500),
    birthdate varchar(100),
    about_me varchar(1000),
    constraint client_fk foreign key (client_id) references client(id)
);
create sequence posts_seq;
CREATE TABLE posts (
    id bigint  primary key default nextval('posts_seq'),
    client_id BIGINT,
    likes BIGINT,
    dislikes BIGINT,
    time timestamp,
    message varchar(1000),
    constraint client_fk foreign key (client_id) references client(id)
);
-- create sequence activity_seq;
-- CREATE TABLE activity (
--                           id bigint  primary key default nextval('activity_seq'),
--                           likes int,
--                           dislikes int
-- );
insert into client (name, username, password, phone_number)
values ('Administration', 'admin', 'Kasimov12','+77777777777');

insert into client_information (client_id, status, birthdate, about_me)
values ('1', 'no status', 'not specified','not specified');
insert into subscriptions (client_id, friend_id)
values (3,4);

insert into client_information (client_id, status, birthdate, about_me)
values (3, 'Мир прекрасен!', '12-03-2004', 'Very english girl');

DELETE FROM client
WHERE id = '2';

UPDATE client
SET password = '111111'
WHERE id = 2;

