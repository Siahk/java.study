import com.siahk.pojo.Student;
import com.siahk.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        Student student = (Student)context.getBean("student");
        System.out.println(student.toString());

        /*
        * Student{
        *   name='qinjiang',
        *   address=Address{address='西安'},
        *   books=[红楼梦, 西游记, 水浒传, 三国演义],
        *   hobbies=[music, movie, picture],
        *   card={身份证=123434324234, 银行卡=23425234234234},
        *   games=[LOL, COC, Dota], wife='null',
        *   info={password=123456, sex=man, xuehao=31400029, username=root}
        * }
         * */
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user2", User.class);
        User user2 = context.getBean("user2", User.class);

        User user3 = context.getBean("user3", User.class);
        User user4 = context.getBean("user3", User.class);
        System.out.println("user3: " + user3.hashCode() + ", user4: " + user4.hashCode());
        System.out.println(user3==user4);
    }

}
