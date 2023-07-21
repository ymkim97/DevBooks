import React from "react";

export function Book(props) {
    const bookId = props.bookId;
    const title = props.title;
    const author = props.author;
    const category = props.category;
    const price = props.price;
    const publishedAt = props.publishedAt;

    const handleAddBtnClicked = e => {
        props.onAddClick(bookId);
    };

    return (<>
        <div className="col-2"><img className="img-fluid" src="./images/book_image.png" alt=""/>
        </div>
        <div className="col">
            <div className="row">{title}</div>
            <div className="row text-muted">{author}</div>
        </div>
        <div className="col text-center price">{price}원</div>
        <div className="col text-end action">
            <button onClick={handleAddBtnClicked} className="btn btn-small btn-outline-dark">추가</button>
        </div>
    </>)
}
