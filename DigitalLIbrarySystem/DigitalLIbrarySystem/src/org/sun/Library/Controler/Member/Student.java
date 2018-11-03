package org.sun.Library.Controler.Member;

import org.sun.Library.Bean.Access;
import org.sun.Library.Bean.PersonInfo;

public class Student extends Member {
   private PersonInfo info;
   private String nationalID;
   private String question;
   private String answer;
   public Student() {
       this(null,null, null,null,null);
   }
   public Student(String nationalID,PersonInfo info, String question,String answer,Access access) {
     setAccess(access);
       setInfo(info);
       setNationalID(nationalID);
       setQuestion(question);
       setAnswer(answer);
   }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setInfo(PersonInfo info) {
        this.info = info;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getNationalID() {
        return nationalID;
    }

    public PersonInfo getInfo() {
        return info;
    }
}
