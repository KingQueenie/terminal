package test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.xgs.dao.FileDao;
import com.xgs.entity.File_alertsystembase_uniqueid;
import com.xgs.entity.Fileinfo;

import test.TestBase;

public class TestFileDao extends TestBase{
	FileDao dao;
	@Before
	public void init() {
		dao=super.getContext().getBean("fileDao",FileDao.class);
	}
	@Test //测试：从表fileinfo取文件信息（分页查询）
	public void testFindFileByPage() {
		List<Fileinfo> data = dao.findFileByPageAndUser(0, 20,"admin");
		System.out.println(data);
		System.out.println(data.size());
//		for(Fileinfo da:data) {
//			System.out.println(da.getId());
//			System.out.println(da.getFile_alertsystembase_uniqueid().getAlertsystembase_uniqueid());
//		}
	}
	@Test //测试：对应用户名，表fileinfo文件数量
	public void testCountFile() {
		Integer cnt=dao.countFile("user");
		System.out.println(cnt);
	}
	
	@Test //测试：向表ile_alertsystembase_uniqueid中插入数据
	public void testAddUniqueid() {
		File_alertsystembase_uniqueid file_alertsystembase_uniqueid=new File_alertsystembase_uniqueid();
		file_alertsystembase_uniqueid.setFile_uniqueid("c3b46991f32cbc2cd0a2184c394e565f");
		file_alertsystembase_uniqueid.setAlertsystembase_uniqueid("1538085794");
		dao.addUniqueid(file_alertsystembase_uniqueid);
		System.out.println("插入数据成功");
	}
	@Test //测试：表fileinfo中state的值
	public void testModifyFileinfo() {
		dao.modifyFileinfo("已检测", "c3b46991f32cbc2cd0a2184c394e565f");
		System.out.println("修改数据成功");
	}
	@Test //测试：表fileinfo是否存在file_uniqueid这一文件
	public void testCountFileUniqueid() {
		int cnt=dao.countFileUniqueid("123");
		System.out.println(cnt);
	}
	@Test //测试：表file_alertsystembase_uniqueid是否存在file_uniqueid
	public void testFindFileSystemUniqueid() {
		File_alertsystembase_uniqueid fau=dao.findFileSystemUniqueid("1277a5f24601582c624fd785889b769b");
//		File_alertsystembase_uniqueid fau=dao.findFileSystemUniqueid("127");
		System.out.println(fau);
	}
	@Test //测试：更改表file_alertsystembase_uniqueid中的alertsystembase_uniqueid的值
	public void testModifyAlertsystembaseUniqueid() {
		File_alertsystembase_uniqueid fau=dao.findFileSystemUniqueid("c3b46991f32cbc2cd0a2184c394e565f");
		if(fau!=null) {
			fau.setAlertsystembase_uniqueid("124");
			dao.modifyAlertsystembaseUniqueid(fau);
		}
		System.out.println("修改数据成功");
	}
	@Test //测试：删除表file_alertsystembase_uniqueid的数据
	public void testDeleteAlertsystembaseUniqueid() {
		File_alertsystembase_uniqueid fau=dao.findFileSystemUniqueid("c3b46991f32cbc2cd0a2184c394e565f");
		dao.deleteAlertsystembaseUniqueid(fau);
		System.out.println("删除数据成功");
	}
	@Test //测试：向表fileinfo中插入数据
	public void testAddFile() {
		dao.saveFile("xx", "dd", "dd", "dd", "dd", "2016-10-26 11:43:24");
		System.out.println("插入数据成功");
	}
	@Test
	public void testDeleteFileById() {
		dao.deleteFileById(61);
		System.out.println("删除文件成功");
	}
	@Test
	public void testFindFileById() {
		Fileinfo fileinfo=dao.findFileById(37);
		System.out.println(fileinfo);
	}
}
