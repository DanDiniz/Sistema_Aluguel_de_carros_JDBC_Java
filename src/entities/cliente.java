package entities;

public class cliente {
	
	private Integer id;
	private String name;
	private String email;
	private String cpf;
	
	public cliente() {

	}
	
	public cliente(Integer id, String name, String email, String cpf) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "cliente [id=" + id + ", name=" + name + ", email=" + email + ", cpf=" + cpf + "]";
	}
	
	
	
}
