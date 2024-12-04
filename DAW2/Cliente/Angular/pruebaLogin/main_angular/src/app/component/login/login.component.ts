import { CommonModule, DOCUMENT } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { SociosService } from '../../service/socios.service';

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
  constructor(private sociosService : SociosService) {
  }
  login(): void {
    
    this.sociosService.login(email.value, pass.value).subscribe(   {
      next: (data) => {
        console.log("Respuesta del servidor: ",data);
        if (data.error != "Sin datos en la consulta") {
          sessionStorage.setItem("user", JSON.stringify(data[0]))
          var useraux = sessionStorage.getItem("user")
          if (useraux) {
            console.log("sesion iniciada como "+JSON.parse(useraux).nombre)
          }
          
        }
    },
    error: (error) => console.error("Error al obtener los datos: ", error)
    })
  }
}
