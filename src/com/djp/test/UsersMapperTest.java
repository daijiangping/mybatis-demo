package com.djp.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.djp.mapper.UsersMapper;
import com.djp.pojo.Orders;
import com.djp.pojo.Users;

public class UsersMapperTest {
	private SqlSessionFactory SqlSessionFactory;

	@Before
	// 在之前执行 加载总配置文件 得到sqlsessionFacoty
	public void setUp() {
		System.out.println("加载文件....");
		String resource = "SqlMapConfig.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 测试 根据ID查找用户
	 */
	@Test
	public void testFindUserById() {
		try {
			// 通过得到的SqlSessionFactory打开回话sqlSession
			SqlSession sqlSession = SqlSessionFactory.openSession();
			// 通过会话得到用户的代理
			UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
			// 调用代理的方法
			
			Users user1 = usersMapper.findUsersById(1);
			System.out.println("===================================================================");
			System.out.println(user1);
			System.out.println("===================================================================");
			sqlSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindUserLazyLoding() {
		try {
			SqlSession sqlSession = SqlSessionFactory.openSession();
			UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
			List<Orders> ps = usersMapper.findUsersLazyLoding();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
