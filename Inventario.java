
package Clases;

import java.util.Vector;

public class Inventario {
    
    int totalPromAuto = 0;
    int totalPromMoto = 0;
    int totalPromCamion = 0;
            
    // Asignacion de los objetos de la clase Inventario
    private Vector<Repuesto> repuestos;
    
    // Asignacion de cantidad del vector
    
    public Inventario(){
        
        repuestos = new Vector(20);
    }
    
    // Metodo para agregar los repuestos al invtentario
    public void agregar(Repuesto repuesto){
        repuestos.add(repuesto);
    }
    
    // Metodo que muestra la informacion de los objetos del inventario
    public void mostrarInventario(){
        
        for (Repuesto repuesto: repuestos){
            
            System.out.println("Nombre del repuesto: "+repuesto.getNombre());
            System.out.println("Marca del repuesto: "+repuesto.getMarca());
            System.out.println("Categoria del repuesto: "+repuesto.getCategoria());
            System.out.println("Precio del repuesto: "+repuesto.getPrecioSinImpuestos());
            System.out.println("\n");
        }
    }
    
    // Metodo que muestre el total del inventario
    public void mostrarTotal(){
        
        int total = 0;
        
        for (Repuesto repuesto: repuestos){
            
            total = total + repuesto.getPrecioSinImpuestos();
            
        }
        
        System.out.print("El total del inventario es: "+total + "\n");
    }
    
    // Metodo que muestra el total por categoria sin impuestos
    public String calcularSinImpuesto(){
        
        int total_auto = 0;
        int total_moto = 0;
        int total_camion = 0;
        
        for (Repuesto repuesto: repuestos){
            
            if (repuesto.getCategoria().equals("automovil")){
                
                total_auto = total_auto + repuesto.getPrecioSinImpuestos();
               
                
            } else if (repuesto.getCategoria().equals("motocicleta")) {
                
                total_moto = total_moto + repuesto.getPrecioSinImpuestos();
             
                
            } else if (repuesto.getCategoria().equals("camion")){
                
                total_camion = total_camion + repuesto.getPrecioSinImpuestos();
              
            }
        
        }
        return "Total de precio en automoviles: "+ total_auto + "\n" 
                + "Total de precio en motocicletas: "+total_moto + "\n"
                + "Total de precio en camiones: "+total_camion + "\n";
                
    }
    
    // Metodo que calcula el precio con impuesto
    public String calcularConImpuesto(){
        
        int totalAuto = 0;
        int totalMoto = 0;
        int totalCamion = 0;
        
        int autoProm = 0;
        int motoProm = 0;
        int camionProm = 0;
        
        for (Repuesto repuesto : repuestos){
            
            if (repuesto.getCategoria().equals("automovil")){
                
                totalAuto = totalAuto + repuesto.getPrecioConImpuestos();
                autoProm = autoProm + 1;
                  
            } else if (repuesto.getCategoria().equals("motocicleta")) {
                
                totalMoto = totalMoto + repuesto.getPrecioConImpuestos();
                motoProm = motoProm + 1;
                
            } else if (repuesto.getCategoria().equals("camion")){
                
                totalCamion = totalCamion + repuesto.getPrecioConImpuestos();
                camionProm = camionProm + 1;
                
            }
            
        }
        
        totalPromAuto = (autoProm > 0) ? (int) totalAuto / autoProm : 0;
        totalPromMoto = (motoProm > 0) ? (int) totalMoto / motoProm : 0;
        totalPromCamion = (camionProm > 0) ? (int) totalCamion / camionProm : 0;
        
        return "El promedio de precios con impuestos en autos es: " + totalPromAuto + "\n" +
                "El promedio de precios con impuestos en motos es: " + totalPromMoto + "\n" +
                "El promedio de precios con impuestos en camiones es: " + totalPromCamion + "\n";
        
        
    }
    
    // Metodo para mostrar el promedio mas bajo
    public void calcularBajo(){
        
        if(totalPromAuto < totalPromMoto && totalPromAuto < totalPromCamion){
            
            System.out.print("El promedio mas bajo lo tiene autos con: "+totalPromAuto + "\n");
            
        } else if (totalPromMoto < totalPromAuto && totalPromMoto < totalPromCamion){
            
            System.out.print("El promedio mas bajo lo tiene motos con: "+totalPromMoto + "\n");
            
        } else if (totalPromCamion < totalPromAuto && totalPromCamion < totalPromMoto){
            
            System.out.println("El promedio mas bajo lo tiene camiones con: "+totalPromCamion + "\n");
        }
    }
           
}
