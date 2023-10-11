package chap03_02isp.integrate;

public class ArticleRepository implements Repository{

    @Override
    public void createUser() {
        // 사용되지 않는 메서드
    }

    @Override
    public User findUserById(Long id) {
        // 사용되지 않는 메서드
        return null;
    }

    @Override
    public void createArticle() {
        // 실제로 사용할 기사 관련 로직
    }

    @Override
    public Article findArticleById(Long id) {
        // 실제로 사용할 기사 관련 로직
        return null;
    }
}
