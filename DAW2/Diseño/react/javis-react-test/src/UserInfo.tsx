import styles from './styles/user.module.css'
import React from 'react'

export interface User{
    nombre: string,
    edad: number,
    ocupacion: string
}

interface UserCardProps{
    user: User;
}

const UserCard: React.FC<UserCardProps> = ({user}) => {
    return(
        <div className={styles.usercont}>
            <div><strong>Nombre</strong><p>{user.nombre}</p></div>
            <div><strong>Edad</strong><p>{user.edad}</p></div>
            <div><strong>Ocupación</strong><p>{user.ocupacion}</p></div>
        </div>
    )
}

const VistaUser = () =>{
    const user:User = { nombre: "Juan", edad: 26, ocupacion: "nini"}
    return (
     <UserCard user={user}/>
    );
    };
    export default VistaUser;