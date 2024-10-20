package DesignPatterns.RateLimiter;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TokenRateLimiter implements RateLimiter {

    private final Integer bucket;

    private final Long allowedTime;

    private final HashMap<Integer, Pair<Integer, Long>> userMap;

    public TokenRateLimiter(Integer bucket, Long allowedTime) {
        this.bucket = bucket;
        this.allowedTime = allowedTime;
        this.userMap = new HashMap<>();
    }

    @Override
    public boolean getAcquired(int id) {
        if (!userMap.containsKey(id)) {
            userMap.put(id, new Pair<>(bucket - 1, System.currentTimeMillis() + this.allowedTime));
            return true;
        } else {
            Pair user = userMap.get(id);
            int bucketToken = (int) user.getKey();
            long allottedTime = (long) user.getValue();
            if (bucketToken > 0) {
                userMap.put(id, new Pair<>(bucketToken-1,allottedTime));
                return true;
            }else {
                if (System.currentTimeMillis() > allottedTime){
                    userMap.put(id, new Pair<>(this.bucket-1,System.currentTimeMillis() + this.allowedTime));
                    return true;
                }else {
                    return false;
                }
            }
        }
    }
}
