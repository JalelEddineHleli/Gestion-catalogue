package entities;

public class Produit {
	
	private int id;
	private String nom;
	private double prix;
	private int quantie;
	private Categorie categorie;
	public Produit(int id, String nom, double prix, int quantie, Categorie categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantie = quantie;
		this.categorie = categorie;
	}
	
	public Produit(int id, String nom, double prix, int quantie) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantie = quantie;
	}

	public Produit(String nom, double prix, int quantie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.quantie = quantie;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
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
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantie() {
		return quantie;
	}
	public void setQuantie(int quantie) {
		this.quantie = quantie;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	

}
