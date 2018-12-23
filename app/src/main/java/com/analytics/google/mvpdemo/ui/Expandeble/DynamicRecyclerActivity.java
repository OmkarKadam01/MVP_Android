package com.analytics.google.mvpdemo.ui.Expandeble;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.analytics.google.mvpdemo.R;

import java.util.ArrayList;

public class DynamicRecyclerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_recycler);
        setContentView(R.layout.activity_dynamic_recycler);
        mContext = DynamicRecyclerActivity.this;
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerDataAdapter recyclerDataAdapter = new RecyclerDataAdapter(getDummyDataToPass());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(recyclerDataAdapter);
        mRecyclerView.setHasFixedSize(true);
    }

    private ArrayList<DummyParentDataItem> getDummyDataToPass() {
        ArrayList<DummyParentDataItem> dummyDataItems = new ArrayList<>();
        ArrayList<DummyChildDataItem> dummyChildDataItems;
        DummyParentDataItem dummyParentDataItem;
        DummyChildDataItem dummyChildDataItem;
        /////////
        dummyParentDataItem = new DummyParentDataItem();
        dummyParentDataItem.setParentName("Parent 1");
        dummyChildDataItems = new ArrayList<>();
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 1");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyParentDataItem.setChildDataItems(dummyChildDataItems);
        dummyDataItems.add(dummyParentDataItem);
        ////////
        dummyParentDataItem = new DummyParentDataItem();
        dummyParentDataItem.setParentName("Parent 2");
        dummyChildDataItems = new ArrayList<>();
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 1");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 2");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyParentDataItem.setChildDataItems(dummyChildDataItems);
        dummyDataItems.add(dummyParentDataItem);
        ////////
        dummyParentDataItem = new DummyParentDataItem();
        dummyParentDataItem.setParentName("Parent 3");
        dummyChildDataItems = new ArrayList<>();
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 1");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 2");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 3");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 4");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 5");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyParentDataItem.setChildDataItems(dummyChildDataItems);
        dummyDataItems.add(dummyParentDataItem);
        ////////
        return dummyDataItems;
    }

    private class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.MyViewHolder> {
        private ArrayList<DummyParentDataItem> dummyParentDataItems;

        RecyclerDataAdapter(ArrayList<DummyParentDataItem> dummyParentDataItems) {
            this.dummyParentDataItems = dummyParentDataItems;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent_child_listing, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            DummyParentDataItem dummyParentDataItem = dummyParentDataItems.get(position);
            holder.textView_parentName.setText(dummyParentDataItem.getParentName());
            //
            int noOfChildTextViews = holder.linearLayout_childItems.getChildCount();
            int noOfChild = dummyParentDataItem.getChildDataItems().size();
            if (noOfChild < noOfChildTextViews) {
                for (int index = noOfChild; index < noOfChildTextViews; index++) {
                    TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(index);
                    currentTextView.setVisibility(View.GONE);
                }
            }
            for (int textViewIndex = 0; textViewIndex < noOfChild; textViewIndex++) {
                TextView currentTextView = (TextView) holder.linearLayout_childItems.getChildAt(textViewIndex);
                currentTextView.setText(dummyParentDataItem.getChildDataItems().get(textViewIndex).getChildName());
                /*currentTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "" + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });*/
            }
        }

        @Override
        public int getItemCount() {
            return dummyParentDataItems.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private Context context;
            private TextView textView_parentName;
            private LinearLayout linearLayout_childItems;

            MyViewHolder(View itemView) {
                super(itemView);
                context = itemView.getContext();
                textView_parentName = itemView.findViewById(R.id.tv_parentName);
                linearLayout_childItems = itemView.findViewById(R.id.ll_child_items);
                linearLayout_childItems.setVisibility(View.GONE);
                int intMaxNoOfChild = 0;
                for (int index = 0; index < dummyParentDataItems.size(); index++) {
                    int intMaxSizeTemp = dummyParentDataItems.get(index).getChildDataItems().size();
                    if (intMaxSizeTemp > intMaxNoOfChild) intMaxNoOfChild = intMaxSizeTemp;
                }
                for (int indexView = 0; indexView < intMaxNoOfChild; indexView++) {
                    TextView textView = new TextView(context);
                    textView.setId(indexView);
                    textView.setPadding(0, 20, 0, 20);
                    textView.setGravity(Gravity.CENTER);
                    textView.setBackground(ContextCompat.getDrawable(context, R.drawable.background_sub_module_text));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    textView.setOnClickListener(this);
                    linearLayout_childItems.addView(textView, layoutParams);
                }
                textView_parentName.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.tv_parentName) {
                    if (linearLayout_childItems.getVisibility() == View.VISIBLE) {
                        linearLayout_childItems.setVisibility(View.GONE);
                    } else {
                        linearLayout_childItems.setVisibility(View.VISIBLE);
                    }
                } else {
                    TextView textViewClicked = (TextView) view;
                    Toast.makeText(context, "" + textViewClicked.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
