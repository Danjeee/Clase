/**
 * Interfaz que define la estructura de un socio.
 * - 'id': identificador numérico.
 * - 'rol': 'U' (usuario) o 'A' (admin).
 * - 'nombre': nombre del socio.
 * - 'apellidos': apellidos del socio.
 * - 'email': correo electrónico del socio.
 * - 'foto': ruta de la foto (opcional).
 * - 'password': contraseña (puede ser guardada cifrada en el backend).
 */
export interface Socio {
  id: number;
  rol: 'U' | 'A';
  nombre: string;
  apellidos: string;
  email: string;
  foto: string;
  password: string;
}
