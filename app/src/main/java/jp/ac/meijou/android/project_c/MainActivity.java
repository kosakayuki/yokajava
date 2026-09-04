package jp.ac.meijou.android.project_c;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import jp.ac.meijou.android.project_c.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] titles ={"2026/1/2", "2027/2/4", "2027/6/4"};

        int[] images = {
                R.drawable.test_image0,R.drawable.test_image0,R.drawable.test_image0,
        };

        int[] images2 = {
                R.drawable.test_image1,R.drawable.test_image1,R.drawable.test_image1,
        };

        ArrayList<Map<String, Object>> listData = new ArrayList<>();
        for (int i=0; i < images.length; i++) {
            Map<String, Object> item = new HashMap<>();

            item.put("image", images[i]);
            item.put("image2", images2[i]);
            item.put("name", titles[i]);
            listData.add(item);
        }

        // ListViewにデータをセットする
        ListView list = findViewById(R.id.list);
        list.setAdapter(new SimpleAdapter(
                this,
                listData,
                R.layout.list_item,
                new String[] {"name", "image2", "image"},
                new int[] {R.id.name, R.id.image2, R.id.image}
        ));


    }
}