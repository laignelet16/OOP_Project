package com.example.broadwayroulette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TO DO: 
// must add a timer (5 minutes) 
// must add the ticket into a class

public class BuyTicketGUI extends JFrame{
	private JComboBox<String> showComboBox;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField addressField;
	
	public BuyTicketGUI() {
		setTitle("Buy Ticket");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     // Create a JLabel with text
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Buy Your Ticket");
        JLabel label1 = new JLabel("Please note you may only buy one ticket!");

        label.setFont(label.getFont().deriveFont(16.0f)); // Set the font size
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align the label horizontally
        label1.setAlignmentX(Component.CENTER_ALIGNMENT); 

        labelPanel.add(label);
        labelPanel.add(label1);
        // Add the label to the content pane of the JFrame
        add(labelPanel, BorderLayout.NORTH);
        // Create a panel with a vertical BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add components to the panel
        panel.add(createShowComboBox());
        panel.add(createTextField("First Name: ", firstNameField = new JTextField()));
        panel.add(createTextField("Last Name: ", lastNameField = new JTextField()));
        panel.add(createTextField("Home Address: ", addressField = new JTextField()));

        // Add a button to perform the buy ticket action
        JButton buyButton = new JButton("Pay Ticket");
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedShow = (String) showComboBox.getSelectedItem();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String address = addressField.getText();
                
                // CREATE A BUY TICKET CLASS
                System.out.println("Selected Show: " + selectedShow);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Home Address: " + address);
            }
        });

        panel.add(buyButton);

        // Add the panel to the content pane of the JFrame
        add(panel);

        // Fetch Broadway show data from the database and populate the table
        fetchData();
    }
	
	private void fetchData() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT show_name, show_date, show_time FROM broadway";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold Broadway show data
            List<String> showList = new ArrayList<>();
            // Populate the list with data from the ResultSet
            while (resultSet.next()) {
                String showName = resultSet.getString("show_name");
                showList.add(showName);
            }
            // Populate the showComboBox
            showComboBox.setModel(new DefaultComboBoxModel<String>(showList.toArray(new String[0])));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	private JPanel createShowComboBox() {
        // Create a panel with a label and a JComboBox
        JPanel comboBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("Select Broadway Show: ");
        showComboBox = new JComboBox<>();
        comboBoxPanel.add(label);
        comboBoxPanel.add(showComboBox);
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
