import com.siahk.dao.UserDaoImpl;
import com.siahk.dao.UserDaoMysqlImpl;
import com.siahk.dao.UserDaoOracleImpl;
import com.siahk.dao.UserDaoSqlserverImpl;
import com.siahk.service.UserService;
import com.siahk.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

//        // 用户实际调用的是业务层，dao层他们不需要接触！
//        UserService userService = new UserServiceImpl();
//
//        ((UserServiceImpl) userService).setUserDao(new UserDaoSqlserverImpl());
//        userService.getUser();

        //获取ApplicationContext; 拿到Spring的容器！
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //需要什么，直接get！
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");

        userServiceImpl.getUser();

    }
}
