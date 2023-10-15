package com.example.javaee.service;


import com.example.javaee.model.TeamMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private final Connection connection;
    private final String ADD_MEMBER = "INSERT INTO TeamList (name) VALUES (?)";

    private final String GET_TEAM_LIST = "SELECT * FROM TeamList";
    private static MemberService instance;
    private MemberService() {
        connection = DatabaseService.getConnection();
    }
    public static MemberService getInstance() {
        if (instance == null) {
            instance = new MemberService();
        }
        return instance;
    }
    public void addMember(String name) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_MEMBER);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }

    public List<TeamMember> getTeamList() throws SQLException{
        PreparedStatement statement = connection.prepareStatement(GET_TEAM_LIST);
        ResultSet resultSet = statement.executeQuery();

        List<TeamMember> members = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            TeamMember member = new TeamMember(id, name);
            members.add(member);
        }

        return members;
    }
}
