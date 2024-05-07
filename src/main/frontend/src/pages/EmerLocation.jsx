import React from 'react';
import '../styles/main.scss'; 
import NavBar from './NavBar';
import Footer from './Footer';

const MainPage = () => {
    return (
        <div>
            <header>
                <NavBar />
            </header>

            <main>
                <div id="map-container"></div>
                <div id="map"></div>

                <section id="introduction" className="section">
                    <h2>검색창 들어갈 예정</h2>
                    <p>검색창이 들어올 예정 검색 구현 아직 안해서...</p>
                </section>

                <section id="projects" className="section">
                    <h2>뭔가 들어올 수 있는 공간</h2>
                    <p>뭔가 가능한 공간</p>
                </section>
            </main>

            <Footer />
        </div>
    );
};

export default MainPage;