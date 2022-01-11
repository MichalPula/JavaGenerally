package pulson.java_generally.cors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveAll() {
        userRepository.saveAll(Arrays.asList(new User("Eric"), new User("James"), new User("Martin")));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        User foundUser;
        try{
            foundUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id" + id + " not found!"));

        } catch (EntityNotFoundException e) {
            foundUser = null;
            e.printStackTrace();
        }
        return foundUser;
    }

    @Override
    public String deleteById(Long id) {
        userRepository.deleteById(id);
        return "Deleted user with id = " + id;
    }
}
