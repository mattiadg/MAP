package it.cnr.itd.uni2014.javafx.demo;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class PersonController implements Initializable {
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField age;
	@FXML
	private CheckBox english;
	@FXML
	private Button save;
	Person p = new Person();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		firstName.textProperty().bindBidirectional(p.firstNameProperty());
		lastName.textProperty().bindBidirectional(p.lastNameProperty());
		age.textProperty().bindBidirectional(p.ageProperty(),
				NumberFormat.getIntegerInstance());
		english.selectedProperty().bindBidirectional(p.englishProperty());
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println(p);
			}
		});
	}
}