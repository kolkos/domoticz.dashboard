INSERT INTO `device` (`id`, `gid`, `name`) VALUES
    (1, 1, 'Light #1'),
    (2, 4, 'Light #2'),
    (3, 6, 'Dimmer #1'),
    (4, 7, 'Thermostat #1'),
    (5, 3, 'Contact #1'),
    (6, 1, 'Test scene');

INSERT INTO `dimmer` (`max_level`, `min_level`, `id`) VALUES
    (16, 0, 3);

INSERT INTO `heater` (`max_temperature`, `min_temperature`, `id`) VALUES
    (30, 10, 4);

INSERT INTO `scene` (`id`) VALUES
    (6);

INSERT INTO `switch` (`id`) VALUES
    (1),
    (2);

INSERT INTO `contact` (`id`) VALUES
    (5);
