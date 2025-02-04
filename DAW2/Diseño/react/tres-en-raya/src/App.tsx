import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css'
import Home from "./pages/home/Home";
import Game from "./pages/game/Home";

function App() {
 

  return (
    <BrowserRouter>
      <Routes>
      <Route path="/" element={<Home />}></Route>
      <Route path="/Game" element={<Game />}></Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
