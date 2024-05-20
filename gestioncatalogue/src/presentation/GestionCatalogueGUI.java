package presentation;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.GestionCatalogueJDBCImpl;
import dao.IGestionCatalogue;
import entities.Categorie;

public class GestionCatalogueGUI extends JFrame {

	JLabel l = new JLabel("selectionner un categorie");
	JComboBox<Categorie> categories = new JComboBox<Categorie>();
	TableModele tm = new TableModele();
	JTable tableau = new JTable(tm);
	JScrollPane jsp = new JScrollPane(tableau);
	JButton fermer = new JButton("Quitter");

	JPanel ph = new JPanel();
	JPanel pb = new JPanel();

	IGestionCatalogue gestion;

	public GestionCatalogueGUI() {
		try {
			gestion = new GestionCatalogueJDBCImpl();
			setTitle("rechercher produit");
			setVisible(true);
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			setLocationRelativeTo(null);
			chargerCombo(gestion.getAllCategories());
			ph.add(l);
			ph.add(categories);
			add(ph, BorderLayout.NORTH);

			add(jsp);

			pb.add(fermer);
			add(pb, BorderLayout.SOUTH);
			tm.charger(gestion.getAllProducts());
			fermer.addActionListener(e -> {
				int res = JOptionPane.showConfirmDialog(this, "voulez vous quitter l'application?");
				if (res == 0)
					dispose();
			});
			categories.addActionListener(e->{
			Categorie c=(Categorie)categories.getSelectedItem();
			try {
			if(c.getNom()==null)
				tm.charger(gestion.getAllProducts());
			else
				tm.charger(gestion.getProductsByCategorie(c.getId()));
			}
			catch(SQLException ee)
			{
				JOptionPane.showMessageDialog(this, ee.getMessage());
			}
				
				
			});

			pack();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}

	}

	public static void main(String[] args) {
		new GestionCatalogueGUI();
	}

	public void chargerCombo(List<Categorie> l) {
		if (l.size() > 1)
			categories.addItem(new Categorie());
		for (Categorie c : l)
			categories.addItem(c);
	}

}
