import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Veterinaria {
		private String nombreAnimal;
		private String nombreDueño;
		private LocalDate cosulta;
		private String motivo;
		private boolean estado;
		private LocalDate cosultaProxima;
		private double peso;
		private boolean vacunas;
		
		public Veterinaria(String nombreAnimal, String nombreDueño, LocalDate cosulta, String motivo, boolean estado, LocalDate cosultaProxima, int peso, boolean vacunas) {
			this.nombreAnimal=nombreAnimal;
			this.nombreDueño=nombreDueño;
			this.cosulta=cosulta;
			this.motivo=motivo;
			this.estado=estado;
			this.cosultaProxima=cosultaProxima;
			this.peso=peso;
			this.vacunas=vacunas;
		}
		public Veterinaria() {
			this.nombreAnimal="sin nombre";
			this.nombreDueño="sin nombre";
			this.cosulta=LocalDate.now();
			this.motivo="sin motivo";
			this.estado=false;
			this.cosultaProxima=LocalDate.now();
			this.peso=0;
			this.vacunas=false;
		}
		
		public boolean ValidarNombre(String nombre) {
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
				return "Esta todo bien";
			} else {
				return "Necesita venir dentro de poco";
			}

		}
		public int validarNumeros(String numero) {
			boolean numer ;
			String num ="" ;
			do {
				numer =true;
				num = JOptionPane.showInputDialog(numero);
				while (num.isEmpty()) {
					num = JOptionPane.showInputDialog(numero);
				}
				for (int i = 0; i < num.length(); i++) {
					if (!Character.isDigit(num.charAt(i))) {
						numer = false;
						break;
					}
				}
			} while (!numer);
			
			return Integer.parseInt(num);
		}

		@Override
		public String toString() {
			return "Veterinaria [nombreAnimal=" + nombreAnimal + ", nombreDueño=" + nombreDueño + ", cosulta=" + cosulta
					+ ", motivo=" + motivo + ", estado=" + mostrarEstado(estado) + ", cosultaProxima=" + cosultaProxima + ", peso="
					+ peso + ", vacunas=" + mostrarEstado(vacunas) + "]";
		}
}
