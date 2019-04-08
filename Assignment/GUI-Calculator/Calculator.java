import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Calculator extends JPanel implements ActionListener {
    private JTextField display = new JTextField("");
    private double result = 0;
    private String operator = "=";
    private boolean calculating = true;

    public Calculator() {
        setLayout(new BorderLayout());
        display.setEditable(false);
        display.setPreferredSize(new Dimension(70, 100));
        add(display, "North");
        Font bigFont = display.getFont().deriveFont(Font.PLAIN, 25f);
        display.setFont(bigFont);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 5));
        String buttonLabels = "789/%456*^123-|&0=+C";
        for (int i = 0; i < buttonLabels.length(); i++) {
            JButton b = new JButton(buttonLabels.substring(i, i + 1));
            b.setFont(bigFont);
            panel.add(b);
            b.addActionListener(this);
        }
        add(panel, "Center");
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(false);
        JFrame frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(300, 300);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Container contentPane = frame.getContentPane();
        contentPane.add(new Calculator());
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if ('0' <= cmd.charAt(0) && cmd.charAt(0) <= '9' || cmd.charAt(0) == '.') {
            if (calculating)
                display.setText(cmd);
            else
                display.setText(display.getText() + cmd);
            calculating = false;
        } else {
            if (cmd.charAt(0) == 'C') {
                cmd = "0";
                calculating = false;
                display.setText(cmd);
            }
            if (calculating) {
                if (cmd.equals("-")) {
                    display.setText(cmd);
                    calculating = false;
                } else
                    operator = cmd;
            } else {
                double x = Double.parseDouble(display.getText());
                calculate(x);
                operator = cmd;
                calculating = true;
            }
        }
    }

    private void calculate(double n) {
        if (operator.equals("+"))
            result += n;
        else if (operator.equals("-"))
            result -= n;
        else if (operator.equals("*"))
            result *= n;
        else if (operator.equals("/"))
            result /= n;
        else if (operator.equals("%"))
            result %= n;
        else if (operator.equals("^"))
            result = Math.pow(result, n);
        else if (operator.equals("|"))
            result = (long) result | (long) n;
        else if (operator.equals("="))
            result = n;
        else if (operator.equals("&"))
            result = (long) result & (long) n;
        else if (operator.equals("C")) {
            result = 0;
        }
        display.setText("" + result);
    }
}
