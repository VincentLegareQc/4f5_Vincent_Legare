package serpents_echelles.pages.historique_parties.controleurs;

import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurMessageMVC;
import serpents_echelles.messages.transmettre_json_choisi.MsgTransmettreJson;
import serpents_echelles.messages.transmettre_json_choisi.MsgTransmettreJsonRecu;
import serpents_echelles.pages.historique_parties.Historique;
import serpents_echelles.pages.historique_parties.HistoriqueLectureSeule;
import serpents_echelles.pages.historique_parties.afficheurs.AfficheurHistorique;
import serpents_echelles.pages.historique_parties.vues.VueHistorique;

public class ControleurHistorique extends ControleurModeleVue<HistoriqueLectureSeule, Historique, VueHistorique, AfficheurHistorique>{

	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
	}
	
	@Override
	protected void installerReceptionMessages() {
		//super.installerReceptionMessages();
		J.appel(this);
		
		installerRecepteurMessage(MsgTransmettreJson.class, new RecepteurMessageMVC<MsgTransmettreJsonRecu>() {

			@Override
			public void recevoirMessageMVC(MsgTransmettreJsonRecu messageRecu) {
				J.appel(this);
				
				
			}
		});
	}
}