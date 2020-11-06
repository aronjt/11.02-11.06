package org.progmatic.nov6.tinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String hairColour;
    private String eyeColour;
    private Map<Integer, String> swipes = new HashMap<>();

    public Person(int id, String name, String sex, int age, String hairColour, String eyeColour) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.hairColour = hairColour;
        this.eyeColour = eyeColour;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getHairColour() {
        return hairColour;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public Map<Integer, String> getSwipes() {
        return swipes;
    }

    public void setSwipes(int key, String swipe) {
        swipes.put(key, swipe);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", hairColour='" + hairColour + '\'' +
                ", eyeColour='" + eyeColour + '\'' +
                ", swipes=" + swipes +
                '}';
    }
}
