package serpents_echelles.pages.historique_parties;

import enumerations.CouleurPartie;

public interface PartieArchiveLectureSeule {

	int getId();
	String getNomGagnant();
	CouleurPartie getCouleur();
	int getDureePartie();
	int getNbCoups();
}