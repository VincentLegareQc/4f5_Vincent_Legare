package serpents_echelles.pages.accueil;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.mvc.controleurs.ControleurVue;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;
import serpents_echelles.commandes.fermer_historique.FermerHistorique;
import serpents_echelles.commandes.fermer_historique.FermerHistoriqueRecue;
import serpents_echelles.commandes.ouvrir_historique.OuvrirHistorique;
import serpents_echelles.commandes.ouvrir_historique.OuvrirHistoriqueRecue;
import serpents_echelles.commandes.quitter.Quitter;
import serpents_echelles.commandes.quitter.QuitterRecue;
import serpents_echelles.pages.historique_parties.Historique;
import serpents_echelles.pages.historique_parties.afficheurs.AfficheurHistorique;
import serpents_echelles.pages.historique_parties.controleurs.ControleurHistorique;
import serpents_echelles.pages.historique_parties.vues.VueHistorique;

import static serpents_echelles.pages.historique_parties.Constantes.*;

import java.io.IOException;
import java.util.Random;

public class ControleurAccueil extends ControleurVue<VueAccueil>{
	
	private Scene sceneHistorique;
	private Stage dialogueHistorique;
	
	private Random alea = new Random();
	
	@Override
	protected void demarrer() {
		try {
			instancierControleurHistorique();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(OuvrirHistorique.class, new RecepteurCommandeMVC<OuvrirHistoriqueRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirHistoriqueRecue commande) {
				J.appel(this);
				
				ouvrirHistorique();
			}
		});
		
		installerRecepteurCommande(FermerHistorique.class, new RecepteurCommandeMVC<FermerHistoriqueRecue>() {
			@Override
			public void executerCommandeMVC(FermerHistoriqueRecue commande) {
				J.appel(this);
				
				fermerHistorique();
			}
		});
		
		installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
			@Override
			public void executerCommandeMVC(QuitterRecue commande) {
				J.appel(this);

				quitter();
			}
		});
	}
	
	@Override
	protected void installerReceptionMessages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		// TODO Auto-generated method stub
		
	}
	
	private void ouvrirHistorique() {
		J.appel(this);
		
		dialogueHistorique = DialogueModal.ouvrirDialogueModal(sceneHistorique);
	}
	
	private void fermerHistorique() {
		J.appel(this);
		
		if(dialogueHistorique != null) {
			dialogueHistorique.close();
		}
	}
	
	private void quitter() {
		J.appel(this);

		Systeme.quitter();
	}
	
	private void instancierControleurHistorique() throws IOException {
		J.appel(this);

		ChargeurDeVue<VueHistorique> chargeur;
		chargeur = new ChargeurDeVue<VueHistorique>(CHEMIN_HISTORIQUE_FXML);
		
		sceneHistorique = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);
		
		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		Historique historique = EntrepotDeModeles.obtenirModele(Historique.class, idModeleTest);
		
		AfficheurHistorique afficheurHistorique = new AfficheurHistorique();
		
		VueHistorique vueHistorique = chargeur.getVue();
		
		FabriqueControleur.creerControleur(ControleurHistorique.class, 
				                           historique, 
				                           vueHistorique, 
				                           afficheurHistorique);
	}
}