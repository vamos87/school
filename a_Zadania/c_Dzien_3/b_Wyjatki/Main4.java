package a_Zadania.c_Dzien_3.b_Wyjatki;


public class Main4 {

    public static void main(String[] args) {
        int a = 1, b = 0, c;
        try {
            c = a / b;
            System.out.println(c);

        } catch (Exception ex) {
            System.out.println("Exception");

        } 
//        catch (ArithmeticException ex) {
//            System.out.println("Arithmetic Exception: You can't divide by 0");
//        }

    }


}
