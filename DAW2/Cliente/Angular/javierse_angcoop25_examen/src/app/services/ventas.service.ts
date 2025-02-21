import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VentasService {
  // URL base del backend, definida en el environment.
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  /**
   * Registra una venta (opcion=RV).
   * Se envía un objeto FormData con la información necesaria para el registro de la venta:
   * fecha, vendedor, artículo, precio y comprador.
   */
  registrarVenta(formData: FormData): Observable<any> {
    return this.http.post(this.apiUrl, formData);
  }
}

/*const fecha = new Date().toISOString().split('T')[0]; // Formato AAAA-MM-DD
    const body = {
      opcion: 'RV',
      fecha: fecha,
      vendedor: vendedorId,
      idarticulo: idArticulo,
      precio: precio,
      idsocio: socioId,
    };*/
