package java8_lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Example_02_event {
	public static void main(String[] args) {
		// Before Java 8:
		JButton show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out
						.println("Event handling without lambda expression is boring");
			}
		});
		// Java 8 way:
		show.addActionListener((e) -> {
			System.out
					.println("Light, Camera, Action !! Lambda expressions Rocks");
		});
	}
}
