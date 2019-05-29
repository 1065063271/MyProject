package action.induc;

import java.util.List;
import com.empty.ProductEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InducAction  extends ActionSupport{

    private int productid;
    private String message="error";
    private List<ProductEntity> list=null;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String execute(){
            InducInfo info= new InducInfo();
            list=info.queryInfo(productid);
            ActionContext.getContext().getSession().put("greeting2", list);
            System.out.println(123123);
            message=SUCCESS;
            return message;
    }
}