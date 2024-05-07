import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Emer from "./pages/Emer";
import Aed from "./pages/Aed";
import MainPage from './pages/MainPage';
import BeePage from './pages/firstaid/bee';
import BeeQuiz from './pages/firstaidquiz/BeeQuiz';
import { NavermapsProvider } from 'react-naver-maps';
import NApiMap from './pages/NApiMap'

function App() {
    console.log(process.env)
    console.log('NCP API Key from .env:', process.env.REACT_APP_NCP_CLIENT_ID);

    return (
    <BrowserRouter>
        <NavermapsProvider ncpClientId={process.env.REACT_APP_NCP_CLIENT_ID}>
        <Routes>
            <Route path='/' element={<MainPage />} />
            <Route path='/emer' element={<Emer />} />
            <Route path='/aed' element={<Aed />} />
            <Route path="/firstaid/bee" element={<BeePage />} />
            <Route path="/firstaidquiz/BeeQuiz" element={<BeeQuiz />} />
        </Routes>
        </NavermapsProvider>
    </BrowserRouter>

    );
}

export default App;