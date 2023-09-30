package entities;

public class veiculo {
	
	private Integer id;
	private Integer marca;
    private String modelo;
    private Double kilometragem;
    
	public veiculo(Integer id, Integer marca, String modelo, Double kilometragem) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.kilometragem = kilometragem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMarca() {
		return marca;
	}

	public void setMarca(Integer marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Double kilometragem) {
		this.kilometragem = kilometragem;
	}
    
    

}
