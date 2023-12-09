
create sequence client_seq;
create sequence masterlist_seq;
create sequence services_seq;
create sequence masterlistAndServices_seq;
create sequence entry_seq;
create sequence support_seq;




create table client (
    id bigint  primary key default nextval('client_seq'),
    name varchar(255),
    username varchar(255) unique,
    password varchar(255),
    phonenumber varchar(255)
);


insert into client (name, username, password, phonenumber)
values ('Admin', 'admin', '1234','+79180234567');

create table services (
    id bigint  primary key default nextval('services_seq'),
    name varchar(50)
);

insert into services (name)
values ('Стрижка'),('Прическа'),('Уход'),('Окрашивание');

create table masterlistAndServices(
        id bigint  primary key default nextval('masterlist_seq'),
        services_id bigint,
        masterlist_id bigint,
        constraint services_fk foreign key (services_id) references services(id),
        constraint master_fk foreign key (masterlist_id) references masterlist(id)
);

insert into masterlistAndServices (services_id, masterlist_id)
values (1,1),
        (1,2),
        (2,3),
        (3,1),
        (3,2),
        (4,1),
        (4,2);

create table masterlist (
    id bigint  primary key default nextval('masterlist_seq'),
    masterlogin varchar(50) unique,
    password varchar(255),
    name varchar(50),
    characterisation varchar(500),
    workexperience varchar(25),
    valuation int,
    phonenumber varchar(255)
);

create table support(
    id bigint  primary key default nextval('support_seq'),
    email varchar(100),
    message varchar(1000)
);

insert into masterlist (masterlogin,password, name, characterisation, workexperience, valuation,phonenumber)
values('IrinaYak01', '10kaY','Ирина Яковлева', 'Парикмахер с высоким уровнем мастерства и профессионализма, ' ||
                          'способная создать индивидуальные и стильные образы для каждого клиента. ' ||
                          'Обладает отличными навыками в области стрижки и окрашивания волос, ' ||
                          'Внимательна к пожеланиям клиентов, предлагает качественные консультации ' ||
                          'и рекомендации по уходу за волосами. Создает уютную и дружелюбную атмосферу в салоне, ' ||
                          'где каждый клиент чувствует себя комфортно и доверяет свой образ в руки опытного специалиста.', '6 лет',8,'87777777777'),
    ('MarinaIva02', '20avI', 'Мария Иванова','Парикмахер с большим опытом работы и талантом, способен создавать уникальные прически ' ||
                     'и окрашивания, подходящие для каждого клиента. Он обладает отличными навыками в стрижке и' ||
                     ' окрашивании волос, всегда готов выслушать пожелания клиентов и предложить качественные консультации по' ||
                     ' уходу за волосами. В его салоне царит уютная и дружелюбная атмосфера, где каждый клиент чувствует себя как' ||
                     ' дома и может полностью доверить свой образ в руки опытного профессионала.','5 лет', 9, '89999999999'),
    ('AliyaMan03', '30naM', 'Алия Мансуровна','Мастер по прическам с большим опытом работы и талантом, способен создавать уникальные образы ' ||
                       'и стили для каждого клиента. Она обладает отличными навыками в создании причесок и укладок, ' ||
                       'всегда готова выслушать пожелания клиентов и предложить качественные консультации по уходу за волосами.' ||
                       ' В ее салоне царит уютная и дружелюбная атмосфера, где каждый клиент чувствует себя комфортно' ||
                       ' и может полностью доверить свой образ в руки опытного профессионала.','9 лет', 9, '84444444444');

create table entry (
    id bigint  primary key default nextval('entry_seq'),
    services_id bigint,
    masterlist_id bigint,
    client_id bigint,
    constraint services_fk foreign key (services_id) references services(id),
    constraint master_fk foreign key (masterlist_id) references masterlist(id),
    constraint client_fk foreign key (client_id) references client(id)
);







