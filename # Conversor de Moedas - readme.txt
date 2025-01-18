# Conversor de Moedas

Este é um projeto simples de um **Conversor de Moedas** desenvolvido para facilitar a conversão de valores entre diferentes moedas utilizando taxas de câmbio atualizadas.

## Funcionalidades

- Conversão rápida entre diversas moedas.
- Atualização automática das taxas de câmbio em tempo real.
- Interface amigável e intuitiva.
- Suporte para as principais moedas do mundo (USD, EUR, BRL, etc.).

## Tecnologias Utilizadas

- Linguagem de programação: Java
- Biblioteca(s): java.net.HttpURLConnection, org.json.JSONObject
- API de taxas de câmbio: [ExchangeRate-API](https://www.exchangerate-api.com/)
- Interface de usuário: Terminal (CLI)

## Como Utilizar

1. Clone este repositório para sua máquina local:
   ```bash
   git clone https://github.com/seu-usuario/conversor-moedas.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd conversor-moedas
   ```

3. Compile o projeto:
   ```bash
   javac -d bin src/ConversorDeMoeda.java
   ```

4. Execute o programa:
   ```bash
   java -cp bin ConversorDeMoeda
   ```

5. Siga as instruções exibidas no terminal para realizar a conversão de moedas.

## Exemplos de Uso

- Escolha uma opção de conversão (ex.: USD para BRL).
- Insira o valor a ser convertido.
- O programa exibirá o resultado baseado na taxa de câmbio atual.

Exemplo:
```plaintext
Bem-vindo ao Conversor de Moedas!
Escolha uma das opções de conversão de moedas:
1 - USD para BRL
2 - EUR para BRL
...
Digite o valor a ser convertido de USD para BRL: 50
50.00 USD equivale a 250.00 BRL
```

## Estrutura do Projeto

```plaintext
conversor-moedas/
├── src/
│   └── ConversorDeMoeda.java # Código-fonte principal
├── bin/                      # Arquivos compilados
├── README.md                 # Documentação do projeto
```

