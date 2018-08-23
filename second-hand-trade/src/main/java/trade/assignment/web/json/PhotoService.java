package trade.assignment.web.json;

import org.springframework.web.multipart.MultipartFile;

import trade.assignment.domain.Photo;

public interface PhotoService {

    int add(Photo photo, MultipartFile[] files);

}
