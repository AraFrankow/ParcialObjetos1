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
		private String clientes;
		
		public Veterinaria(String nombreAnimal, String nombreDueño, LocalDate cosulta, String motivo, boolean estado, LocalDate cosultaProxima, int peso, boolean vacunas, String clientes) {
			this.nombreAnimal=nombreAnimal;
			this.nombreDueño=nombreDueño;
			this.cosulta=cosulta;
			this.motivo=motivo;
			this.estado=estado;
			this.cosultaProxima=cosultaProxima;
			this.peso=peso;
			this.vacunas=vacunas;
			this.clientes=clientes;
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
			this.clientes="";
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
		
		public void setCosultaProxima() {
			this.cosultaProxima = LocalDate.of(validarNumeros("Ingrese año"), validarNumeros("Ingrese mes"), validarNumeros("Ingrese dia"));
		}
		
		public void agregarClientes() {
			do {
				this.nombreDueño = JOptionPane.showInputDialog("Ingrese el nombre del dueño");
			} while (!ValidarNombre(nombreDueño));
			do {
				this.nombreAnimal = JOptionPane.showInputDialog("Ingrese el nombre del animal");
			} while (!ValidarNombre(nombreAnimal));
			String motivo = JOptionPane.showInputDialog("Ingrese el motivo de su consulta");
			
			String[] estadoMascota = {"Esta todo bien","Necesita venir dentro de poco"};
			int estado= JOptionPane.showOptionDialog(null, "Como se encuentra",null,0,0,null, estadoMascota, estadoMascota[0]);
			if (estado==0) {
				this.estado=true;
			} else {
				this.estado=false;
			}
			
			int vacunas= JOptionPane.showOptionDialog(null, "Como estan sus vacunas?",null,0,0,null, estadoMascota, estadoMascota[0]);
			if (vacunas==0) {
				this.vacunas=true;
			} else {
				this.vacunas=false;
			}
			
			if (this.estado==false || this.vacunas==false) {
				setCosultaProxima();
			}
			this.clientes = this.clientes + "\n Nombre del dueño: " + nombreDueño + ", nombre de la mascota: " + nombreAnimal + ", motivo de la consulta: "+ motivo + ", estado de la mascota " + mostrarEstado(this.estado) +", vacunas: "+mostrarEstado(this.vacunas) + ", proxima consulta: "+cosultaProxima;
		}
		
		public String getClientes() {
			return clientes;
		}

		@Override
		public String toString() {
			return "Veterinaria [nombreAnimal=" + nombreAnimal + ", nombreDueño=" + nombreDueño + ", cosulta=" + cosulta
					+ ", motivo=" + motivo + ", estado=" + mostrarEstado(estado) + ", cosultaProxima=" + cosultaProxima + ", peso="
					+ peso + ", vacunas=" + mostrarEstado(vacunas) + "]";
		}
}
