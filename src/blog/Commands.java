package blog;

public interface Commands {


    int EXIT = 0;
    int REGISTER = 1;
    int LOGIN = 2;
    int SEACRH_POST = 3;
    int POSTS_BY_CATEGORY = 4;


    int ADD_POST = 5;
    int ALL_POST = 6;
    int LOGOUT = 7;

    static void prinmainCommands() {
        System.out.println("Please enter " + EXIT + " For EXIT");
        System.out.println("Please enter " + REGISTER + " For REGISTER");
        System.out.println("Please enter " + LOGIN + " For LOGIN");
        System.out.println("Please enter " + SEACRH_POST + " For SEACRH_POST");
        System.out.println("Please enter " + POSTS_BY_CATEGORY + " POSTS_BY_CATEGORY");
    }

    static void printAfterLoginCommands() {
        System.out.println("Please enter " + LOGOUT + " For LOGOUT");
        System.out.println("Please enter " + ADD_POST + " For ADD_POST");


    }
//    սկզբում
//    exit;
//    register;
//    login;
//    searchPost;
//    postByCategory;
//    allpost;
//
//
//    հենց որ գրանցվար, ու արդեն լոգին էղար նոր
//    addpost;
//    search;
//    postByCategory;
//    allpost
//    logout
//
//

}
