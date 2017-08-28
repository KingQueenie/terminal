package test.service;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.xgs.entity.Login;
import com.xgs.service.UserService;
import com.xgs.util.TerResult;

import test.TestBase;

public class TestUserService extends TestBase{
	private UserService service;
	@Before
	public void init() {
		service=super.getContext().getBean("userService",UserService.class);
	}
	@Test //用例-1:预期结果:用户不存在
	public void testCheckLogin1() {
		TerResult<Login> result=new TerResult<Login>();
		result=service.checkLogin("admin4", "5d93ceb70e2bf5daa84ec3d0cd2c731a", "0:0:0:0:0:0:0:1");
		System.out.println(result.getMsg());
	}
	@Test //用例-2:预期结果:密码错误
	public void testCheckLogin2() {
		TerResult<Login> result=new TerResult<Login>();
		result=service.checkLogin("admin", "1234", "0:0:0:0:0:0:0:1");
		System.out.println(result.getMsg());
	}
	@Test //用例-3:预期结果:登录成功
	public void testCheckLogin3() {
		TerResult<Login> result=new TerResult<Login>();
		result=service.checkLogin("admin", "62c8ad0a15d9d1ca38d5dee762a16e01", "0:0:0:0:0:0:0:1");
		System.out.println(result.getMsg());
		System.out.println(result.getExData());
		System.out.println(result.getData());
	}
	
	@Test //用例-1:预期结果:注册成功
	public void testAddUser1() {
		TerResult<Object> result = service.addUser("jiujiu", "5d93ceb70e2bf5daa84ec3d0cd2c731a", 22, "male", "431299780@qq.com", "18900564321", "xi");
		System.out.println(result.getMsg());
	}
	@Test //用例-2:预期结果:用户名已被占用
	public void testAddUser2() {
		TerResult<Object> result = service.addUser("jiujiu", "5d93ceb70e2bf5daa84ec3d0cd2c731a", 22, "male", "431299780@qq.com", "18900564321", "xi");
		System.out.println(result.getMsg());
	}
	
	@Test //用例-1:预期结果:修改密码成功
	public void testChangePwd1() {
		TerResult<Map<String,String>> result = service.changePwd("jiuxi", "62c8ad0a15d9d1ca38d5dee762a16e01", "qwer1234");
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	@Test //用例-2:预期结果:密码修改失败，原密码输入错误
	public void testChangePwd2() {
		TerResult<Map<String,String>> result = service.changePwd("jiuxi", "62c8ad0a15d9d1ca38d5dee762a16e01", "qwer1234");
		System.out.println(result.getData());
		System.out.println(result.getData().get("oldPwdMsg"));
	}
	@Test //用例-3:预期结果:密码修改失败，密码长度过小
	public void testChangePwd3() {
		TerResult<Map<String,String>> result = service.changePwd("jiuxi", "5d93ceb70e2bf5daa84ec3d0cd2c731a", "qwer123");
		System.out.println(result.getData());
		System.out.println(result.getData().get("oldPwdMsg"));
	}
	@Test //用例-4:预期结果:密码修改失败，密码应同时包含数字和字母
	public void testChangePwd4() {
		TerResult<Map<String,String>> result = service.changePwd("jiuxi", "62c8ad0a15d9d1ca38d5dee762a16e01", "11111234");
		System.out.println(result.getData());
		System.out.println(result.getData().get("oldPwdMsg"));
	}
}

