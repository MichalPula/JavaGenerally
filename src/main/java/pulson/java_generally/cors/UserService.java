package pulson.java_generally.cors;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void saveAll();
    List<User> getAll();
    User getById(Long id);
    String deleteById(Long id);
}
