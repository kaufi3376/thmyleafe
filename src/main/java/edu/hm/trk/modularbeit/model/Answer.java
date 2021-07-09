package edu.hm.trk.modularbeit.model;

/**
 * Eine WrapperKlasse um einen String als Objekt zu Wrappen
 *
 */

public class Answer {

    private String ans;

    public Answer(String ans){
        this.ans=ans;

    }

    public Answer(){
        this.ans="";
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
