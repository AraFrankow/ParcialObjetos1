package Ejercicio2;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		Biblioteca libro = new Biblioteca();
		String[] menu = {"Ingrese los datos del libro", "Editar los datos del libro", "Revisar los datos del libro", "Reservar el libro" , "Salir"};
		String eleccion;
		do {
			eleccion = (String)JOptionPane.showInputDialog(null, "Que quiere hacer?", null, 0, null, menu, menu[0]);
			switch (eleccion) {
			case "Ingrese los datos del libro":
				libro.crearLibro();
				break;
			
			case "Editar los datos del libro":
				break;
			
			case "Revisar los datos del libro":
				JOptionPane.showMessageDialog(null, "");
			break;
			
			case "Reservar el libro":
				JOptionPane.showMessageDialog(null, "");
				
			break;
			
			case "Salir":
				JOptionPane.showMessageDialog(null, "Saliendo...", null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("img/salir.gif")));

			break;
			}
		} while (!eleccion.equals("Salir"));

	}

}
