package hxzy.com.cn.springdata.dao;

import hxzy.com.cn.springdata.model.MenuDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: IMenuDaoJapReository
 * DATE: 2020/7/24
 * TIME: 10:51
 * Company: 侠客岛
 * JDK 1.8
 */
@Repository
public interface IMenuDaoJapReository extends JpaRepository<MenuDomain,Integer> {
}
