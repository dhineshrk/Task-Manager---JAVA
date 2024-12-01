import java.util.List;
import java.util.ArrayList;


// Observer Interface
interface Subscriber {
    void update(String news);
}

// Subject Class
class NewsAgency {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notify(String news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}

// Concrete Observer
class UserSubscriber implements Subscriber {
    private String name;

    public UserSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

// Client Code
public class ObserverPattern {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        UserSubscriber user1 = new UserSubscriber("Dhinesh");
        UserSubscriber user2 = new UserSubscriber("Kumaran");

        newsAgency.subscribe(user1);
        newsAgency.subscribe(user2);

        newsAgency.notify("Breaking News: New Java Version Released!");

        newsAgency.unsubscribe(user1);

        newsAgency.notify("Update: Java 17 Released!");
    }
}
