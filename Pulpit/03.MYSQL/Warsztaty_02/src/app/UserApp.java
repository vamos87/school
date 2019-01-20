package app;

import model.Exercise;
import model.Solution;
import util.DbManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class UserApp {
    static Scanner scan;
    public static void main(String[] args) {
        try {
            int userID = Integer.parseInt(args[0]);
            scan = new Scanner(System.in);
            String input = "";
            while (!"quit".equals(input)) {
                System.out.println("Wybierz jedną z opcji:");
                System.out.println("* add - dodawanie rozwiązania");
                System.out.println("* view - przeglądanie swoich rozwiązań");
                System.out.println("* quit - zakończenie programu");
                input = scan.nextLine();
                while (!"add".equals(input) && !"view".equals(input) && !"quit".equals(input)) {
                    System.out.println("Nieznana komenda. Spróbuj jeszcze raz.");
                    input = scan.nextLine();
                }
                if ("add".equals(input)) {
                    ArrayList<Exercise> excercise = Exercise.loadExcerciseWithoutSolutionByUser(DbManager.getInstance().getConnection(), userID);
                    for (Exercise e : excercise) {
                        System.out.println(e);
                    }
                        System.out.println("Podaj ID zadania, do którego chcesz dodać rozwiązanie:");
                    while (!scan.hasNextInt()) {
                        System.out.println("Podaj liczbę:");
                        scan.next();
                    }
                    int excerciseID = scan.nextInt();
                    scan.nextLine();

                    Solution solution = new Solution();
                    solution.setUpdated(LocalDateTime.now().toString());
                    System.out.println("Podaj rozwiązanie zadania:");
                    String description = scan.nextLine();
                    solution.setDescription(description);
                    solution.setUsersId(userID);
                    solution.setExcerciseId(excerciseID);
                    solution.saveToDB(DbManager.getInstance().getConnection());
                    System.out.println("Rozwiązanie zostało dodane do zadania.");

                } else if ("view".equals(input)){
                    ArrayList<Solution> solutions = Solution.loadAllByUserId(DbManager.getInstance().getConnection(), userID);
                    for (Solution s : solutions) {
                        System.out.println(s);
                    }
                    System.out.println();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbManager.getInstance().close();
        }
    }

}
