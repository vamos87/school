package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Group {
    private int id;
    private String name;

    public Group(){
    }

    public Group(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static Group loadGroupById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM user_group where id=?";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Group loadedGroup = new Group();
            loadedGroup.id = resultSet.getInt("id");
            loadedGroup.name = resultSet.getString("name");
            return loadedGroup;
        }
        return null;
    }

    public static ArrayList<Group> loadAllGroup(Connection conn) throws SQLException {
        ArrayList<Group> groups = new ArrayList<Group>();
        String sql = "SELECT * FROM user_group";
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Group loadedGroup = new Group();
            loadedGroup.id = resultSet.getInt("id");
            loadedGroup.name = resultSet.getString("name");
            groups.add(loadedGroup);
        }
        return groups;
    }

    public void saveToDB(Connection conn) throws SQLException {
        if (this.id == 0) {
            String sql = "INSERT INTO user_group(name) VALUES (?)";
            String generatedColumns[] = { "ID" };
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, this.name);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            }
        }else {
            String sql = "UPDATE user_group SET name=? where id = ?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, this.name);
            preparedStatement.setInt(2, this.id);
            preparedStatement.executeUpdate();
        }
    }

    public void delete(Connection conn) throws SQLException {
        if (this.id != 0) {
            String sql = "DELETE FROM user_group WHERE id= ?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, this.id);
            preparedStatement.executeUpdate();
            this.id=0;
        }
    }

    @Override
    public String toString(){
        return this.id+" "+this.name;
    }
}
