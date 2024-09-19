package Ejercicio2;

import java.time.LocalDate;

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
				String[] cambios = {"El nombre del libro", "Al autor del libro", "El año de lanzamiento", "Salir"};
				String cambiar = (String)JOptionPane.showInputDialog(null, "Que quiere cambiar?", null, 0, null, cambios, cambios[0]);
				switch (cambiar) {
				case "El nombre del libro":
					libro.setNombreLibro(JOptionPane.showInputDialog("Ingrese el nuevo nombre del libro"));
					break;

				case "Al autor del libro":
					libro.setAutor(JOptionPane.showInputDialog("Ingrese el nuevo autor del libro"));
					break;
					
				case "El año de lanzamiento":
					libro.setLanzamiento(LocalDate.of(libro.validarNumeros("Ingrese año"), libro.validarNumeros("Ingrese mes"), libro.validarNumeros("Ingrese día")));
					break;
					
				case "Salir":
					JOptionPane.showMessageDialog(null, "Volviendo al menu principal...", null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("../img/salir.gif")));
					break;
				}
				
				break;
			
			case "Revisar los datos del libro":
				JOptionPane.showMessageDialog(null, libro);
			break;
			
			case "Reservar el libro":
				libro.reseva();
				
			break;
			
			case "Salir":
				JOptionPane.showMessageDialog(null, "Saliendo...", null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("../img/salir.gif")));

			break;
			}
		} while (!eleccion.equals("Salir"));

	}

}
