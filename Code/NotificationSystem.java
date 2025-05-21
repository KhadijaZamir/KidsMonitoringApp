
import javax.swing.JLabel;



interface NotificationListener {
    void receiveNotification(String msg);
}

class User implements NotificationListener {
    private String name;
    public User(String name, JLabel lblNotification){
        this.name = name;
    }
    
    public void receiveNotification(String msg){
        System.out.println("Notification for " + name + ": " + msg);
    }
            
}
class NotificationGenerator{
    private NotificationListener  listener;
    public void registerListener(NotificationListener listener){
        this.listener = listener;
    }
    
    public void detectdanger(boolean isdangerous){
        if(isdangerous){
            generateNotification();
        }
    }
    
    private void generateNotification() {
        if (listener != null) {
            listener.receiveNotification("Dangerous activity detected! Please check.");
        }
    }
}

public class NotificationSystem {

    
    public static void main(String args[]) {
        JLabel lblNotification = null;
        // TODO code application logic here
        User parent = new User("Khadija Zamir", lblNotification);

        // Create notification generator
        NotificationGenerator generator = new NotificationGenerator();

        // Register user as listener
        generator.registerListener(parent);

        // Simulate detection of dangerous activity
        generator.detectdanger(true);
    }
}
