package InterfacesDB;

import java.util.List;
import entities.emprestimo;

public interface emprestimoDB {
	
	void insert(emprestimo emprestim);
	void update(emprestimo emprestim);
	void deleteById(Integer id);
	List<emprestimo> deleteByCliente(String name);
	List<emprestimo> selectByCliente(String name);
	List<emprestimo> selectall();

}
