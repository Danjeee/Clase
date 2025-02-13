import '../styles/css/form.css'

function Form() {
    function submit(){
        const name = document.getElementById("name") as HTMLInputElement
        const email = document.getElementById("email") as HTMLInputElement
        const msg = document.getElementById("msg") as HTMLTextAreaElement
        if (email.value.includes('@')){
            alert(
                "Mensaje de: "+name.value +"\n"+
                "Email: "+email.value+"\n"+
                "Message: "+msg.value
            )
        }
    }
  return (
    <>
        <form id="form" onSubmit={event => event.preventDefault()}>
            <h2>Contact us</h2>
            <label>Name</label>
            <input type="text" name="name" id="name"/>
            <label>Email</label>
            <input type="email" name="email" id="email"/>
            <label>Message</label>
            <textarea id="msg" name="msg"></textarea>
            <input type="submit" value="Submit" onClick={submit} />
        </form>
    </>
  )
}

export default Form
