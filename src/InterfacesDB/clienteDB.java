package InterfacesDB;

import java.util.List;

import entities.cliente;

public interface clienteDB {
	
	void insert(cliente cliente);
	void update(cliente cliente,String Nome);
	void deleteById(Integer id);
	void deleteByName(String name);
	List<cliente> selectall();
	List<cliente> selectbyName(String nome);
}
