package com.smart.service;
import java.util.Date;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.smart.domain.User;
import static org.testng.Assert.*;

@ContextConfiguration("classpath*:/applicationContext.xml")//启动Spring容器
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests{
	private UserService userService;

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	@Test
	public void hasMatchUser(){
		boolean b1 = userService.hasMatchUser("admin","123456");
		boolean b2 = userService.hasMatchUser("admin","1111");
		assertTrue(b1);
		assertTrue(!b2);
	}

	@Test
	public void findUserByUserName(){
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
	}

}

