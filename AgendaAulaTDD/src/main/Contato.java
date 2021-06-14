package main;

import javax.management.InvalidAttributeValueException;

public class Contato {
	private String nome;
	private int idade;
	private String telefone;
	
	public String getNome() {
		return nome;
	}
	public boolean setNome(String nome) {
		if( nome != "" && !nome.isEmpty()) {
			this.nome = nome;
			return true;
		}
		return false;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		if (idade >= 0)
			this.idade = idade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) throws InvalidAttributeValueException {
		if (telefone.length() < 11)
			throw new InvalidAttributeValueException();
		this.telefone = telefone;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
            return true;
        }
		
		if (!(o instanceof Contato)) {
            return false;
        }
		
		Contato c = (Contato) o;
		
		return telefone.equals(c.telefone);		
		
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " :: Idade: " + this.idade + " :: Telefone: " + this.telefone + "\n";
	}
	
	
}
