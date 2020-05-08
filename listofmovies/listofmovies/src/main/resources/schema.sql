drop table if exists movies;

create table movies(
id_movies bigint auto_increment,
namemovie varchar(50) not null,
director varchar(50) not null,
genre varchar(30) not null,
primary key(id_movies)
);