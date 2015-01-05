package it.cnr.itd.uni2014.javafx.base;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main3 extends Application {
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500, Color.BLACK);
		Rectangle r = new Rectangle(0, 0, 250, 250);
		r.setFill(Color.BLUE);
		
		
		root.getChildren().add(r);
		
		
		
		Duration duration = Duration.millis(2500);
		TranslateTransition translate = new TranslateTransition(duration);
		translate.setToX(390);
		translate.setToY(390);
		FillTransition fill = new FillTransition(duration);
		fill.setToValue(Color.RED);
		RotateTransition rotate = new RotateTransition(duration);
		rotate.setToAngle(360);
		ScaleTransition scale = new ScaleTransition(duration);
		scale.setToX(0.1);
		scale.setToY(0.1);
		
		ParallelTransition transition = new ParallelTransition(r, translate,
				fill, rotate, scale);
		transition.setCycleCount(Timeline.INDEFINITE);
		transition.setAutoReverse(true);
		transition.play();
		
		stage.setTitle("JavaFX Scene Graph Demo");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}