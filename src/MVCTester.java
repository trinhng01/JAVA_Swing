import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *  MVCTester
 * @author Trinh Nguyem
 * @version 1.0
 * @IDE: IntelliJ IDEA
 * 03/23/2019
 */

/**
 * The MVCTester add new text line into text area
 * while keeping the previous text lines
 */

public class MVCTester {
    public static void main(String[] args) {
        final Model model = new Model();

        JFrame frame = new JFrame();
        frame.setSize(100, 100);

        JButton addButton = new JButton("ADD");

        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea(30, 30);

        ChangeListener listener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                textArea.setText(model.getTextFromModel());
            }
        };
        model.addChangeListener(listener);

        addButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) {
                    String text = textField.getText();
                    model.addText(text);
                }
            }
        );

        frame.add(addButton, BorderLayout.NORTH);
        frame.add(textField, BorderLayout.SOUTH);
        frame.add(textArea, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
