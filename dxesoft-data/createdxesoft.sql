SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `dxesoft` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `dxesoft` ;

-- -----------------------------------------------------
-- Table `dxesoft`.`contacto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`contacto` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`contacto` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `nombres` VARCHAR(200) NULL ,
  `apellidoPaterno` VARCHAR(60) NULL ,
  `apellidoMaterno` VARCHAR(60) NULL ,
  `titulo` VARCHAR(50) NULL,
  `genero` VARCHAR(10) NULL,
  `fechaCreacion` DATE NULL,
  `fechaNacimiento` DATE NULL,
  `paginaWeb` VARCHAR(500) NULL,
  `rfc` VARCHAR(15) NULL ,
  `propietario` INT(10),
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dxesoft`.`Direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`direccion` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`direccion` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `contactoId` INT(10) NOT NULL ,
  `nombreCalle` VARCHAR(100) NULL ,
  `tipoCalle` VARCHAR(80) NULL COMMENT 'tipo calle es:\ncalle\navenida\ncerrada\netc.' ,
  `numeroExterior` VARCHAR(10) NULL ,
  `numeroInterior` VARCHAR(10) NULL ,
  `colonia` VARCHAR(100) NULL ,
  `codigoPostal` VARCHAR(5) NULL ,
  `ciudad` VARCHAR(100) NULL ,
  `tipoDireccion` VARCHAR(45) NULL COMMENT 'Tipo direccion es:\nPersonal o casa\noficina\netc.\n' ,
  `estado` VARCHAR(100) NULL,
  `pais` VARCHAR(100) NULL,
  PRIMARY KEY (`Id`, `contactoId`) ,
  CONSTRAINT `fk_Direccion_Contacto`
    FOREIGN KEY (`contactoId` )
    REFERENCES `dxesoft`.`contacto` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'El estado debe venir de una tabla';

CREATE INDEX `fk_Direccion_contactoIdx` ON `dxesoft`.`direccion` (`contactoId` ASC) ;


-- -----------------------------------------------------
-- Table `dxesoft`.`telefono`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`telefono` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`telefono` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `contactoId` INT(10) NOT NULL ,
  `codigoInternacional` VARCHAR(3) NULL ,
  `numero` VARCHAR(25) NOT NULL ,
  `extension` VARCHAR(5) NULL ,
  `tipoTelefono` VARCHAR(45) NULL COMMENT 'Tipo telefono es:\nCasa\nCelular\nOficina\netc\nes un texto y no una seleccion de opciones' ,
  PRIMARY KEY (`Id`, `contactoId`) ,
  CONSTRAINT `fk_telefono_Contacto1`
    FOREIGN KEY (`contactoId` )
    REFERENCES `dxesoft`.`contacto` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_telefono_Contacto1_idx` ON `dxesoft`.`telefono` (`contactoId` ASC) ;

-- -----------------------------------------------------
-- Table `dxesoft`.`email`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`email` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`email` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `contactoId` INT(10) NOT NULL ,
  `tipoEmail` VARCHAR(45) NULL COMMENT 'Tipo telefono es:\nPersonal\nOficina\netc\nes un texto y no una seleccion de opciones' ,
  `email` VARCHAR(250) NOT NULL,
  `status` VARCHAR(45) NULL COMMENT 'Indica si se puede o no enviar mensajes a este correo',
  PRIMARY KEY (`Id`, `contactoId`),
  CONSTRAINT `fk_email_Contacto1`
    FOREIGN KEY (`contactoId` )
    REFERENCES `dxesoft`.`contacto` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE INDEX `fk_email_Contacto1_idx` ON `dxesoft`.`email` (`contactoId` ASC) ;

-- -----------------------------------------------------
-- Table `dxesoft`.`redesSociales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`redesSociales` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`redesSociales` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `contactoId` INT(10) NOT NULL ,
  `tipoRedSocial` VARCHAR(45) NULL COMMENT 'Tipo telefono es:\nFacebook\nTwitter\netc\nes un texto y no una seleccion de opciones' ,
  `nombreDeUsuario` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`Id`, `contactoId`),
  CONSTRAINT `fk_redesSociales_Contacto1`
    FOREIGN KEY (`contactoId` )
    REFERENCES `dxesoft`.`contacto` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
CREATE INDEX `fk_redesSociales_Contacto1_idx` ON `dxesoft`.`redesSociales` (`contactoId` ASC) ;


USE `dxesoft` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
