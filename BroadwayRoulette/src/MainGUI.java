import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JButton descriptions;
	private JButton startBuy;
	
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		descriptions = new JButton("Kg --> LB");
		descriptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descriptShow();
			}
		});
		descriptions.setBounds(149, 53, 117, 29);
		contentPane.add(descriptions);
		
		startBuy = new JButton("Cm --> Inch");
		startBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startBuyShow();
			}
		});
		startBuy.setBounds(149, 110, 117, 29);
		contentPane.add(startBuy);
	}
	
	public void descriptShow() {
		Descript descript = new Descript();
		descript.show();
	}
	
	public void startBuyShow() {
		
	}
		
}