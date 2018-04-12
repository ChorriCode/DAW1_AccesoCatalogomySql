package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.ConnectionDB;
import model.Model;
import view.View;

public class Controller {
	
	private Model model;
	private View view;

	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
	}
	
	public void selectConnectionToDDBB() {
		ConnectionDB myConnection = new ConnectionDB("jdbc:mysql://localhost:3306/", 
				"information_schema",
				"com.mysql.jdbc.Driver", 
				"root", 
				"Gratis007");
		this.model = new Model(myConnection);
		this.model.setConnDB(myConnection);
		model.connectToBD();
	}

	public void listDDBB(Model myModel){
		ArrayList<String> resultado = new ArrayList<String>();
		ResultSet datos = myModel.readDDBBNames();

		try {
			while (datos.next()) {
				if (datos.getRow() == 0) break;	
				resultado.add(datos.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		view.mostrarMenuBBDD(resultado, "Selecciona Base de Datos");
		System.out.println(view.getOption());
		System.out.println(view.getDatoSeleccionado());
	}
	
	public void listTables(Model myModel){
		ArrayList<String> resultado = new ArrayList<String>();
		ResultSet datos = myModel.readTableNames();

		try {
			while (datos.next()) {
				if (datos.getRow() == 0) break;	
				resultado.add(datos.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		view.mostrarMenuBBDD(resultado, "Selecciona Tabla de la Base de Datos" + view.getDatoSeleccionado());
		System.out.println(view.getOption());
		System.out.println(view.getDatoSeleccionado());
	}
	
	public ArrayList<String> listadoTables(Model myModel, String tabla, String sql){
		ArrayList<String> resultado = new ArrayList<String>();
		myModel.readOnBD(tabla, sql);
		
		
		return resultado;
		
	}
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}	

	
}
