import java.io.*;
import java.net.*;

public class TestClient {

	public static void main(String[] args)
	{
		Socket socket;
		try
		{
			socket = new Socket(InetAddress.getByName("localhost"), 1224);
		
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		
			System.out.println("I am connected to server");
			
			out.writeObject(new String("false"));
			out.flush();
			
			out.writeObject(new Complex(14, -3));
			out.flush();
			
			out.writeObject(new Complex(3, 4));
			out.flush();
			
			out.writeObject(new String("*"));
			out.flush();
			
			Complex result = (Complex)in.readObject();
			
			System.out.println(result);
			
			
			Thread.sleep(10000);
			
			System.out.println("Session ended");
			
			out.writeObject(new String("true"));
			out.flush();
			
			in.close();
			out.close();
			
			
			
			socket.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
