SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE TABLE `czytelnia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(255) NOT NULL,
  `opis` text NOT NULL,
  `adres` varchar(150) NOT NULL,
  `kontakt` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `czytelnia` (`id`, `nazwa`, `opis`, `adres`, `kontakt`) VALUES
(1, 'Kocia Czytelnia "Koci Pufek"', 'Witamy na stronach Systemu Zarządzania Czytelnią. Aby dodać książki,czytelników oraz wypożyczyć książki - skorzystaj z menu po lewej stronie.', 'ul. Psia 12/3 80-288 Gdańsk', 'kontakt@kociaczytelnia.pl');

CREATE TABLE `czytelnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imie` varchar(30) NOT NULL,
  `nazwisko` varchar(50) NOT NULL,
  `pesel` varchar(11) NOT NULL,
  `adres` varchar(255) NOT NULL,
  `miasto` varchar(70) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pesel` (`pesel`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `czytelnik` (`id`, `imie`, `nazwisko`, `pesel`, `adres`, `miasto`) VALUES
(1, 'Tony', 'Halik', '87020421231', 'Polna 13', 'Warszawa'),
(2, 'Miroslaw', 'Yogi', '92080108321', 'Lesna 561', 'Zmijogrod');

CREATE TABLE `ksiazka` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `autorimie` varchar(50) NOT NULL,
  `autornazwisko` varchar(70) NOT NULL,
  `tytul` varchar(120) NOT NULL,
  `iloscwypozyczen` int(5) NOT NULL DEFAULT '0',
  `wypozyczona` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `ksiazka` (`id`, `autorimie`, `autornazwisko`, `tytul`, `iloscwypozyczen`, `wypozyczona`) VALUES
(1, 'David', 'Sawyer McFarland', 'JavaScript i jQuery. Nieoficjalny podrecznik', 0, 0),
(2, 'Stephen', 'Prata', 'Jezyk C++. Szkola programowania. Wydanie VI', 0, 0),
(3, 'Thord Daniel', 'Hedengren', 'Podrecznik WordPressa. Smashing Magazine', 0, 0);

CREATE TABLE `wypozyczenia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idksiazki` int(11) NOT NULL,
  `idwypozyczajacego` int(11) NOT NULL,
  `zwrocono` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idksiazki` (`idksiazki`,`idwypozyczajacego`),
  KEY `idwypozyczajacego` (`idwypozyczajacego`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


ALTER TABLE `wypozyczenia`
  ADD CONSTRAINT `wypozyczenia_ibfk_1` FOREIGN KEY (`idksiazki`) REFERENCES `ksiazka` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `wypozyczenia_ibfk_2` FOREIGN KEY (`idwypozyczajacego`) REFERENCES `czytelnik` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
