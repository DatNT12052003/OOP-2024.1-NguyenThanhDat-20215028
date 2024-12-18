package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        // Cài đặt layout cho cửa sổ
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(10, 10)); // Thêm khoảng cách giữa các thành phần

        // Tạo panel chính với GridLayout
        JPanel panelMain = new JPanel(new GridLayout(2, 2, 10, 10));
        panelMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Thêm padding

        // Thêm label và input field
        JLabel lblInput = new JLabel("Enter an Integer: ");
        lblInput.setFont(new Font("Arial", Font.BOLD, 14));
        panelMain.add(lblInput);

        tfInput = new JTextField(10);
        tfInput.setFont(new Font("Arial", Font.PLAIN, 14));
        panelMain.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        JLabel lblOutput = new JLabel("The Accumulated Sum is: ");
        lblOutput.setFont(new Font("Arial", Font.BOLD, 14));
        panelMain.add(lblOutput);

        tfOutput = new JTextField(10);
        tfOutput.setFont(new Font("Arial", Font.BOLD, 14));
        tfOutput.setEditable(false);
        tfOutput.setBackground(Color.LIGHT_GRAY);
        panelMain.add(tfOutput);

        // Thêm panel chính vào cửa sổ
        cp.add(panelMain, BorderLayout.CENTER);

        // Thêm nút Reset phía dưới
        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Arial", Font.BOLD, 14));
        btnReset.setBackground(Color.RED);
        btnReset.setForeground(Color.WHITE);
        btnReset.addActionListener(e -> resetCalculator());
        cp.add(btnReset, BorderLayout.SOUTH);

        // Thiết lập các thuộc tính cho JFrame
        setTitle("Swing Accumulator");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Căn giữa màn hình
        setResizable(false); // Không cho phép thay đổi kích thước
        setVisible(true);
    }

    private void resetCalculator() {
        sum = 0;
        tfInput.setText("");
        tfOutput.setText("");
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn;
                tfInput.setText("");
                tfOutput.setText(String.valueOf(sum));
            } catch (NumberFormatException e) {
                tfOutput.setText("Invalid input!");
                tfInput.setText("");
            }
        }
    }
}
