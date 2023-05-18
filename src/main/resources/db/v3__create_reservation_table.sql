create table reservation (
       id bigserial not null,
        number_of_seats integer,
        canceled boolean,
        ticket_price integer,
        projection_id bigint not null,
        user_id bigint not null,
        primary key (id)
    );
alter table if exists reservation add constraint fk_projection_id  foreign key (projection_id) references projection (id);
alter table if exists reservation add constraint fk_user_id foreign key (user_id) references "user" (id);
