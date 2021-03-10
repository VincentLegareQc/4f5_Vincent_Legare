package serpents_echelles.pages.historique_parties.afficheurs;

import ntro.debogage.J;
import ntro.mvc.Afficheur;
import serpents_echelles.pages.historique_parties.HistoriqueLectureSeule;
import serpents_echelles.pages.historique_parties.vues.VueHistorique;

public class AfficheurHistorique extends Afficheur<HistoriqueLectureSeule, VueHistorique>{

	@Override
	public void initialiserAffichage(HistoriqueLectureSeule arg0, VueHistorique arg1) {
		J.appel(this);
	}

	@Override
	public void rafraichirAffichage(HistoriqueLectureSeule arg0, VueHistorique arg1) {
		J.appel(this);
	}
}