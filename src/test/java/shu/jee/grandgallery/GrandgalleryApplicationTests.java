package shu.jee.grandgallery;

import com.UpYun;
import com.upyun.UpException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import shu.jee.grandgallery.entity.data.PictureInfo;
import shu.jee.grandgallery.service.PictureService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@SpringBootTest
class GrandgalleryApplicationTests {

    @Autowired
    PictureService pictureService;

    @Test
    void contextLoads() {

    }

    @Test
    void test1(){
        PictureInfo pictureInfo=new PictureInfo();
        pictureInfo.setPictureName("1");
        pictureInfo.setCategoryName("动物");
        pictureInfo.setUploaderId(1);
        pictureInfo.setUploaderName("2021-05-31 20:52:30");
        pictureInfo.setPictureUrl("1");
        pictureInfo.setLikesCount(1);
        pictureInfo.setFavouritesCount(1);
        pictureInfo.setViewTime(1);
        pictureInfo.setCommentCount(1);
        pictureInfo.setDescription("1");
        pictureService.addPicture(pictureInfo);
    }

    @Test
    void test2() throws IOException, UpException {
        File file = new File("F:/testimage1.jpg");
        MultipartFile mulfile=new MockMultipartFile("testimage1.jpg","testimage1.jpg","application/octet-stream" ,new FileInputStream(file));
        PictureInfo pictureInfo=new PictureInfo();
        pictureInfo.setPictureName("大自然");
        pictureInfo.setDescription("测试");
        pictureInfo.setCategoryName("风景");
        pictureInfo.setUploaderId(1);
        UpYun upYun=new UpYun("grandgallery-image","zjh","Sb1GzBevRLbpcG2WsfOp5JFmmQrQOTLn");
        String filename=mulfile.getOriginalFilename()+ UUID.randomUUID().toString()+".jpg";
        System.out.println("图片名称："+filename);
        pictureInfo.setPictureUrl("http://job-imags.test.upcdn.net/"+filename);
        boolean re = upYun.writeFile(filename,mulfile.getBytes(),false);
        pictureService.addPicture(pictureInfo);
    }

}
