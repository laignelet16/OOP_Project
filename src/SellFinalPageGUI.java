import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellFinalPageGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblConf;
	private JLabel lblShowName;
	private JLabel lblTimeLeft;
	private JLabel lblConfNo;
	private JLabel lblPayment;
	private JLabel lblLoc;
	private JLabel lblDayTime;
	private JButton btnMain;
	private String[] selectedShows;
	
	public SellFinalPageGUI(String[] selectedShows) {
		this.selectedShows = selectedShows;
		setTitle("Confirmation Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConfNo = new JLabel("Confirmation Number: ");
		lblConfNo.setBounds(55, 62, 61, 16);
		contentPane.add(lblConfNo);
		
		lblPayment = new JLabel("Payment Method: ");
		lblPayment.setBounds(55, 62, 61, 16);
		contentPane.add(lblPayment);
		
		lblShowName = new JLabel("Show Name: ");
		lblShowName.setBounds(55, 62, 61, 16);
		contentPane.add(lblShowName);
		
		lblDayTime = new JLabel("Show Day/Time: ");
		lblDayTime.setBounds(55, 62, 61, 16);
		contentPane.add(lblDayTime);
		
		lblLoc = new JLabel("Show Location: ");
		lblLoc.setBounds(55, 62, 61, 16);
		contentPane.add(lblLoc);
		
		lblConf = new JLabel("You listed your ticket to be sold for ___");
		lblConf.setBounds(55, 62, 61, 16);
		contentPane.add(lblConf);
		
		lblTimeLeft = new JLabel("You have 30 days to sell your ticket, otherwise your ticket will not be refunded.");
		lblTimeLeft.setBounds(55, 62, 61, 16);
		contentPane.add(lblTimeLeft);
		
		btnMain = new JButton("Back to Home Screen");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen(selectedShows);
			}
		});
		btnMain.setBounds(70, 134, 117, 29);
		contentPane.add(btnMain);		
		
	}	
	public void mainScreen(String[] selectedShows) {
		MainGUI main = new MainGUI(selectedShows);
		main.setVisible(true);
		dispose();
	}
}