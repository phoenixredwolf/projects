package com.edmunds.q1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;


public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// Declare element names
	JFrame frame;
	JPanel entryPanel;
	JPanel buttonPanel;
	JPanel masterPanel;
	JLabel lblName;
	JTextArea taIDs;
	JTextField tfName;
	JButton btnSubmit;
	JButton btnClear;
	JButton btnExit;
	SpringLayout inputLayout;
	FlowLayout buttonLayout;
	IDs id = new IDs();
	Action action;
	
	public UserInterface() {
		
		// Set the parameters of the frame and panels
		frame = new JFrame("Edmunds Gov Tech Q1");
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setDefaultButton(btnSubmit);
		entryPanel = new JPanel();
		buttonPanel = new JPanel();
		masterPanel = new JPanel(new BorderLayout());
		frame.getContentPane().add(masterPanel);
		
		// Create our components
		tfName = new JTextField(20);
		tfName.requestFocus();
		lblName = new JLabel("Name:");
		lblName.setLabelFor(tfName);
		
		taIDs = new JTextArea();
		taIDs.setOpaque(false);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");

		btnClear = new JButton("Clear");
		btnExit = new JButton("Exit");
		
		// Set our layout on the panels
		buttonLayout = new FlowLayout(FlowLayout.CENTER, 10, 10);
		buttonPanel.setLayout(buttonLayout);
		
		inputLayout = new SpringLayout();
		entryPanel.setLayout(inputLayout);
		inputLayout.putConstraint(SpringLayout.EAST, lblName, -10, SpringLayout.WEST, tfName);
		inputLayout.putConstraint(SpringLayout.NORTH, lblName, 10, SpringLayout.NORTH, entryPanel);
		inputLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, tfName, 20, SpringLayout.HORIZONTAL_CENTER, entryPanel);
		inputLayout.putConstraint(SpringLayout.NORTH, tfName, 10, SpringLayout.NORTH, entryPanel);
		inputLayout.putConstraint(SpringLayout.NORTH, taIDs, 10, SpringLayout.SOUTH, tfName);
		inputLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, taIDs, 0, SpringLayout.HORIZONTAL_CENTER, entryPanel);

		// Add the components to the panels
		entryPanel.add(lblName);
		entryPanel.add(tfName);
		entryPanel.add(taIDs);
		buttonPanel.add(btnClear);
		buttonPanel.add(btnSubmit);
		buttonPanel.add(btnExit);
		
		// set the panels to the master
		masterPanel.add(entryPanel, BorderLayout.CENTER);
		masterPanel.add(buttonPanel, BorderLayout.PAGE_END);
		
		frame.setVisible(true);
		
		// Handle button clicks
		btnSubmit.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 String name = tfName.getText();
	        	 String ID = id.createID(name);
	             taIDs.append(ID + "\n");
	             tfName.requestFocus();
	          }          
	       });
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taIDs.setText(null);
				tfName.setText(null);
				tfName.requestFocus();
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// Define what happens when the enter button is pressed
		action = new AbstractAction() {

			private static final long serialVersionUID = 6772889552828432649L;

			@Override
			public void actionPerformed(ActionEvent e) {
				btnSubmit = (JButton)e.getSource();
	        	 String name = tfName.getText();
	        	 String ID = id.createID(name);
	             taIDs.append(ID + "\n");
	             tfName.requestFocus();
				
			}
			
		};
		
		btnSubmit.getActionMap().put("Enter", action);
		btnSubmit.addActionListener(action);
	}
	
	

	
}
