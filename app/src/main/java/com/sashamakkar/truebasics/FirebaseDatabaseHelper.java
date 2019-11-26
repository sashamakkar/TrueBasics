package com.sashamakkar.truebasics;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private List<Details> details = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Details> details, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper() {
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("Details");
    }

//    public void readDetails(final DataStatus dataStatus){
//        mReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                details.clear();
//                List<String> keys = new ArrayList<>();
//                for(DataSnapshot keyNode : dataSnapshot.getChildren()){
//                    keys.add(keyNode.getKey());
//                    Details detail = keyNode.getValue(Details.class);
//                    details.add(detail);
//                }
//                dataStatus.DataIsLoaded(details, keys);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }

    public void addDetails(Details detail, final DataStatus dataStatus){

        String key = mReference.push().getKey();
        mReference.child(key).setValue(detail)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsInserted();
                    }
                });

    }

}
