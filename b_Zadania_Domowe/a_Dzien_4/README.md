<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#### Zadanie 1

W pliku `Main1.java` stwórz metodę o sygnaturze `static int count(String fileName)`.

1. Uzupełnij ciało metody tak, aby zliczała i zwracała ilość znaków z pliku.

#### Zadanie 2

W pliku `Main2.java` stwórz metodę o sygnaturze `static int count(String fileName)`.

1. Uzupełnij ciało metody tak, aby zliczyła i zwracała ilość słów z pliku.

#### Zadanie 3

W pliku `Main3.java` napisz program, który:

1. Pobierze z konsoli nazwę pliku.
2. Wczyta dane w określonym formacie:

Nazwisko Imie RokUrodzenia Płeć np:

```
Kowalski Marek 1955 M
Krzak Marianna 1966 K
```

3. Stworzy i zwróci tablicę String (imię + nazwisko) osób które mogą przejść na emeryturę,
sygnatura metody `static String[] retirement()`.
Dla kobiet będzie to 60 lat, dla mężczyzn 65.

#### Zadanie 4

W pliku `Main4.java` stwórz metodę o sygnaturze `static int[] sortedArray()`.

1. Uzupełnij ciało metody tak, aby wczytała z konsoli ile liczb należy wylosować.
2. Stworzy tablicę oraz umieść w niej losowe wartości z zakresu [0,100].
3. Posortuje elementy tablicy a następnie ją zwróci.

#### Zadanie 5

W pliku `Main5.java` stwórz metodę o sygnaturze `static void printTriangle()`.

1. Uzupełnij ciało metody tak, aby wczytała z konsoli wartość typu int.
2. Wypisze na konsoli trójkąt zbudowany ze znaku `x`, w którym obie przyprostokątne będą równe wczytanej wartości
Przykład dla wczytanej wartości równej 5.

````
x
x x
x x x
x x x x 
x x x x x
````

#### Zadanie 6

W pliku `Main6.java` stwórz metodę o sygnaturze `static boolean checkFileExist()`.

1. Uzupełnij ciało metody tak, aby wczytała z konsoli nazwę pliku.
2. Sprawdzi czy plik istnieje a następnie wypisze `true` lub `false`

#### Zadanie 7

W pliku `Main7.java` stwórz metodę o sygnaturze `static boolean rewrite()`.
1. Uzupełnij ciało metody tak, aby wczytała z konsoli  nazwę pliku.
2. Sprawdzi czy plik istnieje i jeżeli istnieje stworzy drugi plik z sufiksem "_2",
 do którego 2-krotnie zostanie zapisana zawartość pliku wzorcowego.

Przykład: 
wczytana nazwa pliku `text1.txt`, z zawartością abc, zostanie utworzony plik o nazwie `text1_2.txt` o zawartości:
````
abc
abc
````

