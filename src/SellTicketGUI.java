import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellTicketGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblShowName;
	private JLabel lblLoc;
	private JLabel lblDayTime;
	private JLabel lblSellTix;
	private JTextField txtSellTix;
	private JLabel lblPerc;
	private JButton btnCancel;
	private JButton btnConfirm;
	private String[] selectedShows;
	
	public SellTicketGUI(String[] selectedShows) {
		this.selectedShows = selectedShows;
		setTitle("Sell Ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblShowName = new JLabel("Show Name: ");
		lblShowName.setBounds(55, 62, 61, 16);
		contentPane.add(lblShowName);
		
		lblLoc = new JLabel("Show Location: ");
		lblLoc.setBounds(55, 62, 61, 16);
		contentPane.add(lblLoc);
		
		lblDayTime = new JLabel("Show Day/Time: ");
		lblDayTime.setBounds(55, 62, 61, 16);
		contentPane.add(lblDayTime);
		
		lblSellTix = new JLabel("Sell Ticket For:");
		lblSellTix.setBounds(55, 62, 61, 16);
		contentPane.add(lblSellTix);
		
		txtSellTix = new JTextField();
		txtSellTix.setBounds(163, 20, 130, 26);
		contentPane.add(txtSellTix);
		txtSellTix.setColumns(10);
		
		lblPerc = new JLabel("You increased your ticket price by ____ %");
		lblPerc.setBounds(55, 62, 61, 16);
		contentPane.add(lblPerc);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel(selectedShows);
			}
		});
		btnCancel.setBounds(70, 134, 117, 29);
		contentPane.add(btnCancel);	
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirm(selectedShows);
			}
		});
		btnConfirm.setBounds(70, 134, 117, 29);
		contentPane.add(btnConfirm);	
	}
	public void cancel(String[] selectedShows) {
		dispose();
		FinalPageGUI finalPage = new FinalPageGUI(selectedShows);
		finalPage.setVisible(true);
	}
	public void confirm(String[] selectedShows) {
		dispose();
		SellFinalPageGUI sell = new SellFinalPageGUI(selectedShows);
		sell.setVisible(true);
	}
}