# Sistema de Criptografia Assimétrica com RSA

![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=java)
![JavaScript](https://img.shields.io/badge/JavaScript-yellow?style=for-the-badge&logo=javascript)
![Bootstrap](https://img.shields.io/badge/Bootstrap-purple?style=for-the-badge&logo=bootstrap)

Sistema completo de criptografia e descriptografia com o algoritmo RSA (Rivest-Shamir-Adleman), um dos métodos mais conhecidos de criptografia assimétrica.

Todo o algoritmo foi implementado manualmente, sem bibliotecas prontas de criptografia. Os conceitos implementados são:

- Geração de números primos
- Cálculo da função totiente de Euler
- Cálculo do máximo divisor comum (MDC)
- Algoritmo de Euclides estendido, para calcular o inverso modular

Projeto prático da disciplina de Segurança da Informação.

> Projeto didático. Cada caractere da mensagem é convertido em número pela tabela ASCII e cifrado individualmente. A implementação serve para estudar o funcionamento do RSA e não deve ser usada para proteger dados reais.

## O que o sistema faz

1. Gera um par de chaves RSA
2. Recebe uma mensagem digitada pelo usuário
3. Criptografa a mensagem com a chave pública
4. Descriptografa a mensagem com a chave privada

## Como o RSA funciona

Na criptografia assimétrica existem duas chaves relacionadas matematicamente: a **chave pública**, que pode ser compartilhada e serve para criptografar, e a **chave privada**, que deve ficar em segredo e serve para descriptografar. Esse modelo está por trás de tecnologias como HTTPS, certificados digitais e assinaturas digitais.

A segurança do RSA se baseia na dificuldade de fatorar números grandes. Os passos são:

1. Escolher dois números primos `p` e `q`
2. Calcular `n = p × q`
3. Calcular o totiente de Euler: `φ(n) = (p − 1)(q − 1)`
4. Escolher o expoente público `e` tal que `mdc(e, φ(n)) = 1` (nas implementações modernas, costuma-se usar `e = 65537`)
5. Calcular a chave privada `d = e⁻¹ mod φ(n)`, usando o algoritmo de Euclides estendido

**Criptografar:** `c = m^e mod n`, com a chave pública `(e, n)`
**Descriptografar:** `m = c^d mod n`, com a chave privada `(d, n)`

Para aplicar o RSA, cada caractere é convertido em número pela tabela ASCII. Por exemplo: `o` vira 111, `l` vira 108 e `a` vira 97.

## Tecnologias

- Java 21 (JDK 21)
- Servidor HTTP nativo do Java
- `BigInteger` para aritmética com números grandes
- HTML, JavaScript e Bootstrap no front-end

## Estrutura do projeto

```
RSA
├── backend
│   └── back
│       ├── Main.java
│       ├── model
│       │   └── RSAKeys.java
│       └── rsa
│           ├── RSA.java
│           ├── RSAKeyGenerator.java
│           └── MathUtil.java
│
└── frontend
    ├── html
    │   └── index.html
    ├── js
    │   └── app.js
    └── css
        └── style.css
```

## Como executar

**Pré-requisitos:** Java JDK 21 ou superior e o VS Code (ou outra IDE Java).

**1. Back-end:** execute a classe `Main.java`. O terminal vai mostrar:

```
RSA Server running at http://localhost:8080
```

**2. Front-end:** abra `frontend/html/index.html` no navegador, de preferência com a extensão Live Server do VS Code (endereço geralmente `http://127.0.0.1:5500`).

## Como usar

1. Clique em **Generate RSA Keys** para gerar a chave pública `(e, n)` e a chave privada `(d, n)`.
2. Digite uma mensagem, por exemplo `hello`.
3. Clique em **Encrypt**. A saída será uma sequência de números, um por caractere.
4. Clique em **Decrypt** para recuperar a mensagem original.

```
hello  ->  Encrypt  ->  133724648 782909425 1557610181 ...  ->  Decrypt  ->  hello
```

---

## Autor

**Lucas Amaral Luciano**
Desenvolvedor Full Stack Java e Angular, formado em Análise e Desenvolvimento de Sistemas pelo IFTM.

Projeto acadêmico da disciplina de Segurança da Informação, no IFTM Campus Patrocínio.

[![Portfólio](https://img.shields.io/badge/Portf%C3%B3lio-lucasamaral.dev-1f2937?style=for-the-badge&logo=googlechrome&logoColor=white)](https://lucasamaral.dev/)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-lucas--amaral--luciano-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/lucas-amaral-luciano)
[![GitHub](https://img.shields.io/badge/GitHub-LucasLubiL-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/LucasLubiL)
[![E-mail](https://img.shields.io/badge/E--mail-tech.lucas.amaral%40gmail.com-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:tech.lucas.amaral@gmail.com)
