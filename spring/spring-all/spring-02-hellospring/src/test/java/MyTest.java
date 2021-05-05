import com.siahk.pojo.Hello;

import com.siahk.pojo.Hello;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取Spring的上下文对象！
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象现在都在Spring中管理了，我们要使用，直接从Spring中取出来就可以了。
        Hello hello = (Hello) context.getBean("hello");
        hello.show();
    }
}
