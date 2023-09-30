package ImplementDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DataBaseConfig.DB;
import DataBaseConfig.DbException;
import InterfacesDB.clienteDB;
import entities.cliente;

public class clienteDBImplement implements clienteDB{

	private Connection conn;
	
	public clienteDBImplement(Connection conectando) {
		this.conn = conectando;
	}

	@Override
	public void insert(cliente cliente) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement("INSERT INTO cliente"
					+ "(Nome,Email,Cpf)"
					+ "VALUES"
					+ "(?,?,?)",Statement.RETURN_GENERATED_KEYS);
					
					st.setString(1, cliente.getName());
					st.setString(2, cliente.getEmail());
					st.setString(3, cliente.getCpf());
					
					int rowsAffected = st.executeUpdate();
					
					//PEGANDO A NOVA CHAVE PRIMARIA GERADA PELO INSERT
					//E ADICIONADO AO ATRIBUTO ID DA CLASSE CLIENTE
					
					if(rowsAffected > 0) {
						ResultSet rs = st.getGeneratedKeys();
						if(rs.next()) {
							int id = rs.getInt(1);
							cliente.setId(id);
						}
						DB.fechaResultSet(rs);
					} else {
						throw new DbException("ERROR : NENHUMA LINHA FOI AFETADA!!");
					}
			
		} catch(SQLException e) {
			System.out.println("ERROR : "+ e.getMessage());
		} finally {
			DB.fechaStatment(st);
		}
		
		
	}

	@Override
	public void update(cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<cliente> selectall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectbyName() {
		// TODO Auto-generated method stub
		
	}

}
