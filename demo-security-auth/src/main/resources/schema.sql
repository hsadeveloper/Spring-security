create table if not exists card
(
    id   serial primary key not null,
    name text     not null unique,
    password text     not null ,
    note text     not null unique
);
