import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCaretDown, faCaretUp } from '@fortawesome/free-solid-svg-icons';

const DropdownMenu = ({ title, children }) => {
  return (
    <li className="dropdown_main">
      <div className="dropdown_bar">
        {title}
        <FontAwesomeIcon icon={faCaretDown} className="drop_icon1" />
      </div>
      <ul className="dropdown_content">
        {children}
      </ul>
    </li>
  );
};

export default DropdownMenu;
