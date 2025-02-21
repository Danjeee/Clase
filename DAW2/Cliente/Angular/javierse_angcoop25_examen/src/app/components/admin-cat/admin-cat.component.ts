import { Component } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { AlertService } from '../../services/alerts.service';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-admin-cat',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './admin-cat.component.html',
  styleUrl: './admin-cat.component.css'
})
export class AdminCatComponent {

    editando = false
    actual: any
    registroForm: FormGroup;
    imagenPreview: SafeUrl | string = 'http://localhost/pruebaServidor/imgs/categorias/categorias.png'; // Imagen por defecto

    constructor(
        private fb: FormBuilder,
        private adminService: AdminService,
        private router: Router,
        private sanitizer: DomSanitizer,
        private alertService: AlertService,
        private alert: AlertService
      ) {
        // Se inicializa el registroForm con sus campos y validadores.
        this.registroForm = this.fb.group({
          nombre: [
            '',
            [
              Validators.required,
            ],
          ],
          foto: [null], // Campo opcional para la foto
        });
      }
    editCat(e: any) {
      const id = document.getElementById("id") as HTMLInputElement
      id.value = e.id
      this.editando = true
      this.registroForm.setValue({nombre: e.nombre, foto:null})
      this.imagenPreview = "http://localhost/pruebaServidor/imgs/categorias/"+e.imagen
      this.actual = e
    }
    cancel(){
      const id = document.getElementById("id") as HTMLInputElement
      id.value = ""
      this.editando = false
      this.registroForm.setValue({nombre: "", foto: null})
      this.imagenPreview = 'http://localhost/pruebaServidor/imgs/categorias/categorias.png';
      this.actual = null
    }

  categorias: any
  ngOnInit(): void {
    this.adminService.getAllCats().subscribe({ 
      next: (data) => {
        this.categorias = data
      }
    })
  }
  deleteCat(cat: any) {
    this.alert.confirm("¿Estas seguro?", "Vas a borrar una categoria", "Confirmar", "Cancelar").then((response)=>{
      if (response == true) {
        this.adminService.deleteCat(cat.id).subscribe({
          next: (data) => {
            if (data.ok) {
              this.alert.success("Hecho", "Categoria borrada correctamente", true)
            }
            if (data.error) {
              this.alert.error("Error", "La categoria "+cat.nombre +" ya tiene articulos asociados")
            }
          }
        })
      }
    })
  }
    mostrarError(controlName: string, errorName: string): boolean {
      const control = this.registroForm.get(controlName);
      //return control?.hasError(errorName) && control.touched;
      return control!.hasError(errorName) && control!.touched;
    }
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
    registrarCat(){
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
      if (this.registroForm.valid) {
        const data: FormData = new FormData()
        data.append('nombre', this.registroForm.value.nombre);
        if (this.registroForm.value.foto) {
          data.append('imagen', this.registroForm.value.foto);
        } else {
          if (this.editando) {
            data.append('imagen', this.actual.imagen)
          }
        }
        console.log(data)
        if (this.editando) {
          const id = document.getElementById("id") as HTMLInputElement
          data.append("idcategoria", id.value)
          this.adminService.editCat(data).subscribe({
            next: (data) => {
              if (data.ok) {
                this.alert.success("Exito", "Categoria actualizada correctamente", true)
              } else {
                this.alert.error("Error", data.error)
              }
            }
          })
        } else {
          this.adminService.newCat(data).subscribe({
            next: (data) => {
              if (data.ok) {
                this.alert.success("Exito", "Categoria creada correctamente")
              } else {
                this.alert.error("Error", data.error)
              }
            }
          })
        }
      }
    }
}
