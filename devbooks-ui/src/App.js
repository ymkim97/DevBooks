import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import React, {useEffect, useState} from 'react'
import axios from "axios";
import {BookList} from "./components/BookList";
import {Summary} from "./components/Summary";
import moment from 'moment';
import 'moment/locale/ko';

function App() {
    const [books, setBooks] = useState([]);
    const [items, setItems] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/books')
            .then(v => setBooks(v.data));
    }, []);

    const handleAddClicked = bookId => {
        const book = books.find(v => v.bookId === bookId);
        const found = items.find(v => v.bookId === bookId);
        const updatedItems =
            found ? items.map(v => (v.bookId === bookId) ? {...v, count: v.count + 1} : v) : [...items, { ...book, count: 1 }]
        console.log(updatedItems);
        setItems(updatedItems);
    }

    const handleOrderSubmit = (order) => {
        if (items.length === 0) {
            alert("아이템을 추가해 주세요!")
        } else {
            axios.post('http://localhost:8080/api/v1/orders', {
                customerId: order.customerId,
                address: order.address,
                postcode: order.postcode,
                orderStatus: "ACCEPTED",
                createdAt: moment().format("YYYY-MM-DDTHH:mm:sszz"),
                orderItems : items.map(v => ({
                    bookId: v.bookId,
                    quantity: v.count
                }))
            }).then(
                v => alert("주문이 정상적으로 접수되었습니다."),
                e => {
                    alert("서버 장애");
                    console.error(e);
                })
        }
    }

  return (
      <div className="container-fluid">
        <div className="row justify-content-center m-4">
          <h1 className="text-center">DevBooks</h1>
        </div>
        <div className="card">
          <div className="row">
            <div className="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
              <BookList books={books} onAddClick={handleAddClicked}/>
            </div>
            <div className="col-md-4 summary p-4">
              <Summary items={items} onOrderSubmit={handleOrderSubmit}/>
            </div>
          </div>
        </div>

      </div>
  );
}

export default App;
