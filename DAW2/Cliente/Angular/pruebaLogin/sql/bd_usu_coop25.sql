create user 'coop25'@'localhost' identified by 'coop25';
grant usage on *.* to 'coop25'@'localhost' identified by 'coop25' ;
create database if not exists `coop25`  default character set utf8 collate utf8_spanish_ci;;
grant all privileges on `coop25`.* to 'coop25'@'localhost';
use `coop25`;
