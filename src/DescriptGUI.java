import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class DescriptGUI extends JFrame {

	private JPanel contentPane;
	private JPanel buttonPanel;
	private JLabel lblDes;
	private JLabel lblShowOne;
	private JLabel lblShowTwo;
	private JLabel lblShowThree;
	private JLabel lblShowFour;
	private JLabel lblShowFive;
	private JButton btnMain;
	private JButton btnExit;
	private String[] selectedShows;

	public DescriptGUI(String[] selectedShows) {
		this.selectedShows = selectedShows;
		setTitle("Show Descriptions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		contentPane.add(Box.createVerticalStrut(20));
		
		lblDes = new JLabel("Descriptions for Current Shows");
		lblDes.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblDes.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(lblDes);
        
        contentPane.add(Box.createVerticalStrut(20));
		
		lblShowOne = createCenteredLabel("<html>Show Name: Wicked"
				+ "<br>Description: Wicked, the Broadway sensation, looks at what happened in the Land of Oz…but from a different angle. Long before Dorothy arrives, there is another girl, born with emerald-green skin—smart, fiery, misunderstood, and possessing an extraordinary talent. When she meets a bubbly blonde who is exceptionally popular, their initial rivalry turns into the unlikeliest of friendships…until the world decides to call one “good,” and the other one “wicked.”"
				+ "<br>Ticket Cost: $46"
				+ "<br>Schedule details: 10/14/2025 @ 4pm, Studio Jolibee</html>");
		contentPane.add(lblShowOne);
		contentPane.add(Box.createVerticalStrut(20));
		
		lblShowTwo = createCenteredLabel("<html>Show Name: Moulin Rouge!"
				+ "<br>Description: Enter a world of splendor and romance, of eye-popping excess, of glitz, grandeur and glory! A world where Bohemians and aristocrats rub elbows and revel in electrifying enchantment. Pop the champagne and prepare for the spectacular spectacular... Welcome to Moulin Rouge! The Musical."
				+ "<br>Baz Luhrmann’s revolutionary film comes to life onstage, remixed in a new musical mash-up extravaganza. A theatrical celebration of truth, beauty, freedom and—above all—LOVE, Moulin Rouge! is more than a musical; it is a state of mind.\r\n"
				+ "<br>How wonderful life is...at the Moulin Rouge."
				+ "<br>Ticket Cost: $46"
				+ "<br>Schedule details: 10/20/2025 @ 5pm, Studio Wendy’s</html>");
		contentPane.add(lblShowTwo);
		contentPane.add(Box.createVerticalStrut(20));
		
		lblShowThree = createCenteredLabel("<html>Show Name: Chicago"
				+ "<br>Description: Set in the legendary city during the roaring “jazz hot” 20s, Chicago tells the story of two rival vaudevillian murderesses locked up in Cook County Jail. Nightclub star Velma’s serving time for killing her husband and sister after finding the two in bed together. Driven chorus girl Roxie’s been tossed in the joint for bumping off the lover she’s been cheating on her husband with. Not one to rest on her laurels, Velma enlists the help of prison matron Mama Morton and slickster lawyer Billy Flynn, who turn Velma’s incarceration into a murder-of-the-week media frenzy, thus preparing the world for a splashy showbiz comeback. But Roxie’s got some of her own tricks up her sleeve…"
				+ "<br>Ticket Cost: $46"
				+ "<br>Schedule details: 10/10/2023 @ 6pm, Studio Dunkin</html>");
		contentPane.add(lblShowThree);
		contentPane.add(Box.createVerticalStrut(20));
		
		lblShowFour = createCenteredLabel("<html>Show Name: The Lion King"
				+ "<br>Description: "
				+ "A lively stage adaptation of the Academy Award-winning 1994 Disney film, The Lion King is the story of a young lion prince living in the flourishing African Pride Lands."
				+ "<br>When an unthinkable tragedy, orchestrated by Simba’s wicked uncle, Scar, takes his father’s life, Simba flees the Pride Lands, leaving his loss and the life he knew behind. Eventually companioned by two hilarious and unlikely friends, Simba starts anew. But when weight of responsibility and a desperate plea from the now ravaged Pride Lands come to find the adult prince, Simba must take on a formidable enemy, and fulfill his destiny to be king."
				+ "<br>Ticket Cost: $46"
				+ "<br>Schedule details: 10/07/2025 @ 7pm, Studio McDonald's</html>");
		contentPane.add(lblShowFour);
		contentPane.add(Box.createVerticalStrut(20));
		
		lblShowFive = createCenteredLabel("<html>Show Name: The Notebook"
				+ "<br>Description: Allie and Noah, both from different worlds, share a lifetime of love despite the forces that threaten to pull them apart. With a book that has sold millions of copies worldwide and a film that’s one of the highest-grossing romantic dramas of all-time, the musical adaptation of Nicholas Sparks’s The Notebook comes to Broadway following a critically acclaimed world premiere engagement at Chicago Shakespeare Theater in the fall of 2022."
				+ "<br>Ticket Cost: $46"
				+ "<br>Schedule details: 10/18/2025 @ 4pm, Studio Panera</html>");
		contentPane.add(lblShowFive);
		contentPane.add(Box.createVerticalStrut(20));
		
		buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
		btnMain = new JButton("Go back to Main Screen");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen(selectedShows);
			}
		});
		buttonPanel.add(btnMain);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		buttonPanel.add(btnExit);
		
		contentPane.add(Box.createVerticalStrut(20));
		
		contentPane.add(buttonPanel);
	}
	private JLabel createCenteredLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }
	public void mainScreen(String[] selectedShows) {
		MainGUI main = new MainGUI(selectedShows);
		main.setVisible(true);
	}
	public void exit() {
		dispose();
	}
}
