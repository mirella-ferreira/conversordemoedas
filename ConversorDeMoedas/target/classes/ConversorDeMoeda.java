import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.json.JSONObject;

public class ConversorDeMoeda {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/ef770d8e88f7e633cdbee365/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Escolha uma das opções abaixo para realizar a conversão:");

        while (continuar) {
            // Exibindo o menu de opções para o usuário
            System.out.println("\nEscolha uma das opções de conversão de moedas:");
            System.out.println("1 - USD para BRL");
            System.out.println("2 - EUR para BRL");
            System.out.println("3 - GBP para BRL");
            System.out.println("4 - USD para EUR");
            System.out.println("5 - EUR para GBP");
            System.out.println("6 - GBP para USD");
            System.out.println("7 - Sair");

            int escolha = scanner.nextInt();

            if (escolha == 7) {
                System.out.println("Programa encerrado.");
                continuar = false;  // Encerrando o loop
                break;
            }

            // Mapeando as opções para as respectivas moedas de origem e destino
            String moedaOrigem = "";
            String moedaDestino = "";

            switch (escolha) {
                case 1:
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    break;
                case 2:
                    moedaOrigem = "EUR";
                    moedaDestino = "BRL";
                    break;
                case 3:
                    moedaOrigem = "GBP";
                    moedaDestino = "BRL";
                    break;
                case 4:
                    moedaOrigem = "USD";
                    moedaDestino = "EUR";
                    break;
                case 5:
                    moedaOrigem = "EUR";
                    moedaDestino = "GBP";
                    break;
                case 6:
                    moedaOrigem = "GBP";
                    moedaDestino = "USD";
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    continue;
            }

            // Solicitando o valor que o usuário quer converter
            System.out.print("Digite o valor a ser convertido de " + moedaOrigem + " para " + moedaDestino + ": ");
            double valor = scanner.nextDouble();

            try {
                // Obtendo a taxa de conversão da API
                double taxaConversao = obterTaxaConversao(moedaOrigem, moedaDestino);
                if (taxaConversao != -1) {
                    double resultado = valor * taxaConversao;
                    System.out.printf("%.2f %s equivale a %.2f %s\n", valor, moedaOrigem, resultado, moedaDestino);
                } else {
                    System.out.println("Erro ao obter a taxa de conversão.");
                }
            } catch (Exception e) {
                System.out.println("Erro ao obter dados da API: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Função para obter a taxa de conversão da API
    private static double obterTaxaConversao(String moedaOrigem, String moedaDestino) throws Exception {
        String urlString = API_URL + moedaOrigem;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        // Lendo a resposta da API
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Processando a resposta JSON
        JSONObject jsonResponse = new JSONObject(response.toString());
        if (jsonResponse.getString("result").equals("success")) {
            JSONObject conversionRates = jsonResponse.getJSONObject("conversion_rates");
            if (conversionRates.has(moedaDestino)) {
                return conversionRates.getDouble(moedaDestino);
            } else {
                System.out.println("Moeda de destino não encontrada.");
                return -1;
            }
        } else {
            System.out.println("Erro na resposta da API.");
            return -1;
        }
    }
}
