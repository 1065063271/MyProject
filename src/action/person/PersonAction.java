package action.person;

import java.util.List;
import com.empty.UserdEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport{

    private String username;
    private String message="error";
    private List<UserdEntity> list=null;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String execute(){

            String str="aaa";
            PersonInfo info= new PersonInfo();
            list=info.queryInfo(str);
            message=SUCCESS;
            ActionContext.getContext().put("greeting", list);
            return message;
    }
}