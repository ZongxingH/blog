

INSERT INTO sys_user (id, username, password, name, email) VALUES (1, 'admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', '老卫', 'i@waylau.com');
INSERT INTO sys_user (id, username, password, name, email)  VALUES (2, 'waylau', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVKIUi', 'Way Lau', 'waylau@waylau.com');

INSERT INTO sys_auth (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO sys_auth (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO sys_user_auth (user_id, auth_id) VALUES (1, 1);
INSERT INTO sys_user_auth (user_id, auth_id) VALUES (2, 2);