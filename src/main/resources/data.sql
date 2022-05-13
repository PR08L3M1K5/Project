INSERT INTO user(login,email) VALUES('Wojtek','Wojtaszek@gmail.com')
INSERT INTO user(login,email) VALUES('Kamil','Kamil@gmail.com')
INSERT INTO user(login,email) VALUES('Marcin','Kamil@gmail.com')

INSERT INTO lecture(description,topic,code,start,end) VALUES ('opis konferencji javy cz1 ','Java','J1','10:00','11:45')
INSERT INTO lecture(description,topic,code,start,end) VALUES ('opis konferencji C# cz1','C#','C1','10:00','11:45')
INSERT INTO lecture(description,topic,code,start,end) VALUES ('opis konferencji Haskell cz1 ','Haskell','H1','10:00','11:45')
INSERT INTO lecture(description,topic,code,start,end) VALUES ('opis konferencji javy cz2 ','Java','J2','12:00','13:45')
INSERT INTO lecture(description,topic,code,start,end) VALUES ('opis konferencji C# cz2','C#','C2','12:00','13:45')
INSERT INTO lecture(description,topic,code,start,end) VALUES ('opis konferencji Haskell cz2 ','Haskell','H2','12:00','13:45')

INSERT INTO lecture(description,topic,code,start,end) VALUES ('opis konferencji javy cz3 ','Java','J3','14:00','15:45')
INSERT INTO lecture(description,topic,code,start,end) VALUES ('opis konferencji C# cz3','C#','C3','14:00','15:45')
INSERT INTO lecture(description,topic,code,start,end) VALUES ('opis konferencji Haskell cz3 ','Haskell','H3','14:00','15:45')


INSERT iNTO sign_lectures(user_id,lecture_id) VALUES(1,1)
