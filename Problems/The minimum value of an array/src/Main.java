import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int result= 999;
        while (scanner.hasNext()) {
            int value = scanner.nextInt();
            if (value < result) {
                result = value;
            }

        }
        System.out.println(result);
    }
}