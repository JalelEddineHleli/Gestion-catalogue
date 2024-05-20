package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Categorie;
import entities.Produit;

public interface IGestionCatalogue {
	
	public List<Categorie> getAllCategories()throws SQLException;
	public List<Produit> getAllProducts()throws SQLException;
	public List<Produit> getProductsByCategorie(int idCategorie)throws SQLException;
}
