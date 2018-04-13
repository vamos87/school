<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#### Zadanie 1

Szyfr Cezara jest to szyfr za pomocą, którego Juliusz Cezar szyfrował swoje listy do Cycerona.

W pliku `Main1.java` umieść metodę o sygnaturze `static String encode(String str)`.
 
1. Uzupełnij ciało metody tak, by zwracała napis zaszyfrowany szyfrem Cezara   

#### Zadanie 2

W pliku `Main2.java` umieść zmodyfikowaną metodę z zadania domowego 1 o sygnaturze `static String encode(String str, int shift)`.
 
1. `shift` - oznacza przesunięcie znaków
2. Dodaj metodę deszyfrującą `static String decode(String str, int shift)` .


#### Zadanie 3

W pliku `Main3.java` umieść  metodę  o sygnaturze `static String upperCase(String str, int index)` .

1. Metoda zwraca napis `str`, w którym znaki zostały zamienione na duże z pozycji podzielnych przez `index`


#### Zadanie 4

W pliku `Main4.java` umieść  metodę  o sygnaturze `static int tripple(String str)` 
1. Metoda zwraca ilość potrójnych wystąpień znaków w napisie
Przykład dla qazbbbwsx -> 1, dla aaawsxbbb ->2

#### Zadanie 5

W pliku `Main5.java` umieść metodę o sygnaturze `static String replaceChar(String str, char forReplace, char replacement)`.

1. Uzupełnij ciało metody tak, aby zwracała napis powstały z zamiany w napisie `str`
 wszystkich zmaków `forReplace` przez znaki `replacement`.
 
#### Zadanie 6

W pliku `Main6.java` umieść metodę o sygnaturze `static String replaceStr(String str, String forReplace, String replacement)`.

1. Uzupełnij ciało metody tak, aby zwracała napis powstały z zamiany w napisie `str`
 wszystkich wystąpień napisu `forReplace` przez napis `replacement`.


#### Zadanie 7

W pliku `Main7.java` umieść metodę o sygnaturze `static String censor(String str, String[] words)`.

1. Metoda:

* rozbije łańcuch tekstowy na tablicę wyrazów,
* sprawdzi, czy nie znajdują się w nim słowa niedozwolone zawarte w tablicy `words`,
* jeśli tak -- zamieni je na cztery gwiazdki (****)
* ponownie połączy tablicę w string i zwróci wartość.
