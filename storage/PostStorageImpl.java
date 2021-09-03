package blog.storage;

import blog.model.Post;
import blog.interfases.PostStorage;

public class PostStorageImpl implements PostStorage {
    private Post[] posts;
    private int size;

    public PostStorageImpl(int arrayLenght) {
        posts = new Post[arrayLenght];
        size = -1;
    }

    @Override
    public void add(Post post) {
        if (size == posts.length - 1) {
            extend();
        }
        posts[++size] = post;
    }

    private void extend() {
        Post[] tmp = new Post[posts.length + 1];
        System.arraycopy(posts, 0, tmp, 0, posts.length);
        posts = tmp;
    }

    @Override
    public Post getPostByTitle(String title) {
        boolean notFound = true;
        if (size > -1) {
            for (int i = 0; i <= size; i++) {
                if (title.equalsIgnoreCase(posts[i].getTitle())) {
                    notFound = false;
                    return posts[i];
                }
            }
            if (notFound) {
                System.err.println("not found post");
            }
        }
        return null;
    }

    @Override
    public void searchPostsByKeyword(String keyword) {

        boolean notfound = true;

        if (notEmpty()) {
            for (int i = 0; i <= size; i++) {

                if (!posts[i].getTitle().contains(keyword) && !posts[i].getText().contains(keyword)) {
                    continue;
                }
                notfound = false;
                System.out.println(posts[i]);
            }
            if (notfound) {
                System.err.println("not found post");
            }

        }

    }

    @Override
    public void printAllPosts() {
        if (notEmpty()) {

            for (int i = 0; i <= size; i++) {
                System.out.println(posts[i]);
            }

        }
    }

    @Override
    public void printPostsByCategory(String searchingCategory) {
        if (notEmpty()) {

            boolean notfound = true;

            for (int i = 0; i <= size; i++) {
                if (posts[i].getCategory().name().equals(searchingCategory)) {
                    System.out.println(posts[i]);
                    notfound = false;
                }
            }

            if (notfound) {
                System.out.println("not found posts by category " + searchingCategory);
            }
        }

    }


    public void deletePostByTitle(String title) {

        if (notEmpty()) {
            Post deletedPost = getPostByTitle(title);
            if (deletedPost == null) {
                System.err.println("not found post by title " + title);
            } else {
                for (int i = 0; i <= size; i++) {

                    if (posts[i].equals(deletedPost)) {

                        for (int j = i; j < size; j++) {
                            posts[i] = posts[i + 1];
                        }

                    }
                }
                size--;
                System.out.println("post by title " + title + "sucsessfull deleted");

            }

        }


    }

    public void deletePostsByCategory(String deleteCategory) {
        if (notEmpty()) {
            boolean haveCategoryPost = false;
            int count = 0;
            for (int i = 0; i <= size; i++) {
                if (posts[i].getCategory().name().equals(deleteCategory)) {
                    haveCategoryPost = true;
                    count++;
                }
            }

            if (haveCategoryPost) {
                int newSize = -1;
                Post[] tmp = new Post[size];

                for (int i = 0; i <= size; i++) {
                    if (!posts[i].getCategory().name().equals(deleteCategory)) {
                        tmp[++newSize] = posts[i];
                    }
                }

                posts = tmp;
                size = newSize;
                System.out.println(count + "posts by Category " + deleteCategory + " deleted");
            } else {
                System.err.println("not have posts by Category " + deleteCategory);
            }

        }
    }

    public boolean notEmpty() {
        if (size > -1) {
            return true;
        } else {
            System.err.println("not have posts");
            return false;
        }
    }

}
