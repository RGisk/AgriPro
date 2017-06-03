/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agripro;


import basedatos.Ventana;
import basedatos.Metodos;
import basedatos.Metodos;
import basedatos.Ventana;
import login.VentanaPrincipal;
/**
 *
 * @author jquesadaabeijon
 */
public class AgriPro {
    
    public static void main(String[] args) {
        
        VentanaPrincipal ven = new VentanaPrincipal();
        ven.setVisible(true);
        
        Metodos met = new Metodos();
        met.conectar();
        met.crearClientes();
        
        
//        Metodos met = new Metodos();
//        Ventana base = new Ventana();
//        
//        met.conectar();
//        met.crearTabla();
//        base.setVisible(true);
        
//        VentanaPrincipal principal = new VentanaPrincipal();
//        principal.setVisible(true);
    }
    
}
