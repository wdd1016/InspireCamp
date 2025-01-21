package member_lifecycle;

public class MethodClient {
    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    public void send() {
        System.out.println("MethodClient(SingletonCycle).send() is called ... " + this.host);
    }

    public void connect() {
        System.out.println("MethodClient(SingletonCycle).connect() is called ... ");
    }

    public void close() {
        System.out.println("MethodClient(SingletonCycle).close() is called ... ");
    }
}

