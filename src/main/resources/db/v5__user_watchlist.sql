create table user_watchlist_item (
    id bigserial,
    user_id bigint not null references "user" (id),
    movie_id bigint not null references movie (id),
    primary key (id)
);
