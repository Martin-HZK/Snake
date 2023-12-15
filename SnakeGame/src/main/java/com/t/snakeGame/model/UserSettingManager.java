package com.t.snakeGame.model;

public class UserSettingManager {
    private static UserSettingManager instance;



    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    private String difficultyLevel;
    private UserSettingManager() {
        difficultyLevel = "Easy";
    }

    public static UserSettingManager getInstance() {
        if (instance == null) {
            instance = new UserSettingManager();
        }
        return instance;
    }

    public static void setInstance(UserSettingManager instance) {
        UserSettingManager.instance = instance;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }
}
