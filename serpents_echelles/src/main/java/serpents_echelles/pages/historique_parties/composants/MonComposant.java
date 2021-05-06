package serpents_echelles.pages.historique_parties.composants;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import ntro.debogage.J;

public class MonComposant extends Pane{
	
	public MonComposant() {
		super();
		J.appel(this);
		
		Canvas toile = new Canvas(600,400);
		
		GraphicsContext pinceau = toile.getGraphicsContext2D();
		
		pinceau.strokeText("Hello Canvas", 150, 100);
		
		pinceau.setFill(Color.GREEN);
		pinceau.setStroke(Color.BLUE);
		pinceau.setLineWidth(5);
		pinceau.strokeLine(40, 10, 10, 40);
		pinceau.fillOval(10, 60, 30, 30);
		pinceau.strokeOval(60, 60, 30, 30);
		pinceau.fillRoundRect(110, 60, 30, 30, 10, 10);
		pinceau.strokeRoundRect(160, 60, 30, 30, 10, 10);
		pinceau.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
		pinceau.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
		pinceau.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
		pinceau.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
		pinceau.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
		pinceau.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
		pinceau.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
		pinceau.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
		pinceau.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
		pinceau.save();
	}	
}