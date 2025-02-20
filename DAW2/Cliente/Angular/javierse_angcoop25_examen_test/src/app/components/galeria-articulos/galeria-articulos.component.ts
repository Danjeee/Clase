import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

// Servicios para manejar artículos y ventas, así como la sesión y alertas.
import { ArticulosService } from '../../services/articulos.service';
import { VentasService } from '../../services/ventas.service';
import { SessionService } from '../../services/session.service';
import { AlertService } from '../../services/alerts.service';

// Modelo Articulo para tipar la lista de artículos
import { Articulo } from '../../models/articulo';

@Component({
  selector: 'app-galeria-articulos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './galeria-articulos.component.html',
  styleUrl: './galeria-articulos.component.css',
})
export class GaleriaArticulosComponent implements OnInit {
  // Arreglo que almacenará los artículos disponibles para comprar
  articulos: Articulo[] = []; // lista de articulo

  // ID del usuario que ha iniciado sesión (null si no hay sesión activa)
  usuarioId: number | null = null; // ID del usuario logueado

  constructor(
    private articulosService: ArticulosService,
    private ventasService: VentasService,
    private sessionService: SessionService,
    private alertService: AlertService
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
    this.articulosService.getArticulos().subscribe({
      next: (data) => {
        this.articulos = data.filter(
          (articulo) => articulo.vendedor !== this.usuarioId
        );
      },
      error: (error) => console.error('Error al obtener los artículos:', error),
    });
  }

  /**
   * Método que se llama cuando el usuario hace clic en "Comprar".
   * 1. Muestra un diálogo de confirmación (AlertService.confirm).
   * 2. Si el usuario confirma la compra:
   *    - Cambia el estado del artículo a 'V' (vendido).
   *    - Registra la venta en la base de datos.
   *    - Muestra un mensaje de éxito y recarga la lista de artículos.
   */
  comprarArticulo(articulo: Articulo): void {
    this.alertService
      .confirm(
        'Confirmar Compra',
        `¿Estás seguro de que quieres comprar el artículo "${articulo.nombre}" por ${articulo.precio}€?`,
        'Sí, comprar',
        'Cancelar'
      )
      .then((confirmed) => {
        if (confirmed) {
          // Prepara el FormData para actualizar el estado del artículo
          let formData = new FormData();
          formData.set('opcion', 'CA'); // "CA" opcion "Comprar Artículo" cambiar el estado de 'D' a 'V'
          formData.set('idarticulo', articulo.id.toString());

          // Llamada al servicio para cambiar el estado del artículo
          this.articulosService.cambiarEstadoArticulo(formData).subscribe({
            next: () => {
              // Una vez cambiado el estado, se registra la venta
              let formData = new FormData();
              formData.set('opcion', 'RV'); //Registrar venta en la tabla de ventas
              formData.set('idarticulo', articulo.id.toString());
              formData.set('precio', articulo.precio.toString());
              formData.set('fecha', new Date().toISOString().split('T')[0]); //AAAA/MM/AA
              formData.set('vendedor', articulo.vendedor.toString());
              formData.set('idsocio', this.usuarioId!.toString());

              this.ventasService.registrarVenta(formData).subscribe({
                next: (data) => {
                  // Mensaje de éxito
                  this.alertService.success(
                    'Compra Exitosa',
                    `Has comprado el artículo "${articulo.nombre}" por ${articulo.precio} €.`
                  );
                  // Recarga la lista de artículos
                  this.cargarArticulos();
                },
                error: (err) => {
                  console.error('Error al registrar la venta:', err);
                  this.alertService.error(
                    'Error',
                    'Hubo un problema al registrar la venta.'
                  );
                },
              });
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
