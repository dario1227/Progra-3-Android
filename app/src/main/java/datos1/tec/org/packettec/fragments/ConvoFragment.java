package datos1.tec.org.packettec.fragments;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import datos1.tec.org.packettec.R;
import datos1.tec.org.packettec.adapters.ConversationAdapter;
import datos1.tec.org.packettec.model.Conversations;

public class ConvoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView;
    ConversationAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ConvoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConvoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConvoFragment newInstance(String param1, String param2) {
        ConvoFragment fragment = new ConvoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_convo, container, false);

        recyclerView = v.findViewById(R.id.convo_recycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration(new VerticalSpaceItemDecorator(10));
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ConversationAdapter();
        populateRecyclerViewValues();

        return v;
    }

    private void populateRecyclerViewValues() {

        ArrayList<Conversations> listContentArr = new ArrayList<>();


        for (int iter = 0; iter <= 50; iter++) {
            //Creating POJO class object
            Conversations conversations = new Conversations();
            //Values are binded using set method of the POJO class
            conversations.setName("Marco Herrera");
            conversations.setContent("Hello RecyclerView! item: " + iter);
            conversations.setTime("10:45PM");
            //After setting the values, we add all the Objects to the array
            //Hence, listConentArr is a collection of Array of POJO objects

            listContentArr.add(conversations);
        }
        //We set the array to the adapter
        adapter.setListContent(listContentArr);
        //We in turn set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);
    }


}

class VerticalSpaceItemDecorator extends RecyclerView.ItemDecoration {

    private final int spacer;

    public VerticalSpaceItemDecorator(int spacer) {
        this.spacer = spacer;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = spacer;
    }
}