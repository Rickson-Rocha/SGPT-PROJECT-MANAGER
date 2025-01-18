
CREATE TYPE project_status AS ENUM ('NEW', 'IN_PROGRESS', 'DONE', 'DELAYED', 'CANCELLED');


CREATE TABLE tb_project (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL CHECK (LENGTH(name) >= 4 AND LENGTH(name) <= 255),
    description VARCHAR(255) NOT NULL CHECK (LENGTH(description) >= 4 AND LENGTH(description) <= 255),
    project_status project_status NOT NULL,
    start_date DATE NOT NULL CHECK (start_date >= CURRENT_DATE),
    end_date DATE NOT NULL CHECK (end_date > CURRENT_DATE),
    CHECK (end_date > start_date)
);
