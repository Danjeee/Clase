import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { AlertService } from '../../services/alerts.service';
import { VentasService } from '../../services/ventas.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-vender',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './vender.component.html',
  styleUrl: './vender.component.css'
})
export class VenderComponent {
/**
   * FormGroup que agrupa los campos del formulario de registro.
   * Maneja la validación de cada control.
   */
  registroForm: FormGroup;

  /**
   * Variable que almacena la URL (o SafeUrl) de la imagen a mostrar en la previsualización.
   * Inicialmente se carga una imagen por defecto (ruta local o en el servidor).
   */
  imagenPreview: SafeUrl | string =
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
    private ventasService: VentasService,
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
        ],
      ],
      descripcion: [
        '',
        [
          Validators.required,
        ],
      ],
      precio: [
        '',
        [
          Validators.required,
        ],
      ],
      imagen: [
        '',
        [
          Validators.required,
        ],
      ],
    });
  }

  // Ciclo de vida de Angular: ngOnInit se ejecuta después de crear el componente.
  ngOnInit(): void {}

  /**
   * Método para previsualizar la imagen antes de subirla.
   * Se activa cuando se detecta un cambio en el input file (evento change).
   * 1. Obtiene el archivo.
   * 2. Crea un objeto URL temporal (objectURL) para poder mostrarlo en el <img>.
   * 3. Usa DomSanitizer para evitar problemas de seguridad con la URL.
   * 4. Actualiza el campo 'foto' en el FormGroup con el archivo.
   */
  previsualizarImagen(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      this.registroForm.patchValue({ foto: file }); // Actualizar el campo foto con el archivo
      const objectUrl = URL.createObjectURL(file);
      // bypassSecurityTrustUrl evita que Angular marque la URL como insegura.
      this.imagenPreview = this.sanitizer.bypassSecurityTrustUrl(objectUrl);
    }
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
    formData.append('opcion', 'RS');
    formData.append('nombre', this.registroForm.value.nombre);
    formData.append('apellidos', this.registroForm.value.apellidos);
    formData.append('email', this.registroForm.value.email);
    formData.append('password', password);
    // Si se seleccionó una foto, se añade a formData; de lo contrario, se usa una imagen por defecto.
    if (this.registroForm.value.foto) {
      formData.append('foto', this.registroForm.value.foto);
    } else {
      formData.append('foto', 'user.png'); // Imagen por defecto
    }

    // Llamada al servicio para registrar al socio en el backend
    
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
    return control!.hasError(errorName) && control!.touched;
  }
}
