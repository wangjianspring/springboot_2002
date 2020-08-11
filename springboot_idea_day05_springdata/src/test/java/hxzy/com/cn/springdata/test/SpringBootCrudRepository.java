package hxzy.com.cn.springdata.test;

import hxzy.com.cn.springdata.SpringDataTest;
import hxzy.com.cn.springdata.dao.IUserDaoCRUDRepository;
import hxzy.com.cn.springdata.model.UserDomain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: SpringBootCrudRepository
 * DATE: 2020/7/23
 * TIME: 11:03
 * Company: 侠客岛
 * JDK 1.8
 */
@SpringBootTest(classes = {SpringDataTest.class})
public class SpringBootCrudRepository {
    @Autowired
    private IUserDaoCRUDRepository crudRepository;
    @Test
    void save(){
        UserDomain userDomain=new UserDomain();

        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
        userDomain.setBirthday("2020-07-24");
        userDomain.setNiceName("戴娇倩");
        userDomain.setUserName("戴娇倩");
        userDomain.setPassword("daijiaoqian");
        crudRepository.save(userDomain);
    }
    @Test
    void queryAll(){
        Iterable<UserDomain> sList = crudRepository.findAll();
        Iterator<UserDomain> its = sList.iterator();
        while(its.hasNext()){
        System.out.println(its.next());
        }
    }


}
