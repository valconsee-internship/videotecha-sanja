create table movie (
       id bigserial not null,
        deleted boolean,
        description varchar(255),
        director varchar(255),
        length integer,
        movie_genres smallint array,
        name varchar(255),
        primary key (id)
    );

create table theater (
       id bigserial not null,
        capacity integer,
        name varchar(255),
        primary key (id)
    );

create table projection (
       id bigserial not null,
        available_seats integer,
        deleted boolean,
        start timestamp(6),
        ticket_price integer,
        movie_id bigint not null references movie (id),
        theater_id bigint not null references theater (id),
        primary key (id)
    );

create table "user" (
       id bigserial not null,
        email varchar(255) unique,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        user_type smallint,
        primary key (id)
    );

