package Ejercicio2;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Biblioteca {
	private String nombreLibro;
	private String autor;
	private LocalDate lanzamiento;
	private boolean disponibilidad;
	private LocalDate estado;
	private String nombrePersona;
	private String dni;
	
	public Biblioteca(String nombreLibro, boolean disponibilidad, LocalDate estado, String nombrePersona, String dni) {
		this.nombreLibro=nombreLibro;
		this.disponibilidad=disponibilidad;
		this.estado=estado;
		this.nombrePersona=nombrePersona;
		this.dni=dni;
	}
	
	public Biblioteca() {
		this.nombreLibro="";
		this.disponibilidad=true;
		this.estado=LocalDate.now();
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
	}
	
	
	
}
