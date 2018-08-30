package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Solution {
    private int id;
    private String created;
    private String updated;
    private String description;
    private int excercise_id;
    private int users_id;

    public Solution(String created, String updated, String description, int excercise_id, int users_id){
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.excercise_id = excercise_id;
        this.users_id = users_id;
    }

    public Solution(){
    }

    public int getId() {
        return id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setExcerciseId(int excercise_id) {
        this.excercise_id = excercise_id;
    }

    public void setUsersId(int users_id) {
        this.users_id = users_id;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public int getExcerciseId() {
        return this.excercise_id;
    }

    public int getUsersId() {
        return this.users_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Solution loadSolutionById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM solution where id=?";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Solution loadedSolution = new Solution();
            loadedSolution.id = resultSet.getInt("id");
            loadedSolution.created = resultSet.getString("created");
            loadedSolution.updated = resultSet.getString("updated");
            loadedSolution.description = resultSet.getString("description");
            return loadedSolution;
        }
        return null;
    }

    public static ArrayList<Solution> loadAllSolutions(Connection conn) throws SQLException {
        ArrayList<Solution> solutions = new ArrayList<Solution>();
        String sql = "SELECT * FROM solution";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Solution loadedSolution = new Solution();
            loadedSolution.id = resultSet.getInt("id");
            loadedSolution.created = resultSet.getString("created");
            loadedSolution.updated = resultSet.getString("updated");
            loadedSolution.description = resultSet.getString("description");
            solutions.add(loadedSolution);
        }
        return solutions;
    }

    public void saveToDB(Connection conn) throws SQLException {
        if (this.id == 0) {
            String sql = "INSERT INTO solution(created, updated, description, excercise_id, users_id) VALUES (?, ?, ?, ?, ?)";
            String generatedColumns[] = { "ID" };
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, this.created);
            preparedStatement.setString(2, this.updated);
            preparedStatement.setString(3, this.description);
            preparedStatement.setInt(4, this.excercise_id);
            preparedStatement.setInt(5, this.users_id);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            }
        }else {
            String sql = "UPDATE solution SET created=?, updated=?, description=? where id = ?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, this.created);
            preparedStatement.setString(2, this.updated);
            preparedStatement.setString(3, this.description);
            preparedStatement.setInt(4, this.id);
            preparedStatement.executeUpdate();
        }
    }

    public void delete(Connection conn) throws SQLException {
        if (this.id != 0) {
            String sql = "DELETE FROM solution WHERE id= ?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, this.id);
            preparedStatement.executeUpdate();
            this.id=0;
        }
    }

    @Override
    public String toString(){
        return this.id+" "+this.created+" "+this.updated+" "+this.description;
    }

    public static ArrayList<Solution> loadAllByUserId(Connection conn, int user_id) throws SQLException {
        ArrayList<Solution> loadedSolutionByUserId = new ArrayList<>();
        String sql = "SELECT * FROM solution WHERE users_id = ?";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, user_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Solution loadedSolution = new Solution();
            loadedSolution.id = resultSet.getInt("id");
            loadedSolution.created = resultSet.getString("created");
            loadedSolution.updated = resultSet.getString("updated");
            loadedSolution.description = resultSet.getString("description");
            loadedSolutionByUserId.add(loadedSolution);
        }
        return loadedSolutionByUserId;
    }

    public static ArrayList<Solution> loadAllByExerciseId(Connection conn, int excercise_id) throws SQLException {
        ArrayList<Solution> loadedSolutionByExerciseId = new ArrayList<>();
        String sql = "SELECT * FROM solution WHERE excercise_id = ? ORDER BY updated DESC";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, excercise_id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Solution loadedSolution = new Solution();
            loadedSolution.id = resultSet.getInt("id");
            loadedSolution.created = resultSet.getString("created");
            loadedSolution.updated = resultSet.getString("updated");
            loadedSolution.description = resultSet.getString("description");
            loadedSolutionByExerciseId.add(loadedSolution);
        }
        return loadedSolutionByExerciseId;
    }

    public static ArrayList<Solution> loadAllSolutions(Connection conn, int rows) throws SQLException {
        ArrayList<Solution> solutions = new ArrayList<>();
        String sql = "SELECT * FROM solution WHERE updated IS NOT NULL ORDER BY updated DESC LIMIT ?";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, rows);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Solution loadedSolution = new Solution();
            loadedSolution.id = resultSet.getInt("id");
            loadedSolution.created = resultSet.getString("created");
            loadedSolution.updated = resultSet.getString("updated");
            loadedSolution.description = resultSet.getString("description");
            solutions.add(loadedSolution);
        }
        return solutions;
    }


}
