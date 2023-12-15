use vapor;

-- INSERT USUARIOS

insert into usuario (alias, email, pwd, nombre, apellido1, apellido2, fechanac, imagen, region, rol) values
('@agllabs', 'agllabs@agllabs.com', '1234', 'Augusto', 'Gonzalez', 'Linares', '2023-01-12', 'agllabs.png', 1, 0),
('@dev', 'dev@dev.com', '1234', 'devname', 'devapellido1', 'devapellido2', '1990-01-23', 'user.jpg', 2, 0),
('@user', 'user@user.com', '1234', 'username', 'userapellido1', 'userapellido2', '2000-01-23', 'user.jpg', 2, 1);

-- INSERT JUEGOS

insert into juego (titulo, descripcion, imagen, fecha, numdescargas, precio, idusuario) values
('Cantabria entre muros', 'Es un juego basado en las Guerras Cántabras, para expulsar a los romanos de nuestras tierras.', 'Cantabriaentremuros.png', '2023-01-12', 7, 0, 1),
('Rooted Decks', 'Juego de cartas basado en plantas. Donde el jugador tendrá que derrotar a su rival con las cartas que posee.', 'RootedDecks.png', '2023-01-12', 14, 15, 1),
('Deep Roots', '"Deep Roots" es un juego de plataformas que al contrario que las raíces que buscan la oscuridad y la profundidad para crear, nosotros necesitaremos buscar la luz.', 'DeepRoots.png', '2023-01-12', 11, 24, 1),
('Cafe Con Palito','Un juego de mazmorras lleno de desafíos, monstruos y tesoros ocultos. Los jugadores exploran pasillos retorcidos, enfrentando trampas mortales.', 'CafeConPalito.png', '2023-12-15', 200, 10.95,1);

-- INSERT REGULACIONES DE JUEGOS

insert into regulacion (region, nivel) values
(1,'+3'),
(1,'+7'),
(1,'+12'),
(1,'+16'),
(1, '+18'),
(2,'A'),
(2,'B'),
(2,'C'),
(2,'D'),
(2, 'Z'),
(3,'E'),
(3,'E10+'),
(3,'T'),
(3,'M'),
(3, 'AO'),
(4,'G'),
(4,'PG'),
(4,'M'),
(4,'MA'),
(4, 'R'),
(5,'0'),
(5,'6'),
(5,'12'),
(5,'16'),
(5, '18');

-- INSERT REGULACION JUEGO MANY TO MANY
insert into regulacion_juego(idregulacion,idjuego) values
(1,1),
(6,1),
(11,1),
(16,1),
(21,1),
(5,2),
(10,2),
(15,2),
(20,2),
(25,2),
(1,3),
(6,3),
(11,3),
(16,3),
(21,3),
(1,4),
(6,4),
(11,4),
(16,4),
(21,4);

-- INSERT GENEROS
INSERT INTO genero (name) values
("Plataformas"),
("Estrategia"),
("Survival"),
("Shooter"),
("Aventuras");

-- INSERT GENERO JUEGO MANY TO MANY
INSERT INTO juego_genero (idjuego,idgenero) values
(1,2),
(2,1),
(3,1),
(4,5);

INSERT INTO biblioteca(idusuario,idjuego,fecha) values
(1,4,"2023-12-13"),
(2,4,"2023-12-13");