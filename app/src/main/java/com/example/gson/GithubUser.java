package com.example.gson;

public class GithubUser {
    String login;
    Integer id;

    public GithubUser(String login, Integer id, String html_url, Double score, String avatar_url) {
        this.login = login;
        this.id = id;
        this.html_url = html_url;
        this.score = score;
        this.avatar_url = avatar_url;
    }

    String html_url;
    Double score;
    String avatar_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getScore() {
        return score.toString();
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }


}
