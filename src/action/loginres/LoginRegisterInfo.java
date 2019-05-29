package action.loginres;

import java.util.List;
import javax.swing.JOptionPane;

import HibernateSessionFactory.HibernateSessionFactory;
import com.empty.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class LoginRegisterInfo {

    private Session session;
    private Transaction transaction;
    private Query query;
    HibernateSessionFactory getSession;

    public LoginRegisterInfo(){
    }

    public String saveInfo(UserEntity u){
        String mess="error";
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        try{
            transaction=session.beginTransaction();
            session.save(u);
            transaction.commit();
            mess="success";
            return mess;
        }catch(Exception e){
            message("RegisterInfo.error:"+e);
            e.printStackTrace();
            return null;
        }
    }

    public List<UserEntity> queryInfo(String username){
        getSession=new HibernateSessionFactory();
        session=getSession.getSession();
        List<UserEntity> list=null;

        try{
            String hqlsql="from UserEntity user where user.name=\'" + username+"\'";
            query=session.createQuery(hqlsql,UserEntity.class);
            list=query.list();
        }catch(Exception e){
            System.out.print("yicahngLoginRegisterInfo");
            message("LoginRegisterInfo类中有异常，异常为：:"+e);
            e.printStackTrace();
        }
        return list;
    }


    public void message(String mess){
        int type=JOptionPane.YES_NO_OPTION;
        String title="提示信息";
        JOptionPane.showMessageDialog(null, mess,title,type);
    }

}