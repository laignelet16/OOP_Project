import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JLabel lblDue;
	private JLabel lblCardNo;
	private JLabel lblCardName;
	private JLabel lblAddress;
	private JLabel lblCvv;
	private JLabel lblCardExp;
	private JTextField txtCardNo;
	private JTextField txtCardName;
	private JTextField txtAddress;
	private JTextField txtCvv;
	private JTextField txtCardExp;
	private JButton btnPay;
	
	public PaymentGUI() {
		frame = new JFrame("Payment");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 412, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDue = new JLabel("Amount Due: $40.00");
		lblDue.setBounds(55, 62, 61, 16);
		contentPane.add(lblDue);
		
		lblCardName = new JLabel("Name on Card:");
		lblCardName.setBounds(55, 62, 61, 16);
		contentPane.add(lblCardName);
		
		txtCardName = new JTextField();
		txtCardName.setBounds(163, 20, 130, 26);
		contentPane.add(txtCardName);
		txtCardName.setColumns(10);
		
		lblCardNo = new JLabel("6-digit Card Number:");
		lblCardNo.setBounds(55, 62, 61, 16);
		contentPane.add(lblCardNo);
		
		txtCardNo = new JTextField();
		txtCardNo.setBounds(163, 20, 130, 26);
		contentPane.add(txtCardNo);
		txtCardNo.setColumns(10);
		
		lblCardExp = new JLabel("Expiration Date:");
		lblCardExp.setBounds(55, 62, 61, 16);
		contentPane.add(lblCardExp);
		
		txtCardExp = new JTextField();
		txtCardExp.setBounds(163, 20, 130, 26);
		contentPane.add(txtCardExp);
		txtCardExp.setColumns(10);
		
		lblCvv = new JLabel("CVV:");
		lblCvv.setBounds(55, 62, 61, 16);
		contentPane.add(lblCvv);
		
		txtCvv = new JTextField();
		txtCvv.setBounds(163, 20, 130, 26);
		contentPane.add(txtCvv);
		txtCvv.setColumns(10);
		
		lblAddress = new JLabel("Billing Address:");
		lblAddress.setBounds(55, 62, 61, 16);
		contentPane.add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(163, 20, 130, 26);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalPageShow();
			}
		});
		btnPay.setBounds(70, 134, 117, 29);
		contentPane.add(btnPay);		
		
	}
	public void finalPageShow() {
		FinalPageGUI finalPage = new FinalPageGUI();
		finalPage.show();
	}
}