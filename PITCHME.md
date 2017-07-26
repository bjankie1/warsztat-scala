---
### Wprowadzenie do języka Scala

Bartosz Jankiewicz | Stacja IT

http://stacja.it/warsztaty/2017-07-29-scala.html

---
### Podstawy SBT

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
### Podstawy składni
+++
### Klasy i obiekty
- class
- trait
- object
- package object
+++
### Zmienne i stałe (etykiety)
#### val
```scala
val x = 5
x: Int = 5

x = x * 2
:12: error: reassignment to val
x = x * 2
  ^
```

#### var
```scala
var x = 5
x: Int = 5

x = x * 2
x: Int = 10
```
+++
### Operatory
- Operatory są funkcjami
- Każda funkcja jednoargumentowa może być użyta w składni infix
```scala
val x = 2 + 5
val y = 2.+(5)
```
+++
### Pierwszeństwo operatorów
```
(litery)
|
^
&
= !
< >
:
+ -
* / %
(inne znaki specjalne)
```

+++
### Metody i funkcje
```scala
def add(a: Int, b: Int): Int = a + b

val multiply = (a: Int, b: Int) => a * b

/**
* Konwersja funkcji na metodę
*/
def mul = multiply(_, _)
```
+++
### Zapis infix i nawiasy
```scala
"abc".length()
"abc".length
"abc" length

"abc".endsWith("c")
"abc" endsWith("c")
"abc" endsWith "c"
```
+++
### Typ Unit
- Zapisywany także jako `()`
- Funkcja zwracająca `Unit` jest analogią do `void` w Java
- `Unit` jest jednak obiektem dziedziczącym po `AnyVal`
+++
### Bloki kodu

+++
### return
- Nie jest dokładnie tym co myślisz!

+++
### Metoda `apply`

+++
### Aliasy
```scala
type IntList = List[Int]

type UserId = Long

type Converter = String => UserId
```
+++
### Pakiety
```scala
package myapp
package services
```
+++
### Import
```scala
import com.my.app._
import com.my.app.{User, UserService}
import com.my.app.{UserService => US}

```

+++
### Currying

+++
### Domknięcia

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
### Konstrukcje
- pattern matching
- extractors
- krotki
- for comprehension

+++
### Ekstraktory

+++
### Krotki
```scala
val user = ("Marek", 25)
val (_, age) = user
```

+++
### Pattern matching

```scala
val x = Some("abc")

x match {
  case Some("def") => println("Znalazlem def")
  case Some(value) => println("Znalazlem " + value)
  case None => println("Nic nie znalazłem")
}
```
+++
### For comprehension

---
### Typy generyczne

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
### Collections

- List, Map, Set, Seq
- mutable or immutable


---
### Obsługa błędów

+++
### Zacznijmy od unikania wyjątków

Pomogą nam w tym:
- Option[+T]     |
- Try[+T]        |
- Either[+A, +B] |

Oraz w ramach biblioteki Cats:
- Validated[+E, +A] 

+++
### Przećwiczmy to

+++
```scala

/**
 * Skonwertuj tekst na liczbę.
 */
def strToInt(s: String): Try[Int] = ???
```

+++
```scala
/**
 * Znajdź pierwszy tekst w tablicy będący liczbą.
 */
def firstNumber(a: Array[String]): Option[Int] = ???
```
+++
```scala
case class User(name: String, age: Int)

/**
 * Sparsuj wartość argumentu `input` do klasy User.
 * Wartość w pola odpowiada wzorcowi: name:age
 * gdzie 'age' jest liczbą całkowitą.
 * Jeśli wzorzec będzie inny odpowiedni komunikat
 * powinien się znaleźć w rezultacie typu Left
 */
def validateInput(input: String): Either[String, User]

```
---
### Jak to przetestować?


---
### Implicits

---
### Programowanie asynchroniczne

---
### Co dalej?

- https://www.coursera.org/specializations/scala
- https://twitter.github.io/scala_school/
- https://www.manning.com/books/functional-programming-in-scala
- http://www.scalatest.org/user_guide