package DataBaseConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null; 
	
	
	//PEGANDO INFORMAÇÕES DO BANCO DE DADOS A PARTIR DO ARQUIVO "db.properies"
	
	private static Properties pegaInformacaoBD() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties prop = new Properties();
			prop.load(fs);
			
			return prop;
			
		} catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	//CONECTANDO COM O BANCO DE DADOS
	
	public static Connection conectando() {
		if(conn == null) {
		try {
			Properties prop =  pegaInformacaoBD();
			String url = prop.getProperty("dburl"); //PEGANDO URL DO ARQUIVO
			conn = DriverManager.getConnection(url,prop);
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		}
		
		return conn;
	}
	
	public static void fechaConexao() {
		if(conn != null) {
			
			try {
				conn.close();	
			} catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	//CRIANDO METODOS AUXILIARES - PARA FECHAR STATEMENT E RESULT SET SEM PRECISAR
	//IMPLEMENTAR VARIOS TRY CATCH
	
	public static void fechaStatment(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		} 
	}
	
	
	public static void fechaResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		} 
	}
	
}
