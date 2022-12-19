package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import abs.AFrame;

public class FirstFrame extends AFrame{
	
	public FirstFrame() {
		initFrame("Main Panel",initPanel());
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel textJPanel = new JPanel(new GridLayout(1,1));
		JPanel buttonsJPanel = new JPanel(new GridLayout(1,2));
		
		JLabel selectJLabel = new JLabel("Select what you want to do :",JLabel.CENTER);
		textJPanel.add(selectJLabel);
		
		JButton loginButton = new JButton("Login");
		buttonsJPanel.add(loginButton);

		JButton registerButton = new JButton("Register");
		buttonsJPanel.add(registerButton);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginFrame();
				setVisible(false);
				dispose();
			}
		});
		
		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterFrame();
				setVisible(false);
				dispose();
			}
		});
		
		
		panel.add(textJPanel);
		panel.add(buttonsJPanel,BorderLayout.SOUTH);
		return panel;
	}
	
	
	
	
}
