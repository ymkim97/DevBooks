import {SummaryItem} from "./SummaryItem";
import React, {useState} from "react";

export function Summary({items, onOrderSubmit}) {
    const totalPrice = items.reduce((prev, curr) => prev + (curr.price * curr.count), 0);
    const [order, setOrder] = useState({
        customerId: 2, address: "", postcode: ""
    });
    const handleAddressInputChanged = (e) => setOrder({ ...order, address: e.target.value });
    const handlePostcodeInputChanged = (e) => setOrder({ ...order, postcode: e.target.value });
    const handleSubmit = (e) => {
        if (order.address === "" || order.postcode === "") {
            alert("주소 또는 우편번호를 확인해주세요!")
        } else {
            onOrderSubmit(order);
        }
    }
    return (<>
        <div>
            <h5 className="m-0 p-0"><b>Summary</b></h5>
        </div>
        <hr/>
        {items.map(v => <SummaryItem key={v.bookId} title={v.title} count={v.count} />)}
        <form>
            <div className="mb-3">
                <label htmlFor="customerId" className="form-label">고객 ID</label>
                <input type="email" className="form-control mb-1" value={2} id="customerId" disabled={true}/>
            </div>
            <div className="mb-3">
                <label htmlFor="address" className="form-label">주소</label>
                <input type="text" className="form-control mb-1" value={order.address} onChange={handleAddressInputChanged} id="address"/>
            </div>
            <div className="mb-3">
                <label htmlFor="postcode" className="form-label">우편번호</label>
                <input type="text" className="form-control" value={order.postcode} onChange={handlePostcodeInputChanged} id="postcode"/>
            </div>
            <div>책은 주문 검토 후 배송이 시작됩니다.</div>
        </form>
        <div className="row pt-2 pb-2 border-top">
            <h5 className="col">총금액</h5>
            <h5 className="col text-end">{totalPrice}원</h5>
        </div>
        <button className="btn btn-dark col-12" onClick={handleSubmit}>결제하기</button>
    </>)
}