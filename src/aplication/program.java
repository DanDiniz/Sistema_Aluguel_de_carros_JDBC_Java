package aplication;

import java.sql.Connection;

import DataBaseConfig.DB;

public class program {
	public static void main(String args[]) {
	
		Connection conn = DB.conectando();
		
	}
}
