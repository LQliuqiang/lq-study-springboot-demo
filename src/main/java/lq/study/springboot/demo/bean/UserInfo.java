package lq.study.springboot.demo.bean;


import java.io.Serializable;

public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String info;

    public UserInfo(){}

    public UserInfo(Integer id, String username, String info) {
        this.id = id;
        this.username = username;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
