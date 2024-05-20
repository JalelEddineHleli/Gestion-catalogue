package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Categorie;
import entities.Produit;

public class GestionCatalogueJDBCImpl implements IGestionCatalogue{
	
	Connection cnx;
	public GestionCatalogueJDBCImpl() throws SQLException
	{
		this.cnx=SingletonConnection.getInstance();
	}

	@Override
	public List<Categorie> getAllCategories() throws SQLException {
		List<Categorie>liste=new ArrayList<Categorie>();
		PreparedStatement ps=cnx.prepareStatement("select * from categorie");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			liste.add(new Categorie(rs.getInt(1),rs.getString(2)));
			
		return liste;
	}

	@Override
	public List<Produit> getAllProducts() throws SQLException {
		List<Produit>liste=new ArrayList<Produit>();
		PreparedStatement ps=cnx.prepareStatement("select * from produit");
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
			{
			  Produit p=new Produit(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
			  PreparedStatement ps2=cnx.prepareStatement("select * from categorie where id=?");
			  ps2.setInt(1, rs.getInt(5));
			  ResultSet rs2=ps2.executeQuery();
			  Categorie c=null;
			  if(rs2.next())
				  c=new Categorie(rs2.getInt(1),rs2.getString(2));
			  p.setCategorie(c);
				  
			 liste.add(p);
			
			}
			
		return liste;
		
		
	}

	@Override
	public List<Produit> getProductsByCategorie(int idCategorie) throws SQLException {
		List<Produit>liste=new ArrayList<Produit>();
		PreparedStatement ps=cnx.prepareStatement("select * from produit where idcat=?");
		ps.setInt(1, idCategorie);
		ResultSet rs=ps.executeQuery();
		Categorie c=null;
		while(rs.next())
			{
			  Produit p=new Produit(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
			  PreparedStatement ps2=cnx.prepareStatement("select * from categorie where id=?");
			  ps2.setInt(1, rs.getInt(5));
			  ResultSet rs2=ps2.executeQuery();
			  if(rs2.next())
				  c=new Categorie(rs2.getInt(1),rs2.getString(2));
			  p.setCategorie(c);
				  
			 liste.add(p);
			
			}
			
		return liste;
	}
	

}
