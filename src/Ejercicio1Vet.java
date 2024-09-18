import javax.swing.JOptionPane;

public class Ejercicio1Vet {

	public static void main(String[] args) {
		Veterinaria clientes = new Veterinaria();
		String[] menu = {"Ingrese cliente nuevo","Revise clientes anteriores", "Salir"};
		String eleccion;
		do {
			eleccion = (String)JOptionPane.showInputDialog(null, "Que quiere hacer?", null, 0, null, menu, menu[0]);
			switch (eleccion) {
			case "Ingrese cliente nuevo":
				clientes.agregarClientes();
				break;
				
			case "Revise clientes anteriores":
				JOptionPane.showMessageDialog(null, clientes.getClientes());
			break;
			
			case "Salir":
				JOptionPane.showMessageDialog(null, "Saliendo...");
			break;
			}
		} while (!eleccion.equals("Salir"));
		
		

	}

}
