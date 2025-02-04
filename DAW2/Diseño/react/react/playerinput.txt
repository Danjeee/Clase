import React, { useState } from 'react';

interface PlayerInputProps {
  onNamesEntered: (name1: string, name2: string) => void;
  onStartGame: () => void;
}

const PlayerInput: React.FC<PlayerInputProps> = ({ onNamesEntered, onStartGame }) => {
  const [player1Name, setPlayer1Name] = useState('');
  const [player2Name, setPlayer2Name] = useState('');

  const handleNamesSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onNamesEntered(player1Name, player2Name);
  };

  return (
    <form onSubmit={handleNamesSubmit}>
      <label htmlFor="player1Name">Jugador 1:</label>
      <input
        type="text"
        id="player1Name"
        value={player1Name}
        onChange={(e) => setPlayer1Name(e.target.value)}
        required
      />

      <label htmlFor="player2Name">Jugador 2:</label>
      <input
        type="text"
        id="player2Name"
        value={player2Name}
        onChange={(e) => setPlayer2Name(e.target.value)}
        required
      />

      <button type="submit">Guardar nombres</button>
      <button type="button" onClick={onStartGame}>
        Empezar partida
      </button>
    </form>
  );
};

export default PlayerInput;
