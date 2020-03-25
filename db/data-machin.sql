-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-03-2020 a las 16:19:47
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `data-machin`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ban`
--

CREATE TABLE `ban` (
  `id` varchar(20) NOT NULL,
  `Motivo` varchar(20) NOT NULL,
  `duracion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ban`
--

INSERT INTO `ban` (`id`, `Motivo`, `duracion`) VALUES
('123456', 'S', 'xxxx'),
('43234', 'sadas', 'asdd'),
('457ce8368fede64b8f9c', 'd', 'd');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `doc` varchar(20) NOT NULL,
  `posteador` text NOT NULL,
  `comentario` text NOT NULL,
  `id` text NOT NULL,
  `coment_id` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`doc`, `posteador`, `comentario`, `id`, `coment_id`) VALUES
('', '', '', '', '1'),
('11ql4A7iD23jxX', 'Mateo Jimenez', 'Would you watch a show where a billionaire CEO has to go an entire month on their lowest paid employees salary, without access to any other resources than that of the employee? What do you think would happen?', '13123', ''),
('14789', '', '', '', ''),
('159', '', '', '', ''),
('1598', '', '', '', ''),
('555', '', '', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `posts`
--

CREATE TABLE `posts` (
  `id` varchar(20) NOT NULL,
  `posteador` text NOT NULL,
  `fecha` text NOT NULL,
  `post_content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `posts`
--

INSERT INTO `posts` (`id`, `posteador`, `fecha`, `post_content`) VALUES
('11ql4A7iD23jxX', 'b0618219f819fd78a8bc ', '12 feb', 'If you could see a list of every person\'s name and face (including strangers) that thought about you sexually at least once, would you want to see it and why?'),
('123', '2026dc518d05e03e001b ', '23 ene', 'Ayer cumplí 13 e invité como a 10 amigos, mi mamá me preparo todo, para pasármela bien con mis amigos, pastel, churritos, globos, la mesa con mantel, un cartel de felicidades hermoso. Nadie vino... Mamá si lees esto quiero que sepas que te amo y gracias por todo, después de todo pude estar a tu lado ? :’)'),
('14789', '2026dc518d05e03e001b ', '7 dic', 'Quisiera que todos los  , no todosss que lean esto tengan el mejor día de su vida :3 ejejejejej'),
('159', '2026dc518d05e03e001b ', '10 agos', 'En mayo cumplo los 18 años y nunca he probado una sola gota de alcohol, literalmente, nunca he fumado, y voy a llegar virgen. Soy leyenda :v'),
('23124', '2026dc518d05e03e001b ', '2 ene', 'Estoy aburrido , no hay nada q hacer :v'),
('5543KKlsndnfMn', '2026dc518d05e03e001b ', '13123', 'Holaaaaaaaaaaaaaaaaaaaa'),
('65HVNmbasa8i', '2026dc518d05e03e001b ', '33 juli', 'Esto es otro post'),
('9908HHGXXx443', '2026dc518d05e03e001b ', '5 juni', 'Hola mundo soy Riuz :)'),
('ASSJBJBbn3', 'b0618219f819fd78a8bc ', '4 agos', 'Hola\r\n'),
('B6ql8A7iD23j5z', '2026dc518d05e03e001b ', '', 'Hey tu el chico o chica que se detuvo a leer esto ten un hermoso día príncipe o princesa y eres una persona Hermosa que nadie te diga lo contrario y si tu novio o novia no te lo an dicho eres lindo o linda :3 Att:V'),
('B6ql8A7iDRV65m', '2026dc518d05e03e001b ', '', 'Yo cuando leo los secretos: -No lo sé Rick, parece falso*'),
('fg879jjnnbio', '2026dc518d05e03e001b ', '', 'Delgado es mk jejeje ._.XD ?');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `user` varchar(20) NOT NULL,
  `token` text NOT NULL,
  `grado` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`user`, `token`, `grado`) VALUES
('', 'cd38e9c2f30ee1b81ac8', ''),
(' Para otros usos de ', 'eb79c8230120d0f497d0', ''),
('Ana maria santos', 'b8595b54772cc21c86ba', ''),
('Anjelica beltran', 'aaee51d382653dd6a9bf', ''),
('asdadsadasdasdasd', 'd04738fbd3a6b6f07b44', ''),
('Camila zuares', 'fdae881fe1a46fda152b', '11-4'),
('Carla', 'e217314230e34af30dee', '11-2'),
('Darly Jasmin ', 'e09b9408c62240748132', ''),
('j', '93de7a789c20dfbe257d', ''),
('k', 'da61536e60e7d03b36a1', ''),
('Karol Galbal olibero', 'f1090c02991a950f6667', '11-2'),
('Laragon', '18aa48118a13162a365f', '11-3'),
('Mateo Jimenez', '3371faa76f31ab393ecc', '11-4'),
('s', '5bdf445ad7677ca13b4a', ''),
('Sukeina', 'ac7b8e6d5f2fd7516547', ''),
('xxxxx', 'b34d3e88f4afad7c1de4', ''),
('yan', '34234', '11-4'),
('zzzz', '1559e61c1e3fab8d5cf6', '11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `Correo` varchar(20) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Contraseña` varchar(20) NOT NULL,
  `id` text NOT NULL,
  `apellido` text NOT NULL,
  `token` text NOT NULL,
  `session_token` varchar(20) NOT NULL,
  `ban` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`Correo`, `Nombre`, `Contraseña`, `id`, `apellido`, `token`, `session_token`, `ban`) VALUES
('123', 'Dostin', 'xxxx', '457ce8368fede64b8f9c ', 'Urtado', 'dostin007', 'a45zk16yqe8agjehñm9f', 'true'),
('14789', 'Pepito', 'llllsdasdasd', 'b0618219f819fd78a8bc ', 'Gomez', 'Pepe2020', '0', 'false'),
('1598', 'fulanita', 'xxxx', 'a4c2fafaef1f8794ff22 ', 'Perez', 'Adri27', '0', 'false'),
('blalala', 'Ana', 'blala', '2026dc518d05e03e001b ', 'Jimenez', 'anajimenez33', '0', 'false'),
('darly23', 'Darly', '123', '434234', 'Jasmin', 'Darly2303', '0', 'false'),
('hhh', 'Ana', 'hhh', '988088', 'Dolessssssssss', 'Anadolores55YT', 's', 'false'),
('mj9220019@gmail.com', 'Adriana', '123', 'a1490c9b4bf185ef1123 ', 'Gomez', 'Fotos44', '234hv2h4v34m33', 'false'),
('nacional21_23@hotmai', 'Mateo', '123', '0a89d7d300d556c80084', 'Jimenez', 'Riuz', 'mm', 'false');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`doc`);

--
-- Indices de la tabla `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`user`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Correo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
