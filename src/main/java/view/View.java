package view;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
	
	private String option;
	private String datoSeleccionado;
	Scanner sc; 
	
	public View() {
		this.sc = new Scanner(System.in);
	}
	
	//Muestra en un menú la consulta tanto si es una base de datos como si es una tabla
	//para poder seleccionar lo que sea segun el caso.
	//le paso por parámetro el arraylist con la cosulta que se haya hecho previamente
	//y un mensaje para que salga por pantalla si los datos corresponden a una BBDD o a una tabla
	public void mostrarMenuBBDD(ArrayList<String> listadoConsulta, String mensaje) {
		
		int optionInt;
		
		System.out.println("Selecciona " + mensaje);
		for (int i = 0; i < listadoConsulta.size(); i++) {		
			System.out.println(i + ") " + listadoConsulta.get(i));		
		}
		System.out.println((listadoConsulta.size()+ 1) + ") SALIR");
		
		do {
			this.option = this.sc.nextLine();
			try {
				optionInt = Integer.parseInt(option);
			} catch (Exception e) {
				//En caso de que teclemos letras dará un error, asignamos el valor cero para que nos vuelva a preguntar
				//por un numero entre 1 y 5
				optionInt = 0;
			}
			if (optionInt < 0 || optionInt > listadoConsulta.size()+ 1) System.out.println("Seleccione del 0 al " + (listadoConsulta.size() + 1));
		} while (optionInt < 0 || optionInt > listadoConsulta.size()+ 1);
		
		this.datoSeleccionado = listadoConsulta.get(optionInt);
		
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getDatoSeleccionado() {
		return datoSeleccionado;
	}

	public void setDatoSeleccionado(String datoSeleccionado) {
		this.datoSeleccionado = datoSeleccionado;
	}
	
	
}
