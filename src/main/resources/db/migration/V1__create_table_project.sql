
CREATE TYPE project_status AS ENUM ('NEW', 'IN_PROGRESS', 'DONE', 'DELAYED', 'CANCELLED');


CREATE TABLE tb_project (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    description VARCHAR(30) NOT NULL CHECK (LENGTH(description) >= 4 AND LENGTH(description) <= 30),
    project_status project_status NOT NULL
);
