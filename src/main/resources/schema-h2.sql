CREATE table ROKOK(
id int not null AUTO_INCREMENT,
nama VARCHAR2(255) not null,
harga int,
PRIMARY KEY(id)
);

INSERT INTO ROKOK(id,nama,harga)VALUES(1,'LA',19000);

CREATE table EMPLOYEE(
id int not null AUTO_INCREMENT,
last_name VARCHAR2(255) not null,
first_name VARCHAR2(255) not null,
age int,
job VARCHAR2(255) not null,
address VARCHAR2(255) not null,
PRIMARY KEY(id)
);

INSERT INTO EMPLOYEE(id,last_name,first_name,age,job,address)VALUES(1,'ADIASSA','Ethiel',20,'Web Developer','Lome-Togo');
INSERT INTO EMPLOYEE(id,last_name,first_name,age,job,address)VALUES(2,'ADUFU','Patrick',20,'Banker','Senegal-Dakar');
INSERT INTO EMPLOYEE(id,last_name,first_name,age,job,address)VALUES(3,'MOUTON','John',28,'Scientist','New York/USA');
INSERT INTO EMPLOYEE(id,last_name,first_name,age,job,address)VALUES(4,'SMITH','Luther',18,'Pilot','London/GB');
INSERT INTO EMPLOYEE(id,last_name,first_name,age,job,address)VALUES(5,'WALTER','Ramses Peter',38,'Doctor','Paris/France');
INSERT INTO EMPLOYEE(id,last_name,first_name,age,job,address)VALUES(6,'GEORGES','Luther',45,'Musician','Vienne');
INSERT INTO EMPLOYEE(id,last_name,first_name,age,job,address)VALUES(7,'MICHAEL','Daven',27,'Boxer','Pekin/China');
