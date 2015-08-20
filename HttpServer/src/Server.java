import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static ServerSocket server;
	private static String html;
	private static String css = "";

	private static void readHtmlFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"index.html"));
			while (reader.ready()) {
				html += reader.readLine();
			}
			reader.close();
			System.out.println(html);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	private static void readHtmlOtherFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"other.html"));
			while (reader.ready()) {
				html += reader.readLine();
			}
			reader.close();
			System.out.println(html);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	private static void readCssFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(
					"main.css"));
			while (reader.ready()) {
				css += reader.readLine();
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	private static void setupServer() {
		try {
			server = new ServerSocket(80);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void waitForClients() {
		try {
			Socket client = server.accept();
			new ClientThread(client);
		} catch (IOException e) {
		}
	}

	private static class ClientThread extends Thread {

		private BufferedReader reader;
		private BufferedWriter writer;
		private Socket socket;

		public ClientThread(Socket socket) {
			this.socket = socket;
			try {
				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				writer = new BufferedWriter(new OutputStreamWriter(
						socket.getOutputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			start();
		}

		@Override
		public void run() {
			try {


				String get = reader.readLine();
				if (get.split(" ")[1].equals("/")) {
					html = "";
					readHtmlFile();
					writer.write(html);
				}
				if (get.split(" ")[1].equals("/main.css")) {
					writer.write(css);
				}
				if (get.split(" ")[1].equals("/other.html")) {
					html = "";
					readHtmlOtherFile();
					writer.write(html);
				}

				writer.newLine();
				writer.flush();
				writer.close();
				socket.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		readCssFile();
		setupServer();
		for (;;) {
			waitForClients();
		}

	}

}
