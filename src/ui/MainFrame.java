package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import abs.AFrame;
import dal.CustomerDal;
import dal.MemberDal;
import type.CustomerContract;
import type.MemberContract;



public class MainFrame extends AFrame{
	MemberContract loginedContract;
	
	public MainFrame(MemberContract contract) {
		initFrame("Customer Panel",initPanel());
		loginedContract = contract;
	}

	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel buttonsJPanel = new JPanel(new GridLayout(4,3));
		
		JLabel nameJLabel = new JLabel("Name :",JLabel.RIGHT);
		buttonsJPanel.add(nameJLabel);
		JTextField nameField = new JTextField(10);
		buttonsJPanel.add(nameField);
		
		JLabel surnameJLabel = new JLabel("Surname :",JLabel.RIGHT);
		buttonsJPanel.add(surnameJLabel);
		JTextField surnameField = new JTextField(10);
		buttonsJPanel.add(surnameField);
		
		JButton saveButton = new JButton("Add");
		buttonsJPanel.add(saveButton);
		JButton updateButton = new JButton("Edit");		
		buttonsJPanel.add(updateButton);
		JButton deleteButton = new JButton("Delete");
		buttonsJPanel.add(deleteButton);
		JButton adminPanelButton = new JButton("Admin Panel");
		buttonsJPanel.add(adminPanelButton);
		
		JList list = new JList(new CustomerDal().getList().toArray());
		JScrollPane pane = new JScrollPane(list);

		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerContract contract = new CustomerContract();
				
				contract.setName(nameField.getText());
				contract.setSurname(surnameField.getText());
				
				if (contract.getName().isBlank() || contract.getSurname().isBlank()) {
					JOptionPane.showMessageDialog(nameField,"Please input name and surname");
				}
				else {					
					new CustomerDal().insert(contract);
					JOptionPane.showMessageDialog(nameField,contract.getName()+" "+contract.getSurname()+" has added");
					
					list.setListData(new CustomerDal().getList().toArray());
					
					nameField.setText("");
					surnameField.setText("");
					
				}
				
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				
				CustomerContract contract = (CustomerContract) list.getSelectedValue();
				
				if (contract!=null) {
					nameField.setText(contract.getName());
					surnameField.setText(contract.getSurname());					
				}				 
			}
		});
		
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerContract contract = (CustomerContract) list.getSelectedValue();
				
				if (contract==null) {
					JOptionPane.showMessageDialog(nameField,"Please select person");
				}
				else {
					contract.setName(nameField.getText());
					contract.setSurname(surnameField.getText());
					
					new CustomerDal().update(contract);
					
					JOptionPane.showMessageDialog(nameField,"The person has edited");
					
					list.setListData(new CustomerDal().getList().toArray());
					
					nameField.setText("");
					surnameField.setText("");
					
				}
			}
			
			
		});
		
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerContract contract = (CustomerContract) list.getSelectedValue();
				
				if (contract==null) {
					JOptionPane.showMessageDialog(nameField,"Please select person");
				}
				else { 
					new CustomerDal().delete(contract);
					
					JOptionPane.showMessageDialog(nameField,"The person has deleted");
					
					list.setListData(new CustomerDal().getList().toArray());

					nameField.setText("");
					surnameField.setText("");
					
				}	
			}
		});
		
		adminPanelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AdminListFrame();
			}
		});
		
		
		panel.add(buttonsJPanel,BorderLayout.NORTH);
		panel.add(pane,BorderLayout.CENTER);
		
		return panel;
	}
	
	

}
