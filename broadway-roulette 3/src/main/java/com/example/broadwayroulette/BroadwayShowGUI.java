package com.example.broadwayroulette;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BroadwayShowGUI extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public BroadwayShowGUI() {
        setTitle("Broadway Shows");
        setSize(1300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     // Create a JLabel with text
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("BROADWAY SHOWS");
        JLabel label1 = new JLabel("These are the available Broadway shows for the rest of 2023");

        label.setFont(label.getFont().deriveFont(16.0f)); // Set the font size
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align the label horizontally
        label1.setAlignmentX(Component.CENTER_ALIGNMENT); 

        labelPanel.add(label);
        labelPanel.add(label1);
        // Add the label to the content pane of the JFrame
        add(labelPanel, BorderLayout.NORTH);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        add(scrollPane);
        
//      BUTTON PANEL
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.setBackground(Color.DARK_GRAY);
		JButton back = new JButton("BACK");
		buttonPanel.add(back);
		add(buttonPanel, BorderLayout.SOUTH);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainFrameGUI bsg = new MainFrameGUI();
				bsg.show();
			}
		});

        // Fetch Broadway show data from the database and populate the table
        fetchData();
    }

    private void fetchData() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT show_name, show_date, show_time, show_description FROM broadway2";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold Broadway show data
            List<BroadwayShowModel> showList = new ArrayList<>();

            // Populate the list with data from the ResultSet
            while (resultSet.next()) {
                String showName = resultSet.getString("show_name");
                String date = resultSet.getString("show_date");
                String time = resultSet.getString("show_time");
                String description = resultSet.getString("show_description");

                // Create an instance of BroadwayShowModel and add it to the list
                BroadwayShowModel show = new BroadwayShowModel(showName, date, time, description);
                showList.add(show);
            }

            // Create a TableModel and set it to the JTable
            table.setModel(buildTableModel(showList));
         // Set the preferred width for the "Description" column
            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(3).setPreferredWidth(700);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DefaultTableModel buildTableModel(List<BroadwayShowModel> showList) {
        // Build a TableModel from the Broadway show list
        String[] columnNames = {"Show Name", "Date", "Time", "Description"};
        Object[][] data = new Object[showList.size()][4];

        for (int i = 0; i < showList.size(); i++) {
            BroadwayShowModel show = showList.get(i);
            data[i][0] = show.getShowName();
            data[i][1] = show.getDate();
            data[i][2] = show.getTime();
            data[i][3] = show.getDescription();
        }

        return new DefaultTableModel(data, columnNames);
     };


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BroadwayShowGUI gui = new BroadwayShowGUI();
            gui.setVisible(true);
        });
    }
}
