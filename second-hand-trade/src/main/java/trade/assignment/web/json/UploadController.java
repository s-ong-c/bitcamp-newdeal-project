/*package trade.assignment.web.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.util.IOUtils;

import trade.assignment.domain.Member;
import trade.assignment.util.MediaUtils;
import trade.assignment.util.S3Util;
import trade.assignment.util.UploadFileUtils;

@RestController
@RequestMapping("/upload")
public class UploadController {

    S3Util s3 = new S3Util();
    String bucketName = "kds-01.newdeal.bitcamp.net";

    @Resource(name = "uploadPath")
    private String uploadPath;

    @RequestMapping(value = "/uploadAjax", method = RequestMethod.GET)
    public void uploadAjax() {
        System.out.println("업로드란??");

    }

    // 서버에 파일 업로드
    @ResponseBody
    @RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> uploadAjax(MultipartFile file, HttpSession session) throws Exception {
        System.out.println("originalName: " + file.getOriginalFilename());
        System.out.println("size : " + file.getSize());
        System.out.println("contentType : " + file.getContentType());
        Member vo = (Member) session.getAttribute("loginUser");
        String name = vo.getName();
        System.out.println(name);
        return new ResponseEntity<>(
                UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes(), name),
                HttpStatus.CREATED);
    }

    // 파일 표시
    @SuppressWarnings("resource")
    @ResponseBody
    @RequestMapping("/displayFile")
    public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {

        InputStream in = null;
        ResponseEntity<byte[]> entity = null;
        HttpURLConnection uCon = null;
        System.out.println("FILE NAME: " + fileName);

        // System.out.println("FileName : "+fileName);

        try {
            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

            MediaType mType = MediaUtils.getMediaType(formatName);
            HttpHeaders headers = new HttpHeaders();

            String inputDirectory = "faint1122";
            URL url;

            try {
                url = new URL(s3.getFileURL(bucketName, inputDirectory + fileName));
                System.out.println(url);
                uCon = (HttpURLConnection) url.openConnection();
                in = uCon.getInputStream(); // 이미지를 불러옴
            } catch (Exception e) {
                url = new URL(s3.getFileURL(bucketName, "default.jpg"));
                uCon = (HttpURLConnection) url.openConnection();
                in = uCon.getInputStream();
            }

            // 여기
            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
        } catch (FileNotFoundException effe) {
            System.out.println("File Not found Exception");
            String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
            MediaType mType = MediaUtils.getMediaType(formatName);
            HttpHeaders headers = new HttpHeaders();
            in = new FileInputStream(uploadPath + "/noimage.jpeg");

            headers.setContentType(mType);

            entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        } finally {
            in.close();
        }
        return entity;
    }

    // 파일 삭제
    @ResponseBody
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    public ResponseEntity<String> deleteFile(String fileName) {
        System.out.println("delete file: " + fileName);

        String inputDirectory = "faint1122";
        s3.fileDelete(inputDirectory + fileName);

        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }
}*/