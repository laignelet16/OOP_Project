import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyingGUI extends JFrame {

	private JPanel contentPane;
	private JLabel select;
	private JButton next;
	private JLabel showOne;
	private JLabel showTwo;
	private JLabel showThree;
	private JLabel showFour;
	private JLabel showFive;
	private JTextField pickOne;
	private JTextField pickTwo;
	private JTextField pickThree;
	private JTextField pickFour;
	private JTextField pickFive;
	
	public BuyingGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		select = new JLabel("Select your top three shows");
		select.setBounds(55, 25, 96, 16);
		contentPane.add(select);
		
		//have user put 0 next to show not wanted and 1 next to show they want
		
		showOne = new JLabel("Wicked");
		showOne.setBounds(55, 25, 96, 16);
		contentPane.add(showOne);
		
		pickOne = new JTextField();
		pickOne.setBounds(163, 20, 130, 26);
		contentPane.add(pickOne);
		pickOne.setColumns(10);
		
		showTwo = new JLabel("Moulin Rouge!");
		showTwo.setBounds(55, 25, 96, 16);
		contentPane.add(showTwo);
		
		pickTwo = new JTextField();
		pickTwo.setBounds(163, 20, 130, 26);
		contentPane.add(pickTwo);
		pickTwo.setColumns(10);
		
		showThree = new JLabel("Chicago");
		showThree.setBounds(55, 25, 96, 16);
		contentPane.add(showThree);
		
		pickThree = new JTextField();
		pickThree.setBounds(163, 20, 130, 26);
		contentPane.add(		pickThree);
		pickThree.setColumns(10);
		
		showFour = new JLabel("The Lion King");
		showFour.setBounds(55, 25, 96, 16);
		contentPane.add(showFour);
		
		pickFour = new JTextField();
		pickFour.setBounds(163, 20, 130, 26);
		contentPane.add(pickFour);
		pickFour.setColumns(10);
		
		showFive = new JLabel("The Notebook");
		showFive.setBounds(55, 25, 96, 16);
		contentPane.add(showFive);
		
		pickFive = new JTextField();
		pickFive.setBounds(163, 20, 130, 26);
		contentPane.add(pickFive);
		pickFive.setColumns(10);		
		
		next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//goes to the payment gui
			}
		});
		next.setBounds(70, 134, 117, 29);
		contentPane.add(next);
	
	}
}
