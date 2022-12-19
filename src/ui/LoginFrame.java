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

public class LoginFrame extends AFrame{
	
	public LoginFrame() {
		initFrame("Login Panel",initPanel());
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel buttonsJPanel = new JPanel(new GridLayout(3,1));
		
		JLabel usernameJLabel = new JLabel("Username :",JLabel.RIGHT);
		buttonsJPanel.add(usernameJLabel);
		JTextField usernameField = new JTextField(10);
		buttonsJPanel.add(usernameField);
		
		JLabel passwordJLabel = new JLabel("Password :",JLabel.RIGHT);
		buttonsJPanel.add(passwordJLabel);
		JPasswordField passwordField = new JPasswordField(10);
		buttonsJPanel.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		buttonsJPanel.add(loginButton);
		
		JButton backButton = new JButton("Back");
		buttonsJPanel.add(backButton);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberContract contract = new MemberContract();
				
				contract.setUserName(usernameField.getText());
				contract.setPassword(passwordField.getPassword());
				
				if (new MemberDal().login(contract)) {
					JOptionPane.showMessageDialog(usernameField,"Welcome");
					
					new MainFrame(contract);
					
					setVisible(false);
					dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(usernameField,"Wrong username or password please try again");
				}
				
				usernameField.setText("");
				passwordField.setText("");
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
		
		
		panel.add(buttonsJPanel);
		
		return panel;
	}
	
	

}
