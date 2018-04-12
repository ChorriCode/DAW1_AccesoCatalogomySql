package main;

import controller.Controller;
import model.Model;
import view.View;

public class Main {


	public static void main(String[] args) {
		View myView = new View();	
		Controller myController = new Controller(null, myView);
		myController.selectConnectionToDDBB();
		Model myModel = myController.getModel();
		myController.listDDBB(myModel);
		myController.listTables(myModel);
		//Menú eleccion tipo base de datos
		//myView.menuBBDD();
		

		
	
	}

}

//SELECT DISTINCT TABLE_SCHEMA FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA <> 'information_schema' and TABLE_SCHEMA <> 'performance_schema' and TABLE_SCHEMA <> 'mysql'; 
//SELECT TABLE_SCHEMA, TABLE_NAME FROM TABLES WHERE TABLE_SCHEMA = "BD_EMPLEADOS"