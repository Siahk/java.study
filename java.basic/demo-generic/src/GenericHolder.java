public class GenericHolder<T> {
    private T a;

    public GenericHolder() {
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        GenericHolder<String> h3 = new GenericHolder<>();
        h3.set(new String()); // 此处有类型校验
        String a = h3.get();  // 无需类型转换
        //- h3.set("Not an Automobile"); // 报错
        //- h3.set(1);  // 报错
    }
}
