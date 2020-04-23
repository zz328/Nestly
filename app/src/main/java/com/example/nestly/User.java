package com.example.nestly;

import java.util.List;
import java.util.Set;

class User {
    final private String username;
    final private String password;
    private String year;
    private String major;
    private String gender;
    private List<String> habits_answers;
    private List<String> situations_answers;
    private List<String> long_answers;
    private Set<String> blocked;
    private List<String> favorites;
    private boolean hidden;

    private String name;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        hidden=false;
    }

    //public void setPassword(String password) {this.password = password; }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() { return this.password; }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) { this.year=year; }

    public String getYear() { return year; }

    public String getMajor() { return major; }

    public String getGender() { return gender; }

    public void setMajor(String major) { this.major=major; }

    public void setGender(String gender) { this.gender=gender; }

    public void setHabits_answers(List<String> habits_answers) { this.habits_answers = habits_answers; }

    public void setSituations_answers(List<String> situations_answers) { this.situations_answers = situations_answers; }

    public void setLong_answers(List<String> long_answers) { this.long_answers = long_answers; }

    public void setFavorites(List<String> favorite_list) {this.favorites = favorite_list; }

    public void addFavorite(String user) { this.favorites.add(user); }

    public void removeFavorite(String user) {
        for (int i = 0; i < favorites.size(); i++) {
            if (favorites.get(i).equals(user)) {
                favorites.remove(i);
            }
        }
    }

    public List<String> getFavorites() { return this.favorites; }

    public List<String> getHabits_answers() {
        return habits_answers;
    }

    public List<String> getSituations_answers() { return situations_answers; }

    public List<String> getLong_answers() {
        return long_answers;
    }

    public boolean isHidden() {return hidden; }

    public void setHidden() { hidden = true; }

    public Set<String> getBlocked(){ return blocked; }

    public void setBlock(Set<String> blocked){this.blocked = blocked;}

}
