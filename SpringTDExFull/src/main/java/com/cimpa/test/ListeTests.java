package com.cimpa.test;

import com.cimpa.controller.EmployeController;
import com.cimpa.model.Employe;

public class ListeTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Employe e1 = new Employe();
		EmployeController empCont = new EmployeController();
		//e1.toString();
		empCont.listerEmp().toString();
		

	}

}
