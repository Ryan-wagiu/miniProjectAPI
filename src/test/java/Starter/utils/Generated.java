package Starter.utils;

import java.util.Random;

public class Generated {
    public String randomEmail(){
        Random random = new Random();
        String email = "test" +  random.nextInt() + "@gmail.co";
        return email;
    }
    public String randomPassword(){
        Random random = new Random();
        String password = "pass" + random.nextInt();
        return password;
    }
    public String randomFullname(){
        Random random = new Random();
        String fullname = "lengkap" +  random.nextInt();
        return fullname;
    }
    public String nameCategory(){
        Random random = new Random();
        String name = "gaming" + random.nextInt(1);
        return name;
    }
    public String descCategory(){
        Random random = new Random();
        String desc = "game doang" + random.nextInt(1);
        return desc;
    }
}
