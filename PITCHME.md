---
### Aplikacja w Scala

```scala
object HelloApp extends App {

}
```

To co się znajduje między klamrami jest już konstruktorem.

Spróbujmy użyć obiektu `scala.io.StdIn` do czytania czegoś ze standardowego wejścia:

```scala
StdIn.readLine("Napisz coś: ")
```

Potem wydrukujmy odpowiedź i spytajmy się ponownie. Wychodzimy z programu, kiedy
na wejściu nic nie ma (Enter). Drukujemy za pomocą polecenia `println`

Ciekaw jesteś pewnie skąd się bierze funkcja `println`?
---

### Case classes

----
### Exercise
http://practice.geeksforgeeks.org/problems/check-string/0

Given a string S , write a program to check if all the characters of the string are same or not.
