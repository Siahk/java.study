import com.siahk.generic.Pair;

public class demo {
    public static void main(String[] args) {
        Pair<Double> a = new Pair<>(1.1, 2.2);
        Pair<String> b = new Pair<>("a", "b");
        System.out.println(a.getFirst());
    }
}
