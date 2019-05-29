package action.sred;

import java.util.List;
import com.empty.ShopcartEntity;
import com.opensymphony.xwork2.ActionSupport;

public class SredAction  extends ActionSupport{

    private int productid;
    private String user;
    private String message="error";
    private List<ShopcartEntity> list=null;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String execute(){
        SredInfo info= new SredInfo();
        list=info.queryInfo(productid,user);
        message=SUCCESS;
        return message;
    }
}