package me.saket.nestedscrollingbug;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    List<String> items = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      items.add("Item #" + i);
    }
    recyclerView.setAdapter(new RecyclerAdapter(items));
  }

  private static class RecyclerAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private List<String> items;

    public RecyclerAdapter(@Nullable List<String> items) {
      this.items = items;
    }

    @NonNull @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return ItemViewHolder.create(parent.getContext(), R.layout.list_item, parent);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
      holder.editText.setHint(items.get(position));
    }

    @Override public int getItemCount() {
      return items.size();
    }
  }

  public static class ItemViewHolder extends RecyclerView.ViewHolder {

    private EditText editText;

    public static ItemViewHolder create(Context context, @LayoutRes int layoutRes, ViewGroup parent) {
      return new ItemViewHolder(LayoutInflater.from(context).inflate(layoutRes, parent, false));
    }

    public ItemViewHolder(View itemView) {
      super(itemView);
      editText = itemView.findViewById(android.R.id.text1);
    }
  }
}
