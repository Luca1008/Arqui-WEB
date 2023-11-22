INSERT INTO `cuenta` (`id`, `activada`, `dinero`, `fecha_alta`) VALUES
(NULL, b'1', 250, '2023-11-13'),
(NULL, b'1', 5000000, '2023-11-20');

INSERT INTO `usuario` (`id`, `apellido`, `celular`, `contrasenia`, `email`, `nombre`) VALUES
(NULL, 'Lucio', 0, '$2a$10$K0TBht0M3t1oYcO7Jlmc/.YAqpquzc8RtHAtQlciYqZaPkizKOSGm', 'admin@gmail.com', 'Gonzalo'),
(NULL, 'Guidi', 0, '$2a$10$spQeSwxctnHuNu64p0oTSOaXmTW4aoaHwq7HX55NVqto/OBPnHtBC', 'user@gmail.com', 'Luca'),
(NULL, 'Urdangarin', 0, '$2a$10$2.gAkT15q.4txxqWE.BScORFx/Ct1on4//Xpf4mPwKcQn8Bw0XDTG', 'mantenimiento@gmail.com', 'Nico');

INSERT INTO `autoridad` (`nombre`) VALUES
('ADMIN'),
('USER'),
('MANTENIMIENTO');

INSERT INTO `usuario_autoridad` (`usuario_id`, `autoridad_id`) VALUES
(1, 'ADMIN'),
(2, 'USER'),
(3, 'MANTENIMIENTO');

INSERT INTO `usuario_cuenta` (`usuario_id`, `cuenta_id`) VALUES
(1, 1),
(2, 1),
(3, 1);
