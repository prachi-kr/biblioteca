alter table BOOK add author varchar(200);
alter table BOOK add publish_year int;
alter table BOOK add isbn varchar(50);

update BOOK set author='J K Rowling' , publish_year= 2001 , isbn = '978-3-16-148410-0' where id = 'ba0bd157-e668-4d7e-a0a9-af5fb86222b7';
update BOOK set author='J K Rowling' , publish_year= 2002 , isbn = '978-5-16-141210-0' where id = '7df12a8f-38ab-4070-93d5-6e770d9a4606';
update BOOK set author='J K Rowling' , publish_year= 2003 , isbn = '978-7-16-148510-0' where id = '8dc006e1-fb73-497b-9dfd-a91d6817a745';
update BOOK set author='J K Rowling' , publish_year= 2004 , isbn = '978-9-16-142410-0' where id = '9cbf935c-52c6-411d-aa4b-79b67942f79f';