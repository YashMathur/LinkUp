package linkup.geese.io.linkup.data;

/**
 * Created by Azhng on 2017-09-16.
 */

public enum Proficiency {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH");

    private String type;

    Proficiency(String type){
        this.type = type;
    }

    public String asString(){
        return this.type;
    }
}
