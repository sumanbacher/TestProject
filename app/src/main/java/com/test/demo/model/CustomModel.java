package com.test.demo.model;

public class CustomModel {

    String mName,mEmail,mPhone,mDateOfJoin;

    public CustomModel(String mName, String mEmail, String mPhone, String mDateOfJoin) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mPhone = mPhone;
        this.mDateOfJoin = mDateOfJoin;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getmDateOfJoin() {
        return mDateOfJoin;
    }

    public void setmDateOfJoin(String mDateOfJoin) {
        this.mDateOfJoin = mDateOfJoin;
    }
}
