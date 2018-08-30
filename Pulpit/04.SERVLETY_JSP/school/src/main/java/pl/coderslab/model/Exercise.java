package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Exercise {
    private int id;
    private String title;
    private String description;

    public Exercise(String title, String description){
        this.title = title;
        this.description = description;
    }
    
    public Exercise(){
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Exercise loadExerciseById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM excercise where id=?";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Exercise loadedExercise = new Exercise();
            loadedExercise.id = resultSet.getInt("id");
            loadedExercise.title = resultSet.getString("title");
            loadedExercise.description = resultSet.getString("description");
            return loadedExercise;
        }
        return null;
    }
    public static ArrayList<Exercise> loadAllExercises(Connection conn) throws SQLException {
        ArrayList<Exercise> exercises = new ArrayList<>();
        String sql = "SELECT * FROM excercise";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Exercise loadedExercise = new Exercise();
            loadedExercise.id = resultSet.getInt("id");
            loadedExercise.title = resultSet.getString("title");
            loadedExercise.description = resultSet.getString("description");
            exercises.add(loadedExercise);
        }
        return exercises;
    }

    public void saveToDB(Connection conn) throws SQLException {
        if (this.id == 0) {
            String sql = "INSERT INTO excercise(title, description) VALUES (?, ?)";
            String generatedColumns[] = { "ID" };
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, this.title);
            preparedStatement.setString(2, this.description);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            }
        }else {
            String sql = "UPDATE excercise SET title=?, description=? where id = ?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, this.title);
            preparedStatement.setString(2, this.description);
            preparedStatement.setInt(3, this.id);
            preparedStatement.executeUpdate();
        }
    }
    public void delete(Connection conn) throws SQLException {
        if (this.id != 0) {
            String sql = "DELETE FROM excercise WHERE id= ?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, this.id);
            preparedStatement.executeUpdate();
            this.id=0;
        }
    }
    @Override
    public String toString(){
        return this.id+" "+this.title+" "+this.description;
    }

    public static ArrayList<Exercise> loadExcerciseWithoutSolutionByUser(Connection conn, int userID) throws SQLException {
        ArrayList<Exercise> loadedExcercise = new ArrayList<>();
        String query = "SELECT ex.* " +
                "FROM workshop.excercise AS ex " +
                "LEFT JOIN ( " +
                    "SELECT ex.* " +
                    "FROM workshop.excercise AS ex " +
                    "LEFT JOIN workshop.solution AS sol ON ex.id = sol.excercise_id " +
                    "WHERE sol.description IS NOT NULL " +
                    "AND sol.users_id = ?) AS sol ON ex.id = sol.id " +
                "WHERE sol.id IS NULL";
        PreparedStatement preStmt = conn.prepareStatement(query);
        preStmt.setInt(1,userID);
        ResultSet result = preStmt.executeQuery();
        while(result.next()){
            Exercise excercise = new Exercise();
            excercise.id = result.getInt("id");
            excercise.title = result.getString("title");
            excercise.description = result.getString("description");
            loadedExcercise.add(excercise);
        }
        return loadedExcercise;
    }

}
