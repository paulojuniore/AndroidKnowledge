package com.paulojuniore.computacaoufcg;

public class Grade {

    private String subjectName;
    private int workLoad;
    private static final Grade[] subjects = {
            new Grade("Fund de Matemática P/ C. da Computação", 60),
            new Grade("Introdução a Computação", 60),
            new Grade("Laboratório de Programação I", 60),
            new Grade("Programação I", 60)
    };

    private Grade(String subjectName, int workLoad) {
        this.subjectName = subjectName;
        this.workLoad = workLoad;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getWorkLoad() {
        return workLoad;
    }

    public static Grade[] getSubjects() {
        return subjects;
    }

    public String toString() {
        return subjectName;
    }

}
