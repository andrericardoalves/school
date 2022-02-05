--changeset Andre:1
CREATE TABLE student (
	id serial PRIMARY KEY,
	name VARCHAR(50) UNIQUE NOT NULL
);