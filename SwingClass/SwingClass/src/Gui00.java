
import javax.swing.*;
public class Gui00 {
// Constantes y componentes (objetos)
public Gui00(){
JFrame frame = new JFrame("Ejemplo 00");
// Configurar componentes
// y añadirlos al panel del frame

frame.pack();
frame.setBounds(600, 450, 350, 350); 
frame.setTitle("Primer Pantalla");
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}