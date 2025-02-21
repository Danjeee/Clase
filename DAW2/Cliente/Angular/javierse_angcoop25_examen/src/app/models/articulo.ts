// Interfaz para representar un Artículo dentro de la aplicación.
// Define campos como la categoría, nombre, descripción, precio, imagen, etc.
export interface Articulo {
  id: number; // Identificador único del artículo
  categoria: number; // ID de la categoría a la que pertenece
  nombre: string; // Nombre del artículo
  descripcion: string | null; // Descripción opcional (puede ser nula)
  precio: number; // Precio del artículo
  imagen: string; // Nombre la imagen del artículo en el servidor
  vendedor: number; // ID del usuario que publicó el artículo
  estado: 'D' | 'V'; // Estado del artículo, 'D' disponible, 'V' vendido
}
