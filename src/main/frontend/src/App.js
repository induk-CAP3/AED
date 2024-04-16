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
            <p>응급실</p>
            <hr />
            {aed.map(item => (
                <div key={item.buidAddress}>
                    <p>응급실 주소: {item.buildAddress}</p>
                    <p>응급실 이름: {item.enm}</p>
                    <p>응급실 번호: {item.telNumber}</p>
                    <p>응급실 운영여부: {item.estate}</p>
                    <hr />
                </div>
            ))}
        </div>
    );
}

export default App;