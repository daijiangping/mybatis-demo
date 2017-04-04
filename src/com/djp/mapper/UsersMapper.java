package com.djp.mapper;

import java.util.List;

import com.djp.pojo.Orders;
import com.djp.pojo.Users;

public interface UsersMapper {
	/**
	 * find user by id
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Users findUsersById(long id) throws Exception;

	/**
	 * 查询订单列表懒加载用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Orders> findUsersLazyLoding() throws Exception;
}
