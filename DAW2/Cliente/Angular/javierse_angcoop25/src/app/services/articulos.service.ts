import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

// Importa las interfaces que se usarán para tipar los resultados
import { Articulo } from '../models/articulo';
import { Categoria } from '../models/categoria';

@Injectable({
  providedIn: 'root',
})
export class ArticulosService {
  // URL base, definida en environment, para construir las peticiones al backend.
  private apiUrl = environment.apiUrl; // URL base desde el archivo de configuración

  constructor(private http: HttpClient) {}

  /**
   * Obtiene todos los artículos disponibles para la venta (opcion=AV).
   * Devuelve un Observable de un array de Articulos.
   */
  getArticulos(): Observable<Articulo[]> {
    return this.http.get<Articulo[]>(`${this.apiUrl}?opcion=AV`);
  }

  /**
   * Obtiene la lista de categorías (opcion=TC).
   * Devuelve un Observable de un array de Categorias.
   */
  getCategorias(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(`${this.apiUrl}?opcion=TC`);
  }

  /**
   * Registra un nuevo artículo en el sistema mediante FormData (contiene datos e imagen).
   * Se usa POST al endpoint principal.
   */
  registrarArticulo(formData: FormData): Observable<any> {
    return this.http.post(`${this.apiUrl}`, formData);
  }

  /**
   * Obtiene todos los artículos publicados por un usuario específico (articulos del socio que inicia sesión) (opcion=AS).
   * @param usuarioId ID del usuario vendedor
   */
  getMisArticulos(usuarioId: number): Observable<Articulo[]> {
    return this.http.get<Articulo[]>(
      `${this.apiUrl}?opcion=AS&idsocio=${usuarioId}`
    );
  }
  getArticulosComprados(usuarioId: number): Observable<Articulo[]> {
    return this.http.get<Articulo[]>(
      `${this.apiUrl}?opcion=SVS&idsocio=${usuarioId}`
    );
  }

  /**
   * Elimina un artículo por su ID (opcion=BA).
   * @param articuloId ID del artículo a eliminar.
   */
  eliminarArticulo(articuloId: number): Observable<any> {
    return this.http.get(
      `${this.apiUrl}?opcion=BA&idarticulo=${articuloId}`
    );
  }

  /**
   * Cambia el estado del artículo (de 'D' a 'V').
   * Se envía como POST con FormData (opcion=CA).
   */
  cambiarEstadoArticulo(formData: FormData): Observable<any> {
    //const body = { opcion: 'CA', idarticulo: idArticulo };
    return this.http.post(`${this.apiUrl}`, formData);
  }

  /**
   * Obtiene la información de un artículo por su ID (opcion=AC).
   * @param articuloId Identificador del artículo.
   */
  getArticuloById(articuloId: number): Observable<Articulo> {
    return this.http.get<Articulo>(
      `${this.apiUrl}?opcion=AC&idarticulo=${articuloId}`
    );
  }

  /**
   * Modifica los datos de un artículo (nombre, precio, etc.) enviando un FormData (opcion no mostrada pero asumida).
   */
  modificarArticulo(formData: FormData): Observable<any> {
    return this.http.post(`${this.apiUrl}`, formData); // Usamos POST para enviar los datos
  }
}
