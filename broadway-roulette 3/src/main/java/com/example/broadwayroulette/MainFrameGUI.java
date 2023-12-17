package com.example.broadwayroulette;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
//		viewShow.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				BroadwayShowGUI bsg = new BroadwayShowGUI();
//				bsg.show();
//			}
//		});
		
		viewShow(viewShow); 
		
		
//		buyTickets.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				BuyTicketGUI buy = new BuyTicketGUI();
//				buy.show();
//			}
//		});
		buyTicket(buyTickets);
		
		exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}
	
	private void viewShow(JButton viewShow) {
		viewShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BroadwayShowGUI bsg = new BroadwayShowGUI();
				bsg.show();
			}
		});
	}
	
	private void buyTicket(JButton buyTickets) {
		buyTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BuyTicketGUI buy = new BuyTicketGUI();
				buy.show();
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
