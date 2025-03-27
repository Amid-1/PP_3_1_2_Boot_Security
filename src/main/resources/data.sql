
INSERT INTO roles(name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO users(username, last_name, email, password) VALUES
('Admin', 'Root', 'admin@example.com', '$2a$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEaOaO9Y/LTcSKmM7rIu9Q6Ac9G6'); -- пароль: admin

INSERT INTO users_roles(user_id, role_id) VALUES
(1, 1), -- Admin как USER
(1, 2); -- Admin как ADMIN
