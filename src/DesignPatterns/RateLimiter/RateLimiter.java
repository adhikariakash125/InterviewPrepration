package DesignPatterns.RateLimiter;

public interface RateLimiter {
    boolean getAcquired(int id);
}
