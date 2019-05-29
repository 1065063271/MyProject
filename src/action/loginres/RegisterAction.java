package action.loginres;

import java.util.ArrayList;
import java.util.List;

import action.loginres.LoginRegisterInfo;
import com.empty.UserEntity;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

    private String username;
    private String password1;
    private String password2;
    private String mess=ERROR;    //ERROR等同于"error"
    private List<UserEntity> list=new ArrayList<>();

    public String getUsername() {
        return username;
    }
    public void setUsername(String userName) {
        this.username = userName;
    }
    public String getPassword1() {
        return password1;
    }
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    public String getPassword2() {
        return password2;
    }
    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void validate(){
        if(username==null||username.length()==0){
            addFieldError("userName", "用户名不能为空！");
        }else{
            LoginRegisterInfo info= new LoginRegisterInfo();
            list=info.queryInfo(username);
            for(int i=0;i<list.size();i++){
                if(list.get(i).getName().equals(username)){
                    addFieldError("userName", "用户名已存在！");
                }
            }
        }
        if(password1==null||password1.length()==0){
            addFieldError("password1", "登录密码不许为空！");
        }else if(password2==null||password2.length()==0){
            addFieldError("password2", "重复密码不许为空！");
        }else if(!password1.equals(password2)){
            addFieldError("password2", "两次密码不一致！");
        }
    }

    public UserEntity userInfo(){
        UserEntity u=new UserEntity();
        u.setName(this.getUsername());
        u.setPass(this.getPassword1());
        return u;
    }

    public String execute() throws Exception{
        LoginRegisterInfo lr=new LoginRegisterInfo();
        String ri=lr.saveInfo(userInfo());
        if(ri.equals("success")){
            mess=SUCCESS;
        }

        return mess;
    }

}
