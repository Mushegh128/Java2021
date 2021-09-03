package blog;

import blog.interfases.Commands;
import blog.model.Category;
import blog.model.Post;
import blog.storage.PostStorageImpl;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class BlogTest implements Commands {

    public static Scanner scanner = new Scanner(System.in);
    private static PostStorageImpl postStorage = new PostStorageImpl(10);


    public static void main(String[] args) {

        boolean run = true;
        while (run) {

            Commands.printCommands();

            int option;

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
                continue;
            }

            switch (option) {
                case EXIT: {
                    run = false;
                    System.out.println("PROGRAM OVER");
                    break;
                }
                case ADD_POST: {
                    addPost();
                    break;
                }
                case SEARCH_POST: {
                    System.out.println("please, input searching keyword");
                    String keyword = scanner.nextLine();
                    postStorage.searchPostsByKeyword(keyword);
                    break;
                }
                case POSTS_BY_CATEGORY: {
                    System.out.println("please input searching post's category");
                    String searchingCategory = scanner.nextLine().toUpperCase(Locale.ROOT);
                    postStorage.printPostsByCategory(searchingCategory);

                    break;
                }
                case ALL_POSTS: {
                    postStorage.printAllPosts();
                    break;
                }
                case DELETE_POST: {
                    System.out.println("please input deleted post's title");
                    String title = scanner.nextLine();
                    postStorage.deletePostByTitle(title);
                    break;
                }
                case CHANGE_POST: {
                    changePostTitleAndTextByTitle();

                    break;
                }
                case DELETE_BY_CATEGORY: {
                    System.out.println("please input What Category's posts do you want to Delete");
                    for (Category allCategory : Category.values()) {
                        System.out.println(allCategory);
                    }
                    String deleteCategory = scanner.nextLine().toUpperCase(Locale.ROOT);
                    postStorage.deletePostsByCategory(deleteCategory);
                    break;
                }
                default: {
                    System.err.println("wrong option, please try again");
                }
            }

        }


    }

    private static void changePostTitleAndTextByTitle() {
        System.out.println("Please input changing post's title ");
        String changingPostTitle = scanner.nextLine();
        Post post = postStorage.getPostByTitle(changingPostTitle);

        if (post != null) {
            System.out.println("please input NEW title");
            post.setTitle(scanner.nextLine());

            System.out.println("please input NEW text");
            post.setText(scanner.nextLine());

            System.out.println("post by title '" + changingPostTitle + "' was sucsessfully changed to '" + post.getTitle() + "'");
        }


    }

    private static void addPost() {

        Post post = new Post();

        System.out.println("please input category:");
        for (Category allCategory : Category.values()) {
            System.out.println(allCategory);
        }

        try {
            Category category = Category.valueOf(scanner.nextLine().toUpperCase(Locale.ROOT));

            System.out.println("please input title");
            String title = scanner.nextLine();

            System.out.println("please input text");
            String text = scanner.nextLine();

            post.setCreatedDate(new Date());
            post.setTitle(title);
            post.setCategory(category);
            post.setText(text);

            postStorage.add(post);
            System.out.println("Post added ))) ");

        } catch (IllegalArgumentException e) {

            System.err.println("wrong category, please try again");

            addPost();
        }


    }

}
