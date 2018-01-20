package com.bysj.stamps.sys.dao;

import com.bysj.stamps.sys.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lihf
 * @version 1.0
 * @address 邮政
 */
@Repository
public interface SysUserDao {
/**
 * 测试用 没有实际意义
 */
  List<User> queryUser();
}
