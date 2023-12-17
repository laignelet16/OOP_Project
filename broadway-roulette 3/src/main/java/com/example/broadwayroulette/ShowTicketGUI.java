package com.example.broadwayroulette;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
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
	private JLabel confirmationLabel;
	static String labelText;
	
	public ShowTicketGUI(TicketInfo ticketInfo) {
		JFrame f = new JFrame("BorderLayout");
		this.ticketInfo = ticketInfo;
		List<String> selectedChoices = ticketInfo.getChoices();
		
		Random rand = new Random();
		int rand_int = rand.nextInt(selectedChoices.size());
		String fate = selectedChoices.get(rand_int);
		
		setTitle("Congratulations! You are seeing a Broadway Show!");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel center = new JPanel(new BorderLayout());
        
////      LABEL PANEL TO SHOW WHERE YOU ARE
//        JPanel pathPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        JLabel path =  new JLabel("Buy > Payment > Event Details");
//        center.add(pathPanel, "North");
//        
//        path.setFont(path.getFont().deriveFont(10.0f)); // Set the font size
//        path.setAlignmentX(Component.LEFT_ALIGNMENT); 
//        pathPanel.add(path);
//        pathPanel.setBackground(Color.YELLOW);
//        // Add the label to the content pane of the JFrame
//        add(pathPanel, BorderLayout.LINE_END);
        
//		Fetch data and do a label
        showDetailsLabel = new JLabel();
        confirmationLabel = new JLabel();
		fetchData(fate, center);
		
		JPanel imagePanel = new JPanel();
		imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
		center.add(imagePanel, "South");
		
//		add(showDetailsLabel, BorderLayout.CENTER);
		System.out.println(fate);
		if (fate.equals("Chicago")) {
			addImage(imagePanel, "images1/chicago.png", 800, 400);
        } else if (fate.equals("Moulin Rouge")) {
        	addImage(imagePanel, "images1/rouge.png", 800, 400);
        } else if (fate.equals("The Notebook")) {
        	addImage(imagePanel, "images1/notebook.png", 800, 400);
        } else if (fate.equals("Wicked")) {
        	addImage(imagePanel, "images1/wicked.png", 800, 400);
        } else {
        	addImage(imagePanel, "images1/lion.png", 800, 400);
        }
		
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
//        resaleButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				ResaleGUI frame1 = new ResaleGUI(labelText);
//				frame1.show();
//			}
//		});
        add(buttonPanel, BorderLayout.SOUTH);
        resaleAction(resaleButton);
//		add(panel, BorderLayout.SOUTH);
	}
	
	private void resaleAction(JButton resaleButton) {
		resaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ResaleGUI frame1 = new ResaleGUI(labelText);
				frame1.show();
			}
		});
	}
	
	private void addImage(JPanel panel, String imagePath, int width, int height) {
	    ImageIcon icon = new ImageIcon(imagePath);
	    Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(image);
	    
	    JLabel label = new JLabel(scaledIcon, SwingConstants.CENTER);
	    panel.add(label);
	}

	private void fetchData(String show, JPanel center) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT show_name, show_date, show_time FROM broadway2 WHERE show_name=?";
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
                String confirmationNumber = generateConfirmationNumber();
                confirmationLabel.setText("Confirmation Number: " + confirmationNumber);
                confirmationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            }
            
            center.add(showDetailsLabel, "Center");
            center.add(confirmationLabel, "North");
            add(center, BorderLayout.CENTER);
//            add(showDetailsLabel, BorderLayout.CENTER);
//            add(confirmationLabel, BorderLayout.PAGE_START);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private String generateConfirmationNumber() {
        int length = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder confirmationNumber = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            confirmationNumber.append(characters.charAt(index));
        }

        return confirmationNumber.toString();
    }
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicketInfo ticketInfo = new TicketInfo(/* Pass relevant parameters */);
            ShowTicketGUI frame = new ShowTicketGUI(ticketInfo);
            frame.setVisible(true);
        });
    }
}
