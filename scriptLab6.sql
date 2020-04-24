-- MySQL Script generated by MySQL Workbench
-- Sat Nov 30 19:10:38 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema weather_station
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `weather_station` ;

-- -----------------------------------------------------
-- Schema weather_station
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `weather_station` DEFAULT CHARACTER SET utf8 ;
USE `weather_station` ;

-- -----------------------------------------------------
-- Table `weather_station`.`station`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weather_station`.`station` ;

CREATE TABLE IF NOT EXISTS `weather_station`.`station` (
  `idstation` INT NOT NULL,
  `installation_date` DATE NOT NULL,
  `latitude` FLOAT NOT NULL,
  `longtitude` FLOAT NOT NULL,
  `height` FLOAT NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `manufacturer_id` INT NOT NULL,
  `interval_idinterval` INT NOT NULL,
  PRIMARY KEY (`idstation`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weather_station`.`weather`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weather_station`.`weather` ;

CREATE TABLE IF NOT EXISTS `weather_station`.`weather` (
  `date` DATETIME NOT NULL,
  `temperature` FLOAT NOT NULL,
  `humidity` FLOAT NOT NULL,
  `pressure` FLOAT NOT NULL,
  `wind_direction` VARCHAR(20) NOT NULL,
  `wind_speed` FLOAT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `station_idstation` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weather_station`.`service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weather_station`.`service` ;

CREATE TABLE IF NOT EXISTS `weather_station`.`service` (
  `id` INT NOT NULL,
  `date` DATE NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `station_idstation` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weather_station`.`interval`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weather_station`.`interval` ;

CREATE TABLE IF NOT EXISTS `weather_station`.`interval` (
  `idinterval` INT NOT NULL,
  `setting` INT NULL,
  `general` INT NULL,
  PRIMARY KEY (`idinterval`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weather_station`.`manufacturer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weather_station`.`manufacturer` ;

CREATE TABLE IF NOT EXISTS `weather_station`.`manufacturer` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `weather_station`.`station`
-- -----------------------------------------------------
START TRANSACTION;
USE `weather_station`;
INSERT INTO `weather_station`.`station` (`idstation`, `installation_date`, `latitude`, `longtitude`, `height`, `country`, `manufacturer_id`, `interval_idinterval`) VALUES (1, '2009-12-10', 49.4656, 24.0455, 340, 'Ukraine', 1, 1);
INSERT INTO `weather_station`.`station` (`idstation`, `installation_date`, `latitude`, `longtitude`, `height`, `country`, `manufacturer_id`, `interval_idinterval`) VALUES (2, '2015-12-12', 48.4523, 32.5500, 100, 'Ukraine', 4, 2);
INSERT INTO `weather_station`.`station` (`idstation`, `installation_date`, `latitude`, `longtitude`, `height`, `country`, `manufacturer_id`, `interval_idinterval`) VALUES (3, '2019-01-04', 52.8570, 20.8900, 120, 'Poland ', 3, 3);
INSERT INTO `weather_station`.`station` (`idstation`, `installation_date`, `latitude`, `longtitude`, `height`, `country`, `manufacturer_id`, `interval_idinterval`) VALUES (4, '2016-12-10', 52.4560, 28.0000, 345, 'Ukraine', 4, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `weather_station`.`weather`
-- -----------------------------------------------------
START TRANSACTION;
USE `weather_station`;
INSERT INTO `weather_station`.`weather` (`date`, `temperature`, `humidity`, `pressure`, `wind_direction`, `wind_speed`, `id`, `station_idstation`) VALUES ('2017-06-15 09:34:21', 25, 50.9, 745, 'WEST', 12.0, 1, 1);
INSERT INTO `weather_station`.`weather` (`date`, `temperature`, `humidity`, `pressure`, `wind_direction`, `wind_speed`, `id`, `station_idstation`) VALUES ('2018-06-15 09:34:21', 26, 50.9, 760, 'EAST', 3.5, 2, 2);
INSERT INTO `weather_station`.`weather` (`date`, `temperature`, `humidity`, `pressure`, `wind_direction`, `wind_speed`, `id`, `station_idstation`) VALUES ('2017-06-15 10:34:20', 10, 50.9, 745, 'WEST', 3.5, 3, 3);
INSERT INTO `weather_station`.`weather` (`date`, `temperature`, `humidity`, `pressure`, `wind_direction`, `wind_speed`, `id`, `station_idstation`) VALUES ('2017-06-15 10:34:20', 23, 50.9, 760.0, 'EAST', 12.0, 4, 4);
INSERT INTO `weather_station`.`weather` (`date`, `temperature`, `humidity`, `pressure`, `wind_direction`, `wind_speed`, `id`, `station_idstation`) VALUES ('2017-06-12 11:34:21', 23, 74.5, 745, 'WEST', 3.5, 5, 1);
INSERT INTO `weather_station`.`weather` (`date`, `temperature`, `humidity`, `pressure`, `wind_direction`, `wind_speed`, `id`, `station_idstation`) VALUES ('2017-06-15 10:34:20', 23, 74.5, 720.9, 'EAST', 12.0, 6, 2);


COMMIT;


-- -----------------------------------------------------
-- Data for table `weather_station`.`service`
-- -----------------------------------------------------
START TRANSACTION;
USE `weather_station`;
INSERT INTO `weather_station`.`service` (`id`, `date`, `description`, `station_idstation`) VALUES (1, '2018-09-18', 'service review', 1);
INSERT INTO `weather_station`.`service` (`id`, `date`, `description`, `station_idstation`) VALUES (2, '2018-05-09', 'service review', 1);
INSERT INTO `weather_station`.`service` (`id`, `date`, `description`, `station_idstation`) VALUES (3, '2018-04-09', 'service review', 2);
INSERT INTO `weather_station`.`service` (`id`, `date`, `description`, `station_idstation`) VALUES (4, '2017-02-01', 'service review', 4);


COMMIT;


-- -----------------------------------------------------
-- Data for table `weather_station`.`interval`
-- -----------------------------------------------------
START TRANSACTION;
USE `weather_station`;
INSERT INTO `weather_station`.`interval` (`idinterval`, `setting`, `general`) VALUES (1, 15, NULL);
INSERT INTO `weather_station`.`interval` (`idinterval`, `setting`, `general`) VALUES (2, 10, NULL);
INSERT INTO `weather_station`.`interval` (`idinterval`, `setting`, `general`) VALUES (3, NULL, 60);
INSERT INTO `weather_station`.`interval` (`idinterval`, `setting`, `general`) VALUES (4, 12, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `weather_station`.`manufacturer`
-- -----------------------------------------------------
START TRANSACTION;
USE `weather_station`;
INSERT INTO `weather_station`.`manufacturer` (`id`, `name`, `country`) VALUES (1, 'Ea2 BL508 Slim', 'China');
INSERT INTO `weather_station`.`manufacturer` (`id`, `name`, `country`) VALUES (2, 'TFA 35.1152.02', 'China');
INSERT INTO `weather_station`.`manufacturer` (`id`, `name`, `country`) VALUES (3, 'Meteo SP73', 'USA');
INSERT INTO `weather_station`.`manufacturer` (`id`, `name`, `country`) VALUES (4, 'La Crosse WS6812', 'China');
INSERT INTO `weather_station`.`manufacturer` (`id`, `name`, `country`) VALUES (5, 'Ea2 AL808 Aluminium Slim', 'USA');
INSERT INTO `weather_station`.`manufacturer` (`id`, `name`, `country`) VALUES (6, 'Clatronic WSU 7026', 'China');
INSERT INTO `weather_station`.`manufacturer` (`id`, `name`, `country`) VALUES (7, 'TFA 30.5048.01', 'USA');
INSERT INTO `weather_station`.`manufacturer` (`id`, `name`, `country`) VALUES (8, 'La Crosse WS9057', 'Ukraine');
INSERT INTO `weather_station`.`manufacturer` (`id`, `name`, `country`) VALUES (9, 'Oregon Scientific RAR502', 'Ukraine');
INSERT INTO `weather_station`.`manufacturer` (`id`, `name`, `country`) VALUES (10, 'TFA 35.1151.01', 'Ukraine');

COMMIT;

