package aplication;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import DataBaseConfig.DB;
import InterfacesDB.clienteDB;
import InterfacesDB.connectDB;
import entities.cliente;

public class program {
	public static void main(String args[]) {
	
		Connection conn = DB.conectando();
		
		clienteDB clienteDataBase = connectDB.conectandoCliente(); 
				
		
		//TESTANDO UPDATE
		/*
		System.out.println("TESTE 1 UPDATE");
		
		cliente Cliente = new cliente(null,"João","João@gmail.com","458.791.246.30"); 
		clienteDataBase.update(Cliente, "Manoel gomes blue pen");
		System.out.println("UPDATE COMPLETO");
		*/
		
		//TESTANDO DELETE
		/*
		System.out.println("TESTE 2 DELETE");
		clienteDataBase.deleteById(7);
		System.out.println("DELETE COMPLETO");
		*/
		
		/*
		System.out.println("TESTE 3 DELETE");
		clienteDataBase.deleteByName("João");
		System.out.println("DELETE COMPLETO");
		*/
		
		/*
		System.out.println("TESTE 4 SELECTALL");
		List<cliente> ListaCliente = clienteDataBase.selectall();
		
		for(cliente c : ListaCliente) {
			System.out.println(c);
		}
		*/
		
		System.out.println("TESTE 5 SELEC BY NAME");
		System.out.println(clienteDataBase.selectbyName("motta marcos"));
		
		//
		
	
	}
}
