package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xgs.entity.Fileinfo;
import com.xgs.service.FileService;
import com.xgs.util.TerResult;

import test.TestBase;

public class TestFileService extends TestBase{
	private FileService service;
	@Before
	public void init() {
		service=super.getContext().getBean("fileService",FileService.class);
	}
	@Test //测试1：对于管理员，查找所有文件信息
	public void testLoadFiles1() {
		TerResult<List<Fileinfo>> result = service.loadFiles( 2, 5, "admin");
		System.out.println(result);
		for(Fileinfo data : result.getData()) {
			System.out.println(data.getId());
		}
	} 
	@Test //测试2：对于普通用户，查找对应用户的文件信息
	public void testLoadFiles2() {
		TerResult<List<Fileinfo>> result = service.loadFiles( 1, 5, "user");
		System.out.println(result);
		System.out.println(result.getExData());
	} 
	
	@Test //修改状态测试1：预期结果：文件不存在，请重新输入
	public void testChangeState1() {
		TerResult<Object> result=service.changeState("123", "1", "1538085794");
		System.out.println(result);
	}
	@Test //修改状态测试2：预期结果：修改为已检测状态，且向表file_alertsystembase_uniqueid插入新数据
	public void testChangeState2() {
		TerResult<Object> result=service.changeState("c3b46991f32cbc2cd0a2184c394e565f", "1", "1538085794");
		System.out.println(result);
	}
	@Test //修改状态测试3：预期结果：修改为已检测状态，修改表file_alertsystembase_uniqueid中alertsystembase_uniqueid的值
	public void testChangeState3() {
		TerResult<Object> result=service.changeState("c3b46991f32cbc2cd0a2184c394e565f", "1", "123");
		System.out.println(result);
	}
	@Test //修改状态测试4：预期结果：修改为未检测状态，从表file_alertsystembase_uniqueid中删除数据
	public void testChangeState4() {
		TerResult<Object> result=service.changeState("c3b46991f32cbc2cd0a2184c394e565f", "0", "123");
		System.out.println(result);
	}
	@Test
	public void testAddFile() {
		TerResult<Object> result=service.addFile("xx", "dd", "dd", "dd", "dd", "2016-10-26 11:43:24");
		System.out.println(result);
	}
	@Test
	public void testRemoveFile() {
		TerResult<Object> result=service.removeFile(62);
		System.out.println(result);
	}
}
