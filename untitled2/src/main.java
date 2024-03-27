import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Ajouter un étudiant");
        System.out.println("2. Calculer et afficher les moyennes des étudiants par matière");
        System.out.println("3. Afficher le meilleur étudiant par matière");
        System.out.println("4. Afficher pour chaque étudiant les matières à retravailler (en dessous de 15)");
        System.out.println("5. Modifier une note erronée déjà saisie");
        System.out.println("6. Quitter");

        System.out.print("Choisissez une option : ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                calculateAndDisplayAverages();
                break;
            case 3:
                displayBestStudents();
                break;
            case 4:
                displaySubjectsToImprove();
                break;
            case 5:
                modifyGrade();
                break;
            case 6:
                System.out.println("Au revoir !");
                break;
            default:
                System.out.println("Option invalide. Veuillez choisir une option valide.");
                displayMenu();
        }
    }

    private static void addStudent() {
        System.out.println("Ajouter un étudiant :");
        // Code pour ajouter l'étudiant à la base de données
        System.out.println("Nouvel étudiant ajouté avec succès.");
        displayMenu();
    }

    private static void calculateAndDisplayAverages() {
        System.out.println("Calculer et afficher les moyennes des étudiants par matière :");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecole_tennis", "root", "");
             Statement statement = connection.createStatement()) {
            String query = "SELECT subject_id, AVG(grade) AS average FROM grade GROUP BY subject_id";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int subjectId = resultSet.getInt("subject_id");
                double average = resultSet.getDouble("average");
                System.out.println("Matière ID : " + subjectId + ", Moyenne : " + average);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        displayMenu(); // Retour au menu principal après l'affichage des moyennes
    }

    private static void displayBestStudents() {
        System.out.println("Afficher le meilleur étudiant par matière :");
        // Code pour afficher le meilleur étudiant par matière
        displayMenu();
    }

    private static void displaySubjectsToImprove() {
        System.out.println("Afficher pour chaque étudiant les matières à retravailler (en dessous de 15) :");
        // Code pour afficher les matières à retravailler pour chaque étudiant
        displayMenu();
    }

    private static void modifyGrade() {
        System.out.println("Modifier une note erronée déjà saisie :");
        // Code pour modifier une note erronée déjà saisie
        displayMenu();
    }
}
