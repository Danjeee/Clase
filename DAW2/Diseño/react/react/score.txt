import React from 'react';

interface ScoreboardProps {
  player1Name: string;
  player2Name: string;
  player1Score: number;
  player2Score: number;
}

const Scoreboard: React.FC<ScoreboardProps> = ({
  player1Name,
  player2Name,
  player1Score,
  player2Score,
}) => {
  return (
    <div>
      <h2>Marcador</h2>
      <p>{player1Name}: {player1Score}</p>
      <p>{player2Name}: {player2Score}</p>
    </div>
  );
};

export default Scoreboard;
