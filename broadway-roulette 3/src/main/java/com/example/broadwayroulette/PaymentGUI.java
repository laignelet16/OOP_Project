package com.example.broadwayroulette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// finish the next step which is resale and showing the ticket which has to do with the randomization
// learn how to show images
public class PaymentGUI extends JFrame{
	private JTextField cardName;
	private JTextField cardNum;
	private JTextField CVV;
	private JTextField cardDate;
	
	
	public PaymentGUI(TicketInfo ticketInfo) throws ParseException {
		setTitle("Pay for Tickets");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      LABEL PANEL TO SHOW WHERE YOU ARE
        JPanel pathPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel path =  new JLabel("Buy > Payment");
        
        path.setFont(path.getFont().deriveFont(10.0f)); // Set the font size
        path.setAlignmentX(Component.LEFT_ALIGNMENT); 
        pathPanel.add(path);
        pathPanel.setBackground(Color.YELLOW);
        // Add the label to the content pane of the JFrame
        add(pathPanel, BorderLayout.NORTH);
        
        
//		three buttons: exit, back, and then go to the main
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
			
		JLabel label =  new JLabel("Pay for Tickets");
		JLabel label1 = new JLabel("Please follow the labels");
		JLabel stars1 = new JLabel("****************************************************");
		JLabel total = new JLabel("Total Cost (including with tax)"); 
		JLabel cost = new JLabel("$46");
		JLabel stars2 = new JLabel("****************************************************");
		
		label.setFont(label.getFont().deriveFont(20.0f)); // Set the font size
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align the label horizontally
        label1.setFont(label.getFont().deriveFont(10.0f));
        label1.setAlignmentX(Component.CENTER_ALIGNMENT); 
        stars1.setAlignmentX(Component.CENTER_ALIGNMENT);
        cost.setAlignmentX(Component.CENTER_ALIGNMENT); 
        cost.setFont(label.getFont().deriveFont(30.0f));
        stars2.setAlignmentX(Component.CENTER_ALIGNMENT);
        total.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelPanel.add(label);
        labelPanel.add(label1);
        labelPanel.add(stars1);
        labelPanel.add(total);
        labelPanel.add(cost);
        labelPanel.add(stars2);
        // Add the label to the content pane of the JFrame
        add(labelPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(Color.DARK_GRAY);
		
//		BACK BUTTON
		JButton back = new JButton("BACK");
		add(buttonPanel, BorderLayout.SOUTH);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BuyTicketGUI bsg = new BuyTicketGUI();
				bsg.show();
			}
		}); 
		buttonPanel.add(back);
		
//		MAIN BUTTON
		JButton main = new JButton("MAIN");
		add(buttonPanel, BorderLayout.SOUTH);
		
		main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainFrameGUI frame = new MainFrameGUI();
				frame.show();
			}
		});
		buttonPanel.add(main);
		
		JButton confirm = new JButton("CONFIRM BUY");
		add(buttonPanel, BorderLayout.SOUTH);
		
//		Validation of the card information
//		confirm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (!isValidCardNumber(cardNum.getText())) {
//					JOptionPane.showMessageDialog(null, "Invalid Card Number. It can only be 6 digits.");
//					return;
//				}
//				if (!isValidCVV(CVV.getText())) {
//					JOptionPane.showMessageDialog(null, "Invalid CVV. It can only be 3 digits.");
//					return;
//				}
//				
//				if (!isValidCardDate(cardDate.getText())) {
//					JOptionPane.showMessageDialog(null, "Invalid Card Expiration Date. It can only be in this format mm/dd/yyyy");
//					return;
//				}
//				setVisible(false);
//				ShowTicketGUI bsg;
//				bsg = new ShowTicketGUI(ticketInfo);
//				bsg.show();
//			}
//		});
		confirmTicket(confirm, ticketInfo);
		
		buttonPanel.add(confirm);
		
		JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add components to the panel
        panel.add(createTextField("Name Seen on Card (e.g. Jane Doe) : ", cardName = new JTextField()));
        panel.add(createTextField("6 Digit Card Number: ", cardNum = new JTextField()));
        panel.add(createTextField("3 Digit CVV: ", CVV = new JTextField()));
        panel.add(createTextField("Card Date: (e.g. '03/15/2023')", cardDate = new JTextField()));
		
		add(panel);
	}
	
	private void confirmTicket(JButton confirm, TicketInfo ticketInfo) {
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isValidCardNumber(cardNum.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid Card Number. It can only be 6 digits.");
					return;
				}
				if (!isValidCVV(CVV.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid CVV. It can only be 3 digits.");
					return;
				}
				
				if (!isValidCardDate(cardDate.getText())) {
					JOptionPane.showMessageDialog(null, "Invalid Card Expiration Date. It can only be in this format mm/dd/yyyy");
					return;
				}
				setVisible(false);
				ShowTicketGUI bsg;
				bsg = new ShowTicketGUI(ticketInfo);
				bsg.show();
			}
		});
	}
	
	//	VALIDATION FUNCTIONS FOR CARD NUM, CVV, CARD DATE
	private boolean isValidCardNumber(String cardNumber) {
		return cardNumber.matches("\\d{6}");
	}
	
	private boolean isValidCVV(String CVV) {
		return CVV.matches("\\d{3}");
	}
	
	private boolean isValidCardDate(String cardDate) {
		try {
	        DateFormat format = new SimpleDateFormat("mm/dd/yyyy");
	        format.setLenient(false);
	        format.parse(cardDate);
	        return true;
		} catch (Exception e) {
			return false;
		}
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
            try {
                PaymentGUI gui = new PaymentGUI(BuyTicketGUI.ticketInfo);
                gui.setVisible(true);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }
}
