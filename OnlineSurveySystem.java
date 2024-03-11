import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class OnlineSurveySystem {
    JFrame frame;
    JPanel panel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public OnlineSurveySystem() {
        frame = new JFrame("Login - Online Survey System");
        panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Simulated authentication check
                if (authenticate(username, password)) {
                    frame.dispose(); // Close the login window
                    openSurveySystem(); // Open the survey system
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(loginButton, gbc);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        // Simulated authentication logic (replace with your actual authentication logic)
        return username.equals("admin") && password.equals("admin123");
    }

    private void openSurveySystem() {
        // Once authenticated, open the main survey system
        new SurveySystemMain();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OnlineSurveySystem();
            }
        });
    }
}

class SurveySystemMain {
    JFrame frame;
    JPanel panel;
    JMenuBar menuBar;
    JMenu mainMenu, surveyMenu;
    JMenuItem createSurveyItem, distributeSurveyItem, collectResponseItem;
    JLabel nameLabel, ratingLabel, feedbackLabel;
    JTextField nameField;
    JSlider ratingSlider;
    JTextArea feedbackArea;
    JButton submitButton;

    public SurveySystemMain() {
        frame = new JFrame("Online Survey System");
        panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        nameLabel = new JLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        nameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nameField, gbc);

        ratingLabel = new JLabel("Rating:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(ratingLabel, gbc);

        ratingSlider = new JSlider(JSlider.HORIZONTAL, 0, 5, 0);
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(ratingSlider, gbc);

        feedbackLabel = new JLabel("Feedback:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(feedbackLabel, gbc);

        feedbackArea = new JTextArea(5, 20);
        feedbackArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(scrollPane, gbc);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitFeedback();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(submitButton, gbc);

        frame.add(panel);

        // Create menu bar
        menuBar = new JMenuBar();
        mainMenu = new JMenu("Main");
        surveyMenu = new JMenu("Survey");
        createSurveyItem = new JMenuItem("Create Survey");
        distributeSurveyItem = new JMenuItem("Distribute Survey");
        collectResponseItem = new JMenuItem("Collect Response");

        // Add action listeners to menu items
        createSurveyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call method to handle survey creation
                createSurvey();
            }
        });

        distributeSurveyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call method to handle survey distribution
                distributeSurvey();
            }
        });

        collectResponseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call method to handle response collection
                collectResponse();
            }
        });

        // Add menu items to survey menu
        surveyMenu.add(createSurveyItem);
        surveyMenu.add(distributeSurveyItem);
        surveyMenu.add(collectResponseItem);

        // Add survey menu to main menu
        mainMenu.add(surveyMenu);

        // Add main menu to menu bar
        menuBar.add(mainMenu);

        // Set menu bar for the frame
        frame.setJMenuBar(menuBar);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createSurvey() {
        // Implement survey creation functionality here
        JOptionPane.showMessageDialog(frame, "Survey creation functionality will be implemented here.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void distributeSurvey() {
        // Implement survey distribution functionality here
        JOptionPane.showMessageDialog(frame, "Survey distribution functionality will be implemented here.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void collectResponse() {
        // Implement response collection functionality here
        JOptionPane.showMessageDialog(frame, "Response collection functionality will be implemented here.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void submitFeedback() {
        String name = nameField.getText();
        int rating = ratingSlider.getValue();
        String feedback = feedbackArea.getText();

        if (name.isEmpty() || feedback.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simulate storing feedback in database
        try {
            // Establish database connection (replace with your database connection logic)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/surveydb", "root", "Pass@7045");

            // Insert feedback into database
            PreparedStatement statement = conn.prepareStatement("INSERT INTO feedback (name, rating, feedback) VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setInt(2, rating);
            statement.setString(3, feedback);
            statement.executeUpdate();

            // Close connection
            conn.close();

            // Show success message and clear fields
            JOptionPane.showMessageDialog(frame, "Feedback submitted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        ratingSlider.setValue(0);
        feedbackArea.setText("");
    }
}
