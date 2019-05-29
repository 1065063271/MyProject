package action.induc;

import HibernateSessionFactory.HibernateSessionFactory;
import com.empty.ProductEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class InducInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;
    public InducInfo(){
    }
    public List<ProductEntity> queryInfo(int i){
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        List<ProductEntity> list=null;
        try{
            String hqlsql="from ProductEntity pro where pro.ProductId="+i;
            query=session.createQuery(hqlsql,ProductEntity.class);
            list=query.list();
        }catch(Exception e){
            System.out.print("yicahngLoginRegisterInfo");
            e.printStackTrace();
        }
        return list;
    }
}
