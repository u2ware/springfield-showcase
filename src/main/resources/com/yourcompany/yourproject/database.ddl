drop table if exists MybatisBean cascade;
create table MybatisBean(
	id varchar(20) ,
	password varchar(20) ,
	primary key (id)
);


drop table if exists jdbcbean cascade;
create table jdbcbean(
	id varchar(20) ,
	password varchar(20) ,
	primary key (id)
);
