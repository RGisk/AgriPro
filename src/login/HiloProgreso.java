/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Vinyard82
 */
public class HiloProgreso extends Thread {

    JProgressBar barra;
    private static int retraso = 100;

    public HiloProgreso(JProgressBar barra) {
        this.barra = barra;
    }

    @Override
    public void run() {
        int minimo = barra.getMinimum();
        int maximo = barra.getMaximum();

        Runnable ejecutor = new Runnable() {
            @Override
            public void run() {
                int valorActual = barra.getValue();
                barra.setValue(valorActual + 1);
            }
        };

        for (int i = minimo; i < maximo; i++) {
            try {
                EventQueue.invokeAndWait(ejecutor);
                Thread.sleep(retraso);
            } catch (InterruptedException ex) {
            } catch (InvocationTargetException ex) {
            }
        }
    }

}
