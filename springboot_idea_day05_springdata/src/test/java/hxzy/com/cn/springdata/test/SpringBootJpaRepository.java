package hxzy.com.cn.springdata.test;

import hxzy.com.cn.springdata.SpringDataTest;
import hxzy.com.cn.springdata.dao.IMenuDaoJapReository;
import hxzy.com.cn.springdata.dao.IUserDaoJpaRepository;
import hxzy.com.cn.springdata.model.MenuDomain;
import hxzy.com.cn.springdata.model.RoleDomain;
import hxzy.com.cn.springdata.model.UserDomain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: SpringBootJpaRepository
 * DATE: 2020/7/24
 * TIME: 9:08
 * Company: 侠客岛
 * JDK 1.8
 */
@SpringBootTest(classes = {SpringDataTest.class})
public class SpringBootJpaRepository {
    @Autowired
    private IUserDaoJpaRepository jpaRepository;
    @Autowired
    private IMenuDaoJapReository menuDaoJapReository;
    @Test
    public void findAll(){
        List<UserDomain> uList = jpaRepository.findAll();
        for (UserDomain userDomain : uList) {
            System.out.println(userDomain);
        }
    }
    @Test
    @Transactional
    @Rollback(false)
    public void handleUserAndRole(){
        UserDomain user=new UserDomain();
        user.setUserName("王思聪");
        user.setNiceName("校长");
        user.setPassword("123456");
        user.setBirthday("2020-07-24");

        RoleDomain r1=new RoleDomain();
        r1.setRoleName("客服");

        //维护关系
        user.setRoles(r1);

        jpaRepository.save(user);
    }

    @Test
    public void handleMenu(){
        //menuDaoJapReository

        MenuDomain m1=new MenuDomain();
        m1.setMenuName("每周财务报表");

        RoleDomain r1=new RoleDomain();
        r1.setRoleName("会计");
        RoleDomain r2=new RoleDomain();
        r2.setRoleName("财务总监");

        //维护关系
        m1.getrList().add(r1);
        m1.getrList().add(r2);

        menuDaoJapReository.save(m1);
    }
}
