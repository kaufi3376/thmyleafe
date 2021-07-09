package edu.hm.trk.modularbeit.model;

import javax.persistence.*;

/**
 * Eine Entity Klasse, welche die Tabelle Question in der H2-Datenbank repräsentiert.
 *
 */



@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question;
    private String an1;
    private String an2;
    private String an3;
    private String an4;
    private int rightanswer;
    private int rightCounter=0;

    public Question(String question, String an1, String an2, String an3, String an4, int rightanswer) {
        this.question = question;
        this.an1=an1;
        this.an2=an2;
        this.an3=an3;
        this.an4=an4;
        this.rightanswer = rightanswer;

    }

    public Question(){

    }

    /**
     * Die Methode gibt die richte Antwort als String zurück
     *
     * @return
     */
    public String getRightAnswer(){
        if(rightanswer==0){
            return this.an1;
        }
        else if(rightanswer==1){
            return this.an2;
        }
        else if(rightanswer==2){
            return this.an3;
        }
        else{
            return this.an4;
        }
    }



    public long getId() {
        return id;
    }

    public int getRightCounter() {
        return rightCounter;
    }

    public void setRightCounter(int rightCounter) {
        this.rightCounter = rightCounter;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAn1() {
        return an1;
    }

    public void setAn1(String an1) {
        this.an1 = an1;
    }

    public String getAn2() {
        return an2;
    }

    public void setAn2(String an2) {
        this.an2 = an2;
    }

    public String getAn3() {
        return an3;
    }

    public void setAn3(String an3) {
        this.an3 = an3;
    }

    public String getAn4() {
        return an4;
    }

    public void setAn4(String an4) {
        this.an4 = an4;
    }



    public void setRightanswer(int rightanswer) {
        this.rightanswer = rightanswer;
    }
}
