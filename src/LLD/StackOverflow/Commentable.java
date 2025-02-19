package LLD.StackOverflow;

import java.util.List;

public interface Commentable {
    void addComment(Comments comment);
    List<Comments> getComments();
}
