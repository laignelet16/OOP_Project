package com.example.broadwayroulette;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TO DO: 
// learn how to add an image
// this is the main frame that will show the options the customer can see

// This will always be on - because it never closes it 
public class MainFrameGUI extends JFrame{
	public MainFrameGUI() {
		setTitle("Broadway Show Roulette");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		// image doesn't show up!!!!
		ImageIcon wheelIcon = new ImageIcon("DesktopCarouselLogoroulette.png");
		JLabel wheelLabel = new JLabel(wheelIcon);
		add(wheelLabel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBackground(Color.DARK_GRAY);
		
		JButton viewShow = new JButton("View Show Descriptions");
		JButton buyTickets = new JButton("Buy tickets");
		
		JButton exit = new JButton("Exit");
		
		buttonPanel.add(viewShow);
		buttonPanel.add(buyTickets);
		buttonPanel.add(exit);
		add(buttonPanel, BorderLayout.SOUTH);
		
		viewShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BroadwayShowGUI bsg = new BroadwayShowGUI();
				bsg.show();
			}
		});
		
		buyTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BuyTicketGUI buy = new BuyTicketGUI();
				buy.show();
			}
		});
		
		exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrameGUI gui = new MainFrameGUI();
            gui.setVisible(true);
        });
    }
}
