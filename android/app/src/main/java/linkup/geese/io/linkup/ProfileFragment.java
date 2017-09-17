package linkup.geese.io.linkup;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import linkup.geese.io.linkup.cache.Cache;
import linkup.geese.io.linkup.cache.IDataLoadedCallable;
import linkup.geese.io.linkup.data.Link;
import linkup.geese.io.linkup.data.User;

public class ProfileFragment extends Fragment implements IDataLoadedCallable {

    private static final String ARG_USERID = "userId";

    private User mUser;
    private String mUserId;
    private View mView;
    private ConstraintLayout phone, website, email, linkedin, twitter, facebook;

    public ProfileFragment() {}

    public static ProfileFragment newInstance(String paramUserId) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USERID, paramUserId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUserId = getArguments().getString(ARG_USERID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.mView = inflater.inflate(R.layout.fragment_profile, container, false);
        Cache.getInstance(this).getUser(mUserId);


        phone = (ConstraintLayout) this.mView.findViewById(R.id.pf_phone_container);
        website = (ConstraintLayout) this.mView.findViewById(R.id.pf_website_container);
        email = (ConstraintLayout) this.mView.findViewById(R.id.pf_email_container);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return this.mView;
    }

    @Override
    public void onFirebaseLoaded(User user) {
        ((TextView) this.mView.findViewById(R.id.pf_name)).setText(user.getFirstName() + " " + user.getLastName());
    }

    @Override
    public void onFirebaseLinkLoaded(Link link) {

    }
}
