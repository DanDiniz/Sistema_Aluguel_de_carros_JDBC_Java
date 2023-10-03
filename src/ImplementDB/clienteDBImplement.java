package ImplementDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			throw new DbException("ERROR : " + e.getMessage());
		} finally {
			DB.fechaStatment(st);
		}
		
		
	}

	@Override
	public void update(cliente cliente,String Nome) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE cliente "
					+ "SET "
					+ "Nome = ?,Email = ?,Cpf = ? "
					+ "WHERE Nome = ?");
					
			st.setString(1, cliente.getName());
			st.setString(2, cliente.getEmail());
			st.setString(3, cliente.getCpf());
			st.setString(4, Nome);
			
			st.executeUpdate();
			
		} catch(SQLException e) {
			throw new DbException("ERROR : " + e.getMessage());
		} finally {
			DB.fechaStatment(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM cliente "
					+ "WHERE Id = ?");
			
			st.setInt(1, id);
			
			st.executeUpdate();
			
		} catch(SQLException e) {
			throw new DbException("ERROR : " + e.getMessage());
		} finally {
			DB.fechaStatment(st);
		}
		
	}

	@Override
	public void deleteByName(String name) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM cliente "
					+ "WHERE Nome = ?");
			
			st.setString(1, name);
			
			st.executeUpdate();
			
		} catch(SQLException e) {
			throw new DbException("ERROR : " + e.getMessage());
		} finally {
			DB.fechaStatment(st);
		}
		
		
	}

	@Override
	public List<cliente> selectall() {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT * FROM cliente");
			
			rs = st.executeQuery();
			
			List <cliente> listaCliente = new ArrayList<>();
			
			
			while(rs.next()) {
				cliente Cliente = new cliente();
				
				Cliente.setId(rs.getInt("Id"));
				Cliente.setName(rs.getString("Nome"));
				Cliente.setEmail(rs.getString("Email"));
				Cliente.setCpf(rs.getString("Cpf"));
				
				listaCliente.add(Cliente);

			}
			
			return listaCliente;
			
		} catch(SQLException e) {
			
			throw new DbException("ERROR : " + e.getMessage());
			
		} finally {
			
			DB.fechaResultSet(rs);
			DB.fechaStatment(st);
		}
		
	}

	@Override
	public List<cliente> selectbyName(String nome) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("SELECT * FROM cliente "
					+ "WHERE Nome = ?");
			
			st.setString(1, nome);
			
			rs = st.executeQuery();
			
			List <cliente> listaCliente = new ArrayList<>();
			
			
			while(rs.next()) {
				if(rs.getString("Nome") == null) {
					
					throw new DbException("ERROR: USUÁRIO NÃO ENCONTRADO");
				
				} else {
					cliente Cliente = new cliente();
					
					Cliente.setId(rs.getInt("Id"));
					Cliente.setName(rs.getString("Nome"));
					Cliente.setEmail(rs.getString("Email"));
					Cliente.setCpf(rs.getString("Cpf"));
					
					listaCliente.add(Cliente);
				}
			}
			
			return listaCliente;
			
		} catch(SQLException e) {
			
			throw new DbException("ERROR : " + e.getMessage());
			
		} finally {
			
			DB.fechaResultSet(rs);
			DB.fechaStatment(st);
		}
	}

}

