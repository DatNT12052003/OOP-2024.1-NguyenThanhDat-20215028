package hust.soict.dsai.lab01;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập hệ số a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập hệ số b: ");
        double b = sc.nextDouble();
        System.out.print("Nhập hệ số c: ");
        double c = sc.nextDouble();
        
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình vô nghiệm.");
            } else {
                double x = -c / b;
                System.out.println("Phương trình có nghiệm: x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;
            
            if (delta < 0) {
                System.out.println("Phương trình vô nghiệm.");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Phương trình có nghiệm kép: x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Phương trình có hai nghiệm: x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }
}

