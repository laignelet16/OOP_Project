import java.awt.EventQueue;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;

public class FinalPageGUI extends JFrame {

	private JPanel contentPane;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel buttonPanel;
	private JPanel congratsPanel;
	private JPanel showNamePanel;
	private JLabel lblCongrats;
	private JLabel lblShowName;
	private JLabel lblConfNo;
	private JLabel lblPayment;
	private JLabel lblLoc;
	private JLabel lblDayTime;
	private JButton btnViewTix;
	private JButton btnSellTix;
	private JButton btnMain;
	private JLabel[] lblTickets;
	private String[] selectedShows;
	private static String storedCardNo;
	private static String storedCardName;
	private static String storedAddress;
	private static String storedCvv;
	private static String storedCardExp;
	private static Map<String, String> showTicketImages;
	
	private ImageIcon resizeImage(ImageIcon originalImage, int width, int height) {
        Image img = originalImage.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
	
    private String getRandomShow(String[] selectedShows) {
        int randomIndex = (int) (Math.random() * selectedShows.length);
        return selectedShows[randomIndex];
    }
	
	private ImageIcon getTicketImage(String showName) {
		int resizedWidth = 300;
        int resizedHeight = 100;
		
        try {
            String imagePath = showTicketImages.get(showName);
            if (imagePath != null) {
                return resizeImage(new ImageIcon(imagePath), resizedWidth, resizedHeight);
            } else {
                // Provide a default image or handle the case when the image path is not found
                return resizeImage(new ImageIcon("path_to_default_ticket_image"), resizedWidth, resizedHeight);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	
	private String generateConfirmationNumber() {
        Random random = new Random();
        int confirmationNumber = 10000 + random.nextInt(90000); 
        return String.valueOf(confirmationNumber);
    }
	
	private void setShowInformation(JLabel label, String showName, String location, String address, String date) {
        ImageIcon resizedImage = getTicketImage(showName);
        label.setIcon(resizedImage);

        // Set the specific show information
        lblLoc.setText("Show Location: " + location);
        lblDayTime.setText("Show Day/Time: " + date + " @ " + getTimeForShow(showName));

        // Set the show name in lblShowName
        lblShowName.setText("<html><div style='text-align: center;'>The show you are seeing is....." + showName + ".</div></html>");
    }

    private String getTimeForShow(String showName) {
        switch (showName) {
            case "Wicked":
                return "4:00 PM";
            case "Moulin Rouge!":
                return "5:00 PM";
            case "Chicago":
                return "6:00 PM";
            case "The Lion King":
                return "7:00 PM";
            case "The Notebook":
                return "4:00 PM";
            default:
                return "6:00 PM";
        }
    }
	
	public FinalPageGUI(String[] selectedShows) {
		this.selectedShows = selectedShows;
		initializeShowTicketImages();
		setTitle("Confirmation Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1));
		
		lblTickets = new JLabel[5];
	    
	    topPanel = new JPanel(new GridLayout(2, 1));
		
        congratsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblCongrats = new JLabel("<html><div style='text-align: center;'>Congratulations! You are seeing a Broadway show!</div></html>");
        lblCongrats.setFont(lblCongrats.getFont().deriveFont(20.0f));
        congratsPanel.add(lblCongrats);
        topPanel.add(congratsPanel);
        
        lblShowName = new JLabel();
        lblShowName.setFont(lblShowName.getFont().deriveFont(20.0f));
        showNamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        showNamePanel.add(lblShowName);
        topPanel.add(showNamePanel);
        
        contentPane.add(topPanel);
        
        bottomPanel = new JPanel(new GridLayout(5, 1, 10, 10));
		
		lblConfNo = new JLabel("Confirmation Number: " + generateConfirmationNumber());
		bottomPanel.add(lblConfNo);
		
		lblPayment = new JLabel("Payment Method: ");
		bottomPanel.add(lblPayment);
		
		lblLoc = new JLabel("Show Location: ");
		bottomPanel.add(lblLoc);
		
		lblDayTime = new JLabel("Show Day/Time: ");
		bottomPanel.add(lblDayTime);
		
		for (int i = 0; i < lblTickets.length; i++) {
            lblTickets[i] = new JLabel();
            bottomPanel.add(lblTickets[i]);
        }
	    contentPane.add(bottomPanel);
	    
	    buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnViewTix = new JButton("View Ticket");
		btnViewTix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storedCardNo = PaymentGUI.getStoredCardNo();
                storedCardName = PaymentGUI.getStoredCardName();
                storedAddress = PaymentGUI.getStoredAddress();
                storedCvv = PaymentGUI.getStoredCvv();
                storedCardExp = PaymentGUI.getStoredCardExp();
				viewTixShow();
			}
		});
		btnViewTix.setFont(btnViewTix.getFont().deriveFont(14.0f));
		buttonPanel.add(btnViewTix);	
		
		btnSellTix = new JButton("Sell Ticket");
		btnSellTix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellTixShow(selectedShows);
			}
		});
		btnSellTix.setFont(btnSellTix.getFont().deriveFont(14.0f));
		buttonPanel.add(btnSellTix);	
		
		btnMain = new JButton("Back to Home Screen");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen(selectedShows);
			}
		});
		btnMain.setFont(btnMain.getFont().deriveFont(14.0f));
		buttonPanel.add(btnMain);	
		
		contentPane.add(buttonPanel);
		
		initializeLabels();
	}	
	
	private void initializeLabels() {
	    String[] locations = {"Studio Jolibee", "Studio Wendy's", "Studio Dunkin", "Studio McDonald's", "Studio Panera"};
	    String[] addresses = {"123 Wicked St, New York City", "125 Rouge St, New York City", "128 Donuts St, New York City", "120 Mickey St, New York City", "121 Bread St, New York City"};
	    String[] dates = {"October 14, 2025", "October 20, 2025", "October 10, 2025", "October 7, 2025", "October 18, 2025"};

	    for (int i = 0; i < lblTickets.length; i++) {
	        // Check for null values in selectedShows
	        if (selectedShows != null && i < selectedShows.length && selectedShows[i] != null) {
	            String selectedShow = selectedShows[i];
	            String location = locations[i];
	            String address = addresses[i];
	            String date = dates[i];

	            setShowInformation(lblTickets[i], selectedShow, location, address, date);
	        } else {
	            // Handle the case where selectedShows or its elements are null
	            // You can set default values or display an error message
	            System.out.println("Error: Invalid selectedShows array");
	        }
	    }
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
	
    public void viewTixShow() {
        // Retrieve the show information for the selected show
        String selectedShow = getRandomShow(selectedShows);
        String confirmationNumber = generateConfirmationNumber();
        String paymentMethod = getStoredCardNo().substring(getStoredCardNo().length() - 4); // Use the last 4 digits of the card number
        String showName = selectedShow;
        
        // Retrieve location, day, and time based on the selected show
        String location = getLocationForShow(selectedShow);
        String dayTime = getDayTimeForShow(selectedShow);

        String ticketImage = showTicketImages.get(selectedShow);

        // Create an instance of ViewTicketGUI with the show information
        ViewTicketGUI viewTicket = new ViewTicketGUI(confirmationNumber, paymentMethod, showName, location, dayTime, ticketImage);
        viewTicket.setVisible(true);
        dispose();
    }

 // Modify the getLocationForShow method
    private String getLocationForShow(String showName) {
        switch (showName) {
            case "Wicked":
                return "Studio Jolibee, 123 Wicked St, New York City";
            case "Moulin Rouge!":
                return "Studio Wendy's, 125 Rouge St, New York City";
            case "Chicago":
                return "Studio Dunkin, 128 Donuts St, New York City";
            case "The Lion King":
                return "Studio McDonald's, 120 Mickey St, New York City";
            case "The Notebook":
                return "Studio Panera, 121 Bread St, New York City";
            default:
                return "Unknown Location";
        }
    }

    // Modify the getDayTimeForShow method
    private String getDayTimeForShow(String showName) {
        switch (showName) {
            case "Wicked":
                return "October 14, 2025 @ 4:00 PM";
            case "Moulin Rouge!":
                return "October 20, 2025 @ 5:00 PM";
            case "Chicago":
                return "October 10, 2025 @ 6:00 PM";
            case "The Lion King":
                return "October 7, 2025 @ 7:00 PM";
            case "The Notebook":
                return "October 18, 2025 @ 4:00 PM";
            default:
                return "Unknown Day/Time";
        }
    }

	public void sellTixShow(String[] selectedShows) {
		SellTicketGUI sell = new SellTicketGUI(selectedShows);
		sell.setVisible(true);
	}
	
	public void mainScreen(String[] selectedShows) {
		MainGUI main = new MainGUI(selectedShows);
		main.setVisible(true);
	}
	
	private void initializeShowTicketImages() {
        showTicketImages = new HashMap<>();
        // Add entries for each show and its corresponding ticket image file path
        showTicketImages.put("Wicked", "C:/Users/rolan/Downloads/White Modern Event Concert Ticket-3.jpg");
        showTicketImages.put("Moulin Rouge!", "C:/Users/rolan/Downloads/White Modern Event Concert Ticket-4.jpg");
        showTicketImages.put("Chicago", "C:/Users/rolan/Downloads/White Modern Event Concert Ticket-7.jpg");
        showTicketImages.put("The Lion King", "C:/Users/rolan/Downloads/White Modern Event Concert Ticket-8.jpg");
        showTicketImages.put("The Notebook", "C:/Users/rolan/Downloads/White Modern Event Concert Ticket-10.jpg");
    }
}