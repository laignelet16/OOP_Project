package com.example.broadwayroulette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class ShowTicketGUI extends JFrame{
	private TicketInfo ticketInfo;
	private JLabel showDetailsLabel;
	static String labelText;
	
	public ShowTicketGUI(TicketInfo ticketInfo) {
		this.ticketInfo = ticketInfo;
		List<String> selectedChoices = ticketInfo.getChoices();
		
		Random rand = new Random();
		int rand_int = rand.nextInt(selectedChoices.size());
		String fate = selectedChoices.get(rand_int);
		
		setTitle("Thank you for your purchase!");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//      LABEL PANEL TO SHOW WHERE YOU ARE
        JPanel pathPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel path =  new JLabel("Buy > Payment > Event Details");
        
        path.setFont(path.getFont().deriveFont(10.0f)); // Set the font size
        path.setAlignmentX(Component.LEFT_ALIGNMENT); 
        pathPanel.add(path);
        pathPanel.setBackground(Color.YELLOW);
        // Add the label to the content pane of the JFrame
        add(pathPanel, BorderLayout.NORTH);
        
//		Fetch data and do a label
        showDetailsLabel = new JLabel();
		fetchData(fate);
		
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(Color.DARK_GRAY);
        JButton menuButton = new JButton("MENU");
        JButton resaleButton = new JButton("RESALE");
        
//      MENU ACTION 
        buttonPanel.add(menuButton);
        menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainFrameGUI frame = new MainFrameGUI();
				frame.show();
			}
		});
        
        // RESALE ACTION 
        buttonPanel.add(resaleButton);
        resaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ResaleGUI frame1 = new ResaleGUI(labelText);
				frame1.show();
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void fetchData(String show) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT show_name, show_date, show_time FROM broadway WHERE show_name=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, show);
            ResultSet resultSet = preparedStatement.executeQuery();
           
            while (resultSet.next()) {
                String showName = resultSet.getString("show_name");
                String showDate = resultSet.getString("show_date");
                String showTime = resultSet.getString("show_time");
                
                labelText = "<html>ShowName: " + showName + "<br>Show Date: " + showDate +"<br>Show Time: " + showTime + "</html>"; 
                showDetailsLabel.setText(labelText);
                showDetailsLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
            }
            add(showDetailsLabel, BorderLayout.CENTER);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
