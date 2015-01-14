SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `dxesoft` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `dxesoft` ;

-- -----------------------------------------------------
-- Table `dxesoft`.`contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`contact` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`contact` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `Contact_name` VARCHAR(200) NULL ,
  `Last_name` VARCHAR(60) NULL ,
  `Apellido_materno` VARCHAR(60) NULL ,
  `Gender` VARCHAR(10) NULL,
  `Creation_date` DATE NULL,
  `Birth_date` DATE NULL,
  `Web_page` VARCHAR(500) NULL,
  `Owner` INT(10),
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dxesoft`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`address` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`address` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `Contact_id` INT(10) NOT NULL ,
  `Street` VARCHAR(100) NULL ,
  `Street_type` VARCHAR(80) NULL COMMENT 'tipo calle es:\ncalle\navenida\ncerrada\netc.' ,
  `Street_number` VARCHAR(10) NULL ,
  `Apartment_number` VARCHAR(10) NULL ,
  `Colonia` VARCHAR(100) NULL ,
  `Zip_code` VARCHAR(10) NULL ,
  `Address_type` VARCHAR(45) NULL COMMENT 'Tipo address es:\nPersonal o casa\noficina\netc.\n' ,
  `City` VARCHAR(100) NULL ,
  `State` VARCHAR(100) NULL,
  `Country` VARCHAR(100) NULL,
  PRIMARY KEY (`Id`, `Contact_id`) ,
  CONSTRAINT `fk_Address_Contact`
    FOREIGN KEY (`Contact_id` )
    REFERENCES `dxesoft`.`contact` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'El State debe venir de una tabla';

CREATE INDEX `fk_Address_contactIdx` ON `dxesoft`.`address` (`Contact_id` ASC) ;


-- -----------------------------------------------------
-- Table `dxesoft`.`Phone_number`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`phone_number` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`phone_number` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `Contact_id` INT(10) NOT NULL ,
  `International_code` VARCHAR(3) NULL ,
  `Phone_number` VARCHAR(25) NOT NULL ,
  `extension` VARCHAR(5) NULL ,
  `Phone_type` VARCHAR(45) NULL COMMENT 'Tipo Phone_number es:\nCasa\nCelular\nOficina\netc\nes un texto y no una seleccion de opciones' ,
  PRIMARY KEY (`Id`, `Contact_id`) ,
  CONSTRAINT `fk_phone_Contact`
    FOREIGN KEY (`Contact_id` )
    REFERENCES `dxesoft`.`contact` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_phone_Contact_idx` ON `dxesoft`.`phone_number` (`Contact_id` ASC) ;

-- -----------------------------------------------------
-- Table `dxesoft`.`email`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`email` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`email` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `Contact_id` INT(10) NOT NULL ,
  `Email_type` VARCHAR(45) NULL COMMENT 'Tipo telefono es:\nPersonal\nOficina\netc\nes un texto y no una seleccion de opciones' ,
  `Email` VARCHAR(250) NOT NULL,
  `Status` VARCHAR(45) NULL COMMENT 'Indica si se puede o no enviar mensajes a este correo',
  PRIMARY KEY (`Id`, `Contact_id`),
  CONSTRAINT `fk_email_Contact`
    FOREIGN KEY (`Contact_id` )
    REFERENCES `dxesoft`.`contact` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE INDEX `fk_email_Contact_idx` ON `dxesoft`.`email` (`Contact_id` ASC) ;

-- -----------------------------------------------------
-- Table `dxesoft`.`social_network`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`social_network` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`social_network` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `Contact_id` INT(10) NOT NULL ,
  `social_network_type` VARCHAR(45) NULL COMMENT 'Tipo telefono es:\nFacebook\nTwitter\netc\nes un texto y no una seleccion de opciones' ,
  `social_network_user` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`Id`, `Contact_id`),
  CONSTRAINT `fk_Social_network_contact`
    FOREIGN KEY (`Contact_id` )
    REFERENCES `dxesoft`.`contact` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE INDEX `fk_social_network_Contact_idx` ON `dxesoft`.`social_network` (`Contact_id` ASC) ;


USE `dxesoft` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
