---
### Wprowadzenie do języka Scala

Bartosz Jankiewicz | Stacja IT

http://stacja.it/warsztaty/2017-07-29-scala.html

---
### Podstawy SBT
```bash
sbt clean compile

sbt test

sbt console

```

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

+++
Uruchom aplikację za pomocą SBT

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
### Ćwiczenie

Napisz metodę podnoszącą liczbę do potęgi. 

---
### Typ Unit
- Zapisywany także jako `()`
- Funkcja zwracająca `Unit` jest analogią do `void` w Java
- `Unit` jest jednak obiektem dziedziczącym po `AnyVal`
+++
### Bloki kodu

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
---
### Wyrażenia warunkowe
```scala
def canDrink(age: Int) =
    if(age >= 18) {
      true
    } else {
      true
    }
```
+++
### Ćwiczenie

Napisz metodę konwertującą godzinę z formatu 12-godzinnego do 24 godzinnego.

```scala
def convertHour(hour: Int): Int = ???
```
+++
### Ćwiczenie

Napisz metodę liczącą silnię.
---
### Operacje na tekstach

#### string interpolation
```scala
val x = 5
val message = s"x = $x"
```

#### Znaki specjalne
```scala
val message = "name is \"Bartosz\" "
```
Można zapisać czytelniej
```scala
val message = """name is "Bartosz" """
```
---
### Currying

Weżmy pod uwagę prostą metodę:
```scala
def add(a: Int, b: Int) = a + b
```

Możnazapisać także tak:
```scala
def add(a: Int)(b: Int) = a + b
```

Dzięki temu możemy:
```scala
def addTo5 = add(5)
```
+++
### Ćwiczenie

Napisz funkcję, która sprawdza czy ktoś jest starszy niż określony parametr
```scala
def isOlderThan(limit: Int, age: Int): Boolean = ???
```

Przekształć tą funkcję tak, aby można było jej uzyć do stworzenia funkcji
odpowiadającej na pytanie czy ktoś jest pełnoletni.

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
### Ćwiczenie

Napisz metodę, która zamienia czas z godzin i minut na tekst.
Przykładowo: 5, 10 -> "piąta dziesięc"
Można to osiągnąć na wiele sposobów, ale poćwicz pattern matching :)

```scala
def tellTime(hour: Int, minute: Int): String = ???
```
+++
### Ćwiczenie

Jakie zmiany zaproponujesz do metody wcześniej żeby obsłużyć niepoprawną wartość czasu?


---
### Typy generyczne

```scala
class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class
```

+++
### Przykład

---
### Kolekcje

- List, Map, Set, Seq
- mutable or immutable

Kolekcje niemutowalne są zalecane, co pomaga uniknąć wielu niespodzianek.
Niestety W pewnych sytuacjach lepsze okazują się kolekcje mutowalne.
Przykładem takim może być optymalizacja wydajności.
+++
### Tworzenie kolekcji
```scala
val list = List(1, 2, 3)
val set = Set("a", "b", "c")
val map = Map(1 -> "a", 2 -> "b")
val arr = Array(1, 2, 3)
```
+++
### Aktualizowanie kolekcji
Pojedyncze elementy
```scala
list :+ 4
set + "d"
map + (3 -> "c")
arr(3) = 4
```
Sumowanie dwóch kolekcji:
```scala
List(1, 2, 3) ++ List(4, 5, 6)
```

+++
### Operacje na kolekcjach
- map
- filter
- flatMap
- head, drop, take
- fold, foldLeft, foldRight
- zip, zipWithIndex
- reverse
- collect

---
### Ćwiczenia
+++
Znajdź największy element w tablicy.

+++
Sprawdź czy dany tekst jest palindromem

```scala
def isPalindrome(s: String): Boolean
```

+++
Napisz funkcję, która zwróci wspólne dzielniki dla dwóch liczb

```scala
def commonDivisors(a: Int, b: Int): Seq[Int] = ???
```

+++
Policz mediane

```scala
def mean(input: Seq[Int]): Int = ???
```
+++
### For comprehension
```scala
val items = 1 to 4
for( item <- items) yield {
  item * 2
}
```


+++
### Leniwe operacje na kolekcjach
- view
- stream
- iterator
- withFilter
---
### Słowo return
- Nie jest dokładnie tym co myślisz!

Sprawdź na własnej skórze - użyj map i sum do zaimplementowania, ale w map zwróc wartość używając `return`
```scala
def multiplyAndSum(multiplier: Int, input: List[Int]): Int = ???
```

---
### Obsługa błędów

+++
### Zacznijmy od unikania wyjątków

**Pomogą nam w tym:**
- Option[+T]
- Try[+T]
- Either[+A, +B]

**Oraz w ramach biblioteki Cats:**
- Validated[+E, +A]

+++
### Przećwiczmy to

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
### Implicits
- implicit classes
- implicit attributes
- implicit values
---
### Type classes

---
### Akka HTTP
```scala
    implicit val materializer = ActorMaterializer()

    val bindingFuture: Future[Http.ServerBinding] = Http().bindAndHandle(routes, host, port)
    bindingFuture.onFailure {
      case ex: Exception =>
        logger.error(s"Failed to bind to $host, $port", ex)
    }

```

---
### Co dalej?

#### Ćwiczenia
- https://www.coursera.org/specializations/scala
- http://www.scalakoans.org
- https://twitter.github.io/scala_school/

#### Do poczytania
- https://www.manning.com/books/functional-programming-in-scala
- http://www.scalatest.org/user_guide
