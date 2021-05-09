package com.learn.livingscienceclass7.model;

public class Item{
    private Question question;
    private Answer answer;
    private Objective objetive;
    private FillBlank fill;
    private Table table;
    private Pic pic;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Objective getObjetive() {
        return objetive;
    }

    public void setObjetive(Objective objetive) {
        this.objetive = objetive;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Pic getPic() {
        return pic;
    }

    public void setPic(Pic pic) {
        this.pic = pic;
    }

    public FillBlank getFill() {
        return fill;
    }

    public void setFill(FillBlank fill) {
        this.fill = fill;
    }
}
