import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

/**
 * Servicio que gestiona la sesión del usuario (login/logout).
 * Usa BehaviorSubject para permitir que otros componentes
 * se suscriban y reaccionen a los cambios en el estado de la sesión.
 */
@Injectable({
  providedIn: 'root',
})
export class SessionService {
  // BehaviorSubject guarda el estado actual del usuario; inicializa con null.
  private usuarioActual = new BehaviorSubject<any>(null);
  public usuario$ = this.usuarioActual.asObservable();

  constructor() {
    // Al iniciar el servicio, revisamos si ya hay un usuario en localStorage
    const usuarioGuardado = localStorage.getItem('usuario');
    if (usuarioGuardado) {
      this.usuarioActual.next(JSON.parse(usuarioGuardado));
    }
  }

  /**
   * Inicia la sesión guardando el usuario en localStorage
   * y notificando a los suscriptores.
   * @param usuario Objeto que contiene los datos del usuario logueado.
   */
  iniciarSesion(usuario: any): void {
    localStorage.setItem('usuario', JSON.stringify(usuario));
    this.usuarioActual.next(usuario);
  }

  /**
   * Cierra la sesión eliminando el usuario de localStorage
   * y emitiendo null a los suscriptores.
   */
  cerrarSesion(): void {
    localStorage.removeItem('usuario');
    this.usuarioActual.next(null);
  }

  /**
   * Devuelve el usuario actual.
   * Si el BehaviorSubject está en null, pero existe un usuario en localStorage,
   * se actualiza el BehaviorSubject para mantener coherencia.
   */
  obtenerUsuario(): any {
    const usuario = localStorage.getItem('usuario');
    if (usuario) {
      this.usuarioActual.next(JSON.parse(usuario));
    }
    return this.usuarioActual.value;
  }
}
