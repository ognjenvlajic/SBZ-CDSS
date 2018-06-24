-- ADMINISTRATORI
insert into korisnik(id, email, lozinka, authorities) values (1, 'admin@gmail.com', '$2a$04$6e6m6vVWC2OhNtJEpMY3s.39Dph3pQ3JcGR4MzFCXg4drCHf9jUeW', 'ADMIN')
insert into administrator(id) values (1)

-- LEKARI
insert into korisnik(id, email, lozinka, authorities) values (2, 'lekar@gmail.com', '$2a$04$6e6m6vVWC2OhNtJEpMY3s.39Dph3pQ3JcGR4MzFCXg4drCHf9jUeW', 'LEKAR')
insert into lekar(id, ime, prezime) values (1, 'Pera', 'Peric')

-- PACIJENTI
insert into pacijent(id, jmbg, ime, prezime) values (1, '0000000000001', 'Prvi', 'Pacijent')
insert into pacijent(id, jmbg, ime, prezime) values (2, '0000000000002', 'Prvi', 'Pacijent')
insert into pacijent(id, jmbg, ime, prezime) values (3, '0000000000003', 'Prvi', 'Pacijent')
insert into pacijent(id, jmbg, ime, prezime) values (4, '0000000000004', 'Prvi', 'Pacijent')
insert into pacijent(id, jmbg, ime, prezime) values (5, '0000000000005', 'Peta', 'Bolest')

-- SIMPTOMI
-- za prehladu 
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (1, 'Curenje iz nosa', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (2, 'Bol u grlu', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (3, 'Glavobolja', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (4, 'Kijanje', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (5, 'Kasalj', -1, -1)
-- za groznicu
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (6, 'Temperatura', 38, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (7, 'Drhtavica', -1, -1)
-- za upalu krajnika
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (8, 'Bol koji se siri do usiju', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (9, 'Temperatura', 40, 41)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (10, 'Gubitak apetita', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (11, 'Umor', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (12, 'Zuti sekret iz nosa', -1, -1)
-- za sinusnu infekciju
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (13, 'Oticanje oko ociju', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (14, 'Curenje iz nosa', -1, -1)
-- za hipertenziju
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (15, 'Visok pritisak', -1, -1)
-- za dijabetes
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (16, 'Cesto uriniranje', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (17, 'Gubitak telesne tezine', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (18, 'Zamor', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (19, 'Mucnina i povracanje', -1, -1)
-- za hronicnu bubreznu bolest
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (20, 'Nocturia', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (21, 'Otoci nogu i zglbova', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (22, 'Gusenje', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (23, 'Bol u grudima', -1, -1)
-- za akutnu bubreznu bolest
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (24, 'Oporavak od operacije', -1, -1)
insert into simptom(id, naziv, min_vrednost, max_vrednost) values (25, 'Dijareja', -1, -1)

-- BOLESTI
insert into bolest(id, naziv) values (1, 'Prehlada')
insert into bolest(id, naziv) values (2, 'Groznica')
insert into bolest(id, naziv) values (3, 'Upala krajnika')
insert into bolest(id, naziv) values (4, 'Sinusna infekcija')
insert into bolest(id, naziv) values (5, 'Hipertenzija')
insert into bolest(id, naziv) values (6, 'Dijabetes')
insert into bolest(id, naziv) values (7, 'Hronicna bubrezna bolest')
insert into bolest(id, naziv) values (8, 'Akutna bubrezna bolest')

insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (1, 1)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (1, 2)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (1, 3)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (1, 4)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (1, 5)

insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (2, 4)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (2, 2)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (2, 5)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (2, 1)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (2, 6)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (2, 3)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (2, 7)

insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (3, 2)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (3, 8)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (3, 3)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (3, 9)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (3, 7)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (3, 10)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (3, 11)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (3, 12)

insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (4, 13)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (4, 3)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (4, 12)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (4, 2)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (4, 6)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (4, 5)

insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (6, 16)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (6, 17)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (6, 18)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (6, 19)

insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (7, 18)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (7, 20)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (7, 21)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (7, 22)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (7, 23)

insert into bolest_specificni_simptomi(bolest_id, specificni_simptomi_id) values (8, 24)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (8, 18)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (8, 22)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (8, 21)
insert into bolest_opsti_simptomi(bolest_id, opsti_simptomi_id) values (8, 25)

-- LEK
insert into lek(id, naziv, grupa) values (1, 'Brufen', 0)
insert into lek(id, naziv, grupa) values (2, 'Aspirin', 1)
insert into lek(id, naziv, grupa) values (3, 'Bensedin', 2)

-- DIJAGNOZE
--insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (1, '2018-06-24 10:06:31.82', 1, 1)
--insert into dijagnoza_pripisani_lekovi(dijagnoza_id, pripisani_lekovi_id) values (1, 1)
--insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (1, 1)

insert into simptom_vrednost(id, naziv, vrednost) values (1, 'Visok pritisak', -1)
insert into simptom_vrednost(id, naziv, vrednost) values (2, 'Temperatura', -1)

-- uslov za hipertenziju i sinusnu infekciju
insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (1, '2018-06-24 10:06:31.82', 1, 5)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (1, 1)
insert into pacijent_karton(pacijent_id, karton_id) values (5, 1)

insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (2, '2018-06-24 10:06:31.82', 2, 5)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (2, 1)
insert into pacijent_karton(pacijent_id, karton_id) values (5, 2)

insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (3, '2018-06-24 10:06:31.82', 5, 5)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (3, 1)
insert into pacijent_karton(pacijent_id, karton_id) values (5, 3)

insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (4, '2018-06-24 10:06:31.82', 6, 5)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (4, 1)
insert into pacijent_karton(pacijent_id, karton_id) values (5, 4)

insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (5, '2018-06-24 10:06:31.82', 5, 5)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (5, 1)
insert into pacijent_karton(pacijent_id, karton_id) values (5, 5)

insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (6, '2018-06-24 10:06:31.82', 5, 5)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (6, 1)
insert into pacijent_karton(pacijent_id, karton_id) values (5, 6)

insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (7, '2018-06-24 10:06:31.82', 5, 5)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (7, 1)
insert into pacijent_karton(pacijent_id, karton_id) values (5, 7)

insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (8, '2018-06-24 10:06:31.82', 5, 5)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (8, 1)
insert into pacijent_karton(pacijent_id, karton_id) values (5, 8)

insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (9, '2018-02-24 10:06:31.82', 5, 5)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (9, 1)
insert into pacijent_karton(pacijent_id, karton_id) values (5, 9)

insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (10, '2018-06-24 10:06:31.82', 5, 5)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (10, 1)
insert into pacijent_karton(pacijent_id, karton_id) values (5, 10)

-- uslov za akutnu bubreznu infekciju
insert into dijagnoza(id, datum, bolest_id, pacijent_id) values (11, '2018-06-24 10:06:31.82', 2, 2)
insert into dijagnoza_pripisani_lekovi(dijagnoza_id, pripisani_lekovi_id) values (11, 1)
insert into dijagnoza_simptomi(dijagnoza_id, simptomi_id) values (11, 2)


