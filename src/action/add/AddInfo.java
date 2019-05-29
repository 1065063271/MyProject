package action.add;

import HibernateSessionFactory.HibernateSessionFactory;
import com.empty.ProductEntity;
import com.empty.ShopcartEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;
    public AddInfo(){
    }
    public List<ShopcartEntity> queryInfo(int i){
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        List<ShopcartEntity> list=null;
        List<ProductEntity> list1=null;
        ShopcartEntity add=new ShopcartEntity();
        try{
            String hqlsql="from ProductEntity pro where pro.ProductId="+i;
            query=session.createQuery(hqlsql,ProductEntity.class);
            list1=query.list();
            add.setOwner("aaa");
            add.setProductId(list1.get(0).getProductId());
            add.setProductName(list1.get(0).getProductName());
            add.setProductNum(1);
            add.setProductPrice(list1.get(0).getProductPrice());
            transaction=session.beginTransaction();
            session.save(add);
            transaction.commit();
        }catch(Exception e){
            System.out.print("yicahngLoginRegisterInfo");
            e.printStackTrace();
        }
        return list;
    }
}
