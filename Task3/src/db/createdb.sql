CREATE database school;
USE school;
CREATE TABLE students(
	id int AUTO_INCREMENT,
    FirstName varchar(255) NOT NULL,
    Lastname varchar(255) NOT NULL,
    Grade varchar(2) NOT NULL,
    RollNumber varchar(255) NOT NULL,
    PRIMARY KEY (id)
);