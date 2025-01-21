package member_lifecycle;

public class PrototypeClient {
    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    public void send() {
        System.out.println("PrototypeCycleClient.send() is called ... " + this.host);
    }

    public void connect() {
        System.out.println("PrototypeCycleClient.connect() is called ... ");
    }

    public void close() {
        System.out.println("PrototypeCycleClient.close() is called ... ");
    }
}
