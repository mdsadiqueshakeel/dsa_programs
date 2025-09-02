# 🚀 DSA Syntax Cheat Sheet (Java → Python → JavaScript)

This cheat sheet helps you quickly switch between **Java**, **Python**, and **JavaScript** when doing DSA or problem solving.

---

## 1️⃣ Printing

| Java | Python | JavaScript |
|------|--------|------------|
| `System.out.println("Hello");` | `print("Hello")` | `console.log("Hello");` |

---

## 2️⃣ Input

| Java | Python | JavaScript |
|------|--------|------------|
| `Scanner sc = new Scanner(System.in); int n = sc.nextInt(); String s = sc.nextLine();` | `n = int(input())  s = input()` | `// Node.js prompt-sync` <br> `const prompt = require("prompt-sync")();` <br> `let n = parseInt(prompt());` <br> `let s = prompt();` |

Array input:
| Java | Python | JavaScript |
|------|--------|------------|
| `int n = sc.nextInt(); int[] arr = new int[n]; for (int i=0; i<n; i++) arr[i] = sc.nextInt();` | `n = int(input()) arr = list(map(int, input().split()))` | `let arr = prompt().split(" ").map(Number);` |

---

## 3️⃣ Variables & Data Types

| Java | Python | JavaScript |
|------|--------|------------|
| `int x = 5;` <br> `double y = 3.14;` <br> `String s = "hello";` <br> `boolean flag = true;` | `x = 5` <br> `y = 3.14` <br> `s = "hello"` <br> `flag = True` | `let x = 5;` <br> `let y = 3.14;` <br> `let s = "hello";` <br> `let flag = true;` |

---

## 4️⃣ If / Else

| Java | Python | JavaScript |
|------|--------|------------|
| `if (x > 10) { System.out.println("big"); } else if (x == 10) { System.out.println("equal"); } else { System.out.println("small"); }` | `if x > 10: print("big") elif x == 10: print("equal") else: print("small")` | `if (x > 10) { console.log("big"); } else if (x === 10) { console.log("equal"); } else { console.log("small"); }` |

---

## 5️⃣ Loops

| Java | Python | JavaScript |
|------|--------|------------|
| `for (int i = 0; i < 5; i++) { System.out.println(i); }` | `for i in range(5): print(i)` | `for (let i = 0; i < 5; i++) { console.log(i); }` |
| `while (x > 0) { x--; }` | `while x > 0: x -= 1` | `while (x > 0) { x--; }` |

---

## 6️⃣ Arrays / Lists

| Java | Python | JavaScript |
|------|--------|------------|
| `ArrayList<Integer> arr = new ArrayList<>(); arr.add(10); arr.remove(0); arr.get(0);` | `arr = [] arr.append(10) arr.pop(0) arr[0]` | `let arr = []; arr.push(10); arr.shift(); arr[0];` |

---

## 7️⃣ Strings

| Java | Python | JavaScript |
|------|--------|------------|
| `String s = "hello"; s.length(); s.charAt(0); s.substring(1, 3);` | `s = "hello" len(s) s[0] s[1:3]` | `let s = "hello"; s.length; s[0]; s.substring(1, 3);` |

---

## 8️⃣ Functions

| Java | Python | JavaScript |
|------|--------|------------|
| `int add(int a, int b) { return a + b; }` | `def add(a, b): return a + b` | `function add(a, b) { return a + b; }` |

---

## 9️⃣ HashMap / Dictionary / Object

| Java | Python | JavaScript |
|------|--------|------------|
| `HashMap<String, Integer> map = new HashMap<>(); map.put("a", 1); map.get("a"); map.containsKey("b");` | `mp = {"a": 1} mp["a"] "b" in mp` | `let mp = { "a": 1 }; mp["a"]; "b" in mp;` |

---

## 🔟 For-Each Loops

| Java | Python | JavaScript |
|------|--------|------------|
| `int[] arr = {1, 2, 3}; for (int x : arr) System.out.println(x);` | `arr = [1, 2, 3] for x in arr: print(x)` | `let arr = [1, 2, 3]; for (let x of arr) console.log(x);` |

---

## 1️⃣1️⃣ Sorting

| Java | Python | JavaScript |
|------|--------|------------|
| `Arrays.sort(arr);` | `arr.sort()` | `arr.sort((a, b) => a - b);` |

---

## 1️⃣2️⃣ Common Operations

| Java | Python | JavaScript |
|------|--------|------------|
| `arr.size();` | `len(arr)` | `arr.length;` |
| `arr.contains(5);` | `5 in arr` | `arr.includes(5);` |
| `Collections.reverse(arr);` | `arr.reverse()` | `arr.reverse();` |
| `Collections.max(arr);` | `max(arr)` | `Math.max(...arr);` |
| `Collections.min(arr);` | `min(arr)` | `Math.min(...arr);` |

---

## ⚡ Key Notes

- Java = Strict, verbose, best for interviews.  
- Python = Short, easy, great for writing quick solutions.  
- JavaScript = Handy for web + coding interviews (esp. frontend/backend devs).  

---
