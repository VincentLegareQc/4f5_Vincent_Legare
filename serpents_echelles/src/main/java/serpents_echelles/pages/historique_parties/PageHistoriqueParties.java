package serpents_echelles.pages.historique_parties;

import java.util.Random;
import javafx.application.Application;
import javafx.stage.Stage;
import ntro.debogage.J;
import ntro.javafx.Initialisateur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;

public class PageHistoriqueParties extends Application{
	private String[] modelJson = {"test01","test02","test03"};

	static {

		Initialisateur.initialiser();
		
		J.appel(PageHistoriqueParties.class);
	}
	
	private Random alea = new Random();
	
	public static void main(String[] args) {
		J.appel(PageHistoriqueParties.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		String idModeleTest = modelJson[alea.nextInt(modelJson.length)];
		Historique historique = EntrepotDeModeles.obtenirModele(Historique.class, idModeleTest);
		
		System.out.println("Nom du test JSon: " + idModeleTest);
		J.valeurs(historique.getnbPartieArchive());
		for (int i = 0; i < historique.getpartieArchive().size(); i++) {
			System.out.print("ID du joueur : ");
			J.valeurs(historique.getpartieArchive().get(i).getId());
			System.out.print("Nom du joueur : ");
			J.valeurs(historique.getpartieArchive().get(i).getNomGagnant());
			System.out.print("Couleur du joueur : ");
			J.valeurs(historique.getpartieArchive().get(i).getCouleur().name());
			System.out.print("Nombre de coups : ");
			J.valeurs(historique.getpartieArchive().get(i).getNbCoups());
			System.out.print("Durée de la partie : ");
			J.valeurs(historique.getpartieArchive().get(i).getDureePartie());
		}

		Systeme.quitter();
	}
}