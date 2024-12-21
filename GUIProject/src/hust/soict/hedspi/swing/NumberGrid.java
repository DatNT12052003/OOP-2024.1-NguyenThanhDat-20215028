package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        // Khởi tạo JTextField
        tfDisplay = new JTextField();
        tfDisplay.setFont(new Font("Arial", Font.BOLD, 20));
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        tfDisplay.setEditable(false); // Không cho người dùng nhập trực tiếp

        // Tạo JPanel chứa các nút bấm
        JPanel panelButtons = new JPanel(new GridLayout(4, 3, 10, 10));
        panelButtons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        addButtons(panelButtons);

        // Thêm các thành phần vào Container
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout(10, 10));
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        // Thiết lập các thông tin của JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(300, 400);
        setLocationRelativeTo(null); // Căn giữa màn hình
        setVisible(true);
    }

    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();
        
        // Thêm các nút số từ 1 đến 9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = createButton("" + i, btnListener);
            panelButtons.add(btnNumbers[i]);
        }

        // Thêm nút "DEL"
        btnDelete = createButton("DEL", btnListener);
        btnDelete.setBackground(Color.ORANGE);
        panelButtons.add(btnDelete);

        // Thêm nút số 0
        btnNumbers[0] = createButton("0", btnListener);
        panelButtons.add(btnNumbers[0]);

        // Thêm nút "C"
        btnReset = createButton("C", btnListener);
        btnReset.setBackground(Color.RED);
        btnReset.setForeground(Color.WHITE);
        panelButtons.add(btnReset);
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusPainted(false); // Loại bỏ viền focus khi bấm
        button.addActionListener(listener);
        return button;
    }

    // Lớp xử lý sự kiện
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                // Nếu là số, thêm vào tfDisplay
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                // Xóa ký tự cuối cùng nếu không rỗng
                String text = tfDisplay.getText();
                if (!text.isEmpty()) {
                    tfDisplay.setText(text.substring(0, text.length() - 1));
                }
            } else if (button.equals("C")) {
                // Xóa toàn bộ nội dung
                tfDisplay.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
