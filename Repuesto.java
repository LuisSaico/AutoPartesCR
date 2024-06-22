
package Clases;


public class Repuesto {
    
    // Atributos de la clase
    
    private String nombre;
    private String marca;
    private String categoria;

    private int precioSinImpuestos;
    private int impuesto;
    private int precioConImpuestos;
    
    // Constructor de la clase
    
    public Repuesto(String _nombre, String _marca, String _categoria,
            int _precioSinImpuestos){
        
        nombre = _nombre;
        marca = _marca;
        categoria = _categoria;
        precioSinImpuestos = _precioSinImpuestos;
        
        // Asignamos el impuesto y el precio con impuesto
        
        impuesto = CalculadoraImpuestos.precioSinImpuestos(_precioSinImpuestos);
        precioConImpuestos = CalculadoraImpuestos.precioConImpuesto(_precioSinImpuestos);             
    }
    
    // Set y Get de nombre
    
    public void setNombre (String _nombre){
        
        if (nombre.length() > 50){
            throw new IllegalArgumentException("El nombre sobre pasa 50 caracateres.");
        }
        
        nombre = _nombre;
    }
    
    public String getNombre(){
        
        return nombre;
    }
    
    // Set y Get de Marca
    
    public void setMarca (String _marca){
        
        if (nombre.length() > 20){
            throw new IllegalArgumentException("La marca sobre pasa 20 caracteres.");
        }
        
        marca = _marca;
    }
    
    public String getMarca(){
        
        return marca;
    }
    
    // Set Y Get de Categoria
    
    public void setCategoria (String _categoria){
        
        if (categoria.length() > 20){
            
            throw new IllegalArgumentException("La categoria sobre pasa 20 caracteres."); 
        }
        
        categoria = _categoria;
    }
    
    public String getCategoria(){
        
        return categoria;
    }
    
    // Set y Get precio sin impuestos
    
    public void setPrecioSinImpuestos (int _precioSinImpuestos){
        
        if (precioSinImpuestos < 0 ){
            throw new IllegalArgumentException("El numero no puede ser negativo.");
        }
        
        precioSinImpuestos = _precioSinImpuestos;
    }
    
    public int getPrecioSinImpuestos(){
        
        return precioSinImpuestos;
    }
    
    // Get de impuesto
 
    public int getImpuesto(){
        
        return impuesto;
    }
    
    // Get de Precio con impuestos
    
    public int getPrecioConImpuestos(){
        
        return precioConImpuestos;
    }
         
}
