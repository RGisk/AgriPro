/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class Validacion {
    
//    Log auten = new Log();
    
    public void loguearsePrueba(String user, String pass){
        if(user.equals("admin") && pass.equals("1234")){
            Panel_Empresas panel_emp = new Panel_Empresas();
            panel_emp.setVisible(true);
//            auten.dispose();
        }else if(user.equals("user") && pass.equals("1234")){
            Panel_Usuarios panel_client = new Panel_Usuarios();
            panel_client.setVisible(true);
//            auten.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Erro o loguearse. Usuario ou contrasinal incorrectos.");
        }
    }
    
}
