import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Socio } from '../models/socio';

/**
 * Servicio para manejar operaciones relacionadas con "Socios":
 * - Login
 * - Registro
 * - Obtención de todos los socios
 * - Obtención de un socio por id
 */

@Injectable({
  providedIn: 'root',
})
export class SociosService {
  private apiUrl = environment.apiUrl; // URL base del backend

  constructor(private http: HttpClient) {}

  /**
   * Realiza una petición POST al servidor para validar las credenciales del socio.
   * @param formData FormData con los campos necesarios (opcion, email, password).
   * @returns Observable con la respuesta del servidor (puede ser un objeto o array).
   */
  getSocioLogin(formData: FormData): Observable<any> {
    return this.http.post(`${this.apiUrl}`, formData);
  }

  /**
   * Registra un nuevo socio en la plataforma.
   * @param formData FormData con datos del socio a registrar.
   * @returns Observable con la respuesta del servidor (status, error, etc.).
   */
  registrarSocio(formData: FormData): Observable<any> {
    return this.http.post(`${this.apiUrl}`, formData);
  }

  /**
   * Recupera la lista de todos los socios.
   * Retorna un array de objetos que implementan la interfaz Socio.
   */
  getSocios(): Observable<Socio[]> {
    return this.http.get<Socio[]>(`${this.apiUrl}?opcion=TS`);
  }

  /**
   * Obtiene un socio por su identificador único.
   * @param id Identificador numérico del socio
   * @returns Observable con un objeto Socio
   */
  getSocioById(id: number): Observable<Socio> {
    return this.http.get<Socio>(`${this.apiUrl}?opcion=GS&id=${id}`);
  }
}
