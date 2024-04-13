import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
    const [aed, setAed] = useState([])

    useEffect(() => {
        axios.get('/api/emer')
            .then(response => setAed(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div>
            {aed.map(item => (
                <div key={item.buidAddress}>
                    <p>설치 주소: {item.buildAddress}</p>
                    <p>설치 위치: {item.buildPlace}</p>
                    {/*<p>모델명: {item.model}</p>*/}
                    <p>관리자 번호: {item.managerTel}</p>
                </div>
            ))}
        </div>
    );
}

export default App;