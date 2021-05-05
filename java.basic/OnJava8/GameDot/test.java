import java.util.*; 

public class test {
    public static void main(String[] args) {
        var arr = new ArrayList<Integer>();
        arr.add(12);
        RefrenceTest(arr);
    }

    private static void RefrenceTest(ArrayList<Integer> arr)
    {
        arr.add(12);

        arr = new ArrayList<Integer>();
    }
}
