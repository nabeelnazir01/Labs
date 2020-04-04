import java.io.*;
import java.net.*;

public class SimpleServer{
    public static void main(String[]args){
    ServerSocket server;
    PrintStream os;
    Socket client;
    try {
        server = new ServerSocket(1254);
        client = server.accept();
        os = new PrintStream(client.getOutputStream());
        os.println("Hello World!");
    } catch (Exception e) {
        System.out.println(e);
    }
    }
}