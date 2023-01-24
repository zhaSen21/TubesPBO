/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Views;

import javax.swing.SwingUtilities;

/**
 *
 * @author LENOVO
 */
public class runApp {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Login form = new Login();
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });
    }
}
