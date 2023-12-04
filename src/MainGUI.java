import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnDescript;
	private JButton btnStartBuy;
	
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnDescript = new JButton("Descriptions");
		btnDescript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descriptShow();
			}
		});
		btnDescript.setBounds(149, 53, 117, 29);
		contentPane.add(btnDescript);
		
		btnStartBuy = new JButton("Start Buy");
		btnStartBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startBuyShow();
			}
		});
		btnStartBuy.setBounds(149, 110, 117, 29);
		contentPane.add(btnStartBuy);
	}
	
	public void descriptShow() {
		DescriptGUI descript = new DescriptGUI();
		descript.show();
	}
	
	public void startBuyShow() {
		BuyingGUI buy = new BuyingGUI();
		buy.show();
	}

}