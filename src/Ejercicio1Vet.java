import javax.swing.JOptionPane;

public class Ejercicio1Vet {

	public static void main(String[] args) {
		Veterinaria clientes = new Veterinaria();
		String nombreDueño;
		do {
			nombreDueño = JOptionPane.showInputDialog("Ingrese el nombre del dueño");
		} while (!clientes.ValidarNombre(nombreDueño));
		String nombreMascota;
		do {
			nombreMascota = JOptionPane.showInputDialog("Ingrese el nombre del animal");
		} while (!clientes.ValidarNombre(nombreMascota));
		String motivo = JOptionPane.showInputDialog("Ingrese el motivo de su consulta");
		
		String[] menu = {"Esta todo bien","Necesita venir dentro de poco"};
		int estado= JOptionPane.showOptionDialog(null, "Como se encuentra",null,0,0,null, menu, menu[0]);
		int vacunas= JOptionPane.showOptionDialog(null, "Como estan sus vacunas?",null,0,0,null, menu, menu[0]);
		JOptionPane.showMessageDialog(null, clientes);

	}

}
