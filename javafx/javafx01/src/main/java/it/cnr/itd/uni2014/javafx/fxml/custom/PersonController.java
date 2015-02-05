package it.cnr.itd.uni2014.javafx.fxml.custom;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PersonController implements Initializable {
	@FXML
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private Button save;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println(firstName.getText() + "\t"
						+ lastName.getText());
			}
		});
	}
}