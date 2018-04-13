<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#### Zadanie 1

W pliku `Main1.java` umieść metodę o sygnaturze `static double dogAge(double dogAge)` , która przeliczy wiek psa w psich latach. 

* funkcja powinna przyjmować wiek psa jako parametr,
* dla pierwszych dwóch lat, każdy rok życia psa jest równy 10.5 ludzkiego roku,
* powyżej dwóch lat, każdy rok życia psa, to 4 ludzkie lata,
* funkcja powinna zwrócić wiek psa.

##### Przykład:
```
dogAge(1.5)  # spodziewany wynik: 1.5 * 10.5 = 15.75

dogAge(5)  # spodziewany wynik: 2 * 10.5 + 3 * 4 = 33
```

#### Zadanie 2

W pliku `Main2.java` umieść metodę o sygnaturze `static boolean divisibleBy(int a, int b )`: 

1. Uzupełnij ciało metody tak aby zwracała `true` bądź `false` w zależności czy zmienna `a` jest podzielna przez `b`.


#### Zadanie 3

W pliku `Main3.java` umieść metodę o sygnaturze `static int[] minimum(int[][] arr)`.
 
1. Uzupełnij ciało metody tak, aby dla otrzymanej tablicy 2-wymiarowej dla każdego jej wiersza wyznaczyła minimalną wartość.
2. Poszczególne minimalne wartości mają być umieszczone w tablicy, którą metoda zwraca.

#### Zadanie 4

W pliku `Main4.java` umieść metodę o sygnaturze `static int[] lessMore(int[][] arr)`.
 
1. Uzupełnij ciało metody tak, aby dla otrzymanej tablicy 2-wymiarowej obliczyć średnią arytmetyczną.
2. Oblicz ile elementów jest mniejszych a ile większych od średniej.
3. Metoda ma zwrócić tablicę składającą się z 2 elementów 1 - ilość elementów mniejszych od średniej, 2- ilość elementów większych.


#### Zadanie 5

W pliku `Main5.java` umieść metodę o sygnaturze `static int[] append(int[] arr)`. 
 
1. Uzupełnij ciało metody tak, aby dla otrzymanej tablicy jej zawartość została skopiowana do tymczasowej tablicy,
 której rozmiar ma być 2-krotnie większy od tablicy podanej.
2. Uzupełnij brakujące elementy tymczasowej tablicy elementami tablicy pierwotnej w odwrotnej kolejności.
3. Metoda ma zwrócić skopiowaną i uzupełnioną tablicę.
Przykład: dla tablicy int arr[] = {1,2,3}; ma zostać zwrócona tablica int arrTmp[] = {1,2,3,3,2,1};

#### Zadanie 6

W pliku `Main6.java` umieść metodę o sygnaturze `static int evenSum(int[][] arr)`.
 
1. Uzupełnij ciało metody tak, aby zliczyła sumę wartości dla wszystkich elementów z nieparzystych indeksów.
2. Metoda ma zwrócić sumę.
Przykład: dla tablicy int arr[][] = {{1,2,3},{4,5,6}}; int sum = 2 + 5;
