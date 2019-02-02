package com.paulojuniore.computacaoufcg;

public class Grade {

    private String subjectName;
    private int workLoad;
    public static final Grade[] subjects = {
            new Grade("Fund de Matemática P/ C. da Computação I", 60),
            new Grade("Introdução a Computação", 60),
            new Grade("Laboratório de Programação I", 60),
            new Grade("Programação I", 60),

            new Grade("Cálculo Diferencial e Integral I", 60),
            new Grade("Fund de Matemática P/ C. da Computação II", 60),
            new Grade("Laboratório de Programação II", 60),
            new Grade("Programação II", 60),

            new Grade("Algébra Linear I", 60),
            new Grade("Cálculo Diferencial e Integral II", 60),
            new Grade("Estrutura de Dados e Algoritmos", 60),
            new Grade("Laboratório de Estrutura de Dados e Algoritmos", 60),
            new Grade("Lógica para Computação", 60),
            new Grade("Teoria dos Grafos", 60)
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

    public String toString() {
        return this.subjectName;
    }

}
