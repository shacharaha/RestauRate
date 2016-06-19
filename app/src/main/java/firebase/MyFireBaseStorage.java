package firebase;

import com.example.shachar.restaurate.Constants;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by Shachar on 6/19/2016.
 */
public class MyFireBaseStorage {
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://project-4604682362893329843.appspot.com");

    public StorageReference getRestaurantsRef()
    {
        return storageRef.child(Constants.FB_RESTAURANT);
    }
}
