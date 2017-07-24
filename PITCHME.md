---
### Wprowadzenie do języka Scala

Bartosz Jankiewicz | Stacja IT

http://stacja.it/warsztaty/2017-07-29-scala.html
---
### Aplikacja w Scala

```scala
object HelloApp extends App {

}
```
+++

Kod, który znajduje się w ciele klasy jest konstruktorem.

Spróbujmy użyć obiektu `scala.io.StdIn` do czytania czegoś ze standardowego wejścia:

```scala
StdIn.readLine("Napisz coś: ")
```

Potem wydrukujmy odpowiedź i spytajmy się ponownie. Wychodzimy z programu, kiedy
na wejściu nic nie ma (Enter). Drukujemy za pomocą polecenia `println`

+++
**Ciekaw jesteś pewnie skąd się bierze funkcja `println`?**
---

### Case classes

---
### Exercise
http://practice.geeksforgeeks.org/problems/check-string/0

Napisz program, który sprawdzi, czy wszystkie znaki w danym ciągu są takie same. 


---
### Implicits

