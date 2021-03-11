package serpents_echelles.pages.historique_parties.vues;

import java.net.URL;
import java.util.ResourceBundle;

import enumerations.CouleurPartie;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;

public class VueHistorique implements Vue, Initializable{
	
	@FXML
	private ScrollPane ScrollPaneHistorique;
	
	@FXML
	private VBox VBoxHistorique;
	
	@FXML
	private Button btnQuitter, btnRetour;
	
	@FXML
	private Text titreHistorique;
	
	@FXML
	private Rectangle backgroundSquare;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(ScrollPaneHistorique);
		DoitEtre.nonNul(VBoxHistorique);
		DoitEtre.nonNul(btnQuitter);
		DoitEtre.nonNul(btnRetour);
		DoitEtre.nonNul(titreHistorique);
		DoitEtre.nonNul(backgroundSquare);
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
	
	public void creerLigne(CouleurPartie couleur1, String nom1, int dureePartie, int nbCoups1) {
		J.appel(this);
		
		HBox ligne = new HBox();
		AnchorPane anchorPane = new AnchorPane();
		
		Circle circle = new Circle();
		circle.setRadius(10);
		
		Text nom = new Text();
		Text duree = new Text();
		Text nbCoups = new Text();
		
		nom.setText("Nom : " + nom1);
		duree.setText("Durée de la partie : " + String.valueOf(dureePartie));
		nbCoups.setText("Nombre de coups : " + String.valueOf(nbCoups1));
		
		ligne.setSpacing(30);
		ligne.setPadding(new Insets(20, 20, 20, 20));
		
		ligne.setMaxWidth(50);
		
		switch (couleur1) {
		case ROUGE:
			circle.setFill(Color.RED);
			break;
		case BLEU:
			circle.setFill(Color.BLUE);
			break;
		case JAUNE:
			circle.setFill(Color.YELLOW);
			break;
		case VERT:
			circle.setFill(Color.GREEN);
			break;
		default:
			circle.setFill(Color.WHITE);
			break;
		}
		VBoxHistorique.setSpacing(10);
		
		AnchorPane.setLeftAnchor(circle, 5.0);
        AnchorPane.setTopAnchor(circle, 5.0);
        
        AnchorPane.setLeftAnchor(nom, 40.0);
        AnchorPane.setTopAnchor(nom, 5.0);
        
        AnchorPane.setLeftAnchor(duree, 150.0);
        AnchorPane.setTopAnchor(duree, 5.0);
        
        AnchorPane.setLeftAnchor(nbCoups, 320.0);
        AnchorPane.setTopAnchor(nbCoups, 5.0);
        
		
		anchorPane.getChildren().addAll(circle, nom, duree, nbCoups);
		VBoxHistorique.getChildren().add(anchorPane);
		


	}
}