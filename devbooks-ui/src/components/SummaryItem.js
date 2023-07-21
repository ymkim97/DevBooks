import React from "react";

export function SummaryItem({title, count}) {
    return (
        <div className="row">
            <h6 className="p-0">{title} <span className="badge bg-dark">{count}개</span></h6>
        </div>
    )
}