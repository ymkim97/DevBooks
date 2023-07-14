CREATE TABLE books
(
    book_id      BIGINT auto_increment PRIMARY KEY,
    title        VARCHAR(50) NOT NULL,
    author       VARCHAR(50) NOT NULL,
    category     VARCHAR(30) NOT NULL,
    price        BIGINT      NOT NULL,
    published_at DATE        NOT NULL
);
