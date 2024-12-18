package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        // Sử dụng BorderLayout để thêm khoảng cách xung quanh
        setLayout(new BorderLayout(10, 10));

        // Panel chính chứa các Label và TextField
        Panel panelMain = new Panel(new GridLayout(2, 2, 10, 10));

        panelMain.add(new Label("Enter an Integer:"));
        tfInput = new TextField(10);
        tfInput.setFont(new Font("Arial", Font.PLAIN, 16));
        tfInput.addActionListener(new TFInputListener());
        panelMain.add(tfInput);

        panelMain.add(new Label("Accumulated Sum:"));
        tfOutput = new TextField(10);
        tfOutput.setFont(new Font("Arial", Font.BOLD, 16));
        tfOutput.setEditable(false);
        panelMain.add(tfOutput);

        // Thêm khoảng trống xung quanh panelMain bằng cách đặt nó vào BorderLayout.CENTER
        add(panelMain, BorderLayout.CENTER);

        // Thiết lập nút reset bên dưới
        Button btnReset = new Button("Reset");
        btnReset.setFont(new Font("Arial", Font.BOLD, 14));
        btnReset.addActionListener(e -> resetCalculator());
        add(btnReset, BorderLayout.SOUTH);

        // Cài đặt khung chính
        setTitle("AWT Accumulator");
        setSize(400, 200);
        setLocationRelativeTo(null); // Căn giữa màn hình
        setResizable(false); // Không cho phép thay đổi kích thước cửa sổ
        setVisible(true);
    }

    // Hàm reset tổng
    private void resetCalculator() {
        sum = 0;
        tfInput.setText("");
        tfOutput.setText("");
    }

    public static void main(String[] args) {
        new AWTAccumulator();
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
                tfInput.setText("");
                tfOutput.setText("Invalid input!");
            }
        }
    }
}
