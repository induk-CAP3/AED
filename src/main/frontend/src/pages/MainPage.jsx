import React from 'react';
import NavBar from './NavBar';
import Footer from './Footer';
import NaverMapComponent from './NaverMapComponent';

const MainPage = () => {
    return (
        <div>
            <header>
                <NavBar />
            </header>

            <main>
                <section id="introduction" className="section">
                    <NaverMapComponent />
                    
                </section>

                <section id="projects" className="section">
                <h1>검색창이 들어올 예정</h1>
                </section>
            </main>

            <Footer />
        </div>
    );
};

export default MainPage;
