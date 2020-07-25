package com.company;

import java.util.Scanner;

public class SkillView {
    private String menu = "List of features:\n " +
            "1. Get all list of skill type : getAll\n " +
            "2. Save skill type : save SKILL_NAME\n " +
            "3. Delete skill type : delete SKILL_NAME\n" +
            "4. Update skill type : update SKILL_NAME\n" +
            "5. Get by ID type : get SKILL_ID";

    public String getInput(){
        System.out.println(menu);
        Scanner s = new Scanner(System.in);

        return s.nextLine();
    }
}
