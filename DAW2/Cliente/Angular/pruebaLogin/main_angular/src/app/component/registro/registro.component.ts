import { AfterViewInit, Component, inject, Inject, type OnInit } from "@angular/core";
import { SociosService } from "../../service/socios.service";
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroupDirective,
  ReactiveFormsModule,
  ValidationErrors,
  ValidatorFn,
  Validators,
} from "@angular/forms";
import { CommonModule, DOCUMENT } from "@angular/common";

@Component({
  selector: "app-register",
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: "./registro.component.html",
  styleUrl: "./registro.component.css",
})
export class RegistroComponent implements AfterViewInit{
  alrExistError = false
  foto: any
  ngAfterViewInit(): void {
    const form = document.getElementById("form") as HTMLFormElement;
    const body = new FormData(form);
      this.foto = body.get("foto")[0]
      console.log(this.foto)
  }
  
  checkfoto(){
    
  }
  form = this.formBuilder.group({
    nombre: [
      "",
      [Validators.required, Validators.minLength(2), Validators.maxLength(20)],
    ],
    apellidos: [
      "",
      [Validators.required, Validators.minLength(3), Validators.maxLength(30)],
    ],
    email: [
      "",
      [
        Validators.required,
        Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"),
      ],
    ],
    password: [
      "",
      [
        Validators.required,
        Validators.pattern("^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{5,10}$"),
      ],
    ],
    passc: [
      "",
      [Validators.required, this.passwordMatchValidator.bind(this)],
    ],
  });

  constructor(
    private sociosService: SociosService,
    private formBuilder: FormBuilder,
  ) { }

  passwordMatchValidator(control: AbstractControl): ValidationErrors | null {
    const pass = this.form?.get("password")?.value;
    const rep = control.value;
    return pass === rep ? null : { eq: true };
  }

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

  registro() {
    if (this.form.valid) {
      const form = document.getElementById("form") as HTMLFormElement;
      const body = new FormData(form);
      body.append("opcion", "RS")
      console.log(body.get("foto")?["name"]:["name"])
      this.sociosService.register(body).subscribe({
        
        next: (data) => {
          const resp = JSON.parse(JSON.stringify(data));
          if (resp.ok) {
            //window.location.href = "/login";
            console.log(data)
          } else if (resp.error) {
            this.alrExistError = true
            console.log("Usuario ya existe");
          }
        },
        error: (err) => console.log("Error en registro ", err),
      });
    } else {
      this.form.markAllAsTouched();
    }
  }
}