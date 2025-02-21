// Interfaz para representar los datos de una Venta.
export interface Venta {
  idventa: number; // Identificador único de la venta
  fecha: string | null; // Fecha de la venta (como string, formato AAAA-MM-DD, o null)
  socio: number; // ID del socio/vendedor
  articulo: number; // ID del artículo vendido
  precio: number; // Precio de la venta
  comprador: number; // ID del usuario que compró el artículo
}
