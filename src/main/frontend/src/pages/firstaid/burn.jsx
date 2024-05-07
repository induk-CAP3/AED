import React from 'react';
import '../../styles/main.scss';
import NavBar from '../NavBar';
import Footer from '../Footer';


const BeePage = () => {
    return (
        <div>
            <header>
                <NavBar />
            </header>

            <main>
                <div className="content-container">
                    <h2>벌에 쏘였을 때 대처법</h2>
                    <p>벌에 쏘였을 때는 즉시 쏘인 부위의 독침을 제거해야 합니다. 핀셋이나 신용카드를 사용하여 독침을 긁어내세요.</p>

                    <h3>벌침 제거 및 처치 방법</h3>
                    <ul>
                        <li>피부에 벌침이 남아있는 경우, 신용카드로 밀어서 제거합니다. 집게로 잡아당기면 독이 더 들어갈 수 있습니다.</li>
                        <li>상처 부위를 비누와 물로 깨끗이 씻어 감염을 예방합니다.</li>
                        <li>통증이 심할 경우, 얼음을 천에 싸서 상처 부위에 대고 통증과 부기를 줄입니다. 피부에 직접 닿지 않도록 주의하세요.</li>
                    </ul>

                    <h3>응급 상황 대처</h3>
                    <ul>
                        <li>벌이 없는 안전한 곳으로 환자를 옮깁니다.</li>
                        <li>심한 알레르기 반응을 보일 경우, 즉시 119 또는 1339에 연락하고, 구급차가 도착할 때까지 환자를 안정시키고 눕힙니다.</li>
                        <li>환자가 호흡곤란 등을 겪고 있으면 아무것도 먹지 않도록 하고, 가능한 한 진정시키세요.</li>
                    </ul>
                </div>
            </main>

            <Footer />
        </div>
    );
};

export default BeePage;
