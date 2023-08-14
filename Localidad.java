/**
 * Clase que representa una localidad para la venta de boletos de un evento.
 */
public class Localidad {
    private int precio;      // Precio de la localidad
    private int ventas;      // Cantidad de boletos vendidos para esta localidad
    private int id;          // Identificador único de la localidad

    /**
     * Constructor de la clase Localidad.
     * @param precio Precio de la localidad.
     * @param id Identificador único de la localidad.
     */
    public Localidad(int precio, int id) {
        this.precio = precio;
        this.ventas = 0;
        this.id = id;
    }

    /**
     * Obtiene el precio de la localidad.
     * @return Precio de la localidad.
     */
    public int getPrecio() {
        return this.precio;
    }

    /**
     * Establece la cantidad de boletos vendidos para esta localidad.
     * @param ventas Cantidad de boletos vendidos.
     */
    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    /**
     * Obtiene la cantidad de boletos vendidos para esta localidad.
     * @return Cantidad de boletos vendidos.
     */
    public int getVentas() {
        return this.ventas;
    }

    /**
     * Obtiene el identificador único de la localidad.
     * @return Identificador único de la localidad.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Calcula la cantidad de dinero recaudado por la venta de boletos de esta localidad.
     * @return Cantidad de dinero recaudado.
     */
    public int getCaja(){
        return this.ventas * this.precio;
    }
}
