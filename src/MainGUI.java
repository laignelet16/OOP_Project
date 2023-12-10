import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JPanel buttonPanel;
	private JLabel lblWelcome;
	private JLabel lblImage;
	private JButton btnDescript;
	private JButton btnStartBuy;
	private String[] selectedShows;
	
	private ImageIcon resizeImage(ImageIcon originalImage, int width, int height) {
		Image img = originalImage.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    return new ImageIcon(img);
	}
	
	public MainGUI(String[] selectedShows) {
		this.selectedShows = selectedShows;
		setTitle("Home Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		lblWelcome = new JLabel("Welcome to Broadway Show Roulette!");
		lblWelcome.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER); 
        contentPane.add(lblWelcome, BorderLayout.NORTH);
        
        ImageIcon originalImage = new ImageIcon("C:/Users/rolan/Downloads/Broadway.jpg"); 
        ImageIcon resizedImage = resizeImage(originalImage, 500, 400);
        lblImage = new JLabel(resizedImage); 
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblImage, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		btnDescript = new JButton("Descriptions");
		btnDescript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descriptShow(selectedShows);
			}
		});
		buttonPanel.add(btnDescript);
		
		btnStartBuy = new JButton("Start Buy");
		btnStartBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startBuyShow(selectedShows);
			}
		});
		buttonPanel.add(btnStartBuy);
		
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void descriptShow(String[] selectedShows) {
		DescriptGUI descript = new DescriptGUI(selectedShows);
		descript.setVisible(true);
	}
	
	public void startBuyShow(String[] selectedShows) {
		BuyingGUI buy = new BuyingGUI(selectedShows);
		buy.setVisible(true);
	}

}