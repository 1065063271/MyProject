package action.add;

import java.util.List;
import com.empty.ShopcartEntity;
import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport{

    private int productid;
    private String message="error";
    private List<ShopcartEntity> list=null;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String execute(){
        AddInfo info= new AddInfo();
        list=info.queryInfo(productid);
        message=SUCCESS;
        return message;
    }
}