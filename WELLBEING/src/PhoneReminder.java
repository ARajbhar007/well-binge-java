import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A simple Java Swing application that simulates a digital wellbeing assistant.
 * It provides a GUI window that toggles between "on" and "off" states when clicked.
 * This mimics the functionality of the HTML file but is a standalone desktop application.
 */
public class PhoneReminder {

    // Declare Swing components
    private JFrame frame;
    private JPanel screenPanel;
    private JLabel messageLabel;

    // A flag to track the state of the "screen"
    private boolean isScreenOff = false;

    /**
     * The main method to start the application.
     * It ensures that the GUI is created and updated on the Event Dispatch Thread (EDT).
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread to ensure thread safety
        SwingUtilities.invokeLater(() -> {
            new PhoneReminder().createAndShowGUI();
        });
    }

    /**
     * Sets up and displays the main application window and its components.
     */
    private void createAndShowGUI() {
        // Create the main application window (frame)
        frame = new JFrame("Digital Wellbeing Assistant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null); // Center the window

        // Create the main panel that acts as the screen
        screenPanel = new JPanel();
        screenPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering the message
        screenPanel.setBackground(Color.LIGHT_GRAY);

        // Create the message label
        messageLabel = new JLabel("Click anywhere to take a break.");
        messageLabel.setFont(new Font("Inter", Font.BOLD, 18));
        messageLabel.setForeground(Color.BLACK);
        screenPanel.add(messageLabel);

        // Add a mouse listener to handle clicks on the panel
        screenPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleScreenState();
            }
        });

        // Add the panel to the frame
        frame.add(screenPanel);
        frame.setVisible(true);
    }

    /**
     * Toggles the state of the screen between "on" and "off."
     * Updates the background color and the message text accordingly.
     */
    private void toggleScreenState() {
        if (isScreenOff) {
            // If the screen is off, turn it on
            screenPanel.setBackground(Color.LIGHT_GRAY);
            messageLabel.setForeground(Color.BLACK);
            messageLabel.setText("Click anywhere to take a break.");
            isScreenOff = false;
        } else {
            // If the screen is on, turn it off
            screenPanel.setBackground(Color.BLACK);
            messageLabel.setForeground(Color.WHITE);
            messageLabel.setText("Enough of phone use today.");
            isScreenOff = true;
        }
    }
}

