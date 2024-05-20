package entities;

import java.util.List;

public class Categorie {
	private int id;
	private String nom;
	//private List<Produit> produits;
	public Categorie() {
		
	}
	public Categorie(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString()
	{
		if(nom==null)
			return "all";
		return nom;
	}

}
