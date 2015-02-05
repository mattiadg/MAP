package it.cnr.itd.uni2014.javafx.fxml.circles;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.DoubleBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class CirclesController implements Initializable {
	@FXML
	private TextField t;
	@FXML
	private Circle c1;
	@FXML
	private Circle c2;
	@FXML
	private Circle c3;
	@FXML
	private Slider s1;
	@FXML
	private Slider s2;
	@FXML
	private Slider s3;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		c1.radiusProperty().bind(s1.valueProperty());
		c2.radiusProperty().bind(s2.valueProperty());
		final DoubleBinding totalArea = new DoubleBinding() {
			{
				super.bind(c1.radiusProperty(), c2.radiusProperty());
			}

			@Override
			protected double computeValue() {
				return Math.PI * Math.pow(c1.radiusProperty().get(), 2)
						+ Math.PI * Math.pow(c2.radiusProperty().get(), 2);
			}
		};
		DoubleBinding radius = new DoubleBinding() {
			{
				super.bind(totalArea);
			}

			@Override
			protected double computeValue() {
				return Math.sqrt(totalArea.get() / Math.PI);
			}
		};
		c3.radiusProperty().bind(radius);
		t.textProperty().bind(radius.asString());
	}
}