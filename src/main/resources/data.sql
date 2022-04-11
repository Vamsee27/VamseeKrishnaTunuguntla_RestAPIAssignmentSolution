create database empdb;

CREATE TABLE empdb.employee ( 
id int NOT NULL AUTO_INCREMENT, 
firstName varchar(255) DEFAULT NULL, 
lastName varchar(255) DEFAULT NULL, 
email varchar(255) DEFAULT NULL,  
PRIMARY KEY (id) );


-- drop table empdb.student;
-- truncate table empdb.student;

select * from empdb.employee;

select * from empdb.roles;
-- insert into empdb.roles values (1,'ADMIN');
-- insert into empdb.roles values (2,'USER');

-- commit;

select * from empdb.users;

-- insert into empdb.users values(1,'$2a$12$L/mH7HxQvuhhjQb4hTUFz.EHhqMzJXlBASxIOX1hyreYRTX7cizIm','admin');
-- insert into empdb.users values(2,'$2a$12$4q/yydFTyk/c/OY4I90hbupicwMo00fh9yitk4RiYcXisOwixAkxO','vamsee');

select * from empdb.users_roles;

-- insert into empdb.users_roles values(1,1);
-- insert into empdb.users_roles values(2,2);
