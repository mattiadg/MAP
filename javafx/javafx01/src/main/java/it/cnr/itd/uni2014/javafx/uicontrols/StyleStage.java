package it.cnr.itd.uni2014.javafx.uicontrols;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StyleStage {
	private StylePanel stylePanel;
	private Stage stage;
	private Stage demoStage;

	public StyleStage(Stage stage) {
		this.stage = stage;
		stylePanel = new StylePanel();
		Scene scene = new Scene(stylePanel);
		stage.setScene(scene);
		stage.setTitle("Choose style");
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent t) {
				demoStage.close();
			}
		});
	}

	public void add(String name, String styleSheetName) {
		stylePanel.add(name, styleSheetName);
	}

	public void setSceneCreator(final SceneCreator sceneCreator) {
		if (demoStage == null) {
			demoStage = new Stage();
			demoStage.setTitle("Demo");
			demoStage.setX(stage.getX());
			demoStage.setY(stage.getY() + stage.getHeight());
		}
		demoStage.setScene(sceneCreator.createScene());
		demoStage.show();
		stylePanel.selected.addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> ov, String t,
					String t1) {
				demoStage.setScene(sceneCreator.createScene());
				if (t1 != null) {
					demoStage
							.getScene()
							.getStylesheets()
							.setAll(UIControlCSS.class.getResource(t1)
									.toString());
				}
			}
		});
	}

	public static interface SceneCreator {
		Scene createScene();
	}
}

class StylePanel extends HBox {
	public StringProperty selected = new SimpleStringProperty();
	ToggleGroup stylesheetToggleGroup = new ToggleGroup();

	public StylePanel() {
		super(5);
		StyleButton defaultStylesheetButton = new StyleButton("Default", null);
		defaultStylesheetButton.setSelected(true);
		defaultStylesheetButton.setToggleGroup(stylesheetToggleGroup);
		setPadding(new Insets(0, 0, 30, 0));
		setAlignment(Pos.BOTTOM_LEFT);
		getChildren().addAll(defaultStylesheetButton/*
													 * , controlStyle1Button,
													 * controlStyle2Button
													 */);
	}

	public void add(String name, String styleSheetName) {
		StyleButton styleButton = new StyleButton(name, styleSheetName);
		styleButton.setToggleGroup(stylesheetToggleGroup);
		getChildren().addAll(styleButton);
	}

	class StyleButton extends ToggleButton {
		public StyleButton(String text, final String styleSheetName) {
			super(text);
			selectedProperty().addListener(new InvalidationListener() {
				public void invalidated(Observable ov) {
					selected.set(styleSheetName);
					// if (selectedProperty().getValue() && getScene() != null)
					// {
					// getScene().getStylesheets().setAll(styleSheetName == null
					// ? "" :
					// UIControlCSS.class.getResource(styleSheetName).toString());
					// }
				}
			});
		}
	}
}
