-- springboot_transactions.employee definition
CREATE TABLE IF NOT EXISTS `employee` (
  `E_PK_ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`E_PK_ID`)
);

-- springboot_transactions.health_insurance definition
CREATE TABLE IF NOT EXISTS `health_insurance` (
  `HI_PK_ID` int NOT NULL AUTO_INCREMENT,
  `AMOUNT` double DEFAULT NULL,
  `EMP_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`HI_PK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;