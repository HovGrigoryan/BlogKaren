package blog.storage;

import blog.exception.PostNotFoundException;
import blog.model.Post;

public interface PostStorage {

    void addPost(Post post);

    Post getPostByTitle(String title) throws PostNotFoundException;

    void searchPostsByKeyword(String  keyword);

    void printAllposts();

    void printPostsByCategory (String category);


}
