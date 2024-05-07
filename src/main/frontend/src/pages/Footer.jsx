import React from 'react';

const Footer = () => {
    return (
        <div id="footer">
            <div className="container">
                <div className="row">
                    <div className="col-12">
                        <section className="contact">
                            <div className="footer-header">
                                <h3>사이트에 문제가 있나요?</h3>
                            </div>
                            <p>사이트에 문제가 있다면 아래 연락처로 연락 주세요</p>
                            <ul className="icons">
                                <li><a href="#" className="fab fa-twitter" title="Twitter"></a></li>
                                <li><a href="#" className="fab fa-facebook" title="Facebook"></a></li>
                                <li><a href="#" className="fab fa-square-instagram" title="Instagram"></a></li>
                            </ul>
                        </section>
                        <div className="copyright">
                            <ul className="menu">
                                <li>&copy; 010-0000-0000</li>
                                <li>Design: 캡스톤 3조 AED</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Footer;
