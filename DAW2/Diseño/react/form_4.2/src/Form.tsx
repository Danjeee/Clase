
import styles from './form.module.css'

function Form() {

  return (
    <>
      <form action="#" className={styles.form}>
        <h3>Formulario de registro</h3>
        <label htmlFor="name">Nombre</label>
        <input type="text" name='name' />
        <label htmlFor="mail">Correo Electronico</label>
        <input type="email" name='mail' />
        <label htmlFor="pass">Contraseña</label>
        <input type="password" name='pass' />
        <label htmlFor="passc">Confirmar contraseña</label>
        <input type="password" name='passc' />
        <input type="submit" value="Registrarse" />
      </form>
    </>
  )
}

export default Form
