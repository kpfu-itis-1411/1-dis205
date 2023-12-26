---Тренер:
-- Эта сущность будет содержать информацию о тренерах,
-- работающих в школе танцев. Она будет связана с сущностью Тренировка через отношение “один ко многим”,
-- так как один тренер может проводить несколько тренировок. Также, каждая тренировка будет связана с Дисциплиной через отношение “один к одному”,
-- так как каждая тренировка будет соответствовать только одной дисциплине.

---Тренировка:
-- Эта сущность будет содержать информацию о тренировках, которые проводятся в школе танцев.
-- Она будет связана с сущностью Тренер через отношение “многие к одному”, так как несколько тренировок могут проводиться одним тренером.
-- Также, каждая тренировка будет связана с Дисциплиной через отношение “один к одному”, так как каждая тренировка будет соответствовать только одной дисциплине.
-- Кроме того, каждая тренировка будет связана с Пользователем через отношение “многие ко многим”, так как каждый пользователь может записаться на несколько тренировок,
-- а каждая тренировка может иметь несколько записавшихся пользователей.

---Пользователь:
-- Эта сущность будет содержать информацию о пользователях, которые записываются на тренировки в школе танцев.
-- Она будет связана с сущностью Тренировка через отношение “многие ко многим”, так как каждый пользователь может записаться на несколько тренировок,
-- а каждая тренировка может иметь несколько записавшихся пользователей.---
create sequence trainer_seq;
create sequence discipline_seq;
create sequence training_seq;
create sequence client_seq;
CREATE TABLE trainer (
                         trainer_id bigint  primary key default nextval('trainer_seq'),
                         name VARCHAR(50) NOT NULL,
                         email VARCHAR(50) NOT NULL,
                         description varchar(255) NOT NULL,
                         phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE discipline (
                            discipline_id bigint  primary key default nextval('discipline_seq'),
                            name VARCHAR(50) NOT NULL
);

CREATE TABLE training (
                          training_id bigint  primary key default nextval('training_seq'),
                          trainer_id INT NOT NULL,
                          discipline_id INT NOT NULL,
                          recommended_age INT NOT NULL,
                          title varchar(255) NOT NULL,
                          level varchar(255) NOT NULL CHECK (level IN ('beginner', 'intermediate', 'advanced')),
                          date DATE NOT NULL,
                          time TIME NOT NULL,
                          FOREIGN KEY (trainer_id) REFERENCES trainer(trainer_id),
                          FOREIGN KEY (discipline_id) REFERENCES discipline(discipline_id)
);

CREATE TABLE client (
                        client_id bigint  primary key default nextval('client_seq'),
                        name VARCHAR(50) NOT NULL,
                        email VARCHAR(50) NOT NULL,
                        phone_number VARCHAR(20) NOT NULL,
                        password varchar(255) NOT NULL
);

CREATE TABLE client_training (
                                 client_id INT NOT NULL,
                                 training_id INT NOT NULL,
                                 PRIMARY KEY (client_id, training_id),
                                 FOREIGN KEY (client_id) REFERENCES client(client_id),
                                 FOREIGN KEY (training_id) REFERENCES training(training_id)
);
-- Заполнение таблицы trainer
INSERT INTO trainer (name, email, description, phone_number) VALUES
                                                                 ('Анна Смирнова', 'smirnova@mail.ru', 'Профессиональный тренер по бальным танцам', '+79161234567'),
                                                                 ('Иван Петров', 'petrov@mail.ru', 'Тренер по современным танцам', '+79169876543'),
                                                                 ('Елена Соколова', 'sokolova@mail.ru', 'Тренер по хип-хопу', '+79161239876'),
                                                                 ('Алексей Новиков', 'novikov@mail.ru', 'Тренер по брейк-дансу', '+79169875432');

-- Заполнение таблицы discipline
INSERT INTO discipline (name) VALUES
                                  ('Бальные танцы'),
                                  ('Современные танцы'),
                                  ('Хип-хоп'),
                                  ('Брейк-данс');

-- Заполнение таблицы training
INSERT INTO training (trainer_id, discipline_id, recommended_age, title, level, date, time) VALUES
                                                                                                (1, 1, 16, 'Бальные танцы для начинающих', 'beginner', '2023-12-01', '18:00:00'),
                                                                                                (2, 2, 12, 'Современные танцы для продвинутых', 'advanced', '2023-12-02', '19:00:00'),
                                                                                                (3, 3, 14, 'Хип-хоп для начинающих', 'beginner', '2023-12-03', '17:00:00'),
                                                                                                (4, 4, 16, 'Брейк-данс для продвинутых', 'advanced', '2023-12-04', '18:30:00'),
                                                                                                (3, 3, 16, 'Хип-хоп для продвинутых', 'advanced', '2023-12-01', '15:30:00'),
                                                                                                (4, 3, 14, 'Современные танцы для начинающий', 'beginner', '2023-11-27','15:30:00'),
                                                                                                (1, 1, 14, 'Бальные танцы для начинающих', 'beginner', '2023-11-27','18:30:00'),
                                                                                                (2, 4, 16, 'Брейк-данс для продвинутых', 'advanced','2023-11-27','14:00:00')

-- Заполнение таблицы client
INSERT INTO client (name, email, phone_number, password) VALUES
                                                             ('Мария Иванова', 'mari@mail.ru', '+79164567890', 'password123'),
                                                             ('Сергей Петров', 'serg@mail.ru', '+79165432198', 'password321'),
                                                             ('Ольга Сергеева', 'olga@mail.ru', '+79164567891', 'password456'),
                                                             ('Дмитрий Иванов', 'dima@mail.ru', '+79165432199', 'password789');

-- Заполнение таблицы client_training
INSERT INTO client_training (client_id, training_id) VALUES
                                                         (1, 1),
                                                         (2, 2),
                                                         (3, 3),
                                                         (4, 4);