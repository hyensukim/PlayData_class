package chap03_02isp.integrate;

public class UserService {
    private Repository repository = new UserRepository();

    public void createUser(){
        repository.createUser();
    }

    public User findUserById(Long id){
        return repository.findUserById(id);
    }
}
