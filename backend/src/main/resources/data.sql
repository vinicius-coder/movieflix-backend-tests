INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);


INSERT INTO tb_genre (name) VALUES ('Aventura');
INSERT INTO tb_genre (name) VALUES ('Ação');
INSERT INTO tb_genre (name) VALUES ('Ficção');
INSERT INTO tb_genre (name) VALUES ('Desenho');
INSERT INTO tb_genre (name) VALUES ('Terror');

INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('Bad Boys 3', '', 2019, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/upUy2QhMZEmtypPW3PdieKLAHxh.jpg', 'Armando é um assassino de sangue frio com uma natureza cruel e provocadora. Ele está comprometido com o trabalho do cartel e é enviado por sua mãe para matar Mike (Smith). Nuñez assumirá o papel de Rita, psicóloga criminal durona e engraçada que é recém-nomeada chefe da AMMO e é ex-namorada de Mike.', 2);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('Carga Explosiva', '', 2008, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/v7hHxGSbL5gE0y8MuJvkgI44KsC.jpg', 'Frank Martin (Jason Statham) é obrigado a conduzir Valentina (Natalya Rudakova), a filha de Leonid Vasilev (Jeroen Krabbé), o chefe da Agência de Proteção Ambiental da Ucrânia. Ela foi sequestrada por Jonas Johnson (Robert Knepper), contratado por uma empresa de gerenciamento internacional de resíduos que deseja operar na Ucrânia. Para ter Frank e Valentina sob controle, Jonas prende em seus pulsos um dispositivo que determina que não possam se afastar muito do carro que os conduz, caso contrário o bracelete explode. Contando com a ajuda do inspetor Tarconi (François Berléand), Frank busca um meio de deixar a armadilha.', 2);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('Tartarugas Ninjas', '', 1990, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/4qmXnoI9oTo1YyQrrZcngQJnHig.jpg', 'Depois de ser atacada por trombadinhas, a repórter April O Neil (Judith Hoag) é salva por tartarugas mutantes, que passaram a se dedicar a combater o crime desde que foram contaminadas por uma substância radioativa nos esgotos de Nova York e se tornarem guerreiros após serem treinados pelo mestre Splinter. Aliadas a Casey Jones (Elias Koteas), elas combatem a organização Foot, que lança uma onda de crimes na cidade sob o comando do perigoso Demolidor.', 1);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('Naruto Shippuden', '', 2007, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/z6ES1hCbLozoquj5wilidrtKBPp.jpg', 'Naruto Shippuden ocorre 2 anos e meio após Naruto ter ficado para treinar com Jiraiya. Após seu retorno, Naruto descobre que seus amigos shinobi s o superaram na classificação, e ele caiu para trás. No entanto, com apenas 6 meses para resgatar Sasuke, Naruto tem de enfrentar inimigos ainda mais perigosos. O plano da Akatsuki se revela lentamente e os perigos surgem mais do que nunca!', 4);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('Bleach', '', 2004, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/v6UxyiDx9HRCieUZDFfhawPU37u.jpg', 'Ichigo Kurosaki é um garoto de 15 anos que tem uma estranha capacidade de ver, tocar e falar com espíritos de pessoas mortas. Logo que a shinigami Rukia Kuchiki toma conhecimento dos poderes de Ichigo, vai atrás dele para investigar, e acaba em uma luta com um Hollow que foi atraído pelo forte poder espiritual de Ichigo. Antes de ser derrotada pela criatura, Rukia passa seus poderes a Ichigo, o qual se torna um shinigami, e após derrotar o Hollow ingressa em uma jornada para proteger os humanos e os espíritos da ameaça dos Hollows.', 5);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('The Mandalorian', '', 2019, 'https://www.themoviedb.org/t/p/w500_and_h282_face/vQqdGF9rPBzyTDwJjZWWeoCYFgp.jpg', 'A saga de um guerreiro solitário, que também é um mercenário e pistoleiro, viajando pelos territórios esquecidos e marginais do espaço, logo após a queda do Império e antes da criação da temida Primeira Ordem.', 2);

INSERT INTO tb_review (name, movie_id) VALUES ('Ótimo anime, recomendo!', 5);
INSERT INTO tb_review (name, movie_id) VALUES ('Filme é horrível, o careca já foi melhor!', 2);
INSERT INTO tb_review (name, movie_id) VALUES ('A série mistura ação com comédia, super recomendo!', 6);
INSERT INTO tb_review (name, movie_id) VALUES ('Disney de parabéns!!!!!', 6);

