create table reservation (
       id bigserial not null,
        number_of_seats integer,
        canceled boolean,
        projection_id bigint not null references projection (id),
        user_id bigint not null references "user" (id),
        primary key (id)
    );
