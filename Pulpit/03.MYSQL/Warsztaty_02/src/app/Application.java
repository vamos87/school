package app;

import model.Exercise;
import model.Group;
import model.Solution;
import model.User;
import util.DbManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    static Scanner scan;
    public static void main(String[] args) {
        try {
            scan = new Scanner(System.in);

            String input = "";
            while (!"quit".equals(input)) {
                System.out.println("Witaj w szkole programowania. Wybierz jeden z poniższych modułów programu:");
                System.out.println("* user - zarządzanie użytkownikami");
                System.out.println("* exercise - zarządzanie zadaniami");
                System.out.println("* group - zarządzanie grupami");
                System.out.println("* solution - przypisywanie zadań");
                System.out.println("* quit - zakończenie programu");
                input = scan.nextLine();

                while (!"user".equals(input) && !"exercise".equals(input) && !"group".equals(input) && !"solution".equals(input) && !"quit".equals(input)) {
                    System.out.println("Nieznana komenda. Spróbuj jeszcze raz:");
                    input = scan.nextLine();
                }

                if ("user".equals(input)) {
                    userManager();
                } else if ("exercise".equals(input)) {
                    exerciseManager();
                } else if ("group".equals(input)) {
                    groupManager();
                } else if ("solution".equals(input)) {
                    solutionManager();
                }
            }
            scan.close();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbManager.getInstance().close();
        }
    }

    static void solutionManager() throws Exception {
        String inputSolution = "";
        while (!"back".equals(inputSolution)){
            System.out.println("Wybier jedną z opcji:");
            System.out.println("* add - przypisywanie zadań do użytkowników");
            System.out.println("* view - przeglądanie rozwiązań danego użytkownika");
            System.out.println("* back - powrót do menu głównego");

            inputSolution = scan.nextLine();
            while (!"add".equals(inputSolution) && !"view".equals(inputSolution) && !"back".equals(inputSolution)) {
                System.out.println("Nieznana komenda. Spróbuj jeszcze raz:");
                inputSolution = scan.nextLine();
            }
            if ("add".equals(inputSolution)) {
                System.out.println("Lista użytkowników:");
                ArrayList<User> users = User.loadAllUsers(DbManager.getInstance().getConnection());
                for (User u : users) {
                    System.out.println(u);
                }
                System.out.println("-------------------------");
                System.out.println("Podaj ID użytkownika, któremu chcesz przypisać zadanie:");
                while(!scan.hasNextInt()){
                    System.out.println("Podaj liczbę");
                    scan.next();
                }
                int id_user = scan.nextInt();
                scan.nextLine();

                ArrayList<Exercise> exercises = Exercise.loadAllExercises(DbManager.getInstance().getConnection());
                for (Exercise e : exercises) {
                    System.out.println(e);
                }
                System.out.println("-------------------------");
                System.out.println("Podaj ID zadania, które chcesz przypisać użytkownikowi:");
                while(!scan.hasNextInt()){
                    System.out.println("Podaj liczbę");
                    scan.next();
                }
                int id_exercise = scan.nextInt();
                scan.nextLine();

                Solution solution = new Solution();
                solution.setCreated(LocalDateTime.now().toString());
                solution.setUsersId(id_user);
                solution.setExcerciseId(id_exercise);
                solution.saveToDB(DbManager.getInstance().getConnection());

            } else if ("view".equals(inputSolution)){
                System.out.println("Podaj ID użytkownika, którego rozwiązania chcesz przeglądać:");
                while(!scan.hasNextInt()){
                    System.out.println("Podaj liczbę");
                    scan.next();
                }
                int id = scan.nextInt();
                scan.nextLine();
                ArrayList<Solution> solution = Solution.loadAllByUserId(DbManager.getInstance().getConnection(), id);
                for (Solution s : solution) {
                    System.out.println(s);
                }
                System.out.println("-------------------------");
            }
        }
    }

    static void groupManager() throws Exception{
        String inputGroup = "";
        while (!"back".equals(inputGroup)) {
            System.out.println("Lista grup:");
            ArrayList<Group> groups = Group.loadAllGroup(DbManager.getInstance().getConnection());
            for (Group g : groups) {
                System.out.println(g);
            }
            System.out.println("-------------------------");
            System.out.println("Wybierz jedną z opcji:");
            System.out.println("* add - dodanie grupy");
            System.out.println("* edit - edycja grupy");
            System.out.println("* delete - usunięcie grupy");
            System.out.println("* back - powrót do menu głównego");

            inputGroup = scan.nextLine();
            while (!"add".equals(inputGroup) && !"edit".equals(inputGroup) && !"delete".equals(inputGroup) && !"back".equals(inputGroup)) {
                System.out.println("Nieznana komenda. Spróbuj jeszcze raz:");
                inputGroup = scan.nextLine();
            }

            if ("add".equals(inputGroup)) {
                System.out.println("Podaj nazwę nowej grupy:");
                String name = scan.nextLine();

                Group group = new Group(name);
                group.saveToDB(DbManager.getInstance().getConnection());
                System.out.println("Grupa została dodana.");
                System.out.println();

            } else if ("edit".equals(inputGroup)) {
                System.out.println("Podaj ID grupy, którą chcesz zmodyfikować:");
                while (!scan.hasNextInt()) {
                    System.out.println("Podaj liczbę:");
                    scan.next();
                }
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Podaj nową nazwę modyfikowanej grupy:");
                String name = scan.nextLine();

                Group group = Group.loadGroupById(DbManager.getInstance().getConnection(), id);
                group.setName(name);
                group.saveToDB(DbManager.getInstance().getConnection());
                System.out.println("Gruppa została zmodyfikowana.");
                System.out.println();

            } else if ("delete".equals(inputGroup)) {
                System.out.println("Podaj ID grupy, którą chcesz usunąć:");
                while (!scan.hasNextInt()) {
                    System.out.println("Podaj liczbę:");
                    scan.next();
                }
                int id = scan.nextInt();
                scan.nextLine();
                Group group = Group.loadGroupById(DbManager.getInstance().getConnection(), id);
                System.out.println("Czy na pewno chcesz usunąć grupę " + group.getName() + "? [T/n]");
                String answer = scan.nextLine();
                while (!answer.equals("T") && !answer.equals("n")) {
                    System.out.println("Potwierdź usunięcie grupy " + group.getName() + " [T/n]");
                    answer = scan.nextLine();
                }
                if (answer.equals("T")) {
                    group.delete(DbManager.getInstance().getConnection());
                    System.out.println("Grupa została usunięta");
                }
            }
        }
    }

    static void exerciseManager() throws Exception{
        String inputExercise = "";
        while (!"back".equals(inputExercise)) {
            System.out.println("Lista zadań:");
            ArrayList<Exercise> exercises = Exercise.loadAllExercises(DbManager.getInstance().getConnection());
            for (Exercise e : exercises) {
                System.out.println(e);
            }
            System.out.println("-------------------------");
            System.out.println("Wybierz jedną z opcji:");
            System.out.println("* add - dodanie zadania");
            System.out.println("* edit - edycja zadania");
            System.out.println("* delete - usunięcie zadania");
            System.out.println("* back - powrót do menu głównego");

            inputExercise = scan.nextLine();
            while (!"add".equals(inputExercise) && !"edit".equals(inputExercise) && !"delete".equals(inputExercise) && !"back".equals(inputExercise)) {
                System.out.println("Nieznana komenda. Spróbuj jeszcze raz:");
                inputExercise = scan.nextLine();
            }

            if ("add".equals(inputExercise)) {
                System.out.println("Podaj tytuł nowego zadania:");
                String title = scan.nextLine();
                System.out.println("Podaj opis nowego zadania:");
                String description = scan.nextLine();

                Exercise exercise = new Exercise(title, description);
                exercise.saveToDB(DbManager.getInstance().getConnection());
                System.out.println("Zadanie zostało dodane.");
                System.out.println();

            } else if ("edit".equals(inputExercise)) {
                System.out.println("Podaj ID zadania, które chcesz zmodyfikować:");
                while (!scan.hasNextInt()) {
                    System.out.println("Podaj liczbę:");
                    scan.next();
                }
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Podaj nowy tytuł modyfikowanego zadania:");
                String title = scan.nextLine();
                System.out.println("Podaj nowy opis modyfikowanego zadania:");
                String description = scan.nextLine();

                Exercise exercise = Exercise.loadExerciseById(DbManager.getInstance().getConnection(), id);
                exercise.setTitle(title);
                exercise.setDescription(description);
                exercise.saveToDB(DbManager.getInstance().getConnection());
                System.out.println("Zadanie zostało zmodyfikowane.");
                System.out.println();

            } else if ("delete".equals(inputExercise)) {
                System.out.println("Podaj ID zadania, które chcesz usunąć:");
                while (!scan.hasNextInt()) {
                    System.out.println("Podaj liczbę:");
                    scan.next();
                }
                int id = scan.nextInt();
                scan.nextLine();
                Exercise exercise = Exercise.loadExerciseById(DbManager.getInstance().getConnection(), id);
                System.out.println("Czy na pewno chcesz usunąć zadanie " + exercise.getTitle() + "? [T/n]");
                String answer = scan.nextLine();
                while (!answer.equals("T") && !answer.equals("n")) {
                    System.out.println("Potwierdź usunięcie użytkownika " + exercise.getTitle() + " [T/n]");
                    answer = scan.nextLine();
                }
                if (answer.equals("T")) {
                    exercise.delete(DbManager.getInstance().getConnection());
                    System.out.println("Użytkownik został usunięty");
                }
            }
        }
    }

    static void userManager() throws  Exception{
        String inputExercise = "";
        while (!"back".equals(inputExercise)) {
            System.out.println("Lista użytkowników:");
            ArrayList<User> users = User.loadAllUsers(DbManager.getInstance().getConnection());
            for (User u : users) {
                System.out.println(u);
            }
            System.out.println("-------------------------");
            System.out.println("Wybierz jedną z opcji:");
            System.out.println("* add - dodanie użytkownika");
            System.out.println("* edit - edycja użytkownika");
            System.out.println("* delete - usunięcie użytkownika");
            System.out.println("* back - powrót do menu głównego");

            inputExercise = scan.nextLine();
            while (!"add".equals(inputExercise) && !"edit".equals(inputExercise) && !"delete".equals(inputExercise) && !"back".equals(inputExercise)) {
                System.out.println("Nieznana komenda. Spróbuj jeszcze raz:");
                inputExercise = scan.nextLine();
            }

            if ("add".equals(inputExercise)) {
                System.out.println("Podaj nazwę nowego użytkownika:");
                String username = scan.nextLine();
                System.out.println("Podaj hasło nowego użytkownika:");
                String password = scan.nextLine();
                System.out.println("Podaj email nowego użytkownika:");
                String email = scan.nextLine();

                User user = new User(username, password, email);
                user.saveToDB(DbManager.getInstance().getConnection());
                System.out.println("Użytkownik został dodany.");
                System.out.println();

            } else if ("edit".equals(inputExercise)) {
                System.out.println("Podaj ID użytkownika, którego dane chcesz zmodyfikować:");
                while (!scan.hasNextInt()) {
                    System.out.println("Podaj liczbę:");
                    scan.next();
                }
                int id = scan.nextInt();
                scan.nextLine();
                System.out.println("Podaj nową nazwę modyfikowanego użytkownika:");
                String username = scan.nextLine();
                System.out.println("Podaj nowe hasło modyfikowanego użytkownika:");
                String password = scan.nextLine();
                System.out.println("Podaj nowy email modyfikowanego użytkownika:");
                String email = scan.nextLine();

                User user = User.loadUserById(DbManager.getInstance().getConnection(), id);
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.saveToDB(DbManager.getInstance().getConnection());
                System.out.println("Użytkownik został zmodyfikowany.");
                System.out.println();

            } else if ("delete".equals(inputExercise)) {
                System.out.println("Podaj ID użytkownika, którego chcesz usunąć:");
                while (!scan.hasNextInt()) {
                    System.out.println("Podaj liczbę:");
                    scan.next();
                }
                int id = scan.nextInt();
                scan.nextLine();
                User user = User.loadUserById(DbManager.getInstance().getConnection(), id);
                System.out.println("Czy na pewno chcesz usunąć użytkownika " + user.getUsername() + "? [T/n]");
                String answer = scan.nextLine();
                while (!answer.equals("T") && !answer.equals("n")) {
                    System.out.println("Potwierdź usunięcie użytkownika " + user.getUsername() + " [T/n]");
                    answer = scan.nextLine();
                }
                if (answer.equals("T")) {
                    user.delete(DbManager.getInstance().getConnection());
                    System.out.println("Użytkownik został usunięty");
                }
            }
        }
    }
}
