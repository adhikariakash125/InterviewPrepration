package LLD.StackOverflow;

import java.util.ArrayList;
import java.util.List;

public class Answers implements Votable,Commentable{
    private String content;
    private final List<Comments> comments;
    private List<Vote> votes;
    private User author;
    private Boolean isAccepted;

    public Answers() {
        this.isAccepted = false;
        this.comments = new ArrayList<>();
    }

    @Override
    public void addComment(Comments comment) {
        comments.add(comment);
    }

    @Override
    public List<Comments> getComments() {
        return comments;
    }

    @Override
    public void vote(User user, int value) {
        if (value!=1 && value!=-1) {
            throw new IllegalArgumentException("Value can only be +1 or -1");
        }
        votes.removeIf(vote -> vote.getUser().equals(user));
        votes.add(new Vote(value,user));
        user.setReputation(user.getReputation()+15);
    }

    @Override
    public int getVoteCount() {
        return 0;
    }
}
