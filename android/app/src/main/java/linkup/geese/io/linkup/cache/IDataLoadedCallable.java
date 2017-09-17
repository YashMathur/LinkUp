package linkup.geese.io.linkup.cache;

import linkup.geese.io.linkup.data.Link;
import linkup.geese.io.linkup.data.User;

/**
 * Created by Azhng on 2017-09-16.
 */

public interface IDataLoadedCallable {
    void onFirebaseLoaded(User user);
    void onFirebaseLinkLoaded(Link link);
}
