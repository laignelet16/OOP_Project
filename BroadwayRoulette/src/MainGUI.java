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
		
		descriptions = new JButton("Descriptions");
		descriptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descriptShow();
			}
		});
		descriptions.setBounds(149, 53, 117, 29);
		contentPane.add(descriptions);
		
		startBuy = new JButton("Start Buy");
		startBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startBuyShow();
			}
		});
		startBuy.setBounds(149, 110, 117, 29);
		contentPane.add(startBuy);
	}
	
	public void descriptShow() {
		DescriptGUI descript = new DescriptGUI();
		descript.show();
	}
	
	public void startBuyShow() {
		BuyingGUI buy = new BuyingGUI();
		buy.show();
	}
	
	public void paymentShow() {
		PaymentGUI pay = new PaymentGUI();
		pay.show();
	}
	
	public void finalPageShow() {
		FinalPageGUI finalPage = new FinalPageGUI();
		finalPage.show();
	}
	
	public void viewTixShow() {
		ViewTicketGUI view = new ViewTicketGUI();
		view.show();
	}
	
	public void sellTixShow() {
		SellTicketGUI sell = new SellTicketGUI();
		sell.show();
	}
}