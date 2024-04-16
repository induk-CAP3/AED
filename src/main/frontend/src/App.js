import React from 'react';
import Emer from "./pages/Emer";
import Aed from "./pages/Aed";
import {BrowserRouter, Route, Routes} from 'react-router-dom';

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/emer' element={<Emer />} />
                <Route path='/aed' element={<Aed />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;