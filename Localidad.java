public class Localidad {
    private int precio;
    private int ventas;
    private int id;

    public Localidad(int precio,int id) {
        this.precio = precio;
        this.ventas = 0;
        this.id = id;
    }
    
    public int getPrecio() {
        return this.precio;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public int getVentas() {
        return this.ventas;
    }

    public int getId() {
        return this.id;
    }

    public int getCaja(){
        return this.ventas * this.precio;
    }
    
}
