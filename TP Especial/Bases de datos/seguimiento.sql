INSERT INTO `parada` (`id`, `nombre`, `parada_permitida`) VALUES
(NULL, 'Parada 1', b'1'),
(NULL, 'Parada 2', b'1');

INSERT INTO `monopatin` (`id`, `km_recorridos`, `monopatin_mantenimiento`, `tiempo_uso`, `x`, `y`, `id_parada`) VALUES
(NULL, 70.5, b'0', '00:47:38.000000', 5, 5000, 1),
(NULL, 3.3, b'0', '00:08:21.000000', 5000, 5000, 2);

INSERT INTO `viaje` (`id`, `fecha_fin`, `fecha_inicio`, `hora_fin`, `hora_inicio`, `km_recorridos`, `pausa`, `precio`, `id_monopatin`) VALUES
(NULL, '2023-10-04', '2023-10-04', '20:28:09.000000', '17:28:09.000000', 70.5, '01:06:50.000000', 5000, 1),
(NULL, '2023-10-05', '2023-10-05', '10:25:47.000000', '10:40:21.000000', 3.3, '00:00:00.000000', 5000, 2);