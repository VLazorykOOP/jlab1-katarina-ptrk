import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {

    public static void task1(String[] args) {
        //12 = 2 variant
        Scanner console = new Scanner (System.in);
        if((args == null) || args.length == 0) {
            System.out.println("No args provided.");
            System.out.println("1. Double");
            System.out.println("2. In int, Out - Double");
            System.out.println("3. In - double, out - int");
            System.out.println("Choose: ");
            int choose = console.nextInt();

            switch (choose) {
                case 1 -> {
                    double x, y, result;
                    System.out.println("Input x: ");
                    x = console.nextDouble();
                    System.out.println("Input y: ");
                    y = console.nextDouble();
                    result = 1/(x*y)+1/(x*x+y*y)*(x-y);
                    System.out.printf("Result: %f", result);
                }
                case 2 -> {
                    int x, y;
                    double result;
                    System.out.println("Input x: ");
                    x = console.nextInt();
                    System.out.println("Input y: ");
                    y = console.nextInt();
                    result = 1/(x*y)+1/(x*x+y*y)*(x-y);
                    System.out.printf("Result: %f", result);
                }
                case 3 -> {
                    double x, y;
                    int result;
                    System.out.println("Input x: ");
                    x = console.nextDouble();
                    System.out.println("Input y: ");
                    y = console.nextDouble();
                    result = (int) (1/(x*y)+1/(x*x+y*y)*(x-y));
                    System.out.printf("Result: %d", result);
                }
                default -> System.out.println("Error.");
            }
        } else {
            System.out.println("Args provided.");
            if(args.length == 1) {
                System.out.println("Only 1 argument provided. Assuming this as X.");
                double x = Double.parseDouble(args[0]);
                System.out.println("Print y: ");
                double y = console.nextDouble();
                double result = 1/(x*y)+1/(x*x+y*y)*(x-y);
                System.out.printf("Result: %f", result);
            } else if(args.length == 2) {
                System.out.println("Two arguments provided. Assuming this as X and Y");
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);
                double result = 1/(x*y)+1/(x*x+y*y)*(x-y);
                System.out.printf("Result: %f", result);
            }
        }
    }

    public static void task2() {
        //variant 12
        Scanner scanner = new Scanner(System.in);
        //input size
        System.out.print("Input size of array n: ");
        int n = scanner.nextInt();

        //create array
        int[] A = new int[n];
        //input array
        System.out.println("Input array elements:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int negativeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                //if element is <=, move it into start
                int temp = A[i];
                for (int j = i; j > negativeIndex; j--) {
                    A[j] = A[j - 1];
                }
                A[negativeIndex] = temp;
                negativeIndex++;
            }
        }

        //print result array
        System.out.println("Changed array:");
        for (int i = 0; i < n; i++) {
            System.out.print(A[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println(); //10 per row
            }
        }
    }

    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input matrix size n (n <= 15): ");
        int n = scanner.nextInt();

        if (n > 15) {
            System.out.println("Matrix size must be <= 15.");
            return;
        }

        int[][] A = new int[n][n];
        System.out.println("Input matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        //знаходження максимального елементу і його рядка
        int maxElement = A[0][0];
        int maxRowIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] > maxElement) {
                    maxElement = A[i][j];
                    maxRowIndex = i;
                }
            }
        }

        //виконання циклічного зсуву рядків
        int[][] shiftedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                shiftedMatrix[(i + n - maxRowIndex) % n][j] = A[i][j];
            }
        }

        //виведення матриці з циклічним зсувом
        System.out.println("Result:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(shiftedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //метод для підрахунку кількості букв 'А' або 'а' в слові
    private static int countLetterA(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == 'A' || c == 'a') {
                count++;
            }
        }
        return count;
    }

    public static void task4() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input text:");
        String text = scanner.nextLine();

        //split words by punctuation symbols
        String[] words = text.split("[\\s\\p{Punct}]+");

        Map<String, Integer> wordCounts = new HashMap<>();

        //searching for words
        int maxCount = 0;
        for (String word : words) {
            int count = countLetterA(word);
            if (count > maxCount) {
                maxCount = count;
                wordCounts.clear();
                wordCounts.put(word, count);
            } else if (count == maxCount && count != 0) {
                wordCounts.put(word, count);
            }
        }

        //print words
        System.out.println("Words where 'А' or 'а' occurs most times:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        System.out.println("1. Task 1");
        System.out.println("2. Task 2");
        System.out.println("3. Task 3");
        System.out.println("4. Task 4");
        System.out.print("Input task number: ");
        int task = -1;
        task = console.nextInt();
        switch(task) {
            case 1: task1(args); break;
            case 2: task2(); break;
            case 3: task3(); break;
            case 4: task4(); break;
            default:
                System.out.println("Wrong task number.");
        }
    }
}