import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class PaymentGUI extends JFrame {

	private JPanel contentPane;
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
	private String[] selectedShows;
	private static String storedCardNo;
    private static String storedCardName;
    private static String storedAddress;
    private static String storedCvv;
    private static String storedCardExp;
	
	public PaymentGUI(String[] selectedShows) {
		this.selectedShows = selectedShows;
		setTitle("Payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
		
		lblDue = new JLabel("Amount Due: $40.00");
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        contentPane.add(lblDue, gbc);
		
		lblCardName = new JLabel("Name on Card:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
        contentPane.add(lblCardName, gbc);
		
		txtCardName = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtCardName, gbc);
        txtCardName.setColumns(10);
		
		lblCardNo = new JLabel("6-digit Card Number:");
		gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
	    contentPane.add(lblCardNo, gbc);
		
		txtCardNo = new JTextField();
		gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtCardNo, gbc);
        txtCardNo.setColumns(10);
		
		lblCardExp = new JLabel("Expiration Date:");
		gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        contentPane.add(lblCardExp, gbc);
		
		txtCardExp = new JTextField();
		gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtCardExp, gbc);
        txtCardExp.setColumns(10);
		
		lblCvv = new JLabel("CVV:");
		gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        contentPane.add(lblCvv, gbc);
		
		txtCvv = new JTextField();
		gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtCvv, gbc);
        txtCvv.setColumns(10);
		
		lblAddress = new JLabel("Billing Address:");
		gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        contentPane.add(lblAddress, gbc);
		
		txtAddress = new JTextField();
		gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(txtAddress, gbc);
        txtAddress.setColumns(10);
		
		btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storedCardNo = txtCardNo.getText();
                storedCardName = txtCardName.getText();
                storedAddress = txtAddress.getText();
                storedCvv = txtCvv.getText();
                storedCardExp = txtCardExp.getText();
                
                System.out.println("selectedShows: " + Arrays.toString(selectedShows));
                finalPageShow(selectedShows);
			}
		});
		gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        contentPane.add(btnPay, gbc);		
	}
	
	public static String getStoredCardNo() {
		return storedCardNo;
	}

	public static String getStoredCardName() {
		return storedCardName;
	}

	public static String getStoredAddress() {
	    return storedAddress;
	}

	public static String getStoredCvv() {
	    return storedCvv;
	}

	public static String getStoredCardExp() {
	    return storedCardExp;
	}
	
	public void finalPageShow(String[] selectedShows) {
		FinalPageGUI finalPage = new FinalPageGUI(selectedShows);
		finalPage.setVisible(true);
		dispose();
	}
}