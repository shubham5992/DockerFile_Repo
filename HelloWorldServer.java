import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HelloWorldServer {
    public static void main(String[] args) throws IOException {
        // Create an HTTP server on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        
        // Create a context that listens to the root URL
        server.createContext("/", new HelloWorldHandler());
        
        // Start the server
        server.setExecutor(null); // creates a default executor
        server.start();
        
        System.out.println("Server is running on http://localhost:8000/");
    }

    // Handler for HTTP requests
    static class HelloWorldHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // HTML content to be sent in response
            String response = "<html><body style='text-align: center;'>" +
                              "<h1 style='color: blue;'>Hello, World!</h1>" +
                              "<p style='font-size: 20px;'>Welcome to my fancy page!</p>" +
                              "</body></html>";
            
            // Set response headers
            exchange.getResponseHeaders().set("Content-Type", "text/html");
            
            // Send the response
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
