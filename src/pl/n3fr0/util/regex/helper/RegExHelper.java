package pl.n3fr0.util.regex.helper;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExHelper {

    public static final Logger LOGGER = Logger.getLogger("RegExHelper");

    private JTextField tfRegex;
    private JTextArea taInput;
    private JTextArea taResult;
    private JPanel root;
    private JButton btTest;

    private final RegExTester tester = new RegExTester();

    private void updateText() {
        try {
            Pattern pattern = Pattern.compile(tfRegex.getText());
            Matcher matcher = pattern.matcher(taInput.getText());

            String result = tester.testExpression(matcher);
            taResult.setText(result);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "", e);
        }
    }

    public void buildUi(JFrame frame) {
        btTest.addActionListener((e) -> updateText());

        frame.setContentPane(root);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "ui", e);
        }

        SwingUtilities.invokeLater(() -> {
            JFrame main = new JFrame("RegExTool");
            new RegExHelper().buildUi(main);
        });
    }
}
