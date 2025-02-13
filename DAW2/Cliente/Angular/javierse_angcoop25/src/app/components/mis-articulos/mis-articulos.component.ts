import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

// Servicios para manejar artículos y ventas, así como la sesión y alertas.
import { ArticulosService } from '../../services/articulos.service';
import { VentasService } from '../../services/ventas.service';
import { SessionService } from '../../services/session.service';
import { AlertService } from '../../services/alerts.service';

// Modelo Articulo para tipar la lista de artículos
import { Articulo } from '../../models/articulo';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-galeria-articulos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './mis-articulos.component.html',
  styleUrl: './mis-articulos.component.css',
})
export class MisArticulosComponent implements OnInit {

  // Arreglo que almacenará los artículos disponibles para comprar
  articulos: Articulo[] = []; // lista de articulo

  articulosComprados: Articulo[] = []; // lista de articulo

  // ID del usuario que ha iniciado sesión (null si no hay sesión activa)
  usuarioId: number | null = null; // ID del usuario logueado

  constructor(
    private articulosService: ArticulosService,
    private ventasService: VentasService,
    private sessionService: SessionService,
    private alertService: AlertService,
    private router: Router
  ) {}

  /**
   * Al inicializar el componente:
   * 1. Obtiene los datos del usuario logueado desde SessionService.
   * 2. Si existe un usuario, carga la lista de artículos de la base de datos
   *    llamando a cargarArticulos().
   * 3. Si no hay usuario logueado, muestra un error.
   */
  ngOnInit(): void {
    const usuario = this.sessionService.obtenerUsuario();
    this.usuarioId = usuario ? usuario.id : null;
    if (this.usuarioId) {
      this.cargarArticulos();
    } else {
      this.alertService.error(
        'Error',
        'Debes iniciar sesión para comprar un artículo.'
      );
    }
  }

  /**
   * Método para cargar la lista de artículos.
   * Filtra los artículos para que no se muestren aquellos cuyo vendedor es el usuario logueado,
   * evitando que el usuario compre su propio artículo.
   */
  cargarArticulos(): void {
    this.articulosService.getMisArticulos(this.sessionService.obtenerUsuario().id).subscribe({
      next: (data) => {
        this.articulos = data
      },
      error: (error) => console.error('Error al obtener los artículos:', error),
    });
    this.articulosService.getArticulosComprados(this.sessionService.obtenerUsuario().id).subscribe({
      next: (data) => {
        this.articulosComprados = data
      },
      error: (error) => console.error('Error al obtener los artículos:', error),
    });
  }

  editar(art: any) {
      sessionStorage.setItem("art", art.id)
      this.router.navigate(["/editar-articulo"])
    }

  /**
   * Método que se llama cuando el usuario hace clic en "Comprar".
   * 1. Muestra un diálogo de confirmación (AlertService.confirm).
   * 2. Si el usuario confirma la compra:
   *    - Cambia el estado del artículo a 'V' (vendido).
   *    - Registra la venta en la base de datos.
   *    - Muestra un mensaje de éxito y recarga la lista de artículos.
   */
  borrar(articulo: Articulo): void {
    this.alertService
      .confirm(
        'Confirmar Borrado',
        `¿Estás seguro de que quieres borrar el artículo "${articulo.nombre}"`,
        'Sí, borrar',
        'Cancelar'
      )
      .then((confirmed) => {
        if (confirmed) {

          // Llamada al servicio para cambiar el estado del artículo
          this.articulosService.eliminarArticulo(articulo.id).subscribe({
            next: () => {
              this.alertService.success("Exito", "Producto borrado con exito")
              window.location.reload()
            },
            error: (err) => {
              console.error('Error al cambiar el estado del artículo:', err);
              this.alertService.error(
                'Error',
                'Hubo un problema al actualizar el estado del artículo.'
              );
            },
          });
        }
      });
  }
}
