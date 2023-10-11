package chap03_02isp.integrate;

public class ArticleService {
    private Repository repository = new ArticleRepository();

    public void createArticle(){
        repository.createArticle();
    }

    public Article findArticleById(Long id){
        return repository.findArticleById(id);
    }
}
