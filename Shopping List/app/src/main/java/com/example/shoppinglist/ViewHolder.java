package com.example.shoppinglist;

import android.graphics.Color;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

interface ItemClickListener{
    void CheckBoxClick(int position, CheckBox checkBox);
}


class ViewHolder extends RecyclerView.ViewHolder  {
    TextView purchase;
    private CheckBox checkBox;
    RelativeLayout background, foreground;


    ViewHolder(@NonNull View itemView, final ItemClickListener listener) {
        super(itemView);
        findByID();
        setListener(listener);
    }

    public boolean getCheck(){
        return checkBox.isChecked();
    }

    private void findByID() {
        purchase = itemView.findViewById(R.id.purchase);
        checkBox = itemView.findViewById(R.id.checkBox);
        background = itemView.findViewById(R.id.RL_background);
        foreground = itemView.findViewById(R.id.RL_foreground);
    }

    private void setListener(final ItemClickListener listener) {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (listener != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        if (isChecked)
                            purchase.setTextColor(Color.GREEN);
                        else
                            purchase.setTextColor(Color.GRAY);
                        listener.CheckBoxClick(position, checkBox);
                    }
                }
            }
        });
    }

}
