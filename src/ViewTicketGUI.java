import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewTicketGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblConfNo;
	private JLabel lblShowName;
	private JLabel lblPayment;
	private JLabel lblLoc;
	private JLabel lblDayTime;
	private JButton btnExit;
	private JLabel lblTicketImage;
    private JLabel lblQrCode;
    
    private ImageIcon resizeImage(ImageIcon originalImage, int width, int height) {
        Image img = originalImage.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
	
	public ViewTicketGUI(String confirmationNumber, String paymentMethod, String showName, String location, String dayTime, String imagePath) {
		setTitle("Ticket Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("<html><div style='text-align: center; font-size: 20pt;'>Ticket Details</div></html>");
        lblTitle.setBounds(10, 10, 764, 30);
        contentPane.add(lblTitle);
		
		lblConfNo = new JLabel("Confirmation Number: " + confirmationNumber);
		lblConfNo.setBounds(55, 62, 61, 16);
		contentPane.add(lblConfNo);
		
		lblPayment = new JLabel("Payment Method: " + paymentMethod);
		lblPayment.setBounds(55, 62, 61, 16);
		contentPane.add(lblPayment);
		
		lblShowName = new JLabel("Show Name: " + showName);
		lblShowName.setBounds(55, 62, 61, 16);
		contentPane.add(lblShowName);
		
		lblLoc = new JLabel("Show Location: " + location);
		lblLoc.setBounds(55, 62, 61, 16);
		contentPane.add(lblLoc);
		
		lblDayTime = new JLabel("Show Day/Time: " + dayTime);
		lblDayTime.setBounds(55, 62, 61, 16);
		contentPane.add(lblDayTime);
		
		lblTicketImage = new JLabel();
        lblTicketImage.setBounds(10, 100, 300, 150); // Adjusted position and size
        contentPane.add(lblTicketImage);

        if (imagePath != null) {
            ImageIcon ticketImage = new ImageIcon(imagePath);
            ImageIcon resizedTicketImage = resizeImage(ticketImage, 300, 150);
            lblTicketImage.setIcon(resizedTicketImage);
        }

        lblQrCode = new JLabel();
        lblQrCode.setBounds(10, 320, 150, 150);
        contentPane.add(lblQrCode);

        // Replace 'path_to_your_qr_code_image' with the actual path to your QR code image file
        ImageIcon qrCodeImage = new ImageIcon("path_to_your_qr_code_image");
        if (qrCodeImage != null) {
            ImageIcon resizedQrCodeImage = resizeImage(qrCodeImage, 150, 150);
            lblQrCode.setIcon(resizedQrCodeImage);
        }

		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnExit.setBounds(70, 134, 117, 29);
		contentPane.add(btnExit);	
	}
	
	public void exit() {
		dispose();
	}	
}