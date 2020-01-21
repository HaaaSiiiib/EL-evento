package com.example.copyproject;



public class student_userprofile {

    public String username,useremail,userphoneno,userinstitution,userpassword,userconfirmpassword;


    public student_userprofile(String username, String useremail, String userphoneno, String userinstitution, String userpassword, String userconfirmpassword) {
        this.username = username;
        this.useremail = useremail;
        this.userphoneno = userphoneno;
        this.userinstitution = userinstitution;
        this.userpassword = userpassword;
        this.userconfirmpassword = userconfirmpassword;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserphoneno() {
        return userphoneno;
    }

    public void setUserphoneno(String userphoneno) {
        this.userphoneno = userphoneno;
    }

    public String getUserinstitution() {
        return userinstitution;
    }

    public void setUserinstitution(String userinstitution) {
        this.userinstitution = userinstitution;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserconfirmpassword() {
        return userconfirmpassword;
    }



    public void setUserconfirmpassword(String userconfirmpassword) {
        this.userconfirmpassword = userconfirmpassword;
    }
}
