import '../styles/css/home.css'

function Home() {

  return (
    <>
      <div id="home">
          <iframe
              className="video" // PISTA PARA METER ESTILOS AL VIDEO
              src="https://www.youtube.com/embed/dQw4w9WgXcQ?si=DT54fKtrm4NF1Xci"
              title="YouTube video player"
              frameBorder="0"
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope;
picture-in-picture; web-share"
              referrerPolicy="strict-origin-when-cross-origin"
              allowFullScreen/>
          <div>
              <p>“Never Gonna Give You Up” by Rick Astley.</p>
              <p className="views">1,621,866,337 views 25 Oct 2009</p>
              <p>#RickAstley #NeverGonnaGiveYouUp #OfficialMusicVideo </p>
              <p>“Never Gonna Give You Up” was a global smash on its release in July 1987,
              topping the charts in 25 countries including Rick’s native UK and the US
              Billboard Hot 100.
              It also won the Brit Award for Best single in 1988. Stock Aitken and Waterman
              wrote and produced the track which was the lead-off single and lead track
              from Rick’s debut LP “Whenever You Need Somebody”. The album was itself
                  a UK number one and would go on to sell over 15 million copies worldwide.</p>
          </div>
      </div>
    </>
  )
}

export default Home
