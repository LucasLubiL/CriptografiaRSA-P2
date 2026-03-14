# 🔐 Asymmetric Encryption System using RSA

## 📌 Project Description

This project implements a complete **encryption and decryption system using the RSA algorithm (Rivest-Shamir-Adleman)**, one of the most well-known methods of **asymmetric cryptography**.

Unlike symmetric cryptography, where the same key is used to encrypt and decrypt data, RSA uses **two different keys**:

- **Public Key** → used to encrypt messages  
- **Private Key** → used to decrypt messages  

The entire algorithm was implemented **manually**, without using ready-made cryptographic libraries.

The implemented concepts include:

- prime number generation  
- **Euler's Totient** calculation  
- **Greatest Common Divisor (GCD)** calculation  
- implementation of the **Extended Euclidean Algorithm** to compute the modular inverse  

The system allows the user to:

1. Generate an RSA key pair  
2. Type a message  
3. Encrypt the message using the **public key**  
4. Decrypt the message using the **private key**

This project was developed as a practical assignment for the **Information Security** course.

---

# 📚 Theoretical Background

## 🔹 Asymmetric Cryptography

**Asymmetric cryptography** uses two mathematically related keys:

- **Public Key**
- **Private Key**

The public key can be shared freely and is used to **encrypt messages**.

The private key must remain secret and is used to **decrypt received messages**.

This model is widely used in technologies such as:

- HTTPS
- Digital certificates
- Digital signatures
- Secure communication on the internet

---

## 🔹 RSA Algorithm

RSA is an asymmetric encryption algorithm based on the **difficulty of factoring large numbers**.

The algorithm works through the following steps.

### 1️⃣ Choose two prime numbers

```
p
q
```

### 2️⃣ Calculate n

```
n = p × q
```

This value will be used in both the public and private keys.

---

### 3️⃣ Calculate Euler’s Totient

```
φ(n) = (p − 1)(q − 1)
```

Euler’s Totient represents the number of integers smaller than `n` that are coprime with `n`.

---

### 4️⃣ Choose the public exponent

Choose a number `e` such that:

```
gcd(e, φ(n)) = 1
```

In modern RSA implementations it is common to use:

```
e = 65537
```

---

### 5️⃣ Calculate the private key

The private key is obtained using the modular inverse of `e` with respect to `φ(n)`.

```
d = e⁻¹ mod φ(n)
```

This calculation is performed using the **Extended Euclidean Algorithm**.

---

## 🔹 Encryption Process

To encrypt a message `m`, the public key `(e, n)` is used:

```
c = m^e mod n
```

Where:

```
m → original message  
c → encrypted message
```

---

## 🔹 Decryption Process

To recover the original message, the private key `(d, n)` is used:

```
m = c^d mod n
```

This process ensures that only someone with the **private key** can recover the original message.

---

## 🔹 Character Conversion

To apply the RSA algorithm, message characters must be converted into numeric values.

In this project the conversion uses the **ASCII table**.

Example:

```
o → 111
l → 108
a → 97
```

Each character is converted into a number and then encrypted using RSA modular arithmetic.

---

# 🛠 Technologies Used

This project was developed using:

- Java (JDK 21)
- Java HTTP Server
- HTML
- JavaScript
- Bootstrap
- BigInteger (Java)

---

# 📂 Project Structure

```
RSA
│
├── backend
│   └── back
│       ├── Main.java
│       │
│       ├── model
│       │   └── RSAKeys.java
│       │
│       └── rsa
│           ├── RSA.java
│           ├── RSAKeyGenerator.java
│           └── MathUtil.java
│
└── frontend
    ├── html
    │   └── index.html
    │
    ├── js
    │   └── app.js
    │
    └── css
        └── style.css
```

---

# ▶️ How to Run the Project

## 1️⃣ Requirements

Install:

- Java JDK 21 or higher
- Visual Studio Code or any Java IDE

---

## 2️⃣ Run the Backend

Run the class:

```
Main.java
```

The server will start and display in the terminal:

```
RSA Server running at http://localhost:8080
```

---

## 3️⃣ Run the Frontend

Open the file:

```
frontend/html/index.html
```

Use the **Live Server** extension in VSCode or open it directly in the browser.

The address will usually be:

```
http://127.0.0.1:5500
```

or

```
http://127.0.0.1:5501
```

---

# 🔐 How to Use the System

1️⃣ Click **Generate RSA Keys**

The system will automatically generate:

```
Public key:
(e, n)

Private key:
(d, n)
```

---

2️⃣ Type a message.

Example:

```
hello
```

---

3️⃣ Click **Encrypt**

Example output:

```
133724648 782909425 1557610181
```

---

4️⃣ Click **Decrypt**

Result:

```
hello
```

---

# 📷 Example Workflow

```
Message
   ↓
 hello
   ↓
Encrypt
   ↓
133724648 782909425 1557610181
   ↓
Decrypt
   ↓
 hello
```

After decryption, the original message is successfully recovered.

---

# 🎥 Demonstration

The demonstration video presents:

- Code structure
- Explanation of the RSA algorithm
- Generation of public and private keys
- Encryption of a message
- Decryption of the original message

This proves that the implemented algorithm works correctly.

---

# 👨‍💻 Author - Lucas Amaral

Project developed for the **Information Security** course.
