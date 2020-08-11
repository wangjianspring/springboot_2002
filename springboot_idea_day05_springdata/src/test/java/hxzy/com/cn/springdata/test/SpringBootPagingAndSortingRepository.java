package hxzy.com.cn.springdata.test;

import hxzy.com.cn.springdata.SpringDataTest;
import hxzy.com.cn.springdata.dao.IUserDaoCRUDRepository;
import hxzy.com.cn.springdata.dao.IUserDaoPagingAndSortingRepository;
import hxzy.com.cn.springdata.model.UserDomain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
public class SpringBootPagingAndSortingRepository {
    @Autowired
    private IUserDaoPagingAndSortingRepository crudRepository;
    @Test
    void findAll(){
        Sort sort= Sort.by(Sort.Order.desc("id"));
        Iterable<UserDomain> its = crudRepository.findAll(sort);
        for (UserDomain it : its) {
            System.out.println(it);
        }
    }
    @Test
    void pageSort(){
        Sort sort = Sort.by(Sort.Order.asc("id"));
        Pageable page= PageRequest.of(1,3,sort);
        Page<UserDomain> uList = crudRepository.findAll(page);
        System.out.println("总页数:"+uList.getTotalPages());
        System.out.println("总共有多少记录:"+ uList.getTotalElements());
        List<UserDomain> cList = uList.getContent();
        for (UserDomain userDomain : cList) {
            System.out.println(userDomain);
        }
    }
}
