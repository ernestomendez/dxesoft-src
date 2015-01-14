USE `dxesoft` ;
-- -----------------------------------------------------
-- Table `dxesoft`.`opportunity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`opportunity` ;

CREATE TABLE IF NOT EXISTS `dxesoft`.`opportunity` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `Contact_id` INT(10) NOT NULL,
  `Name` VARCHAR(250) NULL ,
  `Expected_close_date` DATE NULL ,
  `Creation_date` DATE NOT NULL,
  `Stage_id` INT(10) NOT NULL,
  `Notes` VARCHAR(5000) NULL ,
  PRIMARY KEY (`Id`),
  CONSTRAINT `fk_Opportunity_Contacto`
    FOREIGN KEY (`Contact_id` )
    REFERENCES `dxesoft`.`contact` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Opportunity_Contact_id` ON `dxesoft`.`opportunity` (`Contact_id` ASC) ;

-- -----------------------------------------------------
-- Table `dxesoft`.`action`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`action` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`action` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `Contact_id` INT(10) NOT NULL ,
  `Description` VARCHAR(500) NULL ,
  `Creation_date` DATE NOT NULL ,
  `End_date` DATE NULL ,
  `Status` VARCHAR(10) NOT NULL,
  `Type` VARCHAR(45) NOT NULL COMMENT 'Type can be \n Call\nEmail\nOther.' ,
  `Notes` VARCHAR(5000) NULL,
  PRIMARY KEY (`Id`) ,
  CONSTRAINT `fk_action_contact`
    FOREIGN KEY (`Contact_id` )
    REFERENCES `dxesoft`.`contact` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Action_Contact_idx` ON `dxesoft`.`action` (`Contact_id` ASC) ;


-- -----------------------------------------------------
-- Table `dxesoft`.`Opportunity_Action`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`opportunity_action` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`opportunity_action` (
  `Opportunity_id` INT(10) NOT NULL,
  `Action_id` INT(10) NOT NULL ,
  PRIMARY KEY (`Opportunity_id`, `Action_id`),
  CONSTRAINT `fk_Opportunity`
    FOREIGN KEY (`Opportunity_id` )
    REFERENCES `dxesoft`.`opportunity` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_Action`
    FOREIGN KEY (`Action_id` )
    REFERENCES `dxesoft`.`action` (`Id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dxesoft`.`stage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dxesoft`.`stage` ;

CREATE  TABLE IF NOT EXISTS `dxesoft`.`stage` (
  `Id` INT(10) NOT NULL AUTO_INCREMENT ,
  `Stage_name` VARCHAR(100) NOT NULL ,
  `Active` TINYINT(1) NOT NULL ,
  `Order` INT(3) NOT NULL ,
  `Is_final` TINYINT(1) NOT NULL ,
  `Creation_date` DATE NULL ,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;

CREATE INDEX `Stages_idx` ON `dxesoft`.`stage` (`Order` ASC) ;



