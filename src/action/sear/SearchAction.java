package action.sear;

import java.util.List;
import com.empty.ProductEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{

    private String productname;
    private String message="error";
    private List<ProductEntity> list=null;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String execute(){
        if(productname==null||productname.length()==0){
            addFieldError("product", "商品名不能为空!");
        }else{
            SearchInfo info= new SearchInfo();
            list=info.queryInfo(productname);
        }
        ActionContext.getContext().getSession().put("greeting1", list);
        message=SUCCESS;
        return message;
    }

}
