ALTER TABLE rendez_vous ADD COLUMN heure_rendez_vous TIME;

UPDATE rendez_vous SET heure_rendez_vous = '09:00:00' WHERE id = 1;
UPDATE rendez_vous SET heure_rendez_vous = '10:30:00' WHERE id = 2;
UPDATE rendez_vous SET heure_rendez_vous = '14:00:00' WHERE id = 3;
UPDATE rendez_vous SET heure_rendez_vous = '08:00:00' WHERE id = 4;
UPDATE rendez_vous SET heure_rendez_vous = '11:00:00' WHERE id = 5;
UPDATE rendez_vous SET heure_rendez_vous = '15:30:00' WHERE id = 6;
UPDATE rendez_vous SET heure_rendez_vous = '09:00:00' WHERE id = 7;
UPDATE rendez_vous SET heure_rendez_vous = '16:00:00' WHERE id = 8;
UPDATE rendez_vous SET heure_rendez_vous = '10:00:00' WHERE id = 9;
UPDATE rendez_vous SET heure_rendez_vous = '13:00:00' WHERE id = 10;
