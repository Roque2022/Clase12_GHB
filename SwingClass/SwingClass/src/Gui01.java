import javax.swing.*;
import java.awt.*;

public class Gui01 extends JFrame {
	private Container panel;
	private JButton miboton;

	public Gui01() {
		super("Ejemplo 01 con botón");
// Configurar componentes ;
		miboton = new JButton("Aceptar"); 
		panel = getContentPane();
		panel.add(miboton);

		setSize(300, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}