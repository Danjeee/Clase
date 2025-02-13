import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { AlertService } from '../../services/alerts.service';
import { VentasService } from '../../services/ventas.service';
import { CommonModule } from '@angular/common';
import { ArticulosService } from '../../services/articulos.service';
import { SessionService } from '../../services/session.service';

@Component({
  selector: 'app-vender',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './vender.component.html',
  styleUrl: './vender.component.css'
})
export class VenderComponent {

  categorias: any

/**
   * FormGroup que agrupa los campos del formulario de registro.
   * Maneja la validación de cada control.
   */
  ventaForm: FormGroup;

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
    private artService: ArticulosService,
    private session: SessionService,
    private router: Router,
    private sanitizer: DomSanitizer,
    private alertService: AlertService
  ) {
    // Se inicializa el ventaForm con sus campos y validadores.
    this.ventaForm = this.fb.group({
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
      foto: [
        '',
        [
          Validators.required,
        ],
      ],
      cat: [],
    });
  }

  // Ciclo de vida de Angular: ngOnInit se ejecuta después de crear el componente.
  ngOnInit(): void {
    this.artService.getCategorias().subscribe({
      next: (data) => {this.categorias = data
        console.log(data)
      },
      error: (err) => {console.error("Error: ",err)}
    })

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
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      this.ventaForm.patchValue({ foto: file }); // Actualizar el campo foto con el archivo
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
  subir(): void {
    // Verifica si el formulario es inválido
    if (this.ventaForm.invalid) {
      // Marca los campos como "touched" para que se muestren mensajes de error correspondientes
      Object.keys(this.ventaForm.controls).forEach((field) => {
        const control = this.ventaForm.get(field);
        control?.markAsTouched(); // Marcar todos los campos como tocados para mostrar errores
      });
      this.alertService.error(
        'Error',
        'Por favor, completa todos los campos correctamente.'
      );
      return;
    }

    // Preparar los datos para enviar al servidor usando FormData
    const formData = new FormData();
    formData.append('opcion', 'RA');
    formData.append('nombre', this.ventaForm.value.nombre);
    formData.append('descripcion', this.ventaForm.value.descripcion);
    formData.append('categoria', this.ventaForm.value.cat);
    formData.append('precio', this.ventaForm.value.precio);
    formData.append('vendedor', this.session.obtenerUsuario().id);
    // Si se seleccionó una foto, se añade a formData; de lo contrario, se usa una imagen por defecto.
    if (this.ventaForm.value.foto) {
      formData.append('imagen', this.ventaForm.value.foto);
    } else {
      formData.append('imagen', 'user.png'); // Imagen por defecto
    }

    // Llamada al servicio para registrar al socio en el backend
    this.ventasService.registrarVenta(formData).subscribe({
      next: (data) => {console.log(data)},
      error: (err) => {console.log("Error: "+ err)}
    })
    
  }

  /**
   * Método auxiliar para mostrar los errores de validación en la plantilla.
   * @param controlName - nombre del control en el FormGroup (ej. 'nombre', 'email').
   * @param errorName - tipo de error que se desea comprobar (ej. 'required', 'pattern').
   * @returns boolean indicando si el control tiene ese error y está "tocado".
   */
  mostrarError(controlName: string, errorName: string): boolean {
    const control = this.ventaForm.get(controlName);
    //return control?.hasError(errorName) && control.touched;
    return control!.hasError(errorName) && control!.touched;
  }
}
