package DesignPatterns.RateLimiter;

public class RateLimiterApp {
    public static void main(String[] args) throws InterruptedException {
        TokenRateLimiter tokenRateLimiter = new TokenRateLimiter(5,1000L);
        for (int i=0;i<10;i++)
            System.out.println(tokenRateLimiter.getAcquired(1) + " customerid=1");
        System.out.println(tokenRateLimiter.getAcquired(2) + " customerid=2");
        System.out.println(tokenRateLimiter.getAcquired(3) + " customerid=3");
        System.out.println(tokenRateLimiter.getAcquired(4) + " customerid=4");
        System.out.println(tokenRateLimiter.getAcquired(5) + " customerid=5");
        Thread.sleep(1001);
        System.out.println(tokenRateLimiter.getAcquired(1) + " customerid=1");

    }
}
