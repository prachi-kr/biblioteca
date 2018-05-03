create table BOOK (
  id char(36) PRIMARY KEY ,
  title varchar(200),
  unique(title)
);

insert into BOOK (id, title) values ('ba0bd157-e668-4d7e-a0a9-af5fb86222b7','The Goblet of Fire');
insert into BOOK (id, title) values ('7df12a8f-38ab-4070-93d5-6e770d9a4606','The Deathly Hallows');
insert into BOOK (id, title) values ('8dc006e1-fb73-497b-9dfd-a91d6817a745','The Half-Blood Prince');
insert into BOOK (id, title) values ('9cbf935c-52c6-411d-aa4b-79b67942f79f','The Chamber of Secrets');