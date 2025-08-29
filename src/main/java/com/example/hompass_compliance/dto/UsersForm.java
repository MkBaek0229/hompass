package com.example.hompass_compliance.dto;

import com.example.hompass_compliance.entity.Users;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersForm {
    private Long id;
    private String nickname;
    private String man_woman;
    private int age;
    private int cm;
    private int kg;
    private String activity_level;



    public static UsersForm createUsersForm(Users users) {
        return new UsersForm(
                users.getId(),
                users.getNickname(),
                users.getMan_woman(),
                users.getAge(),
                users.getCm(),
                users.getKg(),
                users.getActivity_level()
        );
    }



//    public UsersForm(Long id, String nickname, int age, String man_woman, int cm, int kg, String activity_level) {
//        this.id = id;
//        this.nickname = nickname;
//        this.age = age;
//        this.man_woman = man_woman;
//        this.cm = cm;
//        this.kg = kg;
//        this.activity_level = activity_level;
//    }

//    @Override
//    public String toString() {
//        return "UsersForm{" +
//                "id=" + id +
//                ", nickname='" + nickname + '\'' +
//                ", man_woman='" + man_woman + '\'' +
//                ", age=" + age +
//                ", cm=" + cm +
//                ", kg=" + kg +
//                ", activity_level='" + activity_level + '\'' +
//                '}';
//    }

    public Users toEntity() {
        return new Users(null,nickname,man_woman,age,cm,kg,activity_level);
    }


    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMan_woman() {
        return man_woman;
    }

    public int getAge() {
        return age;
    }

    public int getCm() {
        return cm;
    }

    public int getKg() {
        return kg;
    }

    public String getActivity_level() {
        return activity_level;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
