package com.example.finalpreparation;

public class Post {
    String Name;

    public Post(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
