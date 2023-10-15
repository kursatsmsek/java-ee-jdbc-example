package com.example.javaee.controller;

import com.example.javaee.model.TeamMember;
import com.example.javaee.service.MemberService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.util.List;

@Path("/member")
public class MemberController {

    MemberService memberService = MemberService.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TeamMember> getTeamList() {
        try {
            return memberService.getTeamList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Produces("text/plain")
    public String addMember(@QueryParam("name") String name) {
        try {
            memberService.addMember(name);
            return "Member successfully added.";
        } catch (SQLException e) {
            return "something went wrong.";
        }
    }

}
