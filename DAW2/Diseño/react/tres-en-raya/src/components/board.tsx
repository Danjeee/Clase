import React, { useState } from 'react';
import '../styles/css/board.css';
import Confetti from 'react-confetti';

interface BoardProps {
  onGameEnd: (winner: number | null) => void;
}

const Board: React.FC<BoardProps> = ({ onGameEnd }) => {
  const [board, setBoard] = useState<Array<Array<number | null>>>(
    Array(3).fill(null).map(() => Array(3).fill(null))
  );
  const [currentPlayer, setCurrentPlayer] = useState(1);

  const handleClick = (row: number, col: number) => {
    if (board[row][col] === null) {
      const newBoard = [...board];
      newBoard[row][col] = currentPlayer;
      setBoard(newBoard);
      setCurrentPlayer(currentPlayer === 1 ? 2 : 1);
      checkWinner();
    }
  };
  const setClass = (row: number, col: number) => {
    var class_ = "cell "
    if (board[row][col] !== null) {
       var bool_ = board[row][col] === 1
       class_ += bool_ ? "X" : "O";
    }
    return class_;
  }

  const checkWinner = () => {
    const winpart = document.getElementById("particle") as HTMLElement
    const confetti = document.getElementById("confetti") as HTMLElement
    const empate = document.getElementById("empate") as HTMLElement
    const lines = [
      [
        [0, 0],
        [0, 1],
        [0, 2],
      ],
      [
        [1, 0],
        [1, 1],
        [1, 2],
      ],
      [
        [2, 0],
        [2, 1],
        [2, 2],
      ],
      [
        [0, 0],
        [1, 0],
        [2, 0],
      ],
      [
        [0, 1],
        [1, 1],
        [2, 1],
      ],
      [
        [0, 2],
        [1, 2],
        [2, 2],
      ],
      [
        [0, 0],
        [1, 1],
        [2, 2],
      ],
      [
        [0, 2],
        [1, 1],
        [2, 0],
      ],
    ];

    for (let i = 0; i < lines.length; i++) {
      const [a, b, c] = lines[i];
      if (
        board[a[0]][a[1]] &&
        board[a[0]][a[1]] === board[b[0]][b[1]] &&
        board[a[0]][a[1]] === board[c[0]][c[1]]
      ) { //Ganador
        setTimeout(() => {
          onGameEnd(board[a[0]][a[1]]);
        }, 1500);
        winpart.style.display = "flex"
        confetti.style.display = "flex"
        return;
      }
    }

    if (board.flat().every((cell) => cell !== null)) { //Empate
      setTimeout(() => {
        onGameEnd(null);
      }, 1500);
      empate.style.display = "flex"
      return;
    }
  };

  return (
    <div className="board">
      {board.map((row, rowIndex) => (
        <div key={rowIndex} className="row">
          {row.map((cell, colIndex) => (
            <div
              key={colIndex}
              className={setClass(rowIndex, colIndex)}
              onClick={() => handleClick(rowIndex, colIndex)}
            >
              {cell !== null && (cell === 1 ? 'X' : 'O')}
            </div>
          ))}
        </div>
      ))}
      <div id='particle'></div>
      <div id='confetti'>
        <Confetti></Confetti>
      </div>
      <div id='empate'>Empate</div>
    </div>
    
  );
};

export default Board;

