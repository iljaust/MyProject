package com.company;

import java.util.List;

public class SkillController {

    private final SkillRepository n = new SkillRepository();
    private final SkillView b = new SkillView();

    private void analyseInput(){
       String input =  b.getInput();
        String delimeter = " ";
        String[] subStr = input.split(delimeter);

        switch (subStr[0]){
            case "getAll":
                getAllSkills();
            case "save":
                saveSkill(subStr[1]);
            case "delete":
                deleteByIdSkill(subStr[1]);
            case "get":
                getByIdSkill(subStr[1]);
        }
    }

    private void deleteByIdSkill(String id){
        long idToLong = Long.parseLong(id);
        n.deleteById(idToLong);
    }

    private void saveSkill(String skill){
        Skill newSkill = new Skill(n.generateID(),skill);
        n.save(newSkill);
    }

    private void getByIdSkill(String id){
        long idToLong = Long.parseLong(id);
        System.out.println(n.getById(idToLong));
    }

    private void getAllSkills(){
        List<Skill> skills = n.getAll();
        for(Skill x : skills){
            System.out.println(x);
        }
    }


}
