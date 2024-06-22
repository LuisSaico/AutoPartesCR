
package Clases;


public class CalculadoraImpuestos {
    
    
    // Metodo para calcular precio sin impuesto
    
    public static int precioSinImpuestos (int dinero){
        
        if (dinero <= 10000){
            
            return (int) (dinero * 0.02);
            
        } else if (dinero <= 50000) {
            
            return (int) (dinero * 0.05);
            
        } else if (dinero <= 100000){
            
            return (int) (dinero * 0.10);
            
        } else {
            
            return (int) (dinero * 0.15);
        }
    }
    
    // Metodo para calcular el precio con impuesto
    public static int precioConImpuesto (int dinero){
        
        int impuesto = precioSinImpuestos(dinero);
        return dinero + impuesto;
    }
    
}
