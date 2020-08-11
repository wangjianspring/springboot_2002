package hxzy.com.cn.springdata.businessBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * USER: summer
 * CLASSNAME: UserMessage
 * DATE: 2020/7/24
 * TIME: 14:17
 * Company: 侠客岛
 * JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMessage implements Serializable {
    private int id;
    private String userName;
    private String password;
    private String niceName;
    private String birthday;
    private int roleId;
    private String roleName;
    private String menuName;
}
