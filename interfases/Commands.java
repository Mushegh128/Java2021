package blog.interfases;

public interface Commands {

    int EXIT = 0;
    int ADD_POST = 1;
    int SEARCH_POST = 2;
    int POSTS_BY_CATEGORY = 3;
    int ALL_POSTS = 4;
    int DELETE_POST = 5;
    int CHANGE_POST = 6;
    int DELETE_BY_CATEGORY = 7;

    static void printCommands() {
        System.out.println("Please input option \n" +
                EXIT + " for EXIT\n" +
                ADD_POST + " for ADD_POST\n" +
                SEARCH_POST + " for SEARCH_POST\n" +
                POSTS_BY_CATEGORY + " for POSTS_BY_CATEGORY\n" +
                ALL_POSTS + " for ALL_POSTS\n" +
                DELETE_POST + " for DELETE_POST\n" +
                CHANGE_POST + " for CHANGE_POST\n" +
                DELETE_BY_CATEGORY + " for DELETE_BY_CATEGORY");
    }

}
