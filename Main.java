// Segundo cuatrimestre
// Primer proyecto
// Estudiante: Luis Moreno
// Profesora: JENNY ACUÑA CHAVARRIA

// Referencias:
// Manejo de excepciones: https://www.youtube.com/watch?v=fDmuSDRSDLQ
// POO: https://www.youtube.com/watch?v=J2aXYUA1h20
// POO y Metodos: https://www.youtube.com/watch?v=oMWrJwMPd6k

package Clases;

import java.util.Scanner;

public class Main {
    
    public static void main(String [] args){
        
        // Variables 
        Scanner entradaDatos = new Scanner(System.in);
        
        boolean seguirMenu = true;
        boolean seguirRepuesto = true;
        boolean inventarioLLeno = true;
        
        int contador = 0;
        
       
        String nombre;
        String marca;
        String categoria;
        String seguir;
        
        int precioSinImpuestos;
        int decision;
        
        Inventario inventario = new Inventario();
        
        
        System.out.println("||Bienvenido a AutopartesCR||\n");
        System.out.println("A continuacion se desplegara un menu con diferentes"
                + " opciones a realizar.");
        
        while (inventarioLLeno){
            
            
            System.out.println("Digite [1] para agregar un repuesto");
            System.out.println("Digite [2] para salir del sistema.");
                 
            System.out.print("Opcion a realizar: ");
           
            decision = entradaDatos.nextInt();
            entradaDatos.nextLine();
            System.out.println("==============================");
            
            
            if (decision == 1){
                
                while(seguirRepuesto){
                    
                    // Manejo de excepciones
                    try {
                        
                    System.out.print("Ingrese el nombre del repuesto: ");
                    nombre = entradaDatos.nextLine().toLowerCase().trim();
                    if (nombre.isEmpty() || nombre.length() > 50){
                        
                        throw new IllegalArgumentException("El nombre tiene que ser de 1 a 50 caracteres.");
                    }
                    
                    System.out.print("Ingrese la marca del respuesto: ");
                    marca = entradaDatos.nextLine().toLowerCase().trim();
                    if (marca.isEmpty() || marca.length() > 20){
                        
                        throw new IllegalArgumentException("La marca tiene que ser de 1 a 20 caracteres.");
                    }
                       
                    
                    System.out.print("Ingrese la categoria del repuesto: ");
                    categoria = entradaDatos.nextLine().toLowerCase().trim();
                    if (categoria.isEmpty() || categoria.length() > 20){
                        
                        throw new IllegalArgumentException("La categoria tiene que ser de 1 a 20 caracteres.");
                        
                    }
                    
                    
                    System.out.print("Ingrese el precio del respuesto: ");
                    precioSinImpuestos = entradaDatos.nextInt();
                    entradaDatos.nextLine();
                    if(precioSinImpuestos < 0){
                        throw new IllegalArgumentException("El precio no puede ser negativo.");
                    }
                    
                    // Creacion del objeto y calculos del objeto
                    Repuesto repuesto = new Repuesto(nombre, marca, categoria,
                    precioSinImpuestos);
                    inventario.agregar(repuesto);
                    contador = contador + 1;
                    System.out.println("Repuestos anadidos: " + contador);
                    inventario.calcularSinImpuesto();
                    inventario.calcularConImpuesto();
                    
                    System.out.println("El repuesto ha sido agregado al inventario");
                    System.out.println("==============================");
                    
                    System.out.println("¿Desea ingresar más registros?");
                    System.out.println("Digite [S] para SI y [N] para NO.");
                    System.out.print("Decision: ");
                    seguir = entradaDatos.nextLine().toUpperCase();
                    System.out.println("==============================");
                    
                    if (seguir.equals("N") || contador == 20){
                        
                        System.out.println("||INVENTARIO||");
                        inventario.mostrarInventario();
                        System.out.println("==============================");
                        System.out.println("||PRECIOS TOTALES SIN IMPUESTO||");
                        System.out.println(inventario.calcularSinImpuesto());
                        System.out.println("==============================");
                        System.out.println("||PRECIOS PROMEDIO CON IMPUESTOS||");
                        System.out.println(inventario.calcularConImpuesto());
                        System.out.println("==============================");
                        System.out.println("||CATEGORIA CON PROMEDIO MAS BAJO||");
                        inventario.calcularBajo();
                        System.out.println("==============================");
                        System.out.println("||VALOR TOTAL DEL INVENTARIO||");
                        inventario.mostrarTotal();
                        System.out.println("==============================");
                        
                        if(contador == 20){
                            
                            System.out.println("INVENTARIO LLENO");
                            inventarioLLeno = false;
                        }
                        
                        
                        inventarioLLeno = false;
                        break;
                      
                    }
                    
                } catch(IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }       
                        
                }   
            } else if (decision == 2){
                
                System.out.println("Saliendo del sistema");
                inventarioLLeno = false;
                break;
                
            } 
            else {
                
                System.out.println("ERROR. OPCION NO VALIDA.");
                System.out.println("Vuelva a intentarlo.");
            }
            
                 
        
        
    }
    }
    
}
