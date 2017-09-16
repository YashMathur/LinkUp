package linkup.geese.io.linkup.cache;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import linkup.geese.io.linkup.data.User;

/**
 * Created by Azhng on 2017-09-16.
 */

public class Cache {

    public static String TAG = "Cache";

    private FirebaseDatabase mDatabase;
    private DatabaseReference mDbRef;

    private IDataLoadedCallable mCallback;
    private static Cache mInstance = null;

    private Map<String, User> mUsers = new HashMap<>();

    private Cache(IDataLoadedCallable mCallback) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.mDatabase.setPersistenceEnabled(true);
        this.mDbRef    = mDatabase.getReference("users");
        this.mCallback = mCallback;

    }

    public static Cache getInstance(IDataLoadedCallable callback) {
        if(mInstance == null){
            Cache.mInstance = new Cache(callback);
        }
        return Cache.mInstance;
    }

    // return the callback
    public void getUser(Integer userId){
        if(!Cache.mInstance.mUsers.containsKey(userId)){
            DatabaseReference userRef = Cache.mInstance.mDbRef.child(userId.toString());
            ValueEventListener listener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
//                    User user = new User();

                    Cache.mInstance.mCallback.onFirebaseLoaded(user);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            };
            userRef.addValueEventListener(listener);
        }else{
            Cache.mInstance.mCallback.onFirebaseLoaded(Cache.mInstance.mUsers.get(userId));
        }
    }

    

    public void setUser(Integer userId, @NonNull User user){
        Cache.mInstance.mUsers.put(userId.toString(), user);
    }

    public void commit(){
        for(String key : Cache.mInstance.mUsers.keySet()){
            Cache.mInstance.mDbRef.child(key.toString()).setValue(Cache.mInstance.mUsers.get(key));
        }
    }

}
