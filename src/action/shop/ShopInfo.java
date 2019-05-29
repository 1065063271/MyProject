package action.shop;

import HibernateSessionFactory.HibernateSessionFactory;
import com.empty.ShopcartEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ShopInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;
    public ShopInfo(){
    }
    public List<ShopcartEntity> queryInfo(String owner){
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        List<ShopcartEntity> list=null;
        try{
            String hqlsql="from ShopcartEntity sc where sc.owner=\'" + owner+"\'";
            query=session.createQuery(hqlsql,ShopcartEntity.class);
            list=query.list();
        }catch(Exception e){
            System.out.print("yicahngLoginRegisterInfo");
            e.printStackTrace();
        }
        return list;
    }
}
