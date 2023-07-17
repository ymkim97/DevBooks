CREATE TABLE customer
(
    customer_id BIGINT auto_increment PRIMARY KEY,
    name        VARCHAR(30) NOT NULL,
    phone       VARCHAR(20) NOT NULL,
    address     VARCHAR(50) NOT NULL
);

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
    order_id     BIGINT auto_increment PRIMARY KEY,
    customer_id  VARCHAR(50) DEFAULT NULL,
    address      VARCHAR(100) NOT NULL,
    postcode     VARCHAR(10)  NOT NULL,
    created_at   datetime(6)  NOT NULL,
    order_status VARCHAR(30)  NOT NULL,
    CONSTRAINT fk_orders_to_customer FOREIGN KEY (customer_id) references customer (customer_id) ON DELETE CASCADE
);

CREATE TABLE order_item
(
    order_item_id BIGINT auto_increment PRIMARY KEY,
    order_id      BIGINT  NOT NULL,
    book_id       BIGINT  NOT NULL,
    quantity      INTEGER NOT NULL,
    CONSTRAINT fk_order_item_to_orders FOREIGN KEY (order_id) references orders (order_id) ON DELETE CASCADE,
    CONSTRAINT fk_order_item_to_book FOREIGN KEY (book_id) references book (book_id) ON DELETE CASCADE
);