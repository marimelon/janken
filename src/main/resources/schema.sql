CREATE TABLE users (
    id IDENTITY,
    name CHAR NOT NULL
);

CREATE TABLE matches (
    id IDENTITY,
    user_1 INT NOT NULL,
    user_2 INT NOT NULL,
    user_1_hand CHAR NOT NULL,
    user_2_hand CHAR NOT NULL,
    is_active BOOLEAN NOT NULL
);

CREATE TABLE matche_info (
    id IDENTITY,
    user_1 INT NOT NULL,
    user_2 INT NOT NULL,
    is_active BOOLEAN NOT NULL
);