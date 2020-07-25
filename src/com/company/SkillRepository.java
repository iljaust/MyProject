package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SkillRepository {
    private final String SKILL_FILE_NAME = "skills.txt";

    public List<Skill> getAll(){
        List<Skill> arr = fromFileToArray();
        return arr;
    }
    private List<Skill> fromFileToArray() {
        File file = new File(SKILL_FILE_NAME);
        List <Skill> skills = new ArrayList<>();

        try {

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] subStr;
            int s;
            while (line != null) {
                String delimeter = "\\.";
                subStr = line.split(delimeter);
                skills.add(stringToSkill(subStr[1],Long.parseLong(subStr[0])));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skills;
    }

    public Skill save(Skill skill){
        List<Skill> skills = fromFileToArray();
        skills.add(skill);
        fromArrayToFile(skills);
        return skill;
    }

    public void deleteById(Long id){
        List<Skill> skills = fromFileToArray();
        skills.stream()
                .filter(e -> e.getId()!= id)
                .collect(Collectors.toList());
        fromArrayToFile(skills);
    }

    public Skill update(Skill skill){
        List<Skill> skills = fromFileToArray();
        skills.removeIf(n ->n.getId() == skill.getId());
        skills.add(skill);
        fromArrayToFile(skills);
        return skill;
    }

    public Skill getById(Long id) {
        List <Skill> skill = fromFileToArray();
        Optional <Skill> skillOpt = skill.stream().filter(s -> s.getId() == id).findFirst();
        return skillOpt.orElse(null);
    }

    private void fromArrayToFile(List<Skill> skills) {
        try(FileWriter writer = new FileWriter(SKILL_FILE_NAME, false)){
            for(Skill skill : skills) {
                Long number = (long)(skills.indexOf(skill) + 1);
                String name = skill.getName();
                writer.write(number + "." + name + "\n");
            }
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private Skill stringToSkill(String skill,Long id){
        return new Skill(id, skill);
    }

    public long generateID(){
        List<Skill> skills = fromFileToArray();
        Skill highestID = skills.stream().max(Comparator.comparingLong(Skill::getId)).get();
        return highestID.getId();
    }

}
