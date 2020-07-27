package com.company.view;

import com.company.controller.SkillController;
import com.company.model.Skill;

import java.util.List;
import java.util.Scanner;

public class SkillView {
    private SkillController controller = new SkillController();
    private Scanner scan = new Scanner(System.in);

    private void deleteById(){
        Long inputID = scan.nextLong();
        controller.deleteById(inputID);
    }

    public void save(){
        String skillName = scan.nextLine();
        Skill skill = new Skill(controller.generateID(), skillName);
        controller.save(skill);
    }

    public void getByIdSkill(){
        Long inputID = scan.nextLong();
        Skill skill = controller.getById(inputID);
        System.out.println(skill);
    }

    public void update(){
        long id = scan.nextLong();
        String skillName = scan.nextLine();
        controller.update(new Skill(id,skillName));
    }

    public void getAll(){
        List<Skill> skills = controller.getAll();
        for(Skill x : skills){
            System.out.println(x);
        }
    }

}
