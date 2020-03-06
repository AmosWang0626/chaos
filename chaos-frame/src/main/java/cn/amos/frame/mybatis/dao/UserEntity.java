package cn.amos.frame.mybatis.dao;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * PROJECT: user
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/12/11
 */
@Accessors(chain = true)
@Data
public class UserEntity {

    private String account;
    private String username;
    private String salt;
    private String password;
    /**
     * 0: 禁用; 1: 启用
     */
    private Integer status;

    private Boolean deleteFlag;
    private LocalDateTime createTime;
    private String createUser;
    private LocalDateTime modifyTime;
    private String modifyUser;

}


