create table user_watchlist (
    user_id bigint not null references "user" (id),
    movie_id bigint not null references movie (id)
);
