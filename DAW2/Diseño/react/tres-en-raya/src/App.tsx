import React, { useState } from 'react';
import PlayerInput from './components/playerinput';
import Scoreboard from './components/score';
import Board from './components/board';

const App: React.FC = () => {
  const [player1Name, setPlayer1Name] = useState('');
  const [player2Name, setPlayer2Name] = useState('');
  const [player1Score, setPlayer1Score] = useState(0);
  const [player2Score, setPlayer2Score] = useState(0);
  const [gameStarted, setGameStarted] = useState(false);
  const [gameResult, setGameResult] = useState<number | null>(null);

  const handleNamesEntered = (name1: string, name2: string) => {
    setPlayer1Name(name1);
    setPlayer2Name(name2);
  };

  const handleStartGame = () => {
    setGameStarted(true);
    setGameResult(null); // Reiniciar resultado anterior
  };

  const handleGameEnd = (winner: number | null) => {
    setGameStarted(false);
    setGameResult(winner);
    if (winner === 1) {
      setPlayer1Score(prevScore => prevScore + 1);
    } else if (winner === 2) {
      setPlayer2Score(prevScore => prevScore + 1);
    }
  };

  return (
    <div>
      {!gameStarted ? (
        <PlayerInput
          onNamesEntered={handleNamesEntered}
          onStartGame={handleStartGame}
        />
      ) : (
        <Board onGameEnd={handleGameEnd} />
      )}
      <Scoreboard
        player1Name={player1Name}
        player2Name={player2Name}
        player1Score={player1Score}
        player2Score={player2Score}
      />
      {gameResult !== null && (
        <p>
          {gameResult === 1
            ? `${player1Name} gana!`
            : gameResult === 2
            ? `${player2Name} gana!`
            : 'Empate!'}
        </p>
      )}
    </div>
  );
};

export default App;

