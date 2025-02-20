import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

// Importaciones para formularios reactivos (FormBuilder, FormGroup, Validators).
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

// Herramientas para navegar en la aplicación y sanitizar URLs de imágenes.
import { Router } from '@angular/router';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

// Servicios que se utilizarán para la lógica de negocio y alertas.
import { SociosService } from '../../services/socios.service';
import { AlertService } from '../../services/alerts.service';
import { Socio } from '../../models/socio';
import { SessionService } from '../../services/session.service';

@Component({
  selector: 'app-registro-socio',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css'],
})
export class PerfilComponent implements OnInit {


  editando: boolean = true

  user: any = []
  /**
   * FormGroup que agrupa los campos del formulario de registro.
   * Maneja la validación de cada control.
   */
  registroForm: FormGroup;

  /**
   * Variable que almacena la URL (o SafeUrl) de la imagen a mostrar en la previsualización.
   * Inicialmente se carga una imagen por defecto (ruta local o en el servidor).
   */
  def: string =
  'http://localhost/pruebaServidor/imgs/socios/';
  imagenPreview: string =
    'http://localhost/pruebaServidor/imgs/socios/user.png'; // Imagen por defecto

  /**
   * El constructor inyecta:
   * - FormBuilder: para crear el FormGroup y sus validaciones.
   * - SociosService: para interactuar con el backend en el alta de socios.
   * - Router: para navegar a otras rutas al completar el registro.
   * - DomSanitizer: para sanitizar la URL de la imagen al cargarla.
   * - AlertService: para mostrar mensajes y alertas al usuario.
   */
  constructor(
    private fb: FormBuilder,
    private sociosService: SociosService,
    private sessionService: SessionService,
    private router: Router,
    private sanitizer: DomSanitizer,
    private alertService: AlertService
  ) {
    // Se inicializa el registroForm con sus campos y validadores.
    this.registroForm = this.fb.group({
      nombre: [
        '',
        [
          Validators.required,
          Validators.pattern(/^[A-Za-zÁÉÍÓÚáéíóúñÑ0-9 ]{2,20}$/),
        ],
      ],
      apellidos: [
        '',
        [
          Validators.required,
          Validators.pattern(/^[A-Za-zÁÉÍÓÚáéíóúñÑ0-9 ]{2,30}$/),
        ],
      ],
      email: ['', [Validators.required, Validators.email]],
      foto: [null], // Campo opcional para la foto
      password: [
        '',
        [
          Validators.required,
          Validators.pattern(/^(?=.*[A-Za-z])(?=.*\d).{5,10}$/),
        ],
      ],
      repitePassword: [
        '',
        [
          Validators.required,
          Validators.pattern(/^(?=.*[A-Za-z])(?=.*\d).{5,10}$/),
        ],
      ],
    });
  }

  toggleeditar() {
      const form = document.getElementById("form") as HTMLFormElement
      this.editando = !this.editando
      if (this.editando) {
        form.childNodes.forEach(e => {
          if (e instanceof HTMLDivElement) {
            e.childNodes.forEach(elem => {
              if (elem instanceof HTMLInputElement) {
                elem.readOnly = false
              }
            });
          }
        });
      } else {
        form.childNodes.forEach(e => {
          if (e instanceof HTMLDivElement) {
            e.childNodes.forEach(elem => {
              if (elem instanceof HTMLInputElement) {
                elem.readOnly = true
                elem.value = this.user[elem.id]
              }
            });
          }
          this.registroForm.setValue({nombre: this.user.nombre, apellidos: this.user.apellidos, email: this.user.email, foto: this.user.foto , password: null, repitePassword: null})
          const foto = document.getElementById("imagen") as HTMLImageElement

            foto.src = this.def + this.user.foto

        });
      }

    }

  // Ciclo de vida de Angular: ngOnInit se ejecuta después de crear el componente.
  ngOnInit(): void {
    
    
    this.sociosService.getSocioById(this.sessionService.obtenerUsuario().id).subscribe({
      next: (data) => {this.user = data[0]
        this.registroForm.setValue({nombre: data[0].nombre, apellidos: data[0].apellidos, email: data[0].email, foto: data[0].foto, password: null, repitePassword: null})
      },
      error: (err) => {console.error("Error, ",err)}
    })
    
    setTimeout(() => {
      this.toggleeditar()
    }, 200);
    
  }

  /**
   * Método para previsualizar la imagen antes de subirla.
   * Se activa cuando se detecta un cambio en el input file (evento change).
   * 1. Obtiene el archivo.
   * 2. Crea un objeto URL temporal (objectURL) para poder mostrarlo en el <img>.
   * 3. Usa DomSanitizer para evitar problemas de seguridad con la URL.
   * 4. Actualiza el campo 'foto' en el FormGroup con el archivo.
   */
  previsualizarImagen(event: Event): void {

    const imagen = document.getElementById("imagen") as HTMLInputElement
    const input = document.getElementById("foto") as HTMLInputElement
    const files: any = input.files
    imagen.src = window.URL.createObjectURL(files[0])
    /*
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      this.registroForm.patchValue({ foto: file }); // Actualizar el campo foto con el archivo
      const objectUrl = URL.createObjectURL(file);
      // bypassSecurityTrustUrl evita que Angular marque la URL como insegura.
      this.imagenPreview = this.sanitizer.bypassSecurityTrustUrl(objectUrl) as string;
    }*/
  }

  /**
   * Método para registrar un socio.
   * 1. Verifica si el formulario es inválido. De ser así, marca todos los campos como tocados
   *    y muestra una alerta de error para notificar al usuario.
   * 2. Verifica si las contraseñas coinciden.
   * 3. Construye un objeto FormData para enviar la información, incluyendo la foto (si existe).
   * 4. Envía el formData al servicio sociosService.
   * 5. Maneja la respuesta:
   *    - Si es exitoso, muestra una alerta de éxito y redirige al login.
   *    - Si hay un error, muestra una alerta de error.
   */
  registrarSocio(): void {
    const form = document.getElementById("form") as HTMLFormElement
    // Verifica si el formulario es inválido
    if (this.registroForm.invalid) {
      // Marca los campos como "touched" para que se muestren mensajes de error correspondientes
      Object.keys(this.registroForm.controls).forEach((field) => {
        const control = this.registroForm.get(field);
        control?.markAsTouched(); // Marcar todos los campos como tocados para mostrar errores
      });
      this.alertService.error(
        'Error',
        'Por favor, completa todos los campos correctamente.'
      );
      return;
    }

    // Verificar que las contraseñas coincidan
    const password = this.registroForm.value.password;
    const repitePassword = this.registroForm.value.repitePassword;
    if (password !== repitePassword) {
      this.alertService.error('Error', 'Las contraseñas no coinciden.');
      return;
    }

    // Preparar los datos para enviar al servidor usando FormData
    const formData = new FormData();
    formData.append('opcion', 'MS');
    formData.append('idsocio', this.sessionService.obtenerUsuario().id)
    formData.append('nombre', this.registroForm.value.nombre);
    formData.append('apellidos', this.registroForm.value.apellidos);
    formData.append('email', this.registroForm.value.email);
    formData.append('password', password);
    // Si se seleccionó una foto, se añade a formData; de lo contrario, se usa una imagen por defecto.
    const img = document.getElementById("foto") as HTMLInputElement
    const files = img.files as any
    if (files[0]) {
      formData.append('foto', files[0]);
    } else {
      formData.append('foto', this.user.foto); // Imagen por defecto
    }

    // Llamada al servicio para registrar al socio en el backend
    this.sociosService.registrarSocio(formData).subscribe({
      next: (response: any) => {
        // Si el servidor no reporta error
        console.log(response)
        if (!response.error) {
          this.alertService.success('Éxito', 'Socio registrado con éxito.');
          this.router.navigate(['/login']);
        } else {
          this.alertService.error('Error', 'Error al registrar el socio.');
        }
      },
      error: (err) => {
        console.error('Error en la petición (registrar socio):', err);
        this.alertService.error('Error', 'Hubo un problema en la petición.');
      },
    });
  }

  /**
   * Método auxiliar para mostrar los errores de validación en la plantilla.
   * @param controlName - nombre del control en el FormGroup (ej. 'nombre', 'email').
   * @param errorName - tipo de error que se desea comprobar (ej. 'required', 'pattern').
   * @returns boolean indicando si el control tiene ese error y está "tocado".
   */
  mostrarError(controlName: string, errorName: string): boolean {
    const control = this.registroForm.get(controlName);
    //return control?.hasError(errorName) && control.touched;

    const test = document.getElementById(controlName) as HTMLInputElement
    if (test.value != "" && this.editando) {
      //return false;
    }

    return control!.hasError(errorName) && control!.touched;
  }
}
