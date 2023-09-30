package aplication;

import java.sql.Connection;

import DataBaseConfig.DB;
import ImplementDB.clienteDBImplement;
import InterfacesDB.clienteDB;
import InterfacesDB.connectDB;
import entities.cliente;

public class program {
	public static void main(String args[]) {
	
		Connection conn = DB.conectando();
		
	}
}
