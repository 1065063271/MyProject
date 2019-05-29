package test;




import com.empty.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;


public class HibernateTest {


    public static void main(String[] a){
        //1.加载全局配置文件
        Configuration configuration = new Configuration().configure();
        //2.获取session工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //3.创建session对象
        Session session = sessionFactory.openSession();
        Transaction tr=session.beginTransaction();
        //4.操作数据
        UserEntity userEntity=new UserEntity();
        userEntity.setName("zhang");
        userEntity.setPass("12333");
        System.out.println("保存成功:" + session.save(userEntity));
        tr.commit();
        //5.关闭session
        session.close();
    }
}



