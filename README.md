# 🚀 Shamir's Secret Sharing Assignment (But Make It Fun!)

Welcome to the *coolest* polynomial party on GitHub! 🎉 This repo is your backstage pass to seeing how Shamir's Secret Sharing works, with a sprinkle of Java magic and a dash of Gen Z energy. If you're a recruiter, an engineer, or just someone who loves secrets (👀), you're in the right place.

---

## 🧩 The Challenge

> "Given some mysterious points, can you find the secret constant term of a polynomial?"

Of course we can! We use Lagrange interpolation (fancy math, not a TikTok dance move) to reconstruct the secret. All the roots are encoded in different bases, because why not make it extra spicy? 🌶️

---

## 📂 What's in the Box?

- `ShamirSecretSharing.java` – The main event. All the logic, all the drama.
- `testcase1.json` & `testcase2.json` – Sample test cases. Try not to leak the secrets!
- `Verification.java` – Double-checks the math, because trust issues.
- `pom.xml` – Maven config (if you're feeling fancy).
- `README.md` – This file. You're reading it. Meta, right?

---

## 🛠️ How to Run This Bad Boy

### Prereqs
- Java 11+ (because we're not living in the Stone Age)

### Quick Start
```bash
javac ShamirSecretSharing.java
java ShamirSecretSharing
```

If you want to flex with Maven:
```bash
mvn compile
mvn exec:java
```

---

## 🤓 How It Works (No Gatekeeping)

1. **Decode the points** – Each y-value is in a different base. We decode them like secret messages.
2. **Lagrange interpolation** – We use math (the good kind) to reconstruct the polynomial and find the constant term (the secret!).
3. **BigInteger** – Because these numbers are thicc.
4. **Print the secret** – And flex on your friends.

---

## 🧪 Test Cases (Spoiler Alert)

### Test Case 1
- n = 4, k = 3
- Points: (1,4), (2,7), (3,12), (6,39)
- **Secret:** `3` (Shhh 🤫)

### Test Case 2
- n = 10, k = 7
- Points: Big numbers, big vibes
- **Secret:** `79836264049851` (Don't tell anyone)

---

## 🏆 Output Example
```
Solving Test Case 1:
n = 4, k = 3
Point 1: (1, 4)
Point 2: (2, 7)
Point 3: (3, 12)
Point 4: (6, 39)
Secret (constant term c): 3

Solving Test Case 2:
n = 10, k = 7
Point 1: (1, 995085094601491)
Point 2: (2, 21394886326566393)
Point 3: (3, 196563650089608567)
Point 4: (4, 1016509518118225951)
Point 5: (5, 3711974121218449851)
Point 6: (6, 10788619898233492461)
Point 7: (7, 26709394976508342463)
Point 8: (8, 58725075613853308713)
Point 9: (9, 117852986202006511971)
Point 10: (10, 220003896831595324801)
Secret (constant term c): 79836264049851
```

---

## 🧠 The Math-y Bit

We use Lagrange interpolation to reconstruct the polynomial. It's like assembling IKEA furniture, but with more Greek letters and less Allen keys. For a degree m polynomial, you need m+1 points. We plug in x=0 to get the secret (the constant term).

---

## 👨‍💻 About Me

Hey! I'm Aryan, a Java enthusiast, meme connoisseur, and aspiring software engineer. I love solving puzzles, automating boring stuff, and making code a little less boring. If you liked this project, let's connect! (Or just send me a meme, that's cool too.)

---

*May your bugs be shallow and your secrets well-shared!* ✨ 