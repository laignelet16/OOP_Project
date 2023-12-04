import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewTicketGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JLabel lblConfNo;
	private JLabel lblShowName;
	private JLabel lblPayment;
	private JLabel lblLoc;
	private JLabel lblDayTime;
	private JButton btnExit;
	
	public ViewTicketGUI() {
		frame = new JFrame("Ticket Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 412, 239);
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
		
		lblLoc = new JLabel("Show Location: ");
		lblLoc.setBounds(55, 62, 61, 16);
		contentPane.add(lblLoc);
		
		lblDayTime = new JLabel("Show Day/Time: ");
		lblDayTime.setBounds(55, 62, 61, 16);
		contentPane.add(lblDayTime);
		
		btnExit = new JButton("X");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnExit.setBounds(70, 134, 117, 29);
		contentPane.add(btnExit);	
	}
	public void exit() {
		//exit application
	}	
}