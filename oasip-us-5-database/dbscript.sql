CREATE DATABASE oasip DEFAULT CHARACTER SET utf8;
USE oasip;
CREATE USER 'devus5'@'%'  IDENTIFIED by 'oasipus5';
GRANT ALL PRIVILEGES ON *.* TO 'devus5'@'%';
FLUSH PRIVILEGES;
CREATE TABLE eventcategories (
 eventCategoryId INT NOT NULL AUTO_INCREMENT,
 eventCategoryName VARCHAR(100) NOT NULL,
 eventCategoryDescription VARCHAR(500) NULL,
 eventDuration INT NOT NULL,
 PRIMARY KEY (eventCategoryId),
 UNIQUE INDEX eventCategoryName_UNIQUE (eventCategoryName ASC) VISIBLE
);
CREATE TABLE events (
 eventId INT NOT NULL AUTO_INCREMENT,
 bookingName VARCHAR(100) NOT NULL,
 bookingEmail VARCHAR(100) NOT NULL,
 eventStartTime DATETIME NOT NULL,
 eventDuration INT NOT NULL,
 eventNotes VARCHAR(500) NULL,
 eventCategoryId INT NOT NULL,
 PRIMARY KEY (eventId),
 UNIQUE INDEX bookingEmail_UNIQUE (bookingEmail ASC) VISIBLE,
 INDEX fk_events_eventcategories_idx (eventCategoryId ASC) VISIBLE,
 CONSTRAINT fk_events_eventcategories
   FOREIGN KEY (eventCategoryId)
   REFERENCES eventcategories (eventCategoryId)
   ON DELETE NO ACTION
   ON UPDATE NO ACTION
);
INSERT INTO eventcategories (eventCategoryName,eventCategoryDescription,eventDuration)
VALUES ('Project Management Clinic', 'ตารางนัดหมายนี้ใช้สำหรับนัดหมาย Project Management Clinic ในวิชา INT221 integrated project I', 30);
INSERT INTO eventcategories (eventCategoryName,eventCategoryDescription,eventDuration)
VALUES ('DevOps/Infra Clinic', 'ตารางนัดหมายนี้ใช้สำหรับนัดหมาย DevOps/Infra Clinic ในวิชา INT221 integrated project I', 20);
INSERT INTO eventcategories (eventCategoryName,eventCategoryDescription,eventDuration)
VALUES ('Database Clinic', 'ตารางนัดหมายนี้ใช้สำหรับนัดหมาย Database Clinic ในวิชา INT221 integrated project I', 15);
INSERT INTO eventcategories (eventCategoryName,eventCategoryDescription,eventDuration)
VALUES ('Client-side Clinic', 'ตารางนัดหมายนี้ใช้สำหรับนัดหมาย  Client-side Clinic ในวิชา INT221 integrated project I', 30);
INSERT INTO eventcategories (eventCategoryName,eventCategoryDescription,eventDuration)
VALUES (' Server-side Clinic', 'ตารางนัดหมายนี้ใช้สำหรับนัดหมาย Server-side Clinic ในวิชา INT221 integrated project I', 30);
INSERT INTO events (bookingName,bookingEmail,eventStartTime,eventDuration,eventCategoryId)
values ('Somchai Jaidee(OR-7)','somchai.jai@mail.kmutt.ac.th','2022-05-23 06:30:00',30,'2');
INSERT INTO events (bookingName,bookingEmail,eventStartTime,eventDuration,eventCategoryId, eventNotes)
values ('SomsriRakdee(SJ-3)','somsri.rak@mail.kmutt.ac.th','2022-04-27 02:30:00',30,'1', 'ขอปรึกษาปัญหาเพื่อนไม่ช่วยงาน');
INSERT INTO events (bookingName,bookingEmail,eventStartTime,eventDuration,eventCategoryId)
values (' สมเกียรติ ขยันเรียน กลุ่ม TT-4','somkiat.kay@kmutt.ac.th','2022-05-23 09:30:00',15,'3');