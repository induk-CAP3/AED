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
                <div key={item.id}>
                    <p>설치 주소: {item.buildAddress}</p>
                    <p>설치 위치: {item.buildPlace}</p>
                    <p>관리자 : {item.manager}</p>
                    <p>관리자 번호: {item.managerTel}</p>
                    <hr />
                </div>
            ))}
        </div>
    );
}

export default Aed;