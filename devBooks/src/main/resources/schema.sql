CREATE TABLE book
(
    book_id      BIGINT auto_increment PRIMARY KEY,
    title        VARCHAR(50) NOT NULL,
    author       VARCHAR(50) NOT NULL,
    category     VARCHAR(30) NOT NULL,
    price        BIGINT      NOT NULL,
    published_at DATE        NOT NULL
);

CREATE TABLE orders
(
    order_id     VARCHAR(50) PRIMARY KEY,
    address      VARCHAR(100) NOT NULL,
    postcode     VARCHAR(10)  NOT NULL,
    created_at    datetime(6) NOT NULL,
    order_status VARCHAR(30)  NOT NULL
);

CREATE TABLE order_item
(
    order_item_id BIGINT auto_increment PRIMARY KEY,
    order_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    CONSTRAINT fk_order_item_to_order FOREIGN KEY (order_id) references orders (order_id) ON DELETE CASCADE,
    CONSTRAINT fk_order_item_to_book FOREIGN KEY (book_id) references book (book_id)
)