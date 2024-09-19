package Ejercicio1;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Ejercicio2.Main;

public class Ejercicio1Vet {

	public static void main(String[] args) {
		Veterinaria clientes = new Veterinaria();
		String[] menu = {"Sacar turno", "Dia de la consulta", "Revise clientes anteriores" , "Salir"};
		String eleccion;
		do {
			eleccion = (String)JOptionPane.showInputDialog(null, "Que quiere hacer?", null, 0, null, menu, menu[0]);
			switch (eleccion) {
			case "Sacar turno":
				clientes.sacarTurno();
				break;
			
			case "Dia de la consulta":
				clientes.diaConsulta();
				break;

			case "Revise clientes anteriores":
				JOptionPane.showMessageDialog(null, clientes.getClientes());
			break;
			
			case "Salir":
				JOptionPane.showMessageDialog(null, "Saliendo...", null, JOptionPane.DEFAULT_OPTION, new ImageIcon(Main.class.getResource("../img/salir.gif")));

			break;
			}
		} while (!eleccion.equals("Salir"));
		
		

	}

}
