package guii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUII extends JFrame implements ActionListener {

    private JRadioButton birdButton;
    private JRadioButton catButton;
    private JRadioButton dogButton;
    private JRadioButton rabbitButton;
    private JRadioButton pigButton;
    private ButtonGroup group;
    private JLabel picture;

    public GUII() {
        initComponents();
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Initialize radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Group the radio buttons
        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);
        
        // Select birdButton by default
        birdButton.setSelected(true);

        // Add action listeners
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        // Add radio buttons to a panel
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Add radio panel to the frame
        add(radioPanel, BorderLayout.WEST);

        // Initialize picture label
        picture = new JLabel();
        picture.setHorizontalAlignment(SwingConstants.CENTER);
        updatePicture("bird.jpeg");

        // Add picture label to the frame
        add(picture, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPet = "";
        if (e.getSource() == birdButton) {
            updatePicture("brrd.jpeg");
            selectedPet = "Bird";
        } else if (e.getSource() == catButton) {
            updatePicture("catt.jpeg");
            selectedPet = "Cat";
        } else if (e.getSource() == dogButton) {
            updatePicture("dog.jpeg");
            selectedPet = "Dog";
        } else if (e.getSource() == rabbitButton) {
            updatePicture("rabbit.jpg");
            selectedPet = "Rabbit";
        } else if (e.getSource() == pigButton) {
            updatePicture("pig.jpeg");
            selectedPet = "Pig";
        }
        
        // Display message dialog
        JOptionPane.showMessageDialog(this, "You selected: " + selectedPet);
    }

    private void updatePicture(String imagePath) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/" + imagePath));
            picture.setIcon(icon);
        } catch (Exception e) {
            System.err.println("Error loading image: " + imagePath);
            e.printStackTrace();
        }
    }

    private void initComponents() {
        // Method can remain empty or contain initial component setup
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUII().setVisible(true);
            }
        });
    }
}
