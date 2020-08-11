package hxzy.com.cn.springdata.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: MenuDomain
 * DATE: 2020/7/24
 * TIME: 10:38
 * Company: 侠客岛
 * JDK 1.8
 */
@Entity
@Table(name = "s_menu")
public class MenuDomain  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name = "menu_name",length = 50)
    private String menuName;

    //EAGER:；立即加载
    //Lazy: 延迟加载
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    //name:中间表的名称
    //joinColumns:当前实体在中间表的外键名称
    //joinColumns:另外一张表在中间表的外键名称
    @JoinTable(name="role_menu",joinColumns = @JoinColumn(name="menu_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
    private Set<RoleDomain> rList=new HashSet<RoleDomain>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Set<RoleDomain> getrList() {
        return rList;
    }

    public void setrList(Set<RoleDomain> rList) {
        this.rList = rList;
    }

    @Override
    public String toString() {
        return "MenuDomain{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
