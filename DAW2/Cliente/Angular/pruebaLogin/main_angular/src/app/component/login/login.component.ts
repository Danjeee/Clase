import { CommonModule, DOCUMENT } from '@angular/common';
import { AfterViewInit, Component, Inject } from '@angular/core';
import { LoginService } from '../../service/login.service';
import { OnInit } from '@angular/core';

var subm: any;
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
  constructor(private loginService : LoginService, @Inject(DOCUMENT) document:Document) {
    subm = document.getElementById("subm");
    email = document.getElementById("email");
    pass = document.getElementById("pass");
  }
  login(): void {
    
    this.loginService.login(email.value, pass.value).subscribe({
      next: (data) => {
        console.log("Respuesta del servidor: ",data);
    },
    error: (error) => console.error("Error al obtener los articulos: ", error)
    })
  }
}
