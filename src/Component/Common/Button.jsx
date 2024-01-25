import React, { useState, useEffect } from "react";
import styled from './Button.module.css';
import PropTypes from "prop-types";

function Button({ text, onClick, active }) {
  const [isClicked, setIsClicked] = useState(active);

  useEffect(() => {
    setIsClicked(active);
  }, [active]);

  const handleClick = () => {
    setIsClicked(!isClicked);
    onClick();
  };

  return (
    <button
      className={styled.logoContainer}
      style={{
        backgroundColor: isClicked ? "#FFD43A" : "#FFFFFF",
        border: isClicked ? "none" : "3px solid #FFD43A",
        height: '4vh',
        width: '5vw',
        boxSizing: 'border-box'
      }}
      onClick={handleClick}
    >
      <p style={{
        color: isClicked ? "#FFFFFF" : "#FFD43A",
        fontWeight: 'bold',
        margin: 0,

      }}>{text}</p>
    </button>
  );
}

Button.propTypes = {
  text: PropTypes.string.isRequired,
  onClick: PropTypes.func.isRequired,
  active: PropTypes.bool,
};

export default Button;
