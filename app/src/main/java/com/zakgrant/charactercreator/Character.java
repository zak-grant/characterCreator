package com.zakgrant.charactercreator;

public class Character {
    private String id;
    private String name;
    private String characterClass;
    private String age;
    private String imageUrl;

    public Character(String name, String characterClass, String age, String imageUrl) {
        this.setId(id);
        this.setName(name);
        this.setCharacterClass(characterClass);
        this.setAge(age);
        this.setImageUrl(imageUrl);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
