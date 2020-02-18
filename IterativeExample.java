public class IterativeExample {
    public static void main(String[] args) {
        System.out.println(sumNum(10));
    }

    public static int sumNum(int n) {
        int total = 0;
        for (int i = n; i > 0; i--){
            total += i;
        }
        return total;
    }
}