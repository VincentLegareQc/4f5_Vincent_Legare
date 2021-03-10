package serpents_echelles.pages.historique_parties.vues;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import ntro.debogage.J;
import ntro.mvc.Vue;

public class VueHistorique implements Vue, Initializable{
	
	@FXML
	private Button btnSupprimer, btnRetour;
	
	@FXML
	private ScrollPane affichageScroll;
	
	@FXML
	private Text titreHistorique;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
		// TODO Auto-generated method stub
		
	}
	
	/*
	public void afficherNom() {
		J.appel(this);
	}
	
	public void afficherCouleur() {
		J.appel(this);
	}
	
	public void afficherDuree() {
		J.appel(this);
	}
	
	public void afficherNbCoups() {
		J.appel(this);
	}
	
	*/
}