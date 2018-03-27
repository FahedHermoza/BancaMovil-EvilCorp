package com.fahed.developer.evilcorpbank;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.fahed.developer.evilcorpbank.Adapters.MoveHolder;
import com.fahed.developer.evilcorpbank.Models.Movement;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationFragment extends Fragment {

    private View viewRoot;
    private RecyclerView recyclerViewMove;
    private MoveHolder.MoveAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    public OperationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewRoot = inflater.inflate(R.layout.fragment_operation, container, false);

        recyclerViewMove = (RecyclerView) viewRoot.findViewById(R.id.recyclerViewMove);
        linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerViewMove.setLayoutManager(linearLayoutManager);
        recyclerViewMove.setItemAnimator(new DefaultItemAnimator());
        recyclerViewMove.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        initRecycler(prepareMoveData());

        return viewRoot;
    }

    public void initRecycler(final List<Movement> itemMovementList) {
        if (adapter == null) {
            adapter = new MoveHolder.MoveAdapter(itemMovementList);
            recyclerViewMove.setAdapter(adapter);
        }
    }

    private List<Movement> prepareMoveData() {
        List<Movement> movementList = new ArrayList<>();
        Movement movement = new Movement("Retiro en cajero", "Lun 26 mar, 10:00 am", -200);
        movementList.add(movement);
        Movement movement1 = new Movement("Transf web/app", "Mar 20 mar, 5:00 am", 100);
        movementList.add(movement1);
        Movement movement2 = new Movement("Pago Open English", "Jue 15 mar, 2:50 pm", -150);
        movementList.add(movement2);
        Movement movement3 = new Movement("Pago Movistar", "Jue 15 mar, 2:50 pm", -50);
        movementList.add(movement3);
        Movement movement4 = new Movement("Pago Open English", "Lun 5 mar, 11:10 pm", -200);
        movementList.add(movement4);
        Movement movement5 = new Movement("Transf web/app", "Lun 19 feb, 12:00 am", 500);
        movementList.add(movement5);
        Movement movement6 = new Movement("Transf web/app", "Vie 16 feb, 6:34 pm", 300);
        movementList.add(movement6);
        Movement movement7 = new Movement("Pago web/app", "Mar 6 feb, 1:00 am", -200);
        movementList.add(movement7);

        return movementList;
    }

}
