import java.awt.EventQueue;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BuyingGUI extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JLabel lblSelect;
	private JButton btnNext;
	String[] shows = {"Wicked", "Moulin Rouge!", "Chicago", "The Lion King", "The Notebook"};
	final JComboBox<String> cb1 = new JComboBox<String>(shows);
	final JComboBox<String> cb2 = new JComboBox<String>(shows);
	final JComboBox<String> cb3 = new JComboBox<String>(shows);
	
	public BuyingGUI() {
		frame = new JFrame("Show Selection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 412, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSelect = new JLabel("Select your top three shows");
		lblSelect.setBounds(55, 25, 96, 16);
		lblSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblSelect);
		
		cb1.setMaximumSize(cb1.getPreferredSize());
		cb1.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(cb1);
		
		cb2.setMaximumSize(cb2.getPreferredSize());
		cb2.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(cb2);
		
		cb3.setMaximumSize(cb3.getPreferredSize());
		cb3.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(cb3);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentShow();
			}
		});
		btnNext.setBounds(70, 134, 117, 29);
		contentPane.add(btnNext);
	}
	
	public void paymentShow() {
		PaymentGUI pay = new PaymentGUI();
		pay.show();
	}
	
}
