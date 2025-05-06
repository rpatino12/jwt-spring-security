INSERT INTO users (username, password, enabled)
values ('ricardo', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', true);
INSERT INTO users (username, password, enabled)
values ('laura', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', true);

INSERT INTO authorities (username, authority) values ('ricardo', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('laura', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('laura', 'ROLE_ADMIN');