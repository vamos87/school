<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java Podstawy - Snippety
> Krótkie kawałki kodu, które pokazują zależności, rozwiązują popularne problemy oraz pokazują jak używać niektórych funkcji.

#### Jak pobrać wartość typu `int` z klawiatury i przypisać ją do zmiennej?

```Java
Scanner scan = new Scanner(System.in);
try {
  int number = scan.nextInt();
  System.out.println(number);
} catch (InputMismatchException e) {
  System.out.println("Niepoprawna");
}
```

Do dyspozycji mamy również metody dla innych typów `nextLong()`, `nextShort()`, `nextDouble()` .

#### Jak zadeklarować wiele zmiennych w jednej lini

```Java
typ_zmiennej name1, name2 ... namen;
```

Możemy równiej zainicjować dowolne zmienne
```Java
int a, b=3, c, d=11;
```


#### Jak zamienić napis na tablicę elementów typu char.
```Java
String str = new String("Java");
char[] array = str.toCharArray();
``` 

#### Jak wylosować wartość z zakresu [0,10]
```Java
Random r = new Random(); 
int a = r.nextInt(11);
``` 
 z zakresu [-5,15]
```Java
int a = r.nextInt(21)-5;
```
Do dyspozycji mamy również metody dla innych typów `nextBoolean()`, `nextDouble()`, `nextFloat()` .


#### Jak zaokrąglić liczby
Istnieje wiele sposobów na zaokrąglanie w języku java, m.in.
```Java
double roundOff = Math.round(a * 100.0) / 100.0;
```

```Java
double d = 2.34568;
DecimalFormat format = new DecimalFormat("##.00");
format.format(d);
```

```Java
BigDecimal a = new BigDecimal("123.13698");
BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
System.out.println(roundOff);
```

Jeżeli zamierzamy zmienną tylko wyświetlić:
```Java
double a = 12.345694895;
String str = String.format("%.2f", a );
System.out.println(str);
```

Jak podnieść zmienną `a` do potęgi `b`.
```Java
Math.pow(a, b);
```


#### Sekcja finally
Do bloku `try...cath` możemy dołączyć sekcję `finally`, która będzie wykonywana zawsze, niezależnie od tego, co będzie
działo się w bloku schematycznie:
```Java
try{
  ...
}catch (Exception ex){
  ...
}
finally {
  ...
}
````

