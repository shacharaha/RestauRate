package firebase;

import android.util.Log;

import com.example.shachar.restaurate.Constants;
import com.example.shachar.restaurate.model.Restaurant;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Shachar on 6/19/2016.
 */
public class MyFireBaseDataBase {
    FirebaseDatabase database;
    public MyFireBaseDataBase()
    {
        database = FirebaseDatabase.getInstance();
    }
    public DatabaseReference getRestaurantsRef()
    {
        return database.getReference(Constants.FB_RESTAURANTS);
    }
    public void saveRestaurant(Restaurant restaurant)
    {
        getRestaurantsRef().push().setValue(restaurant);
    }
    public void retrieveRestaurants()
    {
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Post post = dataSnapshot.getValue(Post.class);
                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        mPostReference.addValueEventListener(postListener);
    }
}
