package serpents_echelles.pages.historique_parties;

public class Constantes {

	public static final String CHEMIN_HISTORIQUE_FXML = "/historique/structure.xml";
	public static final String CHEMIN_PRINCIPAL_FXML = "/accueil/structure.xml";
	public static final String[] IDS_MODELES_TESTS = {"test01","test02","test03"};
	
	public static final int LARGEUR_PIXELS = 600;
	public static final int HAUTEUR_PIXELS= 400;
	
	public static final int PORT = 8765;
	public static final String ADRESSE_SERVEUR = String.format("ws://localhost:%s", PORT);
	
	
	public static final String CHEMIN_CHAINES = "traductions/chaines";
	public static final String CHEMIN_CSS = "/historique/style.css";
}