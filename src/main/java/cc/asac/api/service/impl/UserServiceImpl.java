package cc.asac.api.service.impl;


import cc.asac.api.dao.UserMapper;
import cc.asac.api.domain.dto.UserDTO;
import cc.asac.api.domain.po.UserPO;
import cc.asac.api.domain.vo.UserVO;
import cc.asac.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户管理业务逻辑层
 * @author fox
 * @since 2020-04-26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserVO> userList(UserDTO userDTO) {
        return userMapper.userList(userDTO);
    }

    @Override
    public Boolean addUser(UserPO userPO) {
        userPO.setCreateTime(new Date());
        return userMapper.addUser(userPO) > 0;
    }

    @Override
    public Boolean updateUser(UserPO userPO) {
        userPO.setUpdateTime(new Date());
        return userMapper.updateUser(userPO) > 0;
    }

    @Override
    public Boolean logicDeleteUser(UserDTO userDTO) {
        UserPO userPO = new UserPO();
        userDTO.setId(userPO.getId());
        userDTO.setDel(1);
        return userMapper.updateUser(userPO) > 0;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return userMapper.deleteUser(id) > 0;
    }
}
