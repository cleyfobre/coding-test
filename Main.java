import java.util.*;

public class Main {

    public static void main(String[] args) {
        stackTest();

        queueTest();

        // 재귀함수는 스택 자료구조
        int factorial = factorialRecursive(5);
        System.out.println("factorial " + factorial);

        int gcd = gcd(192, 162);
        System.out.println("gcd: " + gcd);


        ArrayList<Integer> a = new ArrayList<>(Collections.nCopies(7*7,0));
        System.out.println(a);
    }

    private static void stackTest() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(3);
        stack.push(6);
        stack.pop();
        System.out.println("stack " + stack);
    }

    private static void queueTest() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(5);
        queue.add(2);
        queue.poll();
        System.out.println("queue " + queue);
    }

    private static int factorialRecursive(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorialRecursive(n-1);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

}
