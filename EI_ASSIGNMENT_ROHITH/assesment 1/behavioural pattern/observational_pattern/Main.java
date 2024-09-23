import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void onUpdate(String message);
}

class NewsAgency {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String currentNews;

    
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }


    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    
    private void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.onUpdate(currentNews);
        }
    }

   
    public void publishNews(String news) {
        this.currentNews = news;
        System.out.println("NewsAgency: New update published: " + news);
        notifySubscribers();
    }
}

class NewsApp implements Subscriber {
    private String appName;

    public NewsApp(String name) {
        this.appName = name;
    }

    public void onUpdate(String message) {
        System.out.println(appName + " received news: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        
        NewsAgency agency = new NewsAgency();

       
        NewsApp appOne = new NewsApp("NewsApp One");
        NewsApp appTwo = new NewsApp("NewsApp Two");
        NewsApp appThree = new NewsApp("NewsApp Three");

       
        agency.subscribe(appOne);
        agency.subscribe(appTwo);
        agency.subscribe(appThree);

        
        agency.publishNews("Breaking News: Understanding the Observer Pattern!");

        
        agency.unsubscribe(appTwo);
        agency.publishNews("Update: New Features in Java 17!");
    }
}
