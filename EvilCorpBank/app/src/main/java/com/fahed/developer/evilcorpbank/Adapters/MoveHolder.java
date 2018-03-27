package com.fahed.developer.evilcorpbank.Adapters;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fahed.developer.evilcorpbank.Models.Movement;
import com.fahed.developer.evilcorpbank.R;

import java.util.List;

/**
 * Created by mac on 13/02/18.
 */

public class MoveHolder extends RecyclerView.ViewHolder  {
    private Movement itemMovement;
    private View viewItemMovement;
    private TextView textViewDetail;
    private TextView textViewDate;
    private TextView textViewCount;

    private final int BASE_DISCOUNT= 0;

    public MoveHolder(View viewItemMovement) {
        super(viewItemMovement);
        this.viewItemMovement = viewItemMovement;

        textViewDate = (TextView) viewItemMovement.findViewById(R.id.textViewDateItem);
        textViewDetail = (TextView) viewItemMovement.findViewById(R.id.textViewDetailItem);
        textViewCount = (TextView) viewItemMovement.findViewById(R.id.textViewCountItem);

    }

    public void bindMoves(Movement itemImmovables) {
        this.itemMovement = itemImmovables;

        textViewDetail.setText(this.itemMovement.getDetail());
        textViewDate.setText(this.itemMovement.getDate());
        textViewCount.setText("$ "+this.itemMovement.getCount()+".00");
        if(this.itemMovement.getCount()>BASE_DISCOUNT)
            textViewCount.setTextColor(viewItemMovement.getResources().getColor(R.color.colorAccent));
        else
            textViewCount.setTextColor(viewItemMovement.getResources().getColor(R.color.discount_item));
    }

    public static class MoveAdapter extends RecyclerView.Adapter<MoveHolder> {

        private List<Movement> itemMovementList;

        public MoveAdapter(List<Movement> itemMovementList) {
            this.itemMovementList = itemMovementList;
        }

        @Override
        public MoveHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_movement, parent, false);
            return new MoveHolder(view);
        }

        @Override
        public void onBindViewHolder(MoveHolder holder, int position) {
            Movement itemMovement = itemMovementList.get(position);
            //Connect widgets
            holder.bindMoves(itemMovement);
        }

        @Override
        public int getItemCount() {
            return itemMovementList.size();
        }


    }

}