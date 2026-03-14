const API = "http://localhost:8080";

async function generateKeys() {

    const res = await fetch(API + "/generateKeys");

    const data = await res.json();

    document.getElementById("publicKey").value =
        "e: " + data.e + "\n" +
        "n: " + data.n;

    document.getElementById("privateKey").value =
        "d: " + data.d + "\n" +
        "n: " + data.n;

    document.getElementById("status").innerText = "✅ Chaves RSA geradas";
}

async function encryptMessage() {

    const message = document.getElementById("message").value;

    const res = await fetch(API + "/encrypt", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            message: message
        })

    });

    const data = await res.json();

    document.getElementById("encryptedMessage").value = data.encrypted;

    document.getElementById("status").innerText = "🔒 Mensagem criptografada";
}

async function decryptMessage() {

    const encrypted = document.getElementById("encryptedMessage").value;

    const res = await fetch(API + "/decrypt", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({
            encrypted: encrypted
        })

    });

    const data = await res.json();

    document.getElementById("decryptedMessage").value = data.decrypted;

    document.getElementById("status").innerText = "🔓 Mensagem descriptografada";
}