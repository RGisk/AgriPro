
package agripro;


import basedatos.Metodos;
import login.Intro;
/**
 *
 * @author jquesadaabeijon
 */
public class AgriPro {
    
    public static void main(String[] args) {
        
        Metodos met = new Metodos();
        met.conectar();
        met.crearClientes();
        met.crearEmpresas();
        met.crearProductos();
        
        Intro ven = new Intro();
        ven.setVisible(true);
        
        
    }
    
}
