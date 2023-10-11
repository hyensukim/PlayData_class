package chap03_02isp.integrate;

public interface Repository {
    public void createUser();
    public User findUserById(Long id);

    public void createArticle();
    public Article findArticleById(Long id);

}
