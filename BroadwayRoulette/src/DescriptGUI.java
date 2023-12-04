import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DescriptGUI extends JFrame {

	private JPanel contentPane;
	private JLabel descriptions;
	private JLabel showOne;
	private JLabel showTwo;
	private JLabel showThree;
	private JLabel showFour;
	private JLabel showFive;
	private JButton main;
	private JButton exit;
	
	public DescriptGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		descriptions = new JLabel("Show Descriptions");
		descriptions.setBounds(55, 25, 96, 16);
		contentPane.add(descriptions);
		
		showOne = new JLabel("Wicked: Wicked, the Broadway sensation, looks at what happened in the Land of Oz…but from a different angle. Long before Dorothy arrives, there is another girl, born with emerald-green skin—smart, fiery, misunderstood, and possessing an extraordinary talent. When she meets a bubbly blonde who is exceptionally popular, their initial rivalry turns into the unlikeliest of friendships…until the world decides to call one “good,” and the other one “wicked.”");
		showOne.setBounds(55, 25, 96, 16);
		contentPane.add(showOne);
		
		showTwo = new JLabel("Moulin Rouge!: Enter a world of splendor and romance, of eye-popping excess, of glitz, grandeur and glory! A world where Bohemians and aristocrats rub elbows and revel in electrifying enchantment. Pop the champagne and prepare for the spectacular spectacular... Welcome to Moulin Rouge! The Musical.\r\n"
				+ "\r\n"
				+ "Baz Luhrmann’s revolutionary film comes to life onstage, remixed in a new musical mash-up extravaganza. A theatrical celebration of truth, beauty, freedom and—above all—LOVE, Moulin Rouge! is more than a musical; it is a state of mind.\r\n"
				+ "\r\n"
				+ "How wonderful life is...at the Moulin Rouge.");
		showTwo.setBounds(55, 25, 96, 16);
		contentPane.add(showTwo);
		
		showThree = new JLabel("Chicago: Set in the legendary city during the roaring “jazz hot” 20s, Chicago tells the story of two rival vaudevillian murderesses locked up in Cook County Jail. Nightclub star Velma’s serving time for killing her husband and sister after finding the two in bed together. Driven chorus girl Roxie’s been tossed in the joint for bumping off the lover she’s been cheating on her husband with. Not one to rest on her laurels, Velma enlists the help of prison matron Mama Morton and slickster lawyer Billy Flynn, who turn Velma’s incarceration into a murder-of-the-week media frenzy, thus preparing the world for a splashy showbiz comeback. But Roxie’s got some of her own tricks up her sleeve…");
		showThree.setBounds(55, 25, 96, 16);
		contentPane.add(showThree);
		
		showFour = new JLabel("The Lion King: \r\n"
				+ "A lively stage adaptation of the Academy Award-winning 1994 Disney film, The Lion King is the story of a young lion prince living in the flourishing African Pride Lands.\r\n"
				+ "\r\n"
				+ "When an unthinkable tragedy, orchestrated by Simba’s wicked uncle, Scar, takes his father’s life, Simba flees the Pride Lands, leaving his loss and the life he knew behind. Eventually companioned by two hilarious and unlikely friends, Simba starts anew. But when weight of responsibility and a desperate plea from the now ravaged Pride Lands come to find the adult prince, Simba must take on a formidable enemy, and fulfill his destiny to be king.");
		showFour.setBounds(55, 25, 96, 16);
		contentPane.add(showFour);
		
		showFive = new JLabel("The Notebook: Allie and Noah, both from different worlds, share a lifetime of love despite the forces that threaten to pull them apart. With a book that has sold millions of copies worldwide and a film that’s one of the highest-grossing romantic dramas of all-time, the musical adaptation of Nicholas Sparks’s The Notebook comes to Broadway following a critically acclaimed world premiere engagement at Chicago Shakespeare Theater in the fall of 2022.");
		showFive.setBounds(55, 25, 96, 16);
		contentPane.add(showFive);
		
		main = new JButton("Main Screen");
		main.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen();
			}
		});
		main.setBounds(70, 134, 117, 29);
		contentPane.add(main);
		
		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		exit.setBounds(70, 134, 117, 29);
		contentPane.add(exit);
	}
	public void mainScreen() {
		//go back to main window
	}
	public void exit() {
		//exit application
	}
}
