package blog.storage.impl;

import blog.exception.PostNotFoundException;
import blog.model.Post;
import blog.storage.PostStorage;

import java.util.ArrayList;

public class PostStorageimpl<T> implements PostStorage<T> {

    ArrayList<Post> posts = new ArrayList<>();

    public void addPost(Post post){
        posts.add(post);
    }

    @Override
    public T getPostByTitle(String title) throws PostNotFoundException {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).equals(title)) {
                return (T) posts.get(i);
            }

        }
        throw new PostNotFoundException("Post not found");
    }

    @Override
    public void searchPostsByKeyword(String keyword) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getTitle().contains(keyword) || posts.get(i).getText().contains(keyword)) {
                System.out.println(posts.get(i));
            }
        }

    }


    @Override
    public void printPostsByCategory(String category) {
        for (int i = 0; i < posts.size(); i++) {
            if (category.equals(posts.get(i).getCategory())) {
                System.out.println(posts.get(i));
            }
        }
    }

    @Override
    public void printAllposts() {
        System.out.println("-------------");
        for (int i = 0; i < posts.size(); i++) {
            System.out.println(posts.get(i));

        }
        System.out.println("----------------------------");

    }
}
