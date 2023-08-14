import java.util.Random;

/**
 * Clase que representa a un comprador que desea adquirir boletos para un evento.
 */
public class Comprador {
    private String name;            // Nombre del comprador
    private String email;           // Correo electrónico del comprador
    private int boletos;            // Cantidad de boletos que el comprador desea adquirir
    private int presupuesto;        // Presupuesto disponible del comprador
    private boolean aprovado;       // Indica si el comprador fue aprobado para la compra
    private int localidad;          // Número de localidad seleccionada por el comprador
    private Random r1;              // Generador de números aleatorios

    /**
     * Constructor de la clase Comprador.
     * @param name Nombre del comprador.
     * @param email Correo electrónico del comprador.
     */
    public Comprador(String name, String email){
        this.name = name;
        this.email = email;
        this.r1 = new Random();
    }

    /**
     * Establece el presupuesto disponible para el comprador.
     * @param presupuesto Presupuesto disponible del comprador.
     */
    public void setPresupuesto(int presupuesto){
        this.presupuesto = presupuesto;
    }

    /**
     * Establece la cantidad de boletos que el comprador desea adquirir.
     * @param boletos Cantidad de boletos deseados por el comprador.
     */
    public void setBoletos(int boletos){
        this.boletos = boletos;
    }

    /**
     * Genera un número de ticket aleatorio y verifica si el comprador está aprobado para la compra.
     */
    public void generateTicket(){
        int a = this.r1.nextInt(15000) + 1;
        int b = this.r1.nextInt(15000) + 1;
        int li = 0;
        int ls = 0;
        if(a >= b){
            ls = a;
            li = b;
        } else{
            ls = b;
            li = a;
        }
        int ticket = this.r1.nextInt(15000) + 1;
        System.out.println("Limite superior: " + ls + " Limite inferior: " + li + " Ticket: " + ticket);

        if (ticket <= ls && ticket >= li){
            this.aprovado = true;
        } else{
            this.aprovado = false;
        }
    }

    /**
     * Genera un número de localidad aleatorio para el comprador.
     */
    public void generateLocalidad(){
        int l = this.r1.nextInt(3) + 1;
        this.localidad = l;
    }

    /**
     * Obtiene el correo electrónico del comprador.
     * @return Correo electrónico del comprador.
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Obtiene el nombre del comprador.
     * @return Nombre del comprador.
     */
    public String getNombre(){
        return this.name;
    }

    /**
     * Obtiene la cantidad de boletos deseados por el comprador.
     * @return Cantidad de boletos deseados.
     */
    public int getBoletos(){
        return this.boletos;
    }

    /**
     * Obtiene el presupuesto disponible del comprador.
     * @return Presupuesto disponible.
     */
    public int getPresupuesto(){
        return this.presupuesto;
    }

    /**
     * Obtiene el número de localidad seleccionado por el comprador.
     * @return Número de localidad.
     */
    public int getLocalidad(){
        return this.localidad;
    }

    /**
     * Indica si el comprador fue aprobado para la compra.
     * @return `true` si el comprador está aprobado, `false` en caso contrario.
     */
    public boolean getAprovado(){
        return this.aprovado;
    }
}
