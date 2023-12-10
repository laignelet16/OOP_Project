import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JScrollPane;

public class BuyingGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JLabel lblSelect;
	private JButton btnNext;
	String[] shows = {"Wicked", "Moulin Rouge!", "Chicago", "The Lion King", "The Notebook"};
	JComboBox<String> cb1 = new JComboBox<>(shows);
	JComboBox<String> cb2 = new JComboBox<>(shows);
	JComboBox<String> cb3 = new JComboBox<>(shows);
	private String[] selectedShows;
	
	public BuyingGUI(String[] selectedShows) {
		this.selectedShows = selectedShows;
		setTitle("Show Selection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(412, 239);

		contentPane = new JPanel(); 
		contentPane.setBorder(new EmptyBorder(30, 30, 30, 30));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane(contentPane);
        setContentPane(scrollPane);

		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		lblSelect = new JLabel("Select your top three shows");
		lblSelect.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblSelect.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        contentPane.add(lblSelect);
        contentPane.add(Box.createVerticalStrut(20));
		
		JPanel panel1 = createComboBoxPanel("Show 1: ", cb1);
        JPanel panel2 = createComboBoxPanel("Show 2: ", cb2);
        JPanel panel3 = createComboBoxPanel("Show 3: ", cb3);

        contentPane.add(panel1);
        contentPane.add(Box.createVerticalStrut(20));
        contentPane.add(panel2);
        contentPane.add(Box.createVerticalStrut(20));
        contentPane.add(panel3);
        contentPane.add(Box.createVerticalStrut(20));
        
        addComboBoxListener(cb1, cb2);
        addComboBoxListener(cb2, cb3);
        
        JLabel lblInstructions = new JLabel("Note: Once selected, your choices cannot be changed. Click 'Next' to proceed.");
        lblInstructions.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        contentPane.add(lblInstructions);
		
        btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update the selectedShows array based on user selections
                selectedShows[0] = (String) cb1.getSelectedItem();
                selectedShows[1] = (String) cb2.getSelectedItem();
                selectedShows[2] = (String) cb3.getSelectedItem();

                // Pass the updated selectedShows array to the paymentShow method
                paymentShow(selectedShows);
            }
        });
        contentPane.add(Box.createVerticalStrut(20));
        contentPane.add(btnNext);
	}
	
	private JPanel createComboBoxPanel(String labelText, JComboBox<String> comboBox) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel(labelText);
        panel.add(label, BorderLayout.WEST);
        panel.add(comboBox, BorderLayout.CENTER);
        return panel;
    }

	private void addComboBoxListener(JComboBox<String> source, JComboBox<String>... targets) {
	    source.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	                // Remove selected item from other combo boxes
	                String selectedItem = (String) source.getSelectedItem();
	                for (JComboBox<String> target : targets) {
	                    if (target != source) {
	                        target.removeItem(selectedItem);
	                    }
	                }

	                // Update the other combo boxes based on previous selections
	                for (JComboBox<String> target : targets) {
	                    if (target != source && target.getItemCount() == 0) {
	                        // If target combo box is empty, re-populate it with all options
	                        for (String show : shows) {
	                            if (!show.equals(selectedItem) && !isItemSelected(show, targets)) {
	                                target.addItem(show);
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    });
	}

	// Check if an item is already selected in any of the combo boxes
	private boolean isItemSelected(String item, JComboBox<String>... comboBoxes) {
	    for (JComboBox<String> comboBox : comboBoxes) {
	        if (comboBox.getSelectedItem() != null && comboBox.getSelectedItem().equals(item)) {
	            return true;
	        }
	    }
	    return false;
	}

	private void updateComboBox(JComboBox<String> comboBox, String selectedItem) {
	    List<String> itemsToRemove = new ArrayList<>();
	    for (int i = 0; i < comboBox.getItemCount(); i++) {
	        String item = comboBox.getItemAt(i);
	        if (item.equals(selectedItem)) {
	            itemsToRemove.add(item);
	        }
	    }

	    for (String itemToRemove : itemsToRemove) {
	        comboBox.removeItem(itemToRemove);
	    }

	    // Remove the selected item from the other combo boxes
	    for (JComboBox<String> otherComboBox : Arrays.asList(cb1, cb2, cb3)) {
	        if (otherComboBox != comboBox) {
	            otherComboBox.removeItem(selectedItem);
	        }
	    }

	    // Clear the selected item in the target combo box
	    comboBox.setSelectedItem(null);
	}

	 public void paymentShow(String[] selectedShows) {
		PaymentGUI pay = new PaymentGUI(selectedShows);
		pay.setVisible(true);
		dispose();
	}	
}
