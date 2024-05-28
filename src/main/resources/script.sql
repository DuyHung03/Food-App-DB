CREATE TABLE recipes
(
    recipe_id    BIGINT PRIMARY KEY not null ,
    user_id      BIGINT REFERENCES users (user_id),
    title        VARCHAR(255) NOT NULL,
    description  varchar(max) NOT NULL,
    instructions varchar(max) NOT NULL,
    servings     INT,
    prep_time    INT, -- in minutes
    cook_time    INT, -- in minutes
    created_at   VARCHAR(100),
    note varchar(max)
);

create table [user]
(
    id         bigint not null primary key,
    created_at varchar(255),
    email      varchar(255),
    password   varchar(255),
    photo_url  varchar(255),
    username   varchar(255)
)

CREATE TABLE images
(
    id        bigint PRIMARY KEY,
    url       varchar(max) NOT NULL,
    recipe_id bigint,
    FOREIGN KEY (recipe_id) REFERENCES recipes (recipe_id) ON DELETE CASCADE
);