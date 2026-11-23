# DSA Project 2: Super Simple BST Game

A minimal, beginner-friendly console game designed to teach **Binary Search Trees (BST)** in seconds.

---

## 🎯 The Only Rule You Need to Know:
At each node in a Binary Search Tree:
* If the incoming number is **smaller** ($<$) $\longrightarrow$ type **`L`** (Left)
* If the incoming number is **bigger** ($>$) $\longrightarrow$ type **`R`** (Right)

When you reach an empty slot, the number is placed into the tree, your tree grows, and you score $+1$ point!

---

## 🚀 How to Run in Console

Open your terminal in this folder:
```powershell
cd "c:\Users\avina\Downloads\DSA project 2"
```

### Option 1: PowerShell (Instant, zero setup on Windows)
```powershell
powershell -ExecutionPolicy Bypass -File .\simple_game.ps1
```

### Option 2: Python
```bash
python simple_game.py
```

### Option 3: Java
```bash
java SimpleGame.java
```

---

## 🎮 Gameplay Preview

```text
==================================================
      SUPER SIMPLE BST (BINARY SEARCH TREE) GAME
==================================================
⭐ SCORE: 0
CURRENT TREE:
 ROOT: 50

👉 INCOMING NUMBER: 32
--------------------------------------------------
At node [50], which way does 32 go? (L/R) [Q to quit]: L
✅ Correct! Moving L...
🎉 Slot found! Placed 32 in the tree!
🌟 +1 Point! Total Score: 1
📚 Sorted numbers in tree (In-Order): [32, 50]
```
