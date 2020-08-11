package hxzy.com.cn.springdata.dao;

import hxzy.com.cn.springdata.model.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: IUserDaoJpaRepository
 * DATE: 2020/7/24
 * TIME: 9:06
 * Company: 侠客岛
 * JDK 1.8
 */
public interface IUserDaoJpaRepository extends JpaRepository<UserDomain,Integer> {
}
