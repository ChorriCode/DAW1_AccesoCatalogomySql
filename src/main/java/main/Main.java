package main;

import controller.Controller;
import model.Model;
import view.View;

public class Main {


	public static void main(String[] args) {
		
		
		View myView = new View();
		Controller myController = new Controller(null, myView);
		String optionSwitch = "";
		do {			
			
			myController.selectConnectionToDDBB();
			Model myModel = myController.getModel();
			myController.listDDBB(myModel);
			optionSwitch = myView.getOptionForMain();
			
			do {
				switch (optionSwitch) {
					case "Tablas":
						myController.listTables(myModel);
						optionSwitch = myView.getOptionForMain();
						break;
					case "Registros":
						myController.listDatasTable(myModel, myView.getOptionName(), "Select * from ");
						optionSwitch = myView.getOptionForMain();
						break;
				}
			} while (optionSwitch == "Tablas"  || optionSwitch == "Registros");
		} while (optionSwitch != "Salir");
		
		System.out.println("Que tenga un buen día");
		
	
	}

}

//SELECT DISTINCT TABLE_SCHEMA FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA <> 'information_schema' and TABLE_SCHEMA <> 'performance_schema' and TABLE_SCHEMA <> 'mysql'; 
//SELECT TABLE_SCHEMA, TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = "BD_EMPLEADOS"