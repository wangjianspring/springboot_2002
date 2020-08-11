package hxzy.com.cn.springdata.test;

import hxzy.com.cn.springdata.SpringDataTest;
import hxzy.com.cn.springdata.businessBean.UserMessage;
import hxzy.com.cn.springdata.dao.IUserDaoRepository;
import hxzy.com.cn.springdata.model.UserDomain;
import hxzy.com.cn.springdata.utils.ToEntityUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(classes = {SpringDataTest.class})
class SpringbootRepository {
    @Autowired
    private IUserDaoRepository userDao;
    @Test
    void contextLoads() {
        List<UserDomain> sList = userDao.findByUserNameOrNiceName("zhangsan", "mr_Xiong");
        System.out.println(sList);
    }
    @Test
    void testHql(){
        UserDomain mr_xiong = userDao.findByNiceNameOfHQL("mr_Xiong");
        System.out.println(mr_xiong);
    }
    @Test
    void testSql(){
        List<UserDomain> users = userDao.findByIdBetween(90, 93);
        //iter
        for (UserDomain user : users) {
            System.out.println(user);
        }
    }
    @Test
    @Transactional
    @Rollback(false)
    void updateUser(){
        userDao.updateUserById("maybee",90);
    }
    @Test
    void complex(){
        List<?> objs = userDao.findUserDomainAndRoleAndMenu();
       // String [] lables={"id","userName","password","niceName","birthday","roleId","roleName","menuName"};
        List<UserMessage>  userList= ToEntityUtil.toEntityList(objs, UserMessage.class, ToEntityUtil.getObjectFields(UserMessage.class));
        for (UserMessage userMessage : userList) {
            System.out.println(userMessage);
        }
    }
}
