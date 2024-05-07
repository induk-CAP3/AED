import React, {useEffect, useState} from 'react';
import axios from 'axios';

function Aed() {
    const [aed, setAed] = useState([])

    useEffect(() => {
        axios.get('/api/aed')
            .then(response => setAed(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div>
            <p>Aed 정보</p>
            <hr />
            {aed.map(item => (
                <div key={item.buidAddress}>
                    <p color = "red">설치 주소: {item.buildAddress}</p>
                    <p color = "red">설치 위치: {item.buildPlace}</p>
                    <p>설치 모델: {item.model}</p>
                    <p>관리자 : {item.manager}</p>
                    <p>관리자 번호: {item.managerTel}</p>
                    <p color = "red">설치 기관 명 : {item.org}</p>
                    <p color = "red">설치 기관 번호 : {item.clienttel}</p>
                    <p>우편 번호 : {item.zip1}{item.zip2}</p>
                    <p>제조사 : {item.col}</p>
                    <p>경도 : {item.longitude}</p>
                    <p>위도 : {item.latitude}</p>

                    <hr />
                </div>
            ))}
        </div>
    );
}

export default Aed;