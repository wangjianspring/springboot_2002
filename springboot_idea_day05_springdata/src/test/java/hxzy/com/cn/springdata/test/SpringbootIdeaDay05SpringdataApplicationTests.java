package hxzy.com.cn.springdata.test;

import hxzy.com.cn.springdata.SpringDataTest;
import hxzy.com.cn.springdata.model.UserDomain;
import hxzy.com.cn.springdata.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {SpringDataTest.class})
class SpringbootIdeaDay05SpringdataApplicationTests {
    @Autowired
    private UserServiceImpl userService;
    @Test
    void contextLoads() {
        UserDomain user = userService.queryUser("xiongrui");
        System.out.println(user);
    }

}
