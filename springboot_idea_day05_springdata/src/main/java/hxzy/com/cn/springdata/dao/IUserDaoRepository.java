package hxzy.com.cn.springdata.dao;

import hxzy.com.cn.springdata.model.UserDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: IUserDao
 * DATE: 2020/7/23
 * TIME: 10:02
 * Company: 侠客岛
 * JDK 1.8
 */
@org.springframework.stereotype.Repository
public interface IUserDaoRepository extends Repository<UserDomain,Integer> {
    //findBy+属性+条件
    public UserDomain findByUserNameEquals(String userName);

    public List<UserDomain> findByUserNameOrNiceName(String userName,String niceName);
    @Query(" from UserDomain where niceName=:niceName ")
    public UserDomain findByNiceNameOfHQL(@Param(value = "niceName") String niceName);
    @Query(value = "select * from s_user where id between ? and ? ",nativeQuery = true)
    public List<UserDomain> findByIdBetween(int minId,int maxId );

    @Query(value = "update  s_user set user_name=? where id=? ",nativeQuery = true)
    @Modifying//Modifying:因为@Query本身用来查询的，如果要执行更新则需要加modifying
    public void updateUserById(String userName,int id);

    @Query(value = "SELECT us.*, role.role_name, menu.menu_name FROM " +
            "  s_user us RIGHT JOIN s_role AS role ON role.id = us.role_id" +
            "  LEFT JOIN role_menu AS md ON md.role_id = role.id " +
            "  LEFT JOIN s_menu AS menu ON menu_id = md.menu_id ",nativeQuery = true)
    public List<?> findUserDomainAndRoleAndMenu();
}
