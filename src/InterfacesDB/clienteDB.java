package InterfacesDB;

import java.util.List;

import entities.cliente;

public interface clienteDB {
	
	void insert(cliente cliente);
	void update(cliente cliente);
	void deleteById(Integer id);
	void deleteByName(String name);
	List<cliente> selectall();
	void selectbyName();
}
