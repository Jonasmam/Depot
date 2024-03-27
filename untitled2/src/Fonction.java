import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Fonction {
    private static final DDBconfig dbConfig = new DDBconfig();

    public static boolean addStudent(String firstName, String lastName) {
        try (Connection connection = dbConfig.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO student (firstName, lastName) VALUES (?, ?)")) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addGrade(int idStudent, int idSubject, int grade) {
        try (Connection connection = dbConfig.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO grade (id_student, id_subject, grade) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, idStudent);
            preparedStatement.setInt(2, idSubject);
            preparedStatement.setInt(3, grade);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    
}
