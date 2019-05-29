package action.used;

import HibernateSessionFactory.HibernateSessionFactory;
import com.empty.UserdEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UserdInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;
    public UserdInfo(){
    }
    public List<UserdEntity> queryInfo(String reln,String add,String tel,String birth ){
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        List<UserdEntity> list=null;
        UserdEntity user=new UserdEntity();
        try{
            user=(UserdEntity) session.load(UserdEntity.class,20000);
            user.setAddress(add);
            user.setBirthdate(birth);
            user.setRelname(reln);
            user.setTel(tel);
            transaction=session.beginTransaction();
            session.update(user);
            transaction.commit();
        }catch(Exception e){
            System.out.print("yicahngLoginRegisterInfo");
            e.printStackTrace();
        }
        return list;
    }
}
