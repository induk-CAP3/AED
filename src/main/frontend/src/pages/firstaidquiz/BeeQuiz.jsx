import React, { useState } from 'react';
import '../../styles/main.scss';
import NavBar from '../NavBar';
import Footer from '../Footer';
import beeQuizData from './BeeQuizText.json';
import '../../styles/pages/BeeQuiz.scss';

const BeeQuiz = () => {
    const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
    const [selectedAnswer, setSelectedAnswer] = useState(null);
    const [showConfirmation, setShowConfirmation] = useState(false);
    const [showResult, setShowResult] = useState(false);

    const question = beeQuizData[currentQuestionIndex];

    const handleAnswer = (answer) => {
        setSelectedAnswer(answer);
        setShowConfirmation(true);
    };

    const confirmAnswer = () => {
        setShowConfirmation(false);
        setShowResult(true);
    };

    const nextQuestion = () => {
        if (currentQuestionIndex < beeQuizData.length - 1) {
            setCurrentQuestionIndex(currentQuestionIndex + 1);
            setShowResult(false);
        } else {
            alert("모든 문제를 완료하셨습니다! 다시 시작하시려면 페이지를 새로고침하세요.");
        }
    };

    return (
        <div>
            <header><NavBar /></header>
            <main>
                {question && (
                    <div className="quiz-container">
                        <h1>{question.question}</h1>
                        <div className="button-container">
                            <button className="quiz-button" onClick={() => handleAnswer(true)}>O</button>
                            <button className="quiz-button" onClick={() => handleAnswer(false)}>X</button>
                        </div>
                        {showConfirmation && (
                            <div className="confirmation-container">
                                <p>정답을 선택하셨습니까?</p>
                                <button className="confirm-button" onClick={confirmAnswer}>확인</button>
                            </div>
                        )}
                        {showResult && (
                            <div className="result-container">
                                <p>{selectedAnswer === question.answer ? "정답입니다!" : "오답입니다."}<br></br>
                                {question.explanation}</p>
                                <button className="next-button" onClick={nextQuestion}>다음 문제</button>
                            </div>
                        )}
                    </div>
                )}
            </main>
            <Footer />
        </div>
    );
};

export default BeeQuiz;
