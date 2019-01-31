/*
 * Procesamento Digital de Imagens
 * 25/04/2017
 * 
 * Luiz Claudio Morais Caldeirão
 * RA: 131255061
 */
package Main;

import UI.MainUI;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * //
 *
 *
 * @author Caldeirão
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            MainUI window = new MainUI();
            window.setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("Error setting native LAF: " + e);
        }
    }
}
