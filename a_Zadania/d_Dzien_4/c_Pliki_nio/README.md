<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#  Pliki java.nio &ndash; zadania  

Pamiętaj aby rozwiązania do zadań umieszczać w odpowiednich plikach `java`, przygotowanych do zadań.  

### Zadania rozwiązywane z wykładowcą:

#### Zadanie 1

W pliku `Main1.java` stwórz metodę o sygnaturze `static void createDirectory(String fileName)`.

1. Uzupełnij ciało metody tak, aby tworzyła katalog o zadanej nazwie,
2. sprawdzaj czy katalog nie istnieje,
3. wykorzystaj metody klas pakietu `java.nio.file`: `Files.exists(directory)` oraz `Files.createDirectory(directory);`.

-----------------------------------------------------------------------------   
   
### Zadania rozwiązywane samodzielnie:

#### Zadanie 2

W pliku `Main2.java` stwórz metodę o sygnaturze `static void createFile (String fileName)`.

1. Uzupełnij ciało metody tak, aby tworzyła plik o zadanej nazwie,
2. sprawdzaj czy plik nie istnieje,
3. wykorzystaj metody klas pakietu `java.nio.file` .


#### Zadanie 3

W pliku `Main3.java` stwórz metodę o sygnaturze `static void copyFile(String directory, String fileName, String secondFileName)`.  
Następnie:  

1. uzupełnij ciało metody tak, aby z katalogu `directory` kopiowała plik o nazwie `fileName` do pliku o nazwie `secondFileName`.
2. sprawdzaj czy plik nie istnieje.


#### Zadanie 4

W pliku `Main4.java` stwórz metodę o sygnaturze `static void writeToFile(String fileName)`.  
Uzupełnij ciało metody tak, aby:

1. utworzyła (jeżeli nie istnieje) plik o nazwie `fileName`. 
2. pobierała z konsoli całe linie, a następnie zapisywała je do pliku. Wykorzystaj odpowiednią metodę klasy `Scanner`.


#### Zadanie 5

W pliku `Main4.java` stwórz metodę o sygnaturze `static void readFromFile(String fileName)`.  
Uzupełnij ciało metody tak, aby:

1. wczytała zawartość pliku podanego w parametrze metody,
2. utworzyła nowy plik o rozszerzeniu `html` i nazwie takiej samej jak plik wczytywany,
3. wpisywała do nowego pliku dane w postaci `html`, gdzie każda linia pliku wczytanego będzie się znajdować w tagu `<p>`.

Przykład:
```html
<html>
<body>
<p>pierwsza linia</p>
<p>druga linia</p>
</body>
</html>

```
