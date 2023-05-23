package cn.highedu.cat.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private int id;
    private String userName;
    private  String passWord;
    private String email;
    private String phone;

    public User(String userName, String passWord, String email, String phone) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phone = phone;
    }
}
