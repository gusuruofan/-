package com.example.demo.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(length = 30)
    @NonNull
    private String account;

    @Column(length = 30)
    @NonNull
    private String password;

    @Column(length = 30)
    private String name;

    public enum Sex {
        男, 女
    }

    private Sex grander;

    private LocalDateTime birthday;

    @Column(length = 11)
    private String mobile;

    @Column(length = 100)
    private String email;

    private Integer lastTime; // 最后登录时间

    private Integer loginCount; // 登录次数

    private Integer validState = 1; // 用户是否有效，0表示无效，1表示有效

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @NonNull
    public String getAccount() {
        return account;
    }

    public void setAccount(@NonNull String account) {
        this.account = account;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getGrander() {
        return grander;
    }

    public void setGrander(Sex grander) {
        this.grander = grander;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLastTime() {
        return lastTime;
    }

    public void setLastTime(Integer lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Integer getValidState() {
        return validState;
    }

    public void setValidState(Integer validState) {
        this.validState = validState;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(uid, user.uid) && Objects.equals(account, user.account) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && grander == user.grander && Objects.equals(birthday, user.birthday) && Objects.equals(mobile, user.mobile) && Objects.equals(email, user.email) && Objects.equals(lastTime, user.lastTime) && Objects.equals(loginCount, user.loginCount) && Objects.equals(validState, user.validState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, account, password, name, grander, birthday, mobile, email, lastTime, loginCount, validState);
    }
}
