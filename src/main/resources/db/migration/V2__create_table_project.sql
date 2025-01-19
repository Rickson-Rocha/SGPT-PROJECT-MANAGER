CREATE TYPE task_status AS ENUM ('NEW', 'IN_PROGRESS', 'DONE', 'DELAYED', 'CANCELLED');
CREATE TYPE task_priority AS ENUM ('LOW', 'MEDIUM', 'HIGH');
CREATE TABLE tb_task (
     id BIGSERIAL PRIMARY KEY,
     name VARCHAR(255) NOT NULL CHECK (LENGTH(name) >= 4 AND LENGTH(name) <= 255),
     description VARCHAR(255) NOT NULL CHECK (LENGTH(description) >= 4 AND LENGTH(description) <= 255),
     task_priority task_priority NOT NULL,
     task_status task_status NOT NULL,
     start_date TIMESTAMP NOT NULL,
     end_date TIMESTAMP NOT NULL,
     project_id BIGINT NOT NULL,
     FOREIGN KEY (project_id) REFERENCES tb_project (id) ON DELETE CASCADE,
     CHECK (end_date > start_date)
);
