import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { SociosService } from '../../service/socios.service';
import { FormBuilder, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  standalone: true,

})
export class LoginComponent {
  form = this.formBuilder.group({
    email: [
      "",
      [
        Validators.required,
      ],
    ],
    password: [
      "",
      [
        Validators.required,
      ],
    ],
  })

  errors(field: string): ValidationErrors | null {
    const control = this.form.get(field);
    if (control?.errors) {
      return control.errors;
    }
    return null;
  }

  touched(field: string): boolean | undefined {
    return this.form.get(field)?.touched;
  }
  constructor(private sociosService: SociosService, private formBuilder: FormBuilder) {
  }
  login(): void {
    if (this.form.valid) {
      const formdata = document.getElementById("form") as HTMLFormElement;
      const body = new FormData(formdata);
      body.append("opcion", "SR")
      this.sociosService.login(body).subscribe({
        next: (data) => {
          const resp = JSON.parse(JSON.stringify(data));
          console.log(resp)
          if (resp.error!="Sin datos en la consulta") {
            sessionStorage.setItem("user", JSON.stringify(data[0]))
            var useraux = sessionStorage.getItem("user")
            
            if (useraux) {
              console.log("sesion iniciada como " + JSON.parse(useraux).nombre)
              window.location.href = "/home"
            }

          }
        },
        error: (error) => console.error("Error al obtener los datos: ", error)
      })
    } else {
      this.form.markAllAsTouched()
    }
  }
}
