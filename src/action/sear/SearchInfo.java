package action.sear;

import HibernateSessionFactory.HibernateSessionFactory;
import com.empty.ProductEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class SearchInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;
    public SearchInfo(){
    }
    public List<ProductEntity> queryInfo(String pn){
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        List<ProductEntity> list=null;
        String str=pn;
        try{
            String hqlsql="from ProductEntity product where product.ProductName like \'%" +str+"%\'";
            query=session.createQuery(hqlsql,ProductEntity.class);
            list=query.list();
        }catch(Exception e){
            System.out.print("yicahngLoginRegisterInfo");
            e.printStackTrace();
        }
        return list;
    }
}
