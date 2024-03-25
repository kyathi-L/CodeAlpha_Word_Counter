import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {

    public WordCounterApp() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeComponents();
    }

    private void initializeComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel wordCountLabel = new JLabel("Word Count: 0");

        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText().trim();
                if (text.isEmpty()) {
                    wordCountLabel.setText("Word Count: 0");
                    return;
                }
                String[] words = text.split("\\s+");
                int wordCount = words.length;
                wordCountLabel.setText("Word Count: " + wordCount);
            }
        });

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(wordCountLabel, BorderLayout.SOUTH);
        mainPanel.add(countButton, BorderLayout.NORTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterApp().setVisible(true);
            }
        });
    }
}
