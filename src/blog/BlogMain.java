package blog;

import blog.model.Post;
import blog.storage.PostStorage;
import blog.storage.impl.PostStorageimpl;

import java.util.Date;
import java.util.Scanner;

public class BlogMain implements Commands {
    private static final PostStorage POST_STORAGE = new PostStorageimpl();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            POST_STORAGE.printAllposts();
            printCommands();
            String commandStr = SCANNER.nextLine();
            int command;
            try {
                command = Integer.parseInt(commandStr);
            } catch (NumberFormatException e) {
                command = -1;

            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_POST:
                    addpost();
                    break;
                case SEACRH_POST:
                    searchPost();
                    break;
                case POSTS_BY_CATEGORY:
                    postsByCategory();
                    break;
                default:
                    System.out.println("Invalid Command,please try again");
            }

        }

    }

    private static void postsByCategory() {
        System.out.println("Please enter category");
        String category = SCANNER.nextLine();
        POST_STORAGE.printPostsByCategory(category);
    }

    private static void searchPost() {
        System.out.println("Please Enter Keyword");
        String keyword = SCANNER.nextLine();
        POST_STORAGE.searchPostsByKeyword(keyword);
    }

    private static void addpost() {
        System.out.println("please enter title,text,category");
        String postDataStr = SCANNER.nextLine();
        String postDate[] = postDataStr.split(",");
        try {
            Post post = new Post();
            post.setTitle(postDate[0]);
            post.setText(postDate[1]);
            post.setCategory(postDate[2]);
            post.setCreatedDate(new Date());
            POST_STORAGE.add(post);
            System.out.println("post added!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid data");
            addpost();
        }


    }

    private static void printCommands() {
        System.out.println("Please enter " + EXIT + " For EXIT");
        System.out.println("Please enter " + ADD_POST + " For ADD_POST");
        System.out.println("Please enter " + SEACRH_POST + " For SEACRH_POST");
        System.out.println("Please enter " + POSTS_BY_CATEGORY + " POSTS_BY_CATEGORY");
    }
}
