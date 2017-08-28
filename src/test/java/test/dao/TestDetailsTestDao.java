package test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.xgs.dao.DetailsTestDao;
import com.xgs.entity.Alarminfo;
import com.xgs.entity.Behavior;
import com.xgs.entity.Createthread;
import com.xgs.entity.FileSysteminfo;
import com.xgs.entity.Module;
import com.xgs.entity.Netinfo;
import com.xgs.entity.Pendingthread;
import com.xgs.entity.Processoperation;
import com.xgs.entity.Recoverthread;
import com.xgs.entity.Reginfo;
import com.xgs.entity.Setregvaluekey;

import test.TestBase;

public class TestDetailsTestDao extends TestBase{
	DetailsTestDao dao;
	@Before
	public void init() {
		dao=super.getContext().getBean("detailsTestDao",DetailsTestDao.class);
	}
	// 文件操作详情
	@Test
	public void testFindFileSysteminfoByUniqueId() {
		List<FileSysteminfo> list=dao.findFileSysteminfoByUniqueId(0,2,1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountFileSystem() {
		int cnt=dao.countFileSystem(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindFileSysteminfoByElements() {
		List<FileSysteminfo> list=dao.findFileSysteminfoByElements(0,2,1538085794,3,5,"ProtectedPrefix","ss.exe","216","16:22:25");
		System.out.println(list);
	}
	@Test
	public void testCountFileSysteminfoByElements() {
		int cnt=dao.countFileSysteminfoByElements(1538085794,3,5,"ProtectedPrefix","ss.exe","216","16:22:25");
		System.out.println(cnt);
	}
	// 文件map操作详情
	@Test
	public void testFindFileSystemMapinfoByUniqueId() {
		List<FileSysteminfo> list=dao.findFileSystemMapinfoByUniqueId(0,5,1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountFileSystemMap() {
		int cnt=dao.countFileSystemMap(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindFileSystemMapinfoByElements() {
		List<FileSysteminfo> list=dao.findFileSystemMapinfoByElements(0,9,1538085794,7,5,"Hard","ss.exe","216","");
		System.out.println(list);
	}
	@Test
	public void testCountFileSystemMapinfoByElements() {
		int cnt=dao.countFileSystemMapinfoByElements(1538085794,7,5,"Hard","ss.exe","216","");
		System.out.println(cnt);
	}
	//网络使用信息
	@Test
	public void testFindNetinfoByUniqueId() {
		List<Netinfo> list =dao.findNetinfoByUniqueId(0, 9, 1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountNetinfo() {
		int cnt=dao.countNetinfo(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindNetinfoByElements() {
		List<Netinfo> list = dao.findNetinfoByElements(0, 9, 1538085794, 1, "ie", null, "2016-04-15");
		System.out.println(list);
	}
	@Test
	public void testCountNetinfoByElements() {
		int cnt=dao.countNetinfoByElements(1538085794, 1, "ie", null, "2016-04-15");
		System.out.println(cnt);
	}
	// 注册表基本信息
	@Test
	public void testFindReginfoByUniqueId() {
		List<Reginfo> list =dao.findReginfoByUniqueId(0, 9, 1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountReginfo() {
		int cnt=dao.countReginfo(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindReginfoByElements() {
		List<Reginfo> list =dao.findReginfoByElements(0, 9, 1538085794,1,"",null,"","");
		System.out.println(list);
	}
	@Test
	public void testCountReginfoByElements() {
		int cnt=dao.countReginfoByElements(1538085794,1,"",null,"DEFAULT","");
		System.out.println(cnt);
	}
	// 注册表赋值操作
	@Test
	public void testFindSetregvaluekeyByUniqueId() {
		List<Setregvaluekey> list =dao.findSetregvaluekeyByUniqueId(0, 9, 1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountSetregvaluekey() {
		int cnt=dao.countSetregvaluekey(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindSetregvaluekeyByElements() {
		List<Setregvaluekey> list =dao.findSetregvaluekeyByElements(0, 9, 1538085794,"sm",null,"NUM","","");
		System.out.println(list);
	}
	@Test
	public void testCountSetregvaluekeyByElements() {
		int cnt=dao.countSetregvaluekeyByElements(1538085794,"sm",null,"NUM","","");
		System.out.println(cnt);
	}
	// 进程操作信息
	@Test
	public void testFindProcessoperationByUniqueId() {
		List<Processoperation> list =dao.findProcessoperationByUniqueId(0, 9, 1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountProcessoperation() {
		int cnt=dao.countProcessoperation(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindProcessoperationByElements() {
		List<Processoperation> list =dao.findProcessoperationByElements(0, 9, 1538085794,1,"",null,"",null,"");
		System.out.println(list);
	}
	@Test
	public void testCountProcessoperationByElements() {
		int cnt=dao.countProcessoperationByElements(1538085794,1,"",null,"",null,"");
		System.out.println(cnt);
	}
	// 进程操作线程信息
	@Test
	public void testFindCreatethreadByUniqueId() {
		List<Createthread> list =dao.findCreatethreadByUniqueId(0, 9, 1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountCreatethread() {
		int cnt=dao.countCreatethread(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindCreatethreadByElements() {
		List<Createthread> list =dao.findCreatethreadByElements(0, 9, 1538085794,"drvinst",4,"",null,"","");
		System.out.println(list);
	}
	@Test
	public void testCountCreatethreadByElements() {
		int cnt=dao.countCreatethreadByElements(1538085794,"drvinst",4,"",null,"","");
		System.out.println(cnt);
	}
	// 挂起线程操作信息
	@Test
	public void testFindPendingthreadByUniqueId() {
		List<Pendingthread> list =dao.findPendingthreadByUniqueId(0, 9, 1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountPendingthread() {
		int cnt=dao.countPendingthread(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindPendingthreadByElements() {
		List<Pendingthread> list =dao.findPendingthreadByElements(0, 9, 1538085794,"",null,"www","","","");
		System.out.println(list);
	}
	@Test
	public void testCountPendingthreadByElements() {
		int cnt=dao.countPendingthreadByElements(1538085794,"",null,"www","","","");
		System.out.println(cnt);
	}
	// 恢复线程操作信息
	@Test
	public void testFindRecoverthreadByUniqueId() {
		List<Recoverthread> list =dao.findRecoverthreadByUniqueId(0, 9, 1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountRecoverthread() {
		int cnt=dao.countRecoverthread(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindRecoverthreadByElements() {
		List<Recoverthread> list =dao.findRecoverthreadByElements(0, 9, 1538085794,"",null,"a","","","");
		System.out.println(list);
	}
	@Test
	public void testCountRecoverthreadByElements() {
		int cnt=dao.countRecoverthreadByElements(1538085794,"",null,"a","","","");
		System.out.println(cnt);
	}
	// 模块操作
	@Test
	public void testFindModuleByUniqueId() {
		List<Module> list =dao.findModuleByUniqueId(0, 9, 1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountModule() {
		int cnt=dao.countModule(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindModuleByElements() {
		List<Module> list =dao.findModuleByElements(0, 9, 1538085794,1,"",null,"ko","");
		System.out.println(list);
	}
	@Test
	public void testCountModuleByElements() {
		int cnt=dao.countModuleByElements(1538085794,1,"",null,"ko","");
		System.out.println(cnt);
	}
	// 告警信息
	@Test
	public void testFindAlarminfoByUniqueId() {
		List<Alarminfo> list =dao.findAlarminfoByUniqueId(0, 9, 1538085794);
		System.out.println(list);
	}
	@Test
	public void testCountAlarminfo() {
		int cnt=dao.countAlarminfo(1538085794);
		System.out.println(cnt);
	}
	@Test
	public void testFindAlarminfoByElements() {
		List<Alarminfo> list =dao.findAlarminfoByElements(0, 9, 1538085794,2,"drvi","","","","");
		System.out.println(list);
	}
	@Test
	public void testCountAlarminfoByElements() {
		int cnt=dao.countAlarminfoByElements(1538085794,2,"drvi","","","","");
		System.out.println(cnt);
	}
	// 样本检测报告
	@Test
	public void testFindBehavior() {
		List<Behavior> list=dao.findBehavior();
		System.out.println(list);
	}
	@Test
	public void testCountBehavior() {
		int cnt =dao.countBehavior();
		System.out.println(cnt);
	}
}
