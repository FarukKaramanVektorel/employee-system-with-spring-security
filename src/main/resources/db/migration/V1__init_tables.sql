CREATE TABLE department
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_department PRIMARY KEY (id)
);

CREATE TABLE employee
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    first_name    VARCHAR(255) NULL,
    last_name     VARCHAR(255) NULL,
    email         VARCHAR(255) NULL,
    phone         VARCHAR(255) NULL,
    hire_date     date NULL,
    status        VARCHAR(255) NULL,
    salary DOUBLE NULL,
    department_id BIGINT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

CREATE TABLE employee_role
(
    employe_id BIGINT NOT NULL,
    role_id    BIGINT NOT NULL
);

CREATE TABLE `role`
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

ALTER TABLE department
    ADD CONSTRAINT uc_department_name UNIQUE (name);

ALTER TABLE `role`
    ADD CONSTRAINT uc_role_name UNIQUE (name);

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_DEPARTMENT FOREIGN KEY (department_id) REFERENCES department (id);

ALTER TABLE employee_role
    ADD CONSTRAINT fk_emprol_on_employee FOREIGN KEY (employe_id) REFERENCES employee (id);

ALTER TABLE employee_role
    ADD CONSTRAINT fk_emprol_on_role FOREIGN KEY (role_id) REFERENCES `role` (id);