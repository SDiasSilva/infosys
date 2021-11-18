package model;

public class Cliente {
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private String celular;
	private String email;
	
	public Cliente(String nome, String cpf, String telefone, String celular, String email) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
	}
	
	public Cliente(int id, String nome, String cpf, String telefone, String celular, String email) {
		setId(id);
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
	}
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return this.telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return this.celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Cliente: " + getNome()+
			   "\nCPF: " + getCpf()+
			   "\nTelefone: " + getTelefone()+
			   "\nCelular: " + getCelular()+
			   "\nE-mail: " + getEmail();
	}
}
