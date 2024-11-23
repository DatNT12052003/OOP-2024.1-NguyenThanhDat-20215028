package lab1;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySortAndAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = sc.nextInt();
        
        double[] array = new double[n];
        
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            array[i] = sc.nextDouble();
        }

        Arrays.sort(array);
        
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        double average = sum / n;

        System.out.println("Mảng đã sắp xếp: " + Arrays.toString(array));
        System.out.println("Tổng của mảng: " + sum);
        System.out.println("Giá trị trung bình của mảng: " + average);
    }
}

