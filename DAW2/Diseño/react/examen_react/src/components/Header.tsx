import '../styles/css/header.css'
import yt from '../assets/yt.png'
import ytl from '../assets/ytl.png'

function Header() {

  return (
    <>
      <div id="header">
          <img src={yt} alt=""/>
          <input type="text"/>
          <img src={ytl} alt=""/>
      </div>
    </>
  )
}

export default Header
