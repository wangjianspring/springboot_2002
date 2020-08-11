package hxzy.com.cn.springdata.service;

import hxzy.com.cn.springdata.dao.IUserDaoRepository;
import hxzy.com.cn.springdata.model.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: UserServiceImpl
 * DATE: 2020/7/23
 * TIME: 10:10
 * Company: 侠客岛
 * JDK 1.8
 */
@Service
public class UserServiceImpl {
    @Autowired
  private IUserDaoRepository userDao;

  public UserDomain queryUser(String userName){
      return userDao.findByUserNameEquals(userName);
  }

}
