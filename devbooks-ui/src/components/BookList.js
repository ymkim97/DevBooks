import React from "react";
import {Book} from "./Book";

export function BookList({books = [], onAddClick}) {
    return (<React.Fragment>
        <h5 className="flex-grow-0"><b>책 목록</b></h5>
        <ul className="list-group products">
            {books.map(v =>
                <li key={v.bookId} className="list-group-item d-flex mt-3">
                    <Book bookId={v.bookId} title={v.title} author={v.author} category={v.category} price={v.price} publishedAt={v.publishedAt} onAddClick={onAddClick}/>
                </li>
            )}
        </ul>
    </React.Fragment>)
}