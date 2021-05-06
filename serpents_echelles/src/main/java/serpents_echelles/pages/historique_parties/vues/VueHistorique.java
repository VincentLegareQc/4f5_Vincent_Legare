package serpents_echelles.pages.historique_parties.vues;

import java.net.URL;
import java.util.ResourceBundle;

import enumerations.CouleurPartie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import serpents_echelles.commandes.fermer_historique.FermerHistorique;
import serpents_echelles.commandes.fermer_historique.FermerHistoriquePourEnvoi;

public class VueHistorique implements Vue, Initializable{
	
	private FermerHistoriquePourEnvoi fermerHistorique;
	
	@FXML
	private ScrollPane ScrollPaneHistorique;
	
	@FXML
	private VBox VBoxHistorique;
	
	@FXML
	private Button btnFermer;
	
	@FXML
	private Text titreHistorique;
	
	@FXML
	private Rectangle backgroundSquare;
	
	@FXML
	private VBox VBoxPrincipal;
	
	private ResourceBundle resources;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		this.resources = resources;
		
		DoitEtre.nonNul(ScrollPaneHistorique);
		DoitEtre.nonNul(VBoxHistorique);
		DoitEtre.nonNul(VBoxPrincipal);
		DoitEtre.nonNul(btnFermer);
		DoitEtre.nonNul(titreHistorique);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		btnFermer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				fermerHistorique.envoyerCommande();
			}
		});

	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);

		fermerHistorique = FabriqueCommande.obtenirCommandePourEnvoi(FermerHistorique.class);
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}
	
	public void changeColor(){
		btnFermer.setStyle("-fx-background-color:BLUE;");
	}
	
	public void backColor() {
		btnFermer.setStyle("-fx-background-color:#000000FF;");
	}
	
	public void creerLigne(CouleurPartie couleur1, String nom1, int dureePartie, int nbCoups1) {
		J.appel(this);
		
		VBoxPrincipal.setStyle("-fx-background-color:#268a44;");
		
		HBox ligne = new HBox();
		AnchorPane anchorPane = new AnchorPane();
		
		Circle circle = new Circle();
		circle.setRadius(10);
		
		Text nom = new Text();
		Text duree = new Text();
		Text nbCoups = new Text();
		
		nom.setText(this.resources.getString("Nom") + nom1);
		duree.setText(this.resources.getString("Duree_de_la_partie") + String.valueOf(dureePartie));
		nbCoups.setText(this.resources.getString("Nombre_de_coups") + String.valueOf(nbCoups1));
		
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