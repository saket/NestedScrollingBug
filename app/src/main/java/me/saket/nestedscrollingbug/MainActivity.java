package me.saket.nestedscrollingbug;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    List<String> items = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      items.add("Item #" + i);
    }
    recyclerView.setAdapter(new RecyclerAdapter(items));
  }

  private static class RecyclerAdapter extends RecyclerViewArrayAdapter<String, ItemViewHolder> {

    public RecyclerAdapter(@Nullable List<String> items) {
      super(items);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return ItemViewHolder.create(parent.getContext(), R.layout.list_item, parent);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
      holder.editText.setHint(getItem(position));
    }
  }

  public static class ItemViewHolder extends ViewHolder {

    private EditText editText;

    public static ItemViewHolder create(Context context, @LayoutRes int layoutRes, ViewGroup parent) {
      return new ItemViewHolder(LayoutInflater.from(context).inflate(layoutRes, parent, false));
    }

    public ItemViewHolder(View itemView) {
      super(itemView);
      editText = (EditText) itemView.findViewById(android.R.id.text1);
    }
  }
}
