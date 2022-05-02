<<<<<<< HEAD
use oasipdatabase;
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime)
value ('Somchai Jaidee(OR-7)', 'somchai.jai@mail.kmutt.ac.th', 2, '2022-5-23 13:30:00');
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime, eventNotes)
value ('SomsriRakdee(SJ-3)', 'somsri.rak@mail.kmutt.ac.th', '1', '2022-5-24 16:30:00', 'ขอปรึกษาปัญหาเพื่อนไม่ช่วยงาน');
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime)
value ('สมเกียรติ ขยันเรียน กลุ่ม (TT-4)', 'somkiat.kay@kmutt.ac.th', '3', '2022-5-28 12:00:00');
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime)
value ('สมเกียรติ ขยันเรียน กลุ่ม (TT-5)', 'somkiat.@kmutt.ac.th', '3', '2022-5-28 10:00:00');
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime)
value ('PPKIT', 'PP@kmutt.ac.th', '3', '2022-5-28 10:00:00');
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime)
value ('ink', 'ink.@kmutt.ac.th', '3', '2022-5-28 10:00:00');
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime)
value ('Champ', 'Champ@kmutt.ac.th', '3', '2022-6-28 9:00:00');
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime)
value ('Nut', 'Nutkung@kmutt.ac.th', '3', '2021-6-1 9:00:00');
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime)
value ('OM', 'Ommi@kmutt.ac.th', '5', '2022-1-1 10:00:00');

=======
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime)
value ('Somchai Jaidee(OR-7)', 'somchai.jai@mail.kmutt.ac.th', 2, '2022-5-23 13:30:00');
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime, eventNotes)
value ('SomsriRakdee(SJ-3)', 'somsri.rak@mail.kmutt.ac.th', 'Project Management Clinic', '27 April 2022 9.30', 'ขอปรึกษาปัญหาเพื่อนไม่ช`วยงาน');
insert into events (bookingName, bookingEmail, eventCategoryId, eventStartTime)
value ('สมเกียรติ ขยันเรียน กลุ`ม TT-4)', 'somkiat.kay@kmutt.ac.th', 'Database Clinic', '23 May 2022 16.30');
>>>>>>> 1d05caa3cf7575a8f75676af878e5df993cce47f

select * from events;