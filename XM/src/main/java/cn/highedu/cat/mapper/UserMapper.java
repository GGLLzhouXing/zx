package cn.highedu.cat.mapper;

import cn.highedu.cat.pojo.dto.UserRegDTO;
import cn.highedu.cat.pojo.vo.UserLogInfoVO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int addUser(UserRegDTO user);
     void checkUsername();
     UserLogInfoVO getByUsername(String username);
}
