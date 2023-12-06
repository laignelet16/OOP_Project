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

    public ResaleGUI(String labelText) {
        setTitle("Resale Ticket");
        setSize(225, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pathPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel path =  new JLabel("Ticket > Resale");
        
        path.setFont(path.getFont().deriveFont(10.0f)); // Set the font size
        path.setAlignmentX(Component.LEFT_ALIGNMENT); 
        pathPanel.add(path);
        pathPanel.setBackground(Color.YELLOW);
        // Add the label to the content pane of the JFrame
        add(pathPanel, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        new BoxLayout(panel, BoxLayout.Y_AXIS);
        JLabel label1 = new JLabel("Resale your Ticket");
        label1.setFont(label1.getFont().deriveFont(10.0f));
//        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label1);
        // Initialize showDetailsLabel
        showDetailsLabel = new JLabel();
        showDetailsLabel.setText(labelText);
      
        panel.add(showDetailsLabel);

        resalePrice = new JTextField(10);
        panel.add(new JLabel("Resale Price"));
        panel.add(resalePrice);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
				MainFrameGUI frame = new MainFrameGUI();
				frame.show();
            }
        });
        panel.add(cancelButton);
        
        JButton resaleButton = new JButton("Resale");
        resaleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleResale();
            }
        });
        panel.add(resaleButton);
        add(panel);
        
        add(panel);
    }

    private void handleResale() {
        double resalePriceText = Double.parseDouble(resalePrice.getText());
        double originalPrice = 46.00;
        double percentageIncrease = ((resalePriceText - originalPrice) / originalPrice) * 100;
        
        String percentage = String.format("%.0f", percentageIncrease);
        String message; 
        if (percentageIncrease >= 0) {
            message = "You are trying to resale the ticket by " + percentage + "% higher than $46";

        } else {
            message = "You are trying to resale the ticket by " + percentage + "% lower than $46";

        }
        JOptionPane.showMessageDialog(this, message, "Resale Information", JOptionPane.INFORMATION_MESSAGE);

        // Close the resalegui window
        dispose();

        // go back to main
        MainFrameGUI frame = new MainFrameGUI();
        frame.show();
    }
}
