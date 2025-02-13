import '../styles/css/banner.css'
import bg from '../assets/bg.jpg'

function Banner() {

  return (
    <>
      <div id="banner">
          <img src={bg} alt=""/>
          <div>
              <img src={bg} alt=""/>
              <div>
                  <h1>Channel name</h1>
                  <p>4.24M subscribers · 637 videos</p>
                  <p>Channel demo to lock for real students</p>
                  <p className="red">Link to examen solution</p>
              </div>
          </div>
      </div>
    </>
  )
}

export default Banner
