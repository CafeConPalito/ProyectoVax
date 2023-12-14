use vapor;

-- INSERT USUARIOS

insert into usuario (alias, email, pwd, nombre, apellido1, apellido2, fechanac, imagen, region, rol) values
('dev', 'dev@dev.com', '1234', 'devname', 'devapellido1', 'devapellido2', '1990-01-23', 'dev.png', 2, 0),
('user', 'user@user.com', '1234', 'username', 'userapellido1', 'userapellido2', '2000-01-23', 'user.png', 3, 1),
('alberto23', 'alberto23@gmail.com', 'alberto123', 'Alberto', 'García', 'López', '1990-01-23', 'alberto.jpg', 1, 1),
('maria89', 'maria89@hotmail.com', 'maria456', 'María', 'Sánchez', 'Gómez', '1989-05-12', 'maria.jpg', 1, 1),
('pablo76', 'pablo76@yahoo.com', 'pablo789', 'Pablo', 'Pérez', 'Martín', '1976-09-07', 'pablo.jpg', 1, 1),
('ana34', 'ana34@gmail.com', 'ana101', 'Ana', 'Rodríguez', 'Fernández', '1986-03-04', 'ana.jpg',2, 1),
('carlos45', 'carlos45@hotmail.com', 'carlos202', 'Carlos', 'González', 'Ruiz', '1978-06-15', 'carlos.jpg', 2, 1),
('laura67', 'laura67@yahoo.com', 'laura303', 'Laura', 'López', 'Sánchez', '1967-12-21', 'laura.jpg', 2, 1),
('david52', 'david52@gmail.com', 'david404', 'David', 'Gómez', 'Pérez', '1971-04-02', 'david.jpg', 2, 0),
('sara28', 'sara28@hotmail.com', 'sara505', 'Sara', 'Martín', 'Rodríguez', '1995-07-28', 'sara.jpg', 2, 1),
('jorge31', 'jorge31@yahoo.com', 'jorge606', 'Jorge', 'Fernández', 'González', '1992-10-31', 'jorge.jpg',3, 1),
('lucia40', 'lucia40@gmail.com', 'lucia707', 'Lucía', 'Ruiz', 'López', '1983-02-10', 'lucia.jpg', 3, 1);

-- INSERT JUEGOS

insert into juego (titulo, descripcion, imagen, fecha, numdescargas, precio, idusuario) values
('Super Mario Bros', 'Un clásico de los videojuegos de plataformas, donde el fontanero Mario debe rescatar a la princesa Peach de las garras del malvado Bowser.', 'supermario.jpg', '1985-09-13', 40000000, 19.99, 1),
('Call of Duty', 'Un juego de disparos en primera persona ambientado en la Segunda Guerra Mundial, donde el jugador debe cumplir diversas misiones en el bando aliado.', 'callofduty.jpg', '2003-10-29', 15000000, 29.99, 1),
('Minecraft', 'Un juego de construcción y supervivencia en un mundo abierto generado aleatoriamente, donde el jugador puede crear, explorar y combatir.', 'minecraft.jpg', '2011-11-18', 200000000, 24.99, 1),
('The Sims', 'Un juego de simulación de la vida, donde el jugador puede crear y controlar a personajes virtuales, satisfacer sus necesidades y cumplir sus sueños.', 'thesims.jpg', '2000-02-04', 20000000, 39.99,1);

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
("Shooter");

-- INSERT GENERO JUEGO MANY TO MANY
INSERT INTO juego_genero (idjuego,idgenero) values
(1,1),
(2,4),
(3,3),
(4,2);

INSERT INTO biblioteca(idusuario,idjuego,fecha) values
(1,1,"2023-12-13"),
(1,2,"2023-12-13"),
(2,3,"2023-12-13"),
(2,1,"2023-12-13");
