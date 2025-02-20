create user 'prueba'@'localhost' identified by 'prueba';
grant usage on *.* to 'prueba'@'localhost' identified by 'prueba' ;
create database if not exists `prueba`  default character set utf8 collate utf8_spanish_ci;;
grant all privileges on `prueba`.* to 'prueba'@'localhost';
use `prueba`;
