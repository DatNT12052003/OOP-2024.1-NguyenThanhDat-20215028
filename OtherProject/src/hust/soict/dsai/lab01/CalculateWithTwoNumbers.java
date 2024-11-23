package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class CalculateWithTwoNumbers {

	public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("Nhập số thứ nhất: ");
        double num1 = Double.parseDouble(strNum1);
        
        String strNum2 = JOptionPane.showInputDialog("Nhập số thứ hai: ");
        double num2 = Double.parseDouble(strNum2);
        
        System.out.println("Tổng = " + (num1 + num2));
        System.out.println("Hiệu = " + (num1 - num2));
        System.out.println("Tích = " + (num1 * num2));
        if (num2 != 0) {
        	System.out.println("Thương = " + (num1 / num2));
        } else {
        	System.out.println("Không thể chia cho 0 !");
        }
    }

}
