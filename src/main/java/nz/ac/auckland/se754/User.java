package nz.ac.auckland.se754;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void addPwd(String pwd) {
        list.add(pwd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
