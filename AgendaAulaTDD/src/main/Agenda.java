package main;

import java.util.ArrayList;
import java.util.List;


public class Agenda {
	private List<Contato> contatos = new ArrayList<Contato>();
	private int sizeLimit = 10;
	
	public int getContactListSize() {
		return contatos.size();
	}
	
	public List<Contato> getListConListContacts() {
		return contatos;
	}
	
	public boolean addContact(Contato novo) {
		if (isDuplicateContact(novo))
			throw new IndexOutOfBoundsException("Já existe um contato com este número de telefone");
		
		if (this.getContactListSize() < this.sizeLimit)
			return contatos.add(novo);
		else
			throw new ArrayIndexOutOfBoundsException("Limite máximo de contatos atingido");
		
	}
	
	public boolean isDuplicateContact(Contato contatoBuscado) {
		
		for (Contato c : contatos) {
	        if (c.equals(contatoBuscado)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean removeContact(Contato contato) {
		
		return contatos.remove(contato);
	}
	
	public Contato findContactByName(String nameContact) {
		for (Contato c : contatos) {
	        if (c.getNome().equals(nameContact)) {
	            return c;
	        }
	    }
	    return null;
	}
	
	public boolean printAllContacts() {
		for (Contato c : contatos) {
			System.out.println(c.toString());
	    }
		return true;
	}

	public boolean printContact(String name) {
		Contato c = this.findContactByName(name);
		if (c != null) {
			System.out.println(c.toString());
			return true;
		}
			
		return false;
	}
}
