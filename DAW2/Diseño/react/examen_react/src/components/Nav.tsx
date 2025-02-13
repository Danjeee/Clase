import '../styles/css/nav.css'
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Home from "./Home.tsx";
import Catalog from "./Catalog.tsx";
import Form from "./Form.tsx";

function Nav() {

  return (
    <>
        <BrowserRouter>
            <div id="nav">
                <Link to="/">Home</Link>
                <Link to="/Catalog">Catalog</Link>
                <Link to="/Form">Form</Link>
            </div>
                <Routes>
                    <Route path="/" Component={Home}></Route>
                    <Route path="/Catalog" Component={Catalog}></Route>
                    <Route path="/Form" Component={Form}></Route>
                </Routes>
        </BrowserRouter>
    </>
)
}

export default Nav
