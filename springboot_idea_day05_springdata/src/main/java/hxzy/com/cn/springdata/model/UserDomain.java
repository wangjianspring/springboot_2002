package hxzy.com.cn.springdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: UserDomain
 * DATE: 2020/7/23
 * TIME: 9:32
 * Company: 侠客岛
 * JDK 1.8
 */
//多方
@Entity
@Table(name = "s_user")
public class UserDomain  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "user_name",length = 50)
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "nice_name")
    private String niceName;
    @Column(name = "birthday")
    private String birthday;
    //cascade；级联关系的配置
    //保存A的同时保存B
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private RoleDomain roles;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNiceName() {
        return niceName;
    }

    public void setNiceName(String niceName) {
        this.niceName = niceName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public RoleDomain getRoles() {
        return roles;
    }

    public void setRoles(RoleDomain roles) {
        this.roles = roles;
    }



    @Override
    public String toString() {
        return "UserDomain{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", niceName='" + niceName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
