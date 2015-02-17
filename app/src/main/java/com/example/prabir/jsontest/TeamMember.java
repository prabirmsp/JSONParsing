package com.example.prabir.jsontest;

/**
 * Created by prabir on 2/16/15.
 */
public class TeamMember {


    protected String category = "";
    protected String name = "";
    protected String year = "";
    protected String role = "";
    protected String cellphone = "";
    protected String email = "";
    protected String image = "";
    protected String giturl = "";
    protected String twitterurl= "";
    protected String homepageurl = "";
    protected String linkedurl = "";



    public TeamMember (String category, String name, String year, String role, String cellphone,
                       String email, String image, String giturl, String twitterurl, String homepageurl,
                       String linkedurl) {
        this.name = name;
        this.category = category;
        this.year = year;
        this.role = role;
        this.cellphone = cellphone;
        this.email = email;
        this.image = image;
        this.giturl = giturl;
        this.twitterurl = twitterurl;
        this.homepageurl = homepageurl;
        this.linkedurl = linkedurl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGiturl() {
        return giturl;
    }

    public void setGiturl(String giturl) {
        this.giturl = giturl;
    }

    public String getTwitterurl() {
        return twitterurl;
    }

    public void setTwitterurl(String twitterurl) {
        this.twitterurl = twitterurl;
    }

    public String getHomepageurl() {
        return homepageurl;
    }

    public void setHomepageurl(String homepageurl) {
        this.homepageurl = homepageurl;
    }

    public String getLinkedurl() {
        return linkedurl;
    }

    public void setLinkedurl(String linkedurl) {
        this.linkedurl = linkedurl;
    }





}
