package action.sred;

import HibernateSessionFactory.HibernateSessionFactory;
import com.empty.ShopcartEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SredInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;
    public SredInfo(){
    }
    public List<ShopcartEntity> queryInfo(int pid,String pn){
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        List<ShopcartEntity> list=null;
        ShopcartEntity shopcartEntity=new ShopcartEntity();
        try{
            String hqlsql="from ShopcartEntity shop where shop.productId=" +pid+" and shop.owner=\'"+pn+"\'";
            query=session.createQuery(hqlsql,ShopcartEntity.class);
            list=query.list();
            int i=list.get(0).getShopId();
            shopcartEntity=(ShopcartEntity)session.get(ShopcartEntity.class,i);
            transaction=session.beginTransaction();
            session.delete(shopcartEntity);
            transaction.commit();
        }catch(Exception e){
            System.out.print("yicahngLoginRegisterInfo");
            e.printStackTrace();
        }
        return list;
    }
}
