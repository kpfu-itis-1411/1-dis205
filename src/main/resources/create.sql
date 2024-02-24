
-- Создание таблицы Teacher
create table viewer(
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) unique ,
                       first_name VARCHAR(255) NOT NULL,
                       last_name varchar(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL -- Добавлено поле для пароля
);

-- Создание таблицы Course
create table cinema(
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       director varchar(255) NOT NULL,
                       description TEXT,
                       year integer
);

create table cinema_score(
                             id SERIAL PRIMARY KEY,
                             cinema_id integer,
                             user_id integer,
                             score integer,
                             foreign key (cinema_id) references cinema (id),
                             foreign key (user_id) references viewer (id)
);


-- Вставка некоторых значений в таблицу Viewer
INSERT INTO viewer (first_name, last_name, username,  email, password) VALUES
                                               ('John','Doe', 'johndoe',  'john@example.com', 'teacher123'),
                                               ('Alice','Smith', 'alsmi', 'alice@example.com', 'teacher456');

-- Вставка некоторых значений в таблицу Cinema
INSERT INTO cinema (title, description, year, director) VALUES
                                            ('Traning day', 'Training Day is a 2001 American crime thriller film directed by Antoine Fuqua and written by David Ayer. It stars Denzel Washington as Alonzo Harris and Ethan Hawke as Jake Hoyt, two LAPD narcotics officers over a 24-hour period in the gang-ridden neighborhoods of Westlake, Echo Park, and South Central Los Angeles. It also features Scott Glenn, Eva Mendes, Cliff Curtis, Dr. Dre, Snoop Dogg, and Macy Gray in supporting roles. Training Day was released on October 5, 2001, by Warner Bros. Pictures. It received generally positive reviews from critics, who praised Washington and Hawkes performances but were divided on the screenplay. It was a commercial success, grossing $104 million worldwide against a production budget of $45 million. The film received numerous accolades and nominations, with Washingtons performance earning him the Academy Award for Best Actor and Hawke being nominated for Best Supporting Actor at the 74th Academy Awards. A television series based on the film, produced by Jerry Bruckheimer, was announced in August 2015 and premiered on February 2, 2017, on CBS, but was cancelled after one season.', 2001, 'Antoine Fuqua'),
                                            ('Knives Out', 'When renowned crime novelist Harlan Thrombey (Christopher Plummer) is found dead at his estate just after his 85th birthday, the inquisitive and debonair Detective Benoit Blanc (Daniel Craig) is mysteriously enlisted to investigate. From Harlan''s disfunctional family to his devoted staff, Blanc sifts through a web of red herrings and self-serving lies to uncover the truth behind Harlan''s untimely death.', 2019, 'Rian Johnson'),
                                            ('The Big short', 'The Big Short is a 2015 American biographical crime comedy-drama film directed and co-written by Adam McKay. Co-written by Charles Randolph, it is based on the 2010 book The Big Short: Inside the Doomsday Machine by Michael Lewis showing how the 2007–2008 financial crisis was triggered by the United States housing bubble.[4] The film stars Christian Bale, Steve Carell, Ryan Gosling and Brad Pitt, with John Magaro, Finn Wittrock, Hamish Linklater, Rafe Spall, Jeremy Strong, and Marisa Tomei in supporting roles.To explain financial instruments, the film features cameo appearances by actress Margot Robbie, chef Anthony Bourdain, singer-songwriter Selena Gomez, economist Richard Thaler, and others who break the fourth wall to explain concepts such as subprime mortgages and synthetic collateralized debt obligations.[5] Several of the film''s characters directly address the audience, most frequently Gosling''s, who serves as the narrator.The Big Short began a limited release in the United States on December 11, 2015, followed by a wide release on December 23 by Paramount Pictures.[6][7] A critical and commercial success, the film grossed $133 million on a $50 million budget and received acclaim for the performances of the cast (particularly that of Bale), McKay''s direction, editing, and the screenplay. The film won the Academy Award for Best Adapted Screenplay in addition to nominations for Best Picture, Best Director, Best Supporting Actor (Bale), and Best Film Editing.', 2015, 'Adam McKay');

INSERT INTO cinema_score(user_id, cinema_id, score)  VALUES
                                                         (1, 1, 10),
                                                         (1, 2, 8),
                                                         (1, 3, 9),
                                                         (2, 1, 9),
                                                         (2, 2, 7),
                                                         (2, 3, 10)
