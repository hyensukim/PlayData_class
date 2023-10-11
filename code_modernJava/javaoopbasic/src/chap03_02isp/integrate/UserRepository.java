package chap03_02isp.integrate;

public class UserRepository implements Repository{

    @Override
    public void createUser() {

    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public void createArticle() {

    }

    @Override
    public Article findArticleById(Long id) {
        return null;
    }
}
