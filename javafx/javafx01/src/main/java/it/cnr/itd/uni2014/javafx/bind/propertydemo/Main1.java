package it.cnr.itd.uni2014.javafx.bind.propertydemo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main1 {
	public static void main(String[] args) {
		Bill electricBill = new Bill();
		electricBill.amountDueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue o, Object oldVal, Object newVal) {
				System.out.println("Electric bill has changed!");
			}
		});
		electricBill.setAmountDue(100.00);
	}
}