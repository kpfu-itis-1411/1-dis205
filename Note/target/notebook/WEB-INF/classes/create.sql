
-- Создание таблицы Category
CREATE TABLE Category (
                          categoryId SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT
);

-- Создание таблицы Users
CREATE TABLE Users (
                       user_id SERIAL PRIMARY KEY,
                       userName VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       preferences TEXT
);

-- Создание таблицы Note
CREATE TABLE Note (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      content TEXT NOT NULL,
                      createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      user_id INTEGER REFERENCES Users(user_id)
);

-- Создание таблицы Note_Category для связи заметок с категориями
CREATE TABLE Note_Category (
                               note_id INTEGER REFERENCES Note(id),
                               category_id INTEGER REFERENCES Category(categoryId),
                               PRIMARY KEY (note_id, category_id)
);

-- Вставка начальных данных
-- Данные для таблицы Category
INSERT INTO Category (name, description) VALUES
                                             ('Personal', 'Personal notes'),
                                             ('Work', 'Work-related notes'),
                                             ('Ideas', 'Creative ideas');

-- Данные для таблицы Users
INSERT INTO Users (userName, password, email, preferences) VALUES
                                                               ('user1', 'password1', 'user1@example.com', 'Preference 1'),
                                                               ('user2', 'password2', 'user2@example.com', 'Preference 2');

-- Данные для таблицы Note
INSERT INTO Note (title, content, user_id) VALUES
                                               ('Note 1', 'Content of Note 1', 1),
                                               ('Note 2', 'Content of Note 2', 1),
                                               ('Note 3', 'Content of Note 3', 2);

-- Данные для таблицы Note_Category
INSERT INTO Note_Category (note_id, category_id) VALUES
                                                     (1, 1),
                                                     (2, 2),
                                                     (3, 1);

