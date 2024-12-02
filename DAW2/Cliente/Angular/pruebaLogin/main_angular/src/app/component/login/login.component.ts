import { CommonModule, DOCUMENT } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { LoginService } from '../../service/login.service';

var email: any;
var pass: any;

@Component({
  selector: 'app-login',
  imports: [CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  standalone: true,
  
})
export class LoginComponent{
  user = "a";
  constructor(private loginService : LoginService, @Inject(DOCUMENT) document:Document) {
    email = document.getElementById("email");
    pass = document.getElementById("pass");
  }
  login(): void {
    
    this.loginService.login(email.value, pass.value).subscribe({
      next: (data) => {
        console.log("Respuesta del servidor: ",data);
        if (data.error != "Sin datos en la consulta") {
          sessionStorage.setItem("user", JSON.stringify(data[0]))
          var useraux = sessionStorage.getItem("user")
          console.log(useraux)
          if (useraux) {
            console.log(JSON.parse(useraux).nombre)
            this.user = JSON.parse(useraux).nombre
          }
          console.log("sesion iniciada")
        }
    },
    error: (error) => console.error("Error al obtener los datos: ", error)
    })
  }
}
