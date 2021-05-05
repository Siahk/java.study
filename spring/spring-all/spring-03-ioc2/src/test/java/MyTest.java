import com.siahk.pojo.User;
import com.siahk.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserT user = (UserT) context.getBean("userT2");
        user.show();
    }
}
