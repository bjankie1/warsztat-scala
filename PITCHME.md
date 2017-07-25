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

Coś, czego brakuje w Java.
</br>
Case class to zwykła klasa z dużą ilością cukru składniowego:
- hashCode na wszystkich polach
- toString
- equals
- jest serializowalna
- posiada extractor oraz funkcję apply
- posiada operator kopiowania ze zmianą pola

---
### Generics

```scala
class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class
```
+++
### Example

---
### Exercise
http://practice.geeksforgeeks.org/problems/check-string/0

Napisz program, który sprawdzi, czy wszystkie znaki w danym ciągu są takie same. 


---
### Implicits

---
### Collections

- List, Map, Set, Seq
- mutable or immutable

---
### Error handling

+++
### Zacznijmy od unikania wyjątków

Pomogą nam w tym:
- Option[+T]
- Try[+T]
- Either[+A, +B]

Oraz w ramach biblioteki Cats:
- Validated[+E, +A] 

+++
### Przećwiczmy to

Napisz następujące funkcje:

```scala

/**
 * Skonwertuj tekst na liczbę.
 */
def strToInt(s: String): Try[Int] = ???

/**
 * Znajdź pierwszy tekst w tablicy będący liczbą.
 */
def firstNumber(a: Array[String]): Option[Int] = ???

case class User(name: String, age: Int)

/**
 * Sparsuj wartość argumentu `input` do klasy User. Wartość w pola odpowiada wzorcowi:
 * `name:age`
 * gdzie age jest liczbą całkowitą.
 * Jeśli wzorzec będzie inny odpowiedni komunikat powinien się znaleźć w rezultacie
 * tupu Left
 */
def validateInput(input: String): Either[String, User]

```