package serpents_echelles.pages.historique_parties.composants;


import ntro.debogage.J;
import ntro.javafx.composants.CanvasAjustable;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.NamedArg;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CaseAjustable extends CanvasAjustable {

    private Timeline animationSortieJeton;
    private Timeline animationEntreeJeton;

    public CaseAjustable(@NamedArg("couleurRouge") Color couleurRouge, 
    		             @NamedArg("couleurJaune") Color couleurJaune) {
        super();
        J.appel(this);

        creerAnimationSortieJeton();
        creerAnimationEntreeJeton();

    }


    private void creerAnimationEntreeJeton() {
        J.appel(this);
        
        animationEntreeJeton = new Timeline();

        animationEntreeJeton.getKeyFrames().add(
                new KeyFrame(Duration.ZERO,
                             new KeyValue(this.translateYProperty(), -100),
                             new KeyValue(this.opacityProperty(), 0)));

        animationEntreeJeton.getKeyFrames().add(
                new KeyFrame(new Duration(100),
                             new KeyValue(this.translateYProperty(), 0),
                             new KeyValue(this.opacityProperty(), 1))); 
    }

    private void creerAnimationSortieJeton() {
        J.appel(this);
        
        animationSortieJeton = new Timeline();
        
        animationSortieJeton.getKeyFrames().add(
                new KeyFrame(Duration.ZERO,
                             new KeyValue(this.translateYProperty(), 0),
                             new KeyValue(this.opacityProperty(), 1)));

        animationSortieJeton.getKeyFrames().add(
                new KeyFrame(new Duration(100),
                             new KeyValue(this.translateYProperty(), 200),
                             new KeyValue(this.opacityProperty(), 0))); 
    }


	@Override
	protected void reagirHauteurInitiale(double arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void reagirLargeurInitiale(double arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void reagirNouvelleHauteur(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void reagirNouvelleLargeur(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}
}
