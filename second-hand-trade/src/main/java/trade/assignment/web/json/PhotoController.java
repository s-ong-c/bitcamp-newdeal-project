package trade.assignment.web.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import trade.assignment.domain.Photo;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    
    @Autowired PhotoService photoService;
    
    @RequestMapping("album")
    public Object albums(Photo photo, MultipartFile[] files) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            photoService.add(photo, files);
            result.put("status", "success");

        } catch (Exception e) {
            result.put("status", "fail");
            result.put("message", e.getMessage());
        }

        return result;
    }
}
