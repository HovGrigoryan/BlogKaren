package blog;

import blog.exception.UserNotFoundException;
import blog.model.Post;
import blog.model.User;
import blog.storage.PostStorage;
import blog.storage.impl.PostStorageimpl;
import blog.storage.impl.UserStorageimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BlogMain<T> implements Commands<T> {
    private static final PostStorageimpl POST_STORAGE = new PostStorageimpl();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final UserStorageimpl USER_STORAGE = new UserStorageimpl();


    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            POST_STORAGE.printAllposts();
            Commands.prinmainCommands();
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
                case REGISTER:
                    register();
                case LOGIN:
                    login();
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

    private static void login() {
        System.out.println("Please Input email,password");
        try {
            String userlog = SCANNER.nextLine();
            String userlg[] = userlog.split(",");
            User currenUser = USER_STORAGE.getUserByEmailandByPassword(userlg[0], userlg[1]);
            boolean isRun = true;
            while (isRun) {
                POST_STORAGE.printAllposts();
                Commands.printAfterLoginCommands();
                String commandStr = SCANNER.nextLine();
                int command;
                try {
                    command = Integer.parseInt(commandStr);
                } catch (NumberFormatException e) {
                    command = -1;
                }
                switch (command) {
                    case LOGOUT:
                        isRun = false;
                        break;
                    case ADD_POST:
                        addpost();
                    default:
                        System.out.println("Invalid Command,please try again");

                }
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("please Register");
            register();
        }

    }


    private static void register() {
        System.out.println("please Input name,surname,mail,password ");
        String userstr = SCANNER.nextLine();
        String userData[] = userstr.split(",");
        User user = new User();
        user.setName(userData[0]);
        user.setSurname(userData[1]);
        user.setEmail(userData[2]);
        user.setPassword(userData[3]);
        try {
            USER_STORAGE.getUserByEmail(userData[3]);
            System.out.println("Email already Exist");
        } catch (UserNotFoundException e) {
            USER_STORAGE.addUser(user);
            System.out.println("Thank you!");

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
            POST_STORAGE.addPost(post);
            System.out.println("post added!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid data");
            addpost();
        }


    }


}
