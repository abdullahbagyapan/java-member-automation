package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import abs.AFrame;
import dal.CustomerDal;
import dal.MemberDal;
import type.MemberContract;

public class AdminListFrame extends AFrame{
	public AdminListFrame() {
		initFrame("Admin List",initPanel());
	}
	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(400, 300));
		
		JList list = new JList(new MemberDal().showAdmin().toArray());
		JScrollPane pane = new JScrollPane(list);
		
		
		
		panel.add(pane);
		
		return panel;
	}
}
