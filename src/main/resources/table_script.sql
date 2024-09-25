create database if not exists Student_Details;
 
 
use Student_Details;
drop table Student;
 
 
 create table login (
	admin_id BIGINT(20) PRIMARY KEY,
    password VARCHAR(20) NOT NULL
);

INSERT INTO LOGIN VALUES (1291311, 'Abc@123');
INSERT INTO LOGIN VALUES (1291312, 'Xyz@123');
INSERT INTO LOGIN VALUES (1291313, 'Def@123');
INSERT INTO LOGIN VALUES (1291314, 'Ghi@123');
 
 
 
create table Student (

    id Int PRIMARY KEY,
    email varchar(30) NOT NULL,
    name varchar(30) NOT NULL,
    age Int NOT NULL,
    phone_number BIGINT(10) NOT NULL
   
);
 
INSERT INTO Student VALUES ('1001', 'abhi12@gmail.com','Abhinendra Pratap Singh',18,9827663749);
INSERT INTO Student VALUES ('1002', 'sonu12@gmail.com','Sonu Kumar',19,9752449807);
INSERT INTO Student VALUES ('1003', 'piyush12@gmail.com','Piyush Singh',16,8294657608);
INSERT INTO Student VALUES ('1004', 'smriti12@gmail.com','Smriti Irani',17,9575054553);
INSERT INTO Student VALUES ('1005', 'abhishek12@gmail.com','Abhishek Singh',18,9575054551);
INSERT INTO Student VALUES ('1006', 'abhimanyu12@gmail.com','Abhimanyu Singh',15,9575054552);
INSERT INTO Student VALUES ('1007', 'abhinav12@gmail.com','Abhinav Singh',16,9575054554);
INSERT INTO Student VALUES ('1008', 'abhiraj12@gmail.com','Abhiraj Pandey',19,9575054553);
 
 
 
commit;
SELECT * FROM Student;
SELECT * FROM Login;


