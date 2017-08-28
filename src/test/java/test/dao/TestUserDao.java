package test.dao;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xml.internal.security.Init;
import com.xgs.dao.UserDao;
import com.xgs.entity.Changelog;
import com.xgs.entity.Errlogin;
import com.xgs.entity.Login;
import com.xgs.entity.User;

import test.TestBase;

public class TestUserDao extends TestBase{
	UserDao dao;
	@Before
	public void init() {
		dao = super.getContext().getBean("userDao",UserDao.class);
	}
	@Test //测试：根据用户名向表logininfo查找登录信息
	public void testFindByName(){
		UserDao dao = super.getContext().getBean("userDao",UserDao.class);
		Login login = dao.findByName("user");
		System.out.println(login);
	}
	@Test //测试：向表logininfo中插入新注册的用户信息
	public void testSaveLogininfo() {
		Login login=new Login();
		login.setUsername("jiuxi");
		login.setPwd("202cb962ac59075b964b07152d234b70");
		login.setType("user");
		login.setFlag(0);
		login.setGroup(0);
		login.setLast_change("2017-07-23 11:42:36");
		dao.saveLogininfo(login);
	}
	@Test //测试：修改表logininfo中某一用户的登录密码
	public void testModifyLogin() {
		Login login=dao.findByName("jiuxi");
		login.setPwd("62c8ad0a15d9d1ca38d5dee762a16e01");
		dao.modifyLogin(login);
		System.out.println("修改密码成功");
	}
	@Test //测试：根据type的值向表config查找对应的value
	public void testConfigDao() {
		UserDao dao = super.getContext().getBean("userDao",UserDao.class);
		int type=1;
		String value = dao.findByType(type);
		System.out.println(value);
	}
	@Test //测试：根据ip地址、开始时间、结束时间向表errlogin查找错误信息表
	public void testFindByDateAndIp() {
		UserDao dao = super.getContext().getBean("userDao",UserDao.class);
		String ip_addr="0:0:0:0:0:0:0:1";
		String begin = "2017-07-10 09:43:02";
		String end = "2017-07-18 09:49:07";
		List<Errlogin> list=dao.findByDateAndIp(ip_addr,begin,end);
		for(Errlogin err:list) {
			System.out.println(err.getId());
		}
		System.out.println(list);
	}
	@Test //测试：向表errlogin插入登录错误信息
	public void testAddErrLogin() {
		UserDao dao = super.getContext().getBean("userDao",UserDao.class);
		Errlogin errlogin=new Errlogin();
		String ip_addr="0:0:0:0:0:0:0:1";
		String login_time= "2017-07-20 09:43:02";
		String username="admin3";
		errlogin.setIp_addr(ip_addr);
		errlogin.setLogin_time(login_time);
		errlogin.setUsername(username);
		dao.AddErrLoginInfo(errlogin);
		System.out.println("插入数据成功");
	}
	@Test //测试：向表user中插入新注册的用户
	public void testSaveUser() {
		UserDao dao=super.getContext().getBean("userDao",UserDao.class);
		User user = new User();
		user.setUsername("jiuxiii");
		user.setPwd("202cb962ac59075b964b07152d234b70");
		user.setAge(24);
		user.setGender("female");
		user.setEmail("612466450@qq.com");
		user.setPhone("13390652121");
		user.setNickname("九溪");
		dao.saveUser(user);
		System.out.println("插入数据成功");
	}
	@Test //测试：根据用户名向表user查找用户信息
	public void testFindByUsername(){
		User user = dao.findByUsername("jiuxi");;
		System.out.println(user);
	}
	@Test //测试：修改表user中某一用户的登录密码
	public void testModifyUser() {
		User user=dao.findByUsername("jiuxi");
		user.setPwd("62c8ad0a15d9d1ca38d5dee762a16e01");
		dao.modifyUser(user);
		System.out.println("修改密码成功");
	}
	@Test //测试：向表changelog中插入修改密码信息
	public void testSaveChangelog() {
		Changelog changelog=new Changelog();
		changelog.setUniqueid(0);
		changelog.setTable_name("");
		changelog.setTable_id(0);
		changelog.setContent("修改密码失败");
		changelog.setProcess_time("2017-07-26 10:12:36");
		changelog.setUser("jiuxi");
		dao.saveChangelog(changelog);
		System.out.println("插入数据成功");
	} 
}
