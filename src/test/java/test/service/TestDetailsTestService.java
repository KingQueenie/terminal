package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
import com.xgs.service.DetailsTestService;
import com.xgs.util.TerResult;

import test.TestBase;

public class TestDetailsTestService extends TestBase{
	DetailsTestService service;
	@Before
	public void init() {
		service=super.getContext().getBean("detailsTestService",DetailsTestService.class);
	}
	// 文件操作详情
	@Test //测试：根据uniqueId，查找表filesysteminfo中的数据
	public void testLoadFileSysteminfo() {
		TerResult<List<FileSysteminfo>> result=service.loadFileSysteminfo(1, 3, 1538085794);
		System.out.println(result);
	}
	@Test //测试：根据条件信息，查找表filesysteminfo中的数据
	public void testLoadFileSysteminfoByElements() {
		TerResult<List<FileSysteminfo>> result=service.loadFileSysteminfoByElements(1,2,1538085794,3,5,"ProtectedPrefix","ss.exe","216","16:22:25");
		System.out.println(result);
	}
	// 文件map操作详情
	@Test //测试：根据uniqueId，查找表filesysteminfo中的Map数据
	public void testLoadFileSystemMapinfo() {
		TerResult<List<FileSysteminfo>> result=service.loadFileSystemMapinfo(1, 10, 1538085794);
		System.out.println(result);
	}
	@Test //测试：根据条件信息，查找表filesysteminfo中的Map数据
	public void testLoadFileSystemMapinfoByElements() {
		TerResult<List<FileSysteminfo>> result=service.loadFileSystemMapinfoByElements(1,2,1538085794,7,5,"hard","ss.exe","216","");
		System.out.println(result);
	}
	// 网络使用信息
	@Test
	public void testLoadNetinfo() {
		TerResult<List<Netinfo>> result=service.loadNetinfo(1, 10, 1538085794);
		System.out.println(result);
	}
	@Test
	public void testLoadNetinfoByElements() {
		TerResult<List<Netinfo>> result=service.loadNetinfoByElements(1, 9, 1538085794, 1, "ie", null, "2016-04-15");
		System.out.println(result);
	}
	// 注册表基本信息
	@Test
	public void testLoadReginfo() {
		TerResult<List<Reginfo>> result=service.loadReginfo(1, 10, 1538085794);
		System.out.println(result);
	}
	@Test
	public void testLoadReginfoByElements() {
		TerResult<List<Reginfo>> result=service.loadReginfoByElements(1, 10, 1538085794,1,"",null,"DEFAULT","");
		System.out.println(result);
	}
	// 注册表赋值操作
	@Test
	public void testLoadSetregvaluekey() {
		TerResult<List<Setregvaluekey>> result=service.loadSetregvaluekey(2, 15, 1538085794);
		System.out.println(result);
	}
	@Test
	public void testLoadSetregvaluekeyByElements() {
		TerResult<List<Setregvaluekey>> result=service.loadSetregvaluekeyByElements(1, 10, 1538085794,"sm",null,"NUM","","");
		System.out.println(result);
	}
	// 进程操作信息
	@Test
	public void testLoadProcessoperation() {
		TerResult<List<Processoperation>> result=service.loadProcessoperation(2, 15, 1538085794);
		System.out.println(result);
	}
	@Test
	public void testLoadProcessoperationByElements() {
		TerResult<List<Processoperation>> result=service.loadProcessoperationByElements(1, 10, 1538085794,1,"",null,"",null,"");
		System.out.println(result);
	}
	// 进程操作线程信息
	@Test
	public void testLoadCreatethread() {
		TerResult<List<Createthread>> result=service.loadCreatethread(2, 15, 1538085794);
		System.out.println(result);
	}
	@Test
	public void testLoadCreatethreadByElements() {
		TerResult<List<Createthread>> result=service.loadCreatethreadByElements(1, 10, 1538085794,"drvinst",4,"",null,"","");
		System.out.println(result);
	}
	// 挂起线程操作信息
	@Test
	public void testLoadPendingthread() {
		TerResult<List<Pendingthread>> result=service.loadPendingthread(1, 15, 1538085794);
		System.out.println(result);
	}
	@Test
	public void testLoadPendingthreadByElements() {
		TerResult<List<Pendingthread>> result=service.loadPendingthreadByElements(1, 10, 1538085794,"",null,"www","","","");
		System.out.println(result);
	}
	// 恢复线程操作信息
	@Test
	public void testLoadRecoverthread() {
		TerResult<List<Recoverthread>> result=service.loadRecoverthread(1, 15, 1538085794);
		System.out.println(result);
	}
	@Test
	public void testLoadRecoverthreadByElements() {
		TerResult<List<Recoverthread>> result=service.loadRecoverthreadByElements(1, 10, 1538085794,"",null,"a","","","");
		System.out.println(result);
	}
	// 模块操作
	@Test
	public void testLoadModule() {
		TerResult<List<Module>> result=service.loadModule(1, 15, 1538085794);
		System.out.println(result);
	}
	@Test
	public void testLoadModuleByElements() {
		TerResult<List<Module>> result=service.loadModuleByElements(1, 10, 1538085794,2,"r",null,"set","");
		System.out.println(result);
	}
	// 告警信息
	@Test
	public void testLoadAlarminfo() {
		TerResult<List<Alarminfo>> result=service.loadAlarminfo(1, 15, 1538085794);
		System.out.println(result);
	}
	@Test
	public void testLoadAlarminfoByElements() {
		TerResult<List<Alarminfo>> result=service.loadAlarminfoByElements(1, 10, 1538085794,2,"drvi","","","","");
		System.out.println(result);
	}
	// 样本检测报告
	@Test
	public void testLoadBehavior() {
		TerResult<List<Behavior>> result=service.loadBehavior();
		System.out.println(result);
	}
}
