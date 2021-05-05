import com.siahk.service.UserService;
import com.siahk.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        // 动态代理代理的是接口
        UserService userService =(UserService) context.getBean("userService");

        //
        userService.add();
    }
}