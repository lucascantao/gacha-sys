INSERT INTO user_table (name, email, password, pulls) VALUES('user', 'user@email.com', '$2a$12$XrOvnti4NJAzdeOA2KP/sevaog.fRuG3QpxMbNn2oC83m8zexz2Oe', 90);

INSERT INTO banner (name) VALUES('Favonious Festival');
INSERT INTO pity (banner_id, t4pity, t5pity, user_id) VALUES (1, 0, 0, 1);

INSERT INTO character (tier, bio, name) VALUES(5, 'Funerary Director', 'Hu Tao');
INSERT INTO character (tier, bio, name) VALUES(5, 'Geo Archon', 'Zhongli');
INSERT INTO character (tier, bio, name) VALUES(5, 'Hydro Archon', 'Furina');
INSERT INTO character (tier, bio, name) VALUES(5, 'Knights of Favonious Leader', 'Jean');
INSERT INTO character (tier, bio, name) VALUES(4, 'Favonious Maid Knight', 'Noelle');
INSERT INTO character (tier, bio, name) VALUES(4, 'Unlucky Boy', 'Bennet');
INSERT INTO character (tier, bio, name) VALUES(4, 'Cryon Num', 'Rosaria');
INSERT INTO character (tier, bio, name) VALUES(4, 'Favonious Alchemist', 'Sucrose');
INSERT INTO character (tier, bio, name) VALUES(5, 'Firecracker Girl', 'Yoimiya');
INSERT INTO character (tier, bio, name) VALUES(5, 'Zombi child', 'Qiqi');

INSERT INTO banner_characters (banner_id, character_id) VALUES (1, 4);
INSERT INTO banner_characters (banner_id, character_id) VALUES (1, 5);
INSERT INTO banner_characters (banner_id, character_id) VALUES (1, 6);
INSERT INTO banner_characters (banner_id, character_id) VALUES (1, 7);