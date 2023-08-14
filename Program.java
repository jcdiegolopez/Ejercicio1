import java.util.Scanner;

/**
 * Clase que contiene el programa principal que gestiona la venta de boletos para un evento.
 */
public class Program {

    public static void main(String[] args){
        // Creación de instancias de localidades
        Localidad localidad1 = new Localidad(100,1);
        Localidad localidad5 = new Localidad(500,5);
        Localidad localidad10 = new Localidad(1000,10);
        Scanner myInput = new Scanner(System.in);
        Comprador cliente = null;
        boolean finalizar = false;

        // Ciclo principal del programa
        while(!finalizar){
            System.out.println("Ingrese la opcion que desea realizar:");
            System.out.println("1.Nuevo Cliente");
            System.out.println("2.Nueva Solicitud:");
            System.out.println("3.Disponibilidad total:");
            System.out.println("4.Disponibiliad individual:");
            System.out.println("5.Reporte caja:");
            System.out.println("6.Salir:");

            int opt = myInput.nextInt();
            
            switch(opt){
                case 1:{
                    System.out.println("Ingrese el nombre del cliente");
                    String name = myInput.next();
                    System.out.println("Ingrese el email del cliente");
                    String email = myInput.next();
                    cliente = new Comprador(name, email);
                    break;
                }
                case 2:{
                    try {
                        System.out.println("Ingrese su presupuesto");
                        int presupuesto = myInput.nextInt();
                        System.out.println("Ingrese la cantidad de boletos");
                        int boletos = myInput.nextInt();
                        cliente.setPresupuesto(presupuesto);
                        cliente.setBoletos(boletos);
                        cliente.generateLocalidad();
                        cliente.generateTicket();
                        if(cliente.getAprovado()){
                            System.out.println("El ticket generado fue aceptado");
                            switch(cliente.getLocalidad()) {
                                case 1:{
                                    manejarVentas(localidad1, cliente);
                                    break;
                                }
                                case 2:{
                                    manejarVentas(localidad5, cliente);
                                    break;
                                }
                                case 3:{
                                    manejarVentas(localidad10, cliente);
                                    break;
                                }
                            }
                        }else{
                            System.out.println("El ticket generado no fue aceptado");
                        }
                         


                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                        System.out.println("Posiblemente no ha generado al nuevo comprador");
                    }
                    
                    break;
                }
                case 3:{
                    dispoIndividual(localidad1);
                    dispoIndividual(localidad5);
                    dispoIndividual(localidad10);
                    break;
                }
                case 4:{
                    try {
                        System.out.println("Ingrese el id de la localidad");
                        int id = myInput.nextInt();
                        switch(id){
                            case 1:{
                                dispoIndividual(localidad1);
                                break;
                            }
                            case 5:{
                                dispoIndividual(localidad5);
                                break;
                            }
                            case 10:{
                                dispoIndividual(localidad10);
                                break;
                            }
                        }

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case 5:{
                    int total = localidad1.getCaja() + localidad5.getCaja() + localidad10.getCaja();
                    System.out.println("La caja total es de: $" + total);
                    break;
                }
                default:{
                    finalizar = true;
                    System.out.println("Se ha finalizado el programa");
                    break;
                }
            }
        }
        myInput.close();
    }

    /**
     * Método que gestiona la venta de boletos para una localidad específica.
     * @param localidad La localidad para la que se gestionará la venta.
     * @param cliente El comprador que desea adquirir boletos.
     */
    public static void manejarVentas(Localidad localidad, Comprador cliente) {
        System.out.println("La localidad es " + localidad.getId());
        int disponibles = 20 - localidad.getVentas();
        int precio = 0;
        int add = 0;
        System.out.println("Hay " + disponibles + " disponibles");
        if (disponibles < cliente.getBoletos()) {
            System.out.println("No hay suficientes boletos disponibles, se venderán los que quedan");
            precio = disponibles * localidad.getPrecio();
            add = disponibles;
        } else {
            System.out.println("Hay tickets disponibles");
            precio = cliente.getBoletos() * localidad.getPrecio();
            add = cliente.getBoletos();
        }
        System.out.println("El precio de compra es: $"+precio);
        if (precio > cliente.getPresupuesto()) {
            System.out.println("El precio es mayor al presupuesto");
        } else {
            System.out.println("La venta se ha realizado con éxito");
            localidad.setVentas(localidad.getVentas() + add);
        }
    }


    /**
     * Método que muestra la disponibilidad individual de una localidad.
     * @param localidad La localidad de la cual se mostrará la disponibilidad.
     */
    public static void dispoIndividual(Localidad localidad){
        System.out.println("La localidad es " + localidad.getId());
        System.out.println("Con " + localidad.getVentas() + " Ventas y " + (20 - localidad.getVentas()) + " boletos disponibles");

    }

    
}
