create table checkout (
  id SERIAL PRIMARY KEY,
  book_id char(36) references BOOK,
  date_of_issue timestamp default current_timestamp,
  date_of_return timestamp
);
