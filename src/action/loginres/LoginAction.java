package action.loginres;

import java.util.List;
import com.empty.UserEntity;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

    private String username;
    private String password;
    private String message="error";
    private List<UserEntity> list=null;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {

        System.out.print(username);
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String execute(){
        if(username==null||username.length()==0){
            addFieldError("userName", "用户名不能为空!");
        }else{
            LoginRegisterInfo info= new LoginRegisterInfo();
            list=info.queryInfo(username);
            if(list!=null&&list.size()>0&&list.get(0).getPass().equals(password))
            {
                message=SUCCESS;
            }
        }
        return message;
    }
}