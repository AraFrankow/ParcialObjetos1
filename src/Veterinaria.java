import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Veterinaria {
		private String nombreAnimal;
		private String nombreDueño;
		private LocalDate cosulta;
		private String motivo;
		private boolean estado;
		private LocalDate cosultaProxima;
		
		public Veterinaria(String nombreAnimal, String nombreDueño, LocalDate cosulta, String motivo, boolean estado, LocalDate cosultaProxima) {
			this.nombreAnimal=nombreAnimal;
			this.nombreDueño=nombreDueño;
			this.cosulta=cosulta;
			this.motivo=motivo;
			this.estado=estado;
			this.cosultaProxima=cosultaProxima;
		}
		
		public static boolean ValidarNombre(String nombre) {
			boolean numero = false;
			if (nombre.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Está vacio el nombre");
				return false;
			} else {
				for (int i = 0; i < nombre.length(); i++) {
					if (Character.isDigit(nombre.charAt(i))) {
						numero=true;
					}
				}
				if (numero==true) {
					JOptionPane.showMessageDialog(null, "No puede tener numeros un nombre");
					return false;
				} else {
					return true;
				}
			}
		}
		
		public String mostrarEstado(boolean estado) {
			if (estado==true) {
				return "Se encuentra bien";
			} else {
				return "Necesita ser revisado dentro de poco";
			}

		}
}
