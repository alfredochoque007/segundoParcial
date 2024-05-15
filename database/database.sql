create database bd_internet;

use bd_internet;

create table estudiantes(
id int(11) not null auto_increment primary key,
nombres varchar(50),
apellidos varchar(50),
seminario varchar(50),
confirmacion boolean, 
fecha varchar(50)
);


insert into estudiantes(nombres, apellidos,seminario , confirmacion, fecha) 
	values('Luis Alfredo', 'Choque', 'Estegonografia', 1, '2023-02-02');

insert into estudiantes(nombres, apellidos, seminario, confirmacion, fecha) 
	values('Alfredo', 'Canaviri','Criptografia', 0, '2023-02-02');


insert into estudiantes(nombres, apellidos, seminario, confirmacion, fecha) 
	values('Ramon', 'Valdez','Hacking web', 0, '2023-03-02');

select *from estudiantes ;

