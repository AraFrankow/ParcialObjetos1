package Ejercicio2;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Biblioteca {
	private String nombreLibro;
	private String autor;
	private LocalDate lanzamiento;
	private boolean disponibilidad;
	private LocalDate regreso;
	private String nombrePersona;
	private String dni;
	
	public Biblioteca(String nombreLibro, boolean disponibilidad, LocalDate regreso, String nombrePersona, String dni) {
		this.nombreLibro=nombreLibro;
		this.disponibilidad=disponibilidad;
		this.regreso=regreso;
		this.nombrePersona=nombrePersona;
		this.dni=dni;
	}
	
	public Biblioteca() {
		this.nombreLibro="";
		this.disponibilidad=true;
		this.regreso=LocalDate.now();
		this.nombrePersona="";
		this.dni="";
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
	
	public void crearLibro() {
		if (nombreLibro.isEmpty()) {
			do {
				this.nombreLibro = JOptionPane.showInputDialog("Ingrese el nombre del libro");
			} while (!ValidarNombre(nombreLibro));
			do {
				this.autor = JOptionPane.showInputDialog("Ingrese el nombre del autor");
			} while (!ValidarNombre(autor));
			this.lanzamiento = LocalDate.of(validarNumeros("Ingrese año de lanzamiento"), validarNumeros("Ingrese mes de lanzamiento"), validarNumeros("Ingrese día de lanzamiento"));
			if (this.lanzamiento.isAfter(LocalDate.now())) {
				do {
					JOptionPane.showMessageDialog(null, "Hubo un error con la fecha ingresada, vuelva a ingresarla");
					this.lanzamiento = LocalDate.of(validarNumeros("Ingrese año"), validarNumeros("Ingrese mes"), validarNumeros("Ingrese día"));
				} while (this.lanzamiento.isAfter(LocalDate.now()));
			}
		} else {
			JOptionPane.showMessageDialog(null, "Ya registraste un libro");
		}
	}
	
	public String getNombreLibro() {
		return nombreLibro;
	}
	
	public String getAutor() {
		return nombreLibro;
	}
	
	public String getLanzamiento() {
		return nombreLibro;
	}
	
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro=nombreLibro;
	}
	
	public void setAutor(String autor) {
		this.autor=autor;
	}
	
	public void setLanzamiento(LocalDate lanzamiento) {
		this.lanzamiento=lanzamiento;
	}
	public void setDisponibilidad(int i) {
		if (i==0) {
			this.disponibilidad=true;
			this.regreso=LocalDate.now();
		} else {
			this.disponibilidad=false;
		}
		
	}
	
	public boolean getDisponibilidad() {
		return disponibilidad;
	}
	
	public String mostrarDisponibilidad(boolean disponibilidad) {
		if (disponibilidad==true) {
			return "Disponible";
		} else {
			return "Vuelva a preguntar pronto";
		}
	}
	
	public static boolean ValidarDni(String dni) {
		boolean letra = false;
		if (dni.length()<7 || dni.length()>8) {
			return false;
		} else {
			for (int i = 0; i < dni.length(); i++) {
				if (Character.isLetter(dni.charAt(i))) {
					letra=true;
				}
			}
			if (letra==true) {
				JOptionPane.showMessageDialog(null, "No puede tener letras el DNI");
				return false;
			} else {
				return true;
			}
		}	
	}
	
	public void reseva() {
		if (this.disponibilidad==true) {
			do {
				this.nombrePersona = JOptionPane.showInputDialog("Ingrese el nombre del usuario");
			} while (!ValidarNombre(nombrePersona));
			do {
				this.dni = JOptionPane.showInputDialog("Ingrese el dni de: "+nombrePersona);
			} while (!ValidarDni(dni));
			this.regreso = regreso.plusDays(3);
			disponibilidad=false;
		} else {
			JOptionPane.showMessageDialog(null, "El libro ya fue reservado");
		}
		
	}

	@Override
	public String toString() {
		return "Biblioteca Lectores Felices: \n Nombre del libro: " + nombreLibro + "\n Autor: " + autor + "\n Lanzamiento: " + lanzamiento
				+ "\n Disponibilidad: " + mostrarDisponibilidad(disponibilidad) + "\n Regreso: " + regreso + "\n Nombre de la persona: " + nombrePersona
				+ "\n Dni: " + dni;
	}
	
	
	
	
	
}
