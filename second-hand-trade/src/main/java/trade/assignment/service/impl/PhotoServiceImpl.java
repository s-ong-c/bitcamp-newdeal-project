package trade.assignment.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import trade.assignment.domain.Photo;
import trade.assignment.repository.PhotoRepository;
import trade.assignment.web.json.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired PhotoRepository photorepository;
    @Autowired ServletContext sc;
    
    @Override
    public int add(Photo photo, MultipartFile[] files) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("photo", photo);
        ArrayList<String> filenames = new ArrayList<>();
        result.put("filenames", filenames);
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;
                String newfilename = UUID.randomUUID().toString();
                String path = sc.getRealPath("/files/" + newfilename);
                file.transferTo(new File(path));
                filenames.add(newfilename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return photorepository.findByUrl(result);
    }

}
