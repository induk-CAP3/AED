import React, {useEffect, useState} from 'react';
import axios from 'axios';

function Emer() {
    const [emer, setEmer] = useState([])

    useEffect(() => {
        axios.get('/api/emer')
            .then(response => setEmer(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div>
            <p>응급실</p>
            <hr />
            {emer.map(item => (
                <div key={item.buidAddress}>
                    <p>응급실 주소: {item.buildAddress}</p>
                    <p>응급실 이름: {item.enm}</p>
                    <p>응급실 번호: {item.telNumber}</p>
                    {item.estate ? <p>운영중</p> : <p>운영 안함</p> }
                    <p>경도 : {item.longitude}</p>
                    <p>위도 : {item.latitude}</p>
                    <hr />
                </div>
            ))}
        </div>
    );
}

export default Emer;