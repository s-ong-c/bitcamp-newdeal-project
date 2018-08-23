package trade.assignment.repository;

import java.util.HashMap;

public interface PhotoRepository {

    int findByUrl(HashMap<String, Object> result);
}
