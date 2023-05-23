package cn.highedu.cat.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegDTO {

    private String username;
    private  String password;
    private String email;
    private String phone;

}
