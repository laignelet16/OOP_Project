import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalPageGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JLabel lblCongrats;
	private JLabel lblConfNo;
	private JLabel lblPayment;
	private JLabel lblLoc;
	private JLabel lblDayTime;
	private JButton btnViewTix;
	private JButton btnSellTix;
	private JButton btnMain;
	
	public FinalPageGUI() {
		frame = new JFrame("Confirmation Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 412, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCongrats = new JLabel("Congratulations! You are seeing a broadway show!");
		lblCongrats.setBounds(55, 62, 61, 16);
		contentPane.add(lblCongrats);
		
		lblConfNo = new JLabel("Confirmation Number: ");
		lblConfNo.setBounds(55, 62, 61, 16);
		contentPane.add(lblConfNo);
		
		lblPayment = new JLabel("Payment Method: ");
		lblPayment.setBounds(55, 62, 61, 16);
		contentPane.add(lblPayment);
		
		lblLoc = new JLabel("Show Location: ");
		lblLoc.setBounds(55, 62, 61, 16);
		contentPane.add(lblLoc);
		
		lblDayTime = new JLabel("Show Day/Time: ");
		lblDayTime.setBounds(55, 62, 61, 16);
		contentPane.add(lblDayTime);
		
		btnViewTix = new JButton("View Ticket");
		btnViewTix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTixShow();
			}
		});
		btnViewTix.setBounds(70, 134, 117, 29);
		contentPane.add(btnViewTix);	
		
		btnSellTix = new JButton("Sell Ticket");
		btnSellTix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellTixShow();
			}
		});
		btnSellTix.setBounds(70, 134, 117, 29);
		contentPane.add(btnSellTix);	
		
		btnMain = new JButton("Back to Home Screen");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen();
			}
		});
		btnMain.setBounds(70, 134, 117, 29);
		contentPane.add(btnMain);	
		
	}	
	public void viewTixShow() {
		ViewTicketGUI view = new ViewTicketGUI();
		view.show();
	}
	
	public void sellTixShow() {
		SellTicketGUI sell = new SellTicketGUI();
		sell.show();
	}
	
	public void mainScreen() {
		MainGUI main = new MainGUI();
		main.show();
	}
}