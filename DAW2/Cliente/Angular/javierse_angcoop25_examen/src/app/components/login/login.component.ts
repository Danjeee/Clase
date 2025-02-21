import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { SessionService } from '../../services/session.service';
import { SociosService } from '../../services/socios.service';
import { AlertService } from '../../services/alerts.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  /**
   * Variables enlazadas al formulario:
   * - email: correo electrónico del usuario
   * - password: contraseña del usuario
   * - error: mensaje de error que se muestra en la plantilla si ocurre algún problema
   */
  email = '';
  password = '';
  error = '';

  /**
   * Inyecta servicios:
   * - Router para navegación
   * - SessionService para gestión de sesión (login/logout)
   * - SociosService para llamadas HTTP relacionadas con "Socios"
   * - AlertService para mostrar notificaciones (SweetAlert)
   */
  constructor(
    private router: Router,
    private sessionService: SessionService,
    private sociosService: SociosService,
    private alertService: AlertService
  ) {}

  /**
   * Método principal que se ejecuta al hacer "submit" en el formulario.
   * Realiza validaciones y, si son correctas, consulta el servicio `sociosService`
   * para verificar las credenciales en el servidor.
   */
  login(): void {

    if (!this.validarEmail(this.email)) {
      this.error = 'Formato de email incorrecto';
      return;
    }
    if (!this.validarPassword(this.password)) {
      this.error =
        'La contraseña debe tener más de 6 caracteres y al menos un número y una letra';
      return;
    }
    //const body = { opcion: 'SR', email: this.email, password: this.password };
    const params = new FormData();
    params.append('opcion', 'SR');
    params.append('email', this.email);
    params.append('password', this.password);

    this.sociosService.getSocioLogin(params).subscribe({
      next: (response: any) => {
        if (!response.error) {
          let datosUsuario = response[0];
          this.sessionService.iniciarSesion(datosUsuario);
          this.alertService.success('Mi app', '¡Acceso correcto!.');
          if (datosUsuario.rol == 'A') {
            this.router.navigate(['/admin/ventas']);
          } else {
            this.router.navigate(["galeria"])
          }
        } else {
          this.error = 'Usuario no registrado';
          this.alertService.error(
            'Mi app',
            'Usuario no registrado. Redirigiendo a registro.'
          );
          this.router.navigate(['/registro']);
        }
      },
      error: (error) => {
        console.log(error)
        this.error = 'Error de conexión';
      },
    });
  }

  validarEmail(email: string): boolean {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
  }

  validarPassword(password: string): boolean {
    const re = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,}$/;
    return re.test(password);
  }
}
