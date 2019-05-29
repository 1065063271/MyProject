package action.shop;

import java.util.ArrayList;
import java.util.List;
import com.empty.ShopcartEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShopAction extends ActionSupport{

    private String owner;
    private String message="error";
    private List<ShopcartEntity> list=null;
    private List<ShopcartEntity> listT=new ArrayList<>();

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String execute(){

        ShopInfo info= new ShopInfo();
        owner="aaa";
        list=info.queryInfo(owner);
        listT.add(list.get(0));
        System.out.print(listT.size());


        for(int i=1;i<list.size();i++)
        {
            int x=0;
            for (int j=0;j<listT.size();j++)
            {
                if (list.get(i).getProductId().equals(listT.get(j).getProductId()))
                {
                    listT.get(j).setProductNum(listT.get(j).getProductNum()+1);
                    x=0;
                    break;
                }
                else
                {
                    x=x+1;
                }
            }
            if (x!=0)
                listT.add(list.get(i));
        }
        ActionContext.getContext().getSession().put("greeting3", listT);
        message=SUCCESS;
        return message;
    }
}