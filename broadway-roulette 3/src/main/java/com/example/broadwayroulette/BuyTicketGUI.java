package com.example.broadwayroulette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

// TO DO: 
// must add a timer (5 minutes) 
// must add the ticket into a class 

public class BuyTicketGUI extends JFrame{
	private JComboBox<String> showComboBox;
	private JComboBox<String> showComboBox1;
	private JComboBox<String> showComboBox2;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField addressField;
	static TicketInfo ticketInfo;
	
	public BuyTicketGUI() {
		ticketInfo = new TicketInfo();
		
		setTitle("Buy Ticket");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//      LABEL PANEL TO SHOW WHERE YOU ARE
        JPanel pathPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel path =  new JLabel("Buy");
        
        path.setFont(path.getFont().deriveFont(10.0f)); // Set the font size
        path.setAlignmentX(Component.LEFT_ALIGNMENT); 
        pathPanel.add(path);
        pathPanel.setBackground(Color.YELLOW);
        // Add the label to the content pane of the JFrame
        add(pathPanel, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Buy Your Ticket");
        JLabel label1 = new JLabel("Please note you may only buy ONE ticket.");
        JLabel label2 = new JLabel("Please choose DIFFERENT shows!");

        label.setFont(label.getFont().deriveFont(16.0f)); // Set the font size
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align the label horizontally
        label1.setAlignmentX(Component.CENTER_ALIGNMENT); 
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createVerticalStrut(10)); // Add some spacing
        panel.add(label1);
        panel.add(Box.createVerticalStrut(10)); // Add some spacing
        panel.add(label2);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // Add the label to the content pane of the JFrame
        add(panel, BorderLayout.CENTER);

        // Add components to the panel
        panel.add(createShowComboBox());
        panel.add(createTextField("First Name: ", firstNameField = new JTextField()));
        panel.add(createTextField("Last Name: ", lastNameField = new JTextField()));
        panel.add(createTextField("Home Address: ", addressField = new JTextField()));
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.setBackground(Color.DARK_GRAY);
        // Add a button to perform the buy ticket action
        JButton buyButton = new JButton("PAY");
        
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedShow = (String) showComboBox.getSelectedItem();
                String selectedShow1 = (String) showComboBox1.getSelectedItem();
                String selectedShow2 = (String) showComboBox2.getSelectedItem();
//                String firstName = firstNameField.getText();
//                String lastName = lastNameField.getText();
//                String address = addressField.getText();
               
                // Check if the selected shows are distinct
                if (selectedShow.equals(selectedShow1) || selectedShow.equals(selectedShow2) || selectedShow1.equals(selectedShow2)) {
                    JOptionPane.showMessageDialog(BuyTicketGUI.this, "Please select distinct shows for each dropdown.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method to prevent further processing
                }
                
                ticketInfo.addChoice(selectedShow);
                ticketInfo.addChoice(selectedShow1);
                ticketInfo.addChoice(selectedShow2);
                
                setVisible(false);
				PaymentGUI bsg;
				try {
					bsg = new PaymentGUI(ticketInfo);
					bsg.show();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

                // CREATE A BUY TICKET CLASS
//                System.out.println("Selected Show 1 : " + selectedShow);
//                System.out.println("Selected Show 2: " + selectedShow1);
//                System.out.println("Selected Show 3: " + selectedShow2);
//                System.out.println("First Name: " + firstName);
//                System.out.println("Last Name: " + lastName);
//                System.out.println("Home Address: " + address);
//                System.out.println("")
            }
        });
        
        buttonPanel.add(buyButton);
		add(buttonPanel, BorderLayout.SOUTH);

        // Add the panel to the content pane of the JFrame
        add(panel);

        // Fetch Broadway show data from the database and populate the table
        fetchData();
    }
	
	private void fetchData() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT show_name, show_date, show_time FROM broadway2";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold Broadway show data
            List<String> showList = new ArrayList<>();
            List<String> showList1 = new ArrayList<>();
            List<String> showList2 = new ArrayList<>();
            // Populate the list with data from the ResultSet
            while (resultSet.next()) {
                String showName = resultSet.getString("show_name");
                showList.add(showName);
                showList1.add(showName);
            }
            // Populate the showComboBox
            showComboBox.setModel(new DefaultComboBoxModel<String>(showList.toArray(new String[0])));
            showComboBox1.setModel(new DefaultComboBoxModel<String>(showList1.toArray(new String[0])));
            showComboBox2.setModel(new DefaultComboBoxModel<String>(showList1.toArray(new String[0])));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private JPanel createShowComboBox() {
        // Create a panel with a label and a JComboBox
        JPanel comboBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("Select Broadway Show: ");
        showComboBox = new JComboBox<>();
        JLabel label1 = new JLabel("Select Broadway Show: ");
        showComboBox1 = new JComboBox<>();
        JLabel label2 = new JLabel("Select Broadway Show: ");
        showComboBox2 = new JComboBox<>();
        comboBoxPanel.add(label);
        comboBoxPanel.add(showComboBox);
        comboBoxPanel.add(label1);
        comboBoxPanel.add(showComboBox1);
        comboBoxPanel.add(label2);
        comboBoxPanel.add(showComboBox2);
        return comboBoxPanel;
    }

    private JPanel createTextField(String labelText, JTextField textField) {
        // Create a panel with a label and a JTextField
        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        textField.setColumns(20);
        textFieldPanel.add(label);
        textFieldPanel.add(textField);
        return textFieldPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BuyTicketGUI buyTicketGUI = new BuyTicketGUI();
            buyTicketGUI.setVisible(true);
        });
    }
}
