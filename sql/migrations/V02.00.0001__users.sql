create table users
(
    user_id  serial primary key,
    name     text unique not null,
    password text        not null
);