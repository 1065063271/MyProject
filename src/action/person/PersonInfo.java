package action.person;

import HibernateSessionFactory.HibernateSessionFactory;
import com.empty.UserdEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonInfo {
    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;
    public PersonInfo(){
    }
    public List<UserdEntity> queryInfo(String pn){
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        List<UserdEntity> list=null;
        try{
            String hqlsql="from UserdEntity userd where userd.name=\'" + pn+"\'";
            query=session.createQuery(hqlsql,UserdEntity.class);
            list=query.list();
        }catch(Exception e){
            System.out.print("yicahngLoginRegisterInfo");
            e.printStackTrace();
        }
        return list;
    }
}
