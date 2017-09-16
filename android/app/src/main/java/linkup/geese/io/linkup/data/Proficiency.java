package linkup.geese.io.linkup.data;

/**
 * Created by Azhng on 2017-09-16.
 */

public enum Proficiency {
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private String type;

    Proficiency(String type){
        this.type = type;
    }

    public String asString(){
        return this.type;
    }
}
