import React from 'react';
import Emer from "./pages/Emer";
import Aed from "./pages/Aed";
import {BrowserRouter, Route, Routes, Link} from 'react-router-dom';

function App() {

    return (
        <BrowserRouter>
            <nav>
                <Link to='/emer'>응급실 정보</Link>
                <br />
                <Link to='/aed'>Aed 정보</Link>
            </nav>
            <Routes>
                <Route path='/emer' element={<Emer />} />
                <Route path='/aed' element={<Aed />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;