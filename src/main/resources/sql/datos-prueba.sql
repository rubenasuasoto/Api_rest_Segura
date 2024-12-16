INSERT INTO `usuarios`( `password`, `roles`, `username` )
VALUES ('$2a$10$DBc2FPq.4XperQMRTGpYnufwdTFxFCJtRZj1zsX.7vFo9YVe9rCyW', 'MECANICO', 'diego');

INSERT INTO `talleres`( `nombre_Taller`, `direccion`, `telefono`)
VALUES ('FixIt', 'calle margarita', '123456789');

INSERT INTO citas_Taller (`id_usuario`, `id_taller`, `fecha`, `servicio`, `estado`)
VALUES (1, 1, '2024-12-12 10:00:00', 'Cambio de frenos', 'PENDIENTE');

