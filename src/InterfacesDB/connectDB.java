package InterfacesDB;

import DataBaseConfig.DB;
import ImplementDB.clienteDBImplement;

public class connectDB {
	
	public static clienteDB conectandoCliente() {
		return new clienteDBImplement(DB.conectando());
	}

}
