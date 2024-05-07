import React, { useState } from 'react';

const QuizComponent = ({ quiz, onAnswer }) => {
  const [selectedAnswer, setSelectedAnswer] = useState(null);

  const handleAnswer = (answer) => {
    setSelectedAnswer(answer);
  };

  const handleSubmit = () => {
    if (typeof onAnswer === 'function') {
      onAnswer(selectedAnswer);
    } else {
      console.error('onAnswer is not a function');
    }
  };

  if (!quiz || !quiz.question) {
    return <div>질문이 존재하지 않습니다.</div>;
  }

  return (
    <div>
      <h3>{quiz.question}</h3>
      <div>
        <button onClick={() => handleAnswer(true)}>O</button>
        <button onClick={() => handleAnswer(false)}>X</button>
      </div>
      {selectedAnswer !== null && (
        <button onClick={handleSubmit}>확인</button>
      )}
    </div>
  );
};

export default QuizComponent;
