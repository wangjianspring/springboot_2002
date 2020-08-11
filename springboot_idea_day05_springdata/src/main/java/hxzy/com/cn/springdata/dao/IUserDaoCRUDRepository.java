package hxzy.com.cn.springdata.dao;

import hxzy.com.cn.springdata.model.UserDomain;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: IUserDaoCRUDRepository
 * DATE: 2020/7/23
 * TIME: 11:02
 * Company: 侠客岛
 * JDK 1.8
 */
@Repository
public interface IUserDaoCRUDRepository extends CrudRepository<UserDomain,Integer> {

}
