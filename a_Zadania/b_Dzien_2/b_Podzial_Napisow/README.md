<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#  Podział napisów &ndash; zadania

Pamiętaj, aby rozwiązania do zadań umieszczać w odpowiednich plikach `java`, przygotowanych do zadań.  

### Zadania rozwiązywane z wykładowcą:

#### Zadanie 1

W pliku `Main1.java` napisz program, który:

1. podzieli na wyrazy ciąg znaków przechowywany w zmiennej `str`, znajdującej się w pliku,
2. wyświetli na konsoli każdy z tych wyrazów w oddzielnej linii.

-----------------------------------------------------------------------------

### Zadania rozwiązywane samodzielnie:

#### Zadanie 2

W pliku `Main2.java` znajduje się zmienna `str`. Napisz program, który:

1. podzieli podany ciąg znaków na zdania – znakiem podziału jest kropka `(.)`,
2. wyświetli na konsoli każde zdanie w oddzielnej linii.

#### Zadanie 3

W pliku `Main3.java`:

1. umieść metodę o sygnaturze `static int countTokens(String str)`,
2. uzupełnij ciało metody tak, aby zwracała liczbę wyrazów w podanym ciągu znaków.

Metoda powinna pomijać białe znaki.

Przykład:
dla `String str = "   To jest  tekst do   ";` mamy otrzymać wartość **4**;

#### Zadanie 4

W pliku `Main4.java` umieść metodę o sygnaturze `static String[] onlyTwoElements(String str, char separator)`.
Uzupełnij ciało metody tak, aby zwracała tablicę dwóch elementów, które powstały po podzieleniu tekstu (`str`) po pierwszym napotkanym znaku podziału (`separator`).

Przykład:
dla napisu `Java-zadania-podzial-napisow` oraz separatora `-` otrzymamy:
1. pierwszy element tablicy: `Java`
2. drugi element: `zadania-podzial-napisow`.
