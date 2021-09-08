package com.gyuri.reddit.reddit.model;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;


public class ApproveUser {
    @Value( "${token.auth}" )
    private String tokenAuth;
    @Value( "${bot.password}" )
    private String botpass;
    @Value( "${bot.username}" )
    private String botuname;
    private void approve(String uname) throws UnirestException {

        Unirest.setTimeouts(20000, 15000);
            HttpResponse<JsonNode> token = Unirest.post("https://www.reddit.com/api/v1/access_token")
                    .header("Authorization", "Basic "+tokenAuth)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .field("grant_type", "password")
                    .field("username", botuname)
                    .field("password", botpass).asJson();

        if (token.getStatus()!=200)
        {
            //Bot authorization failed. Please contact a site administrator.
            return;
        }

        HttpResponse<JsonNode> response = Unirest.post("https://oauth.reddit.com/r/schonherz/api/friend?api_type=json&container=r/schonherz&name="+uname+"&type=contributor")
                .header("Authorization", "bearer "+token.getBody().getObject().getString("access_token")).asJson();

        if (response.getStatus()!=200)
        {
            //Error posting approve request. Please contact a site administrator.
            return;
        }

        JSONArray errors = response.getBody().getObject().getJSONObject("json").getJSONArray("errors");

        if (errors.length()>0)
        {
            //Failed to approve user. +errorok
            return;
        }
    }
}
