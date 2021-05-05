import com.siahk.pojo.User;
import com.siahk.pojo.config.SiahkConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

        // 如果完全使用了配置类方式去做，就只能通过 AnnotationConfig 上下文来获取容器，通过配置类的class对象加载。
        ApplicationContext context = new AnnotationConfigApplicationContext(SiahkConfig.class);

        User getUser = context.getBean("user", User.class);
        System.out.println(getUser.getName());
    }
}
