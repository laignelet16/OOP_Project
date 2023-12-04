package com.example.broadwayroulette;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TO DO: 
// learn how to add an image
// this is the main frame that will show the options the customer can see
public class MainFrameGUI extends JFrame{
	public MainFrameGUI() {
		setTitle("Broadway Show Roulette");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		// image doesn't show up!!!!
		ImageIcon wheelIcon = new ImageIcon("DesktopCarouselLogoroulette.png");
		JLabel wheelLabel = new JLabel(wheelIcon);
		add(wheelLabel, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBackground(Color.DARK_GRAY);
		
		JButton b1 = new JButton("View Show Descriptions");
		JButton b2 = new JButton("Buy tickets");
		
		JButton exit = new JButton("Exit");
		
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(exit);
		add(buttonPanel, BorderLayout.SOUTH);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BroadwayShowGUI bsg = new BroadwayShowGUI();
				bsg.show();
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
