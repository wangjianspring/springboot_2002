package hxzy.com.cn.springdata.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: RoleDomain
 * DATE: 2020/7/24
 * TIME: 9:37
 * Company: 侠客岛
 * JDK 1.8 -一方
 */
@Entity
@Table(name = "s_role")
public class RoleDomain  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "role_name",length = 50)
    private String roleName;
    //每一个用户对应的角色
    @OneToMany(mappedBy ="roles" )
    private Set<UserDomain> users=new HashSet<UserDomain>();
    //每一个菜单对应的角色
    @ManyToMany(mappedBy ="rList" )
    private Set<MenuDomain> mList=new HashSet<>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserDomain> getUsers() {
        return users;
    }
    public void setUsers(Set<UserDomain> users) {
        this.users = users;
    }

    public Set<MenuDomain> getmList() {
        return mList;
    }

    public void setmList(Set<MenuDomain> mList) {
        this.mList = mList;
    }

    @Override
    public String toString() {
        return "RoleDomain{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
