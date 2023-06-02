package com.atguigu.gulimall.product;


/**
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest(classes = GulimallProductApplication.class)
@Slf4j
@RunWith(SpringRunner.class)
public class GulimallProductApplicationTests {

	@Autowired
	BrandService brandService;

	@Autowired
	OSSClient ossClient;

	@Test
	public void contextLoads() {
		BrandEntity brandEntity = new BrandEntity();
		brandEntity.setName("huawei");
		brandService.save(brandEntity);
		System.out.println("Successfully saved");
	}

	@Test
	public void testUpload() throws FileNotFoundException {
		// Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
//		String endpoint = "oss-cn-qingdao.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
//		String accessKeyId = "LTAI5tNN3jgftMrHHDp3Nd3c";
//		String accessKeySecret = "GetB3P4JPOxpLWpulsUQLgm142Z0tE";
		// 填写Bucket名称，例如examplebucket。
		String bucketName = "gulimall-chenjianrui";
        // 填写Object完整路径，例如exampledir/exampleobject.txt。Object完整路径中不能包含Bucket名称。
        // 如果没有文件夹就不需要写
		String objectName = "toudi.txt";
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
		String filePath = "D:\\Java\\投递情况.txt";

        // 创建OSSClient实例。
//		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

		try {
			InputStream inputStream = new FileInputStream(filePath);
			// 创建PutObject请求。
			ossClient.putObject(bucketName, objectName, inputStream);
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message:" + oe.getErrorMessage());
			System.out.println("Error Code:" + oe.getErrorCode());
			System.out.println("Request ID:" + oe.getRequestId());
			System.out.println("Host ID:" + oe.getHostId());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ossClient != null) {
				ossClient.shutdown();
				System.out.println("上传完成");
			}
		}
	}
}
*/
