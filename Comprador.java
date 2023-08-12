import java.util.Random;

public class Comprador {
    private String name;
    private String email;
    private int boletos;
    private int presupuesto;
    private boolean aprovado;
    private int localidad;
    private Random r1;

    public Comprador(String name, String email){
        this.name = name;
        this.email = email;
        this.r1 = new Random();
    }

    public void setPresupuesto(int presupuesto){
        this.presupuesto = presupuesto;
    }

    public void setBoletos(int boletos){
        this.boletos = boletos;
    }

    public void generateTicket(){
        int a = this.r1.nextInt(15000) + 1;
        int b = this.r1.nextInt(15000) + 1;
        int li = 0;
        int ls = 0;
        if(a>=b){
            ls = a;
            li = b;
        }else{
            ls = b;
            li = a;
        }
        int ticket = this.r1.nextInt(15000) + 1;
        System.out.println("Limite superior: "+ ls + " Limite inferior: "+ li + " Ticket: "+ ticket);

        if (ticket<= ls && ticket>=li){
            this.aprovado = true;
        }
        else{
            this.aprovado = false;
        }
    }

    public void generateLocalidad(){
        int l = this.r1.nextInt(3) + 1;
        this.localidad = l;
    }

    public String getEmail(){
        return this.email;
    }

    public String getNombre(){
        return this.name;
    }
    
    public int getBoletos(){
        return this.boletos;
    }

    public int getPresupuesto(){
        return this.presupuesto;
    }

    public int getLocalidad(){
        return this.localidad;
    }

    public boolean getAprovado(){
        return this.aprovado;
    }


    
}
