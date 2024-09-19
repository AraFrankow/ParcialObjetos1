package Ejercicio1;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Veterinaria {
		private String nombreAnimal;
		private String nombreDueño;
		private LocalDate consulta;
		private String motivo;
		private boolean estado;
		private LocalDate consultaProxima;
		private String peso;
		private boolean vacunas;
		private String clientes;
		
		public Veterinaria(String nombreAnimal, String nombreDueño, LocalDate consulta, String motivo, boolean estado, LocalDate consultaProxima, String peso, boolean vacunas, String clientes) {
			this.nombreAnimal=nombreAnimal;
			this.nombreDueño=nombreDueño;
			this.consulta=consulta;
			this.motivo=motivo;
			this.estado=estado;
			this.consultaProxima=consultaProxima;
			this.peso=peso;
			this.vacunas=vacunas;
			this.clientes=clientes;
		}
		public Veterinaria() {
			this.nombreAnimal="sin nombre";
			this.nombreDueño="sin nombre";
			this.consulta=LocalDate.now();
			this.motivo="sin motivo";
			this.estado=false;
			this.consultaProxima=LocalDate.now();
			this.peso="";
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
			this.consultaProxima = LocalDate.of(validarNumeros("Ingrese año"), validarNumeros("Ingrese mes"), validarNumeros("Ingrese dia"));
			JOptionPane.showMessageDialog(null, "Agendando proximo turno...");
		}
		
		public void agregarClientes() {
			do {
				this.nombreDueño = JOptionPane.showInputDialog("Ingrese el nombre del dueño");
			} while (!ValidarNombre(nombreDueño));
			do {
				this.nombreAnimal = JOptionPane.showInputDialog("Ingrese el nombre del animal");
			} while (!ValidarNombre(nombreAnimal));
			do {
				this.motivo = JOptionPane.showInputDialog("Ingrese el motivo de su consulta");
			} while (!ValidarNombre(motivo));
			do {
				this.peso= JOptionPane.showInputDialog("Ingrese el peso del animal");
			} while (!ValidarPeso(peso));
			
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
			if (this.consultaProxima.isBefore(LocalDate.now())) {
				do {
					JOptionPane.showMessageDialog(null, "Hubo un error con la fecha ingresada, vuelva a ingresarla");
					setCosultaProxima();
				} while (this.consultaProxima.isBefore(LocalDate.now()));
			}
			this.clientes = this.clientes + "\n Fecha de la consulta: "+consulta+", nombre del dueño: " + nombreDueño + ", nombre de la mascota: " + nombreAnimal + ", motivo de la consulta: "+ motivo + ", peso de la mascota: "+ peso +"kg , estado de la mascota: " + mostrarEstado(this.estado) +", vacunas: "+mostrarEstado(this.vacunas) + ", proxima consulta: "+consultaProxima;
		}
		
		
		public static boolean ValidarPeso(String peso) {
			boolean letra = false;
			if (peso.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No puede estar vacio");
				return false;
			} else {
				for (int i = 0; i < peso.length(); i++) {
					if (Character.isLetter(peso.charAt(i))) {
						letra=true;
					}
				}
				if (letra==true) {
					JOptionPane.showMessageDialog(null, "No puede tener letras el peso");
					return false;
				} else {
					return true;
				}
			}	
		}	
		
		// SET Y GET
		public String getClientes() {
			return clientes;
		}
		public boolean getVacunas() {
			return vacunas;
		}
		public String getPeso() {
			return peso;
		}
		public LocalDate getConsultaProxima() {
			return consultaProxima;
		}
		public boolean getEstado() {
			return estado;
		}
		public String getMotivo() {
			return motivo;
		}
		public LocalDate getConsulta() {
			return consulta;
		}
		public String getNombreDueño() {
			return nombreDueño;
		}
		public String getNombreAnimal() {
			return nombreAnimal;
		}
		
		
		public void setClientes(String clientes) {
			this.clientes=clientes;
		}
		public void setVacunas(boolean vacunas) {
			this.vacunas=vacunas;
		}
		public void setPeso(String peso) {
			this.peso=peso;
		}
		public void setCosultaProxima1() {
			this.consultaProxima = LocalDate.of(validarNumeros("Ingrese año"), validarNumeros("Ingrese mes"), validarNumeros("Ingrese dia"));
			JOptionPane.showMessageDialog(null, "Agendando proximo turno...");
		}
		public void setEstado(boolean estado) {
			this.estado=estado;
		}
		public void setMotivo(String motivo) {
			this.motivo=motivo;
		}
		public void setConsulta(LocalDate consulta) {
			this.consulta=consulta;
		}
		public void setNombreDueño(String nombreDueño) {
			this.nombreDueño=nombreDueño;
		}
		public void setNombreAnimal(String nombreAnimal) {
			this.nombreAnimal=nombreAnimal;
		}

		@Override
		public String toString() {
			return "Veterinaria [nombreAnimal=" + nombreAnimal + ", nombreDueño=" + nombreDueño + ", consulta=" + consulta
					+ ", motivo=" + motivo + ", estado=" + mostrarEstado(estado) + ", cosultaProxima=" + consultaProxima + ", peso="
					+ peso + ", vacunas=" + mostrarEstado(vacunas) + "]";
		}
}
