import java.io.*;
import java.net.*;

public class SimpleClient{
    public static void main(String[]args){
    Socket client;
    DataInputStream input;
    try {
        client = new Socket("localhost",1254);
        input = new DataInputStream(client.getInputStream());
        BufferedReader read = new BufferedReader(new InputStreamReader(input));
        System.out.println(read.readLine());
    } catch (Exception e) {
        System.out.println(e);
    }
}
}