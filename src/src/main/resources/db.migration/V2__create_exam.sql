create table school._exam (
                              _subject varchar(255),
                              person_id int,
                              _value int,
                              PRIMARY KEY (_subject),
                              FOREIGN KEY (person_id) REFERENCES _user(id)
);