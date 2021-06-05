package com.gaurav.livingscience.models;

public class ObjectiveModel implements Model {
    public String ques, allOption;
    private final int TYPE;

    public ObjectiveModel(String ques, String allOption) {
        this.ques = ques;
        this.allOption = allOption;
        TYPE = Model.OBJ_TYPE;
    }

    @Override
    public int getType() {
        return TYPE;
    }
}
