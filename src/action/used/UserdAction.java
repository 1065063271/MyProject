package action.used;

import java.util.List;
import com.empty.UserdEntity;
import com.opensymphony.xwork2.ActionSupport;

public class UserdAction extends ActionSupport{

    private String relname;
    private String address;
    private String tel;
    private String birthdate;
    private String message="error";
    private List<UserdEntity> list=null;

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String execute(){
        System.out.print(1231);
        String str="aaa";
        UserdInfo info= new UserdInfo();
        list=info.queryInfo(relname,address,tel,birthdate);
        message=SUCCESS;
        return message;
    }
}