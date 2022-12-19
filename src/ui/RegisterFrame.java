package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import abs.AFrame;
import dal.MemberDal;
import type.MemberContract;

public class RegisterFrame extends AFrame{

	public RegisterFrame() {
		initFrame("Register Panel",initPanel());
	}
	
	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel buttonsJPanel = new JPanel(new GridLayout(5,1));
		
		JLabel nameJLabel = new JLabel("Name :",JLabel.RIGHT);
		buttonsJPanel.add(nameJLabel);
		JTextField nameField = new JTextField(10);
		buttonsJPanel.add(nameField);
		
		JLabel surnameJLabel = new JLabel("Surname :",JLabel.RIGHT);
		buttonsJPanel.add(surnameJLabel);
		JTextField surnameField = new JTextField(10);
		buttonsJPanel.add(surnameField);
		
		JLabel usernameJLabel = new JLabel("Username :",JLabel.RIGHT);
		buttonsJPanel.add(usernameJLabel);
		JTextField usernameField = new JTextField(10);
		buttonsJPanel.add(usernameField);
		
		JLabel passwordJLabel = new JLabel("Password :",JLabel.RIGHT);
		buttonsJPanel.add(passwordJLabel);
		JPasswordField passwordField = new JPasswordField(10);
		buttonsJPanel.add(passwordField);
		
		JButton registerButton = new JButton("Register");
		buttonsJPanel.add(registerButton);

		JButton backButton = new JButton("Back");
		buttonsJPanel.add(backButton);

		registerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberContract contract = new MemberContract();
				
				contract.setName(nameField.getText());
				contract.setSurname(surnameField.getText());
				contract.setUserName(usernameField.getText());;
				contract.setPassword(passwordField.getPassword());
				
				if (new MemberDal().register(contract)) {
					JOptionPane.showMessageDialog(nameField,"Succesfully registered");
					
					new LoginFrame();
					
					setVisible(false);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(nameField,"The username already taken\nPlease change");
				}
			}
		});
		
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FirstFrame();
				
				setVisible(false);
				dispose();
			}
		});
		
		panel.add(buttonsJPanel,BorderLayout.NORTH);
		return panel;
	}

}
