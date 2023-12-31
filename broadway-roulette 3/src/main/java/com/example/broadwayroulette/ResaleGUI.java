package com.example.broadwayroulette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ResaleGUI extends JFrame {
	private JTextField resalePrice;
    private JLabel showDetailsLabel;
    private JCheckBox confirmCheckBox; 

    public ResaleGUI(String labelText) {
        setTitle("Resale Ticket");
        setSize(900, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pathPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel path = new JLabel("Ticket > Resale");

        path.setFont(path.getFont().deriveFont(10.0f)); // Set the font size
        path.setAlignmentX(Component.LEFT_ALIGNMENT);
        pathPanel.add(path);
        pathPanel.setBackground(Color.YELLOW);
        // Add the label to the content pane of the JFrame
        add(pathPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Correct usage of BoxLayout
        JLabel label1 = new JLabel("Resale your Ticket");
        label1.setFont(label1.getFont().deriveFont(10.0f));
        panel.add(label1);

        // Initialize showDetailsLabel
        showDetailsLabel = new JLabel();
        showDetailsLabel.setText(labelText);
        panel.add(showDetailsLabel);

        resalePrice = new JTextField(10);
        panel.add(new JLabel("Resale Price"));
        panel.add(resalePrice);

        confirmCheckBox = new JCheckBox("I confirm the resale and that I have 30 days to sell my ticket before it can no longer be resold.");
        panel.add(confirmCheckBox);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainFrameGUI frame = new MainFrameGUI();
                frame.show();
            }
        });
        panel.add(cancelButton);
       
        JButton resaleBtn1 = new JButton("Resale");
        panel.add(resaleBtn1);
        resaleApprove(resaleBtn1);
        add(panel);
    }

    private void handleResale() {
        double resalePriceText = Double.parseDouble(resalePrice.getText());
        double originalPrice = 46.00;
        double percentageIncrease = ((resalePriceText - originalPrice) / originalPrice) * 100;
        
        String percentage = String.format("%.0f", percentageIncrease);
        String message; 
        if (percentageIncrease >= 0) {
            message = "You are trying to resale the ticket by " + percentage + "% higher than $46. You have now entered your ticket to be resold.";

        } else {
            message = "You are trying to resale the ticket by " + percentage + "% lower than $46. You have now entered your ticket to be resold.";

        }
        JOptionPane.showMessageDialog(this, message, "Resale Information", JOptionPane.INFORMATION_MESSAGE);

        // Close the resalegui window
        dispose();

        // go back to main
        MainFrameGUI frame = new MainFrameGUI();
        frame.show();
    }
    
    private void resaleApprove(JButton resaleBtn1) {
    	resaleBtn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (confirmCheckBox.isSelected()) {
                    handleResale();
                } else {
                    JOptionPane.showMessageDialog(ResaleGUI.this, "Please check the checkbox to confirm the terms.", "Confirmation Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
	}
}
