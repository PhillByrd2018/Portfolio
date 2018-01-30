-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 28, 2017 at 07:40 AM
-- Server version: 5.6.36-82.1-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `phill664_CSCI_332`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`phill664`@`localhost` PROCEDURE `UpdateBAL` (IN `ID` INT(10), IN `AMT` INT(10), IN `PAID` INT(10))  UPDATE Balances SET 
Balances.TotalAmount= AMT,
Balances.Paid=PAID,
Balances.Remaining=(AMT-PAID)
WHERE Balances.ContractID=ID$$

--
-- Functions
--
CREATE DEFINER=`phill664`@`localhost` FUNCTION `Calculator` (`id` INT(10)) RETURNS INT(11) BEGIN
   
	DECLARE totalAmt INT(25);
	DECLARE ser_type VARCHAR(15);
	DECLARE vault CHAR(5);
	DECLARE section INT(25);
	   
	SET totalAmt = 0;   
	SET ser_type = (select Service_Type from Services_rendered Where ContractID= id);
	SET vault = (select Vault from Services_rendered Where ContractID= id);
	SET section = (select Section from Services_rendered Where ContractID= id);
	   
	IF ser_type = "Burial" THEN SET totalAmt = totalAmt + 5000;
	ELSE SET totalAmt = totalAmt + 2500;
	END IF;
	   
	IF vault = 'Y' THEN SET totalAmt = totalAmt + 500;
	ELSE SET totalAmt = totalAmt + 250;
	END IF;
	   
	IF section < 150 THEN SET totalAmt = totalAmt + 700;
	ELSEIF section > 151 AND section < 350 THEN SET totalAmt = totalAmt+ 500;
	ELSE SET totalAmt = totalAmt + 250;
	END IF;
	   
	RETURN(totalAmt);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `Balances`
--

CREATE TABLE `Balances` (
  `ContractID` int(11) NOT NULL,
  `TotalAmount` int(11) NOT NULL,
  `Paid` int(11) NOT NULL,
  `Remaining` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Balances`
--

INSERT INTO `Balances` (`ContractID`, `TotalAmount`, `Paid`, `Remaining`) VALUES
(49, 5000, 1000, 4000),
(62, 3000, 1600, 1400),
(63, 5500, 2000, 3500);

-- --------------------------------------------------------

--
-- Table structure for table `Cause_of_Death`
--

CREATE TABLE `Cause_of_Death` (
  `ContractID` int(11) DEFAULT NULL,
  `C_O_D` varchar(30) DEFAULT NULL,
  `Foul_Play` char(1) DEFAULT NULL,
  `Sex` char(1) DEFAULT NULL,
  `height` varchar(4) DEFAULT '0.0',
  `weight` varchar(4) DEFAULT '0.0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Cause_of_Death`
--

INSERT INTO `Cause_of_Death` (`ContractID`, `C_O_D`, `Foul_Play`, `Sex`, `height`, `weight`) VALUES
(38, 'Attack by Emu', 'N', 'F', '5.11', '135'),
(41, 'Cancer', 'N', 'M', '5.11', '225'),
(49, 'Kicked by a horse', 'N', 'M', '5.10', '200'),
(62, 'Bad Oyster', 'N', 'M', '5.9', '195'),
(63, 'Failed a Class', 'Y', 'M', '6.00', '170');

-- --------------------------------------------------------

--
-- Table structure for table `Certificate_Info`
--

CREATE TABLE `Certificate_Info` (
  `ContractID` int(11) NOT NULL,
  `Address` varchar(85) NOT NULL,
  `SSN` varchar(13) NOT NULL,
  `DC_Num` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Certificate_Info`
--

INSERT INTO `Certificate_Info` (`ContractID`, `Address`, `SSN`, `DC_Num`) VALUES
(38, '212 West Coleman Blvd Charleston,SC', '234781029', 980561),
(41, '100 Nottoway Blvd. Dothan, AL', '345201290', 752309),
(49, '300 EastWay Blvd Charleston,SC', '345128923', 76892),
(62, '200 Lanister Lane Charleston, SC', '3457891234', 5673448),
(63, '725 Bull Street Charleston,SC', '789237867', 3489329);

-- --------------------------------------------------------

--
-- Table structure for table `Deceased`
--

CREATE TABLE `Deceased` (
  `ContractID` int(11) NOT NULL,
  `firstName` varchar(15) NOT NULL DEFAULT '',
  `lastName` varchar(15) NOT NULL DEFAULT '',
  `DOB` varchar(10) NOT NULL DEFAULT '--/--/----',
  `DOD` varchar(10) NOT NULL DEFAULT '--/--/----',
  `Age` int(11) NOT NULL DEFAULT '0',
  `Service_Type` varchar(30) NOT NULL DEFAULT 'Unkown'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Deceased`
--

INSERT INTO `Deceased` (`ContractID`, `firstName`, `lastName`, `DOB`, `DOD`, `Age`, `Service_Type`) VALUES
(38, 'Danny', 'Allens', '2000-02-02', '2017-11-13', 17, 'Cremation'),
(41, 'Robert', 'Burns', '1956-10-10', '2017-11-11', 61, 'Burial'),
(49, 'Tom', 'Tomson', '2006-06-13', '2017-11-08', 11, 'Burial'),
(62, 'William', 'Rogers', '1987-02-04', '2017-11-01', 30, 'Cremation'),
(63, 'Phillip', 'Byrd', '1990-10-20', '2017-11-02', 27, 'Burial');

--
-- Triggers `Deceased`
--
DELIMITER $$
CREATE TRIGGER `BalanceMaker` AFTER INSERT ON `Deceased` FOR EACH ROW BEGIN

INSERT INTO Balances VALUES(NEW.ContractID,0,0,0);



END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `delALL` BEFORE DELETE ON `Deceased` FOR EACH ROW BEGIN

        DELETE FROM Service_Info WHERE Service_Info.ContractID = OLD.ContractID;
        DELETE FROM Plot_Info WHERE Plot_Info.ContractID = OLD.ContractID;
        DELETE FROM Next_Of_Kin WHERE Next_Of_Kin.ContractID = OLD.ContractID;
        DELETE FROM Certificate_Info WHERE Certificate_Info.ContractID = OLD.ContractID;
        DELETE FROM Cause_of_Death WHERE Cause_of_Death.ContractID = OLD.ContractID;
        DELETE FROM Balances WHERE Balances.ContractID = OLD.ContractID;
        
        
 
    END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `Login_Info`
--

CREATE TABLE `Login_Info` (
  `UserName` varchar(35) NOT NULL,
  `Password` varchar(35) NOT NULL,
  `UserID` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Login_Info`
--

INSERT INTO `Login_Info` (`UserName`, `Password`, `UserID`) VALUES
('Phill100', 'test', 1),
('Megan200', 'oyster', 2),
('Tommy', 'Pass', 8),
('Bob', 'doggy', 9);

-- --------------------------------------------------------

--
-- Table structure for table `Next_Of_Kin`
--

CREATE TABLE `Next_Of_Kin` (
  `ContractID` int(10) NOT NULL,
  `NOK_ID` int(10) NOT NULL,
  `firstName` varchar(13) DEFAULT NULL,
  `lastName` varchar(15) DEFAULT NULL,
  `Address` varchar(50) NOT NULL DEFAULT '',
  `Phone` varchar(17) DEFAULT NULL,
  `Email` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Next_Of_Kin`
--

INSERT INTO `Next_Of_Kin` (`ContractID`, `NOK_ID`, `firstName`, `lastName`, `Address`, `Phone`, `Email`) VALUES
(38, 114, 'Mandi', 'Allens', '212 West Coleman Blvd Charleston,SC', '2346781920', 'Allens@gmail.com'),
(41, 116, 'Toni', 'Burns', '100 Nottoway Blvd. Dothan,AL', '1237891234', 'Burns@gmail.com'),
(49, 118, 'Jane ', 'Tomson', '300 EastWay Blvd Charleston,SC', '2347891234', 'Jane@gmail.com'),
(62, 122, 'Dennis', 'Rogers', '200 Lanister Lane Charleston, SC', '3450981290', 'Rogers@gmail.com'),
(63, 123, 'Robert', 'Byrd', '100 Nottoway Blvd Dothan,AL', '3347962132', 'byrd@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `Plot_Info`
--

CREATE TABLE `Plot_Info` (
  `ContractID` int(13) DEFAULT NULL,
  `Section` varchar(50) NOT NULL,
  `Plot_Number` int(25) NOT NULL,
  `Vault` char(1) NOT NULL DEFAULT 'Y',
  `HeadStone` varchar(50) NOT NULL DEFAULT 'RIP'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Plot_Info`
--

INSERT INTO `Plot_Info` (`ContractID`, `Section`, `Plot_Number`, `Vault`, `HeadStone`) VALUES
(62, 'New Hope', 256, 'Y', 'Live Long and Prosper'),
(63, 'New Hope', 367, 'Y', 'He was not a good student'),
(38, 'The Holy Family', 675, 'N', 'Into Your Hands I Commit My Spirit'),
(49, 'Quiet Plains', 678, 'Y', 'He was a good man'),
(41, 'New Hope', 756, 'Y', 'Do this in memory of me');

-- --------------------------------------------------------

--
-- Stand-in structure for view `Services_rendered`
-- (See below for the actual view)
--
CREATE TABLE `Services_rendered` (
`ContractID` int(13)
,`Service_Type` varchar(30)
,`Service_Official` varchar(30)
,`Service_Location` varchar(60)
,`Service_Date` varchar(20)
,`Section` varchar(50)
,`Plot_Number` int(25)
,`Vault` char(1)
,`HeadStone` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `Service_Info`
--

CREATE TABLE `Service_Info` (
  `ContractID` int(10) NOT NULL,
  `Service_Type` varchar(30) NOT NULL DEFAULT '',
  `Service_Official` varchar(30) NOT NULL DEFAULT '',
  `Service_Location` varchar(60) NOT NULL DEFAULT '',
  `Service_Date` varchar(20) NOT NULL DEFAULT '--/--/----'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Service_Info`
--

INSERT INTO `Service_Info` (`ContractID`, `Service_Type`, `Service_Official`, `Service_Location`, `Service_Date`) VALUES
(38, 'Open Casket', 'Father Bob Jones', 'St. Mary Catholic Church', '2017-11-08'),
(41, 'Burial', 'Rev William Jones', 'First Methodist Church- Charleston, SC', '2017-11-14'),
(49, 'Burial', 'Rev. Billie Thorn', 'First Baptist Church, Charleston', '2017-11-15'),
(62, 'Cremation', 'Rev. Billie Thorn', 'First Baptist Church, Charleston', '2017-11-14'),
(63, 'Burial', 'Rev Tim Hollow', 'First Baptist Church, Charleston', '2017-11-10');

-- --------------------------------------------------------

--
-- Structure for view `Services_rendered`
--
DROP TABLE IF EXISTS `Services_rendered`;

CREATE ALGORITHM=UNDEFINED DEFINER=`phill664`@`localhost` SQL SECURITY DEFINER VIEW `Services_rendered`  AS  select `p`.`ContractID` AS `ContractID`,`s`.`Service_Type` AS `Service_Type`,`s`.`Service_Official` AS `Service_Official`,`s`.`Service_Location` AS `Service_Location`,`s`.`Service_Date` AS `Service_Date`,`p`.`Section` AS `Section`,`p`.`Plot_Number` AS `Plot_Number`,`p`.`Vault` AS `Vault`,`p`.`HeadStone` AS `HeadStone` from (`Plot_Info` `p` join `Service_Info` `s`) where (`p`.`ContractID` = `s`.`ContractID`) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Balances`
--
ALTER TABLE `Balances`
  ADD PRIMARY KEY (`ContractID`);

--
-- Indexes for table `Cause_of_Death`
--
ALTER TABLE `Cause_of_Death`
  ADD KEY `ContractID` (`ContractID`);

--
-- Indexes for table `Certificate_Info`
--
ALTER TABLE `Certificate_Info`
  ADD PRIMARY KEY (`ContractID`),
  ADD UNIQUE KEY `SSN` (`SSN`),
  ADD UNIQUE KEY `DC_Num` (`DC_Num`);

--
-- Indexes for table `Deceased`
--
ALTER TABLE `Deceased`
  ADD PRIMARY KEY (`ContractID`);

--
-- Indexes for table `Login_Info`
--
ALTER TABLE `Login_Info`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `UserName` (`UserName`),
  ADD UNIQUE KEY `Password` (`Password`);

--
-- Indexes for table `Next_Of_Kin`
--
ALTER TABLE `Next_Of_Kin`
  ADD PRIMARY KEY (`ContractID`),
  ADD UNIQUE KEY `NOK_ID` (`NOK_ID`);

--
-- Indexes for table `Plot_Info`
--
ALTER TABLE `Plot_Info`
  ADD PRIMARY KEY (`Plot_Number`),
  ADD KEY `ContractID` (`ContractID`);

--
-- Indexes for table `Service_Info`
--
ALTER TABLE `Service_Info`
  ADD PRIMARY KEY (`ContractID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Deceased`
--
ALTER TABLE `Deceased`
  MODIFY `ContractID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;
--
-- AUTO_INCREMENT for table `Login_Info`
--
ALTER TABLE `Login_Info`
  MODIFY `UserID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `Next_Of_Kin`
--
ALTER TABLE `Next_Of_Kin`
  MODIFY `NOK_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Balances`
--
ALTER TABLE `Balances`
  ADD CONSTRAINT `Balances_ibfk_1` FOREIGN KEY (`ContractID`) REFERENCES `Deceased` (`ContractID`);

--
-- Constraints for table `Cause_of_Death`
--
ALTER TABLE `Cause_of_Death`
  ADD CONSTRAINT `Cause_of_Death_ibfk_1` FOREIGN KEY (`ContractID`) REFERENCES `Deceased` (`ContractID`),
  ADD CONSTRAINT `Cause_of_Death_ibfk_2` FOREIGN KEY (`ContractID`) REFERENCES `Deceased` (`ContractID`),
  ADD CONSTRAINT `Cause_of_Death_ibfk_3` FOREIGN KEY (`ContractID`) REFERENCES `Deceased` (`ContractID`);

--
-- Constraints for table `Certificate_Info`
--
ALTER TABLE `Certificate_Info`
  ADD CONSTRAINT `Certificate_Info_ibfk_1` FOREIGN KEY (`ContractID`) REFERENCES `Deceased` (`ContractID`),
  ADD CONSTRAINT `Certificate_Info_ibfk_2` FOREIGN KEY (`ContractID`) REFERENCES `Deceased` (`ContractID`);

--
-- Constraints for table `Next_Of_Kin`
--
ALTER TABLE `Next_Of_Kin`
  ADD CONSTRAINT `Next_Of_Kin_ibfk_1` FOREIGN KEY (`ContractID`) REFERENCES `Deceased` (`ContractID`);

--
-- Constraints for table `Plot_Info`
--
ALTER TABLE `Plot_Info`
  ADD CONSTRAINT `Plot_Info_ibfk_1` FOREIGN KEY (`ContractID`) REFERENCES `Deceased` (`ContractID`);

--
-- Constraints for table `Service_Info`
--
ALTER TABLE `Service_Info`
  ADD CONSTRAINT `Service_Info_ibfk_1` FOREIGN KEY (`ContractID`) REFERENCES `Deceased` (`ContractID`),
  ADD CONSTRAINT `Service_Info_ibfk_2` FOREIGN KEY (`ContractID`) REFERENCES `Deceased` (`ContractID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
