package back;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import back.rsa.RSA;
import back.rsa.RSAKeyGenerator;
import back.model.RSAKeys;

import java.io.*;
import java.net.InetSocketAddress;
import java.math.BigInteger;

public class Main {

    private static RSAKeys Lal_keys;

    public static void main(String[] args) throws Exception {

        HttpServer Lal_server = HttpServer.create(new InetSocketAddress(8080), 0);

        Lal_server.createContext("/generateKeys", Main::generateKeys);
        Lal_server.createContext("/encrypt", Main::encrypt);
        Lal_server.createContext("/decrypt", Main::decrypt);

        Lal_server.start();

        System.out.println("Servidor RSA rodando em http://localhost:8080");
    }

    private static void generateKeys(HttpExchange Lal_exchange) throws IOException {

        handleCors(Lal_exchange);

        if (Lal_exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            Lal_exchange.sendResponseHeaders(200, -1);
            return;
        }

        Lal_keys = RSAKeyGenerator.generateKeys();

        String Lal_response =
                "{ \"e\":\"" + Lal_keys.e +
                "\", \"d\":\"" + Lal_keys.d +
                "\", \"n\":\"" + Lal_keys.n + "\" }";

        sendResponse(Lal_exchange, Lal_response);
    }

    private static void encrypt(HttpExchange Lal_exchange) throws IOException {

        handleCors(Lal_exchange);

        if (Lal_exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            Lal_exchange.sendResponseHeaders(200, -1);
            return;
        }

        if (Lal_keys == null) {

            String Lal_response = "{ \"encrypted\":\"Erro: gere as chaves primeiro\" }";

            sendResponse(Lal_exchange, Lal_response);

            return;
        }

        String Lal_body = readBody(Lal_exchange);

        String Lal_message = Lal_body
                .replace("{", "")
                .replace("}", "")
                .replace("\"", "")
                .replace("message:", "");

        StringBuilder Lal_result = new StringBuilder();

        for (char Lal_char : Lal_message.toCharArray()) {

            BigInteger Lal_m = BigInteger.valueOf((int) Lal_char);

            BigInteger Lal_cipher = RSA.encrypt(Lal_m, Lal_keys.e, Lal_keys.n);

            Lal_result.append(Lal_cipher.toString()).append(" ");
        }

        String Lal_response =
                "{ \"encrypted\":\"" + Lal_result.toString().trim() + "\" }";

        sendResponse(Lal_exchange, Lal_response);
    }

    private static void decrypt(HttpExchange Lal_exchange) throws IOException {

        handleCors(Lal_exchange);

        if (Lal_exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            Lal_exchange.sendResponseHeaders(200, -1);
            return;
        }

        if (Lal_keys == null) {

            String Lal_response = "{ \"decrypted\":\"Erro: gere as chaves primeiro\" }";

            sendResponse(Lal_exchange, Lal_response);

            return;
        }

        String Lal_body = readBody(Lal_exchange);

        String Lal_encrypted = Lal_body
                .replace("{", "")
                .replace("}", "")
                .replace("\"", "")
                .replace("encrypted:", "");

        String[] Lal_numbers = Lal_encrypted.split(" ");

        StringBuilder Lal_result = new StringBuilder();

        for (String Lal_num : Lal_numbers) {

            BigInteger Lal_cipher = new BigInteger(Lal_num);

            BigInteger Lal_message = RSA.decrypt(Lal_cipher, Lal_keys.d, Lal_keys.n);

            Lal_result.append((char) Lal_message.intValue());
        }

        String Lal_response =
                "{ \"decrypted\":\"" + Lal_result.toString() + "\" }";

        sendResponse(Lal_exchange, Lal_response);
    }

    private static String readBody(HttpExchange Lal_exchange) throws IOException {

        BufferedReader Lal_reader = new BufferedReader(
                new InputStreamReader(Lal_exchange.getRequestBody())
        );

        StringBuilder Lal_body = new StringBuilder();

        String Lal_line;

        while ((Lal_line = Lal_reader.readLine()) != null) {

            Lal_body.append(Lal_line);
        }

        return Lal_body.toString();
    }

    private static void sendResponse(HttpExchange Lal_exchange, String Lal_response) throws IOException {

        byte[] Lal_bytes = Lal_response.getBytes();

        Lal_exchange.sendResponseHeaders(200, Lal_bytes.length);

        OutputStream Lal_os = Lal_exchange.getResponseBody();

        Lal_os.write(Lal_bytes);

        Lal_os.close();
    }

    private static void handleCors(HttpExchange Lal_exchange) {

        Lal_exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        Lal_exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        Lal_exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
    }
}