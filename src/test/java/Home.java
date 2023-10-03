import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of your triangle: ");
        double lengthOfSides = input.nextDouble();
        double areaOfTriangle = lengthOfSides * lengthOfSides * Math.sqrt(3) / 4;

        double volumeOfTriangle = areaOfTriangle * lengthOfSides;

    }
}