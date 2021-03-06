package com.company.controller;

import com.company.model.Skill;
import com.company.repository.SkillRepository;

import java.util.List;

public class SkillController {

    private SkillRepository repository = new SkillRepository();

    public void deleteById(long id){
        repository.deleteById(id);
    }

    public Skill save(Skill skill){
        repository.save(skill);
        return skill;
    }

    public Skill getById(long id){
        return repository.getById(id);
    }

    public List<Skill> getAll(){
        return repository.getAll();
    }

    public Skill update(Skill skill){
        return repository.update(skill);
    }

    public long generateID(){
        return repository.generateID();
    }
}
