package trade.assignment.web.json;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import trade.assignment.service.PhotoService;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    
    @Autowired PhotoService photoService;
    @Autowired ServletContext servletContext;
    
    @PostMapping("album")
    public Object albums(MultipartFile[] files) {
        
        System.out.println(files);
        
        for (MultipartFile parts : files) {
            if (parts.isEmpty())
               continue;
        }
        
        HashMap<String, Object> result = new HashMap<>();
        
        try {
            result.put("status", "success");
        } catch (Exception e) {
            result.put("status", "fail");
            result.put("message", e.getMessage());
        }

        return result;
    }
}
