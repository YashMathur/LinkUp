package linkup.geese.io.linkup.data;

/**
 * Created by Azhng on 2017-09-16.
 */

public enum UserType {

    CANDIDATE("candidate"),
    RECRUITER("recruiter");

    private String type;

    UserType(String type){
        this.type = type;
    }

    public String asString(){
        return this.type;
    }
}
