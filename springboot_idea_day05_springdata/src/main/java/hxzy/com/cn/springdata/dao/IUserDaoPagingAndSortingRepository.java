package hxzy.com.cn.springdata.dao;

import hxzy.com.cn.springdata.model.UserDomain;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: IUserDaoPagingAndSortingRepository
 * DATE: 2020/7/23
 * TIME: 11:19
 * Company: 侠客岛
 * JDK 1.8
 */
@Repository
public interface IUserDaoPagingAndSortingRepository extends PagingAndSortingRepository<UserDomain,Integer>  {

}
