package com.kjandgo.authproject.member.command.dto;

import lombok.Getter;
import lombok.ToString;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@ToString
public class UserImpl extends User {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private String email;
    private String signUpDate;
    private String recentLoginDate;
    private Character status;
    private String profileImage;

    public UserImpl(String username, @Nullable String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public void setUserInfo(UserDetailInfoDTO userInfo){
        this.id = userInfo.getId();
        this.userName = userInfo.getUserName();
        this.password = userInfo.getPassword();
        this.name = userInfo.getName();
        this.email = userInfo.getEmail();
        this.signUpDate = userInfo.getSignUpDate();
        this.recentLoginDate = userInfo.getRecentLoginDate();
        this.status = userInfo.getStatus();
        this.profileImage = userInfo.getProfileImage();
    }
}
