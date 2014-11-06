package lambda;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Esempio extends JFrame {
	
	public Esempio()
	{
		init();
		
	}

	private void init() {
		BorderLayout b=new BorderLayout();
		this.setLayout(b);
		JButton button=new JButton("Ok");
		this.add(button,BorderLayout.SOUTH);
		this.setSize(400, 300);
		this.setVisible(true);
		
		ActionListener l=new Azione();
		
		button.addActionListener(( e) -> System.out.println("ciao"));
	}

	public static void main(String[] args) {
		
		
		Esempio e=new Esempio();
		

		
		
		
	}

}
