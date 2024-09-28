package lab1;

import java.util.Scanner;

public class LinearSystemTwoVariables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập a11: ");
        double a11 = sc.nextDouble();
        System.out.print("Nhập a12: ");
        double a12 = sc.nextDouble();
        System.out.print("Nhập a21: ");
        double a21 = sc.nextDouble();
        System.out.print("Nhập a22: ");
        double a22 = sc.nextDouble();
        System.out.print("Nhập b1: ");
        double b1 = sc.nextDouble();
        System.out.print("Nhập b2: ");
        double b2 = sc.nextDouble();
        
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        
        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Hệ phương trình có vô số nghiệm.");
            } else {
                System.out.println("Hệ phương trình vô nghiệm.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Nghiệm của hệ phương trình là: x1 = " + x1 + ", x2 = " + x2);
        }
    }
}
