import React from 'react';
import DropdownMenu from './DropdownMenuButton';
import MenuButton from './MenuButton';
import { Link } from 'react-router-dom';

const NavBar = () => (
  <header>
      <Link to="/">
        <img src="/AEDWEBLOGO.png" alt="Logo" className="logo" />
      </Link>    <div className="navbar" id="navbar">
      <ul className="menu">
        <li><Link to="/firstaid/burn">AED 위치</Link></li>
        <li><Link to="/emerlocation">응급실 위치</Link></li>
        <DropdownMenu title="응급처치법">
          <li><Link to="/firstaid/burn">화상</Link></li>
          <li><Link to="/firstaid/bee">벌에 쏘였을 때</Link></li>
          <li><Link to="/firstaid/overbreathing">과호흡 증후군</Link></li>
          <li><Link to="/firstaid/cpr">심폐소생술</Link></li>
        </DropdownMenu>
        <DropdownMenu title="응급처치 퀴즈">
          <li><a href="quiz_burn.html">화상 응급처치 퀴즈</a></li>
          <li><Link to="/firstaidquiz/BeeQuiz">벌에 쏘였을 때 퀴즈</Link></li>
          <li><a href="overbreathing.html">과호흡 증후군 퀴즈</a></li>
          <li><a href="cpr.html">심폐소생술 퀴즈</a></li>
        </DropdownMenu>
      </ul>
      <MenuButton />
    </div>
  </header>
);


export default NavBar;
