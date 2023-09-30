package InterfacesDB;

import java.util.List;
import entities.vendendor;

public interface vendendorDB {
	
	void insert(vendendor vendendor);
	void update(vendendor vendendor);
	void deleteById(Integer id);
	void deleteByName(String name);
	List<vendendor> selectall();
	void selectByName(String name);
	
}
