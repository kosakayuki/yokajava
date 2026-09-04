package jp.ac.meijou.android.project_c;

import static android.provider.MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.project_c.databinding.ActivityMainBinding;
import jp.ac.meijou.android.project_c.databinding.ActivityPostPageBinding;

public class PostPage extends AppCompatActivity {

    private ActivityPostPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //最初のやつ
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityPostPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //カメラ起動
        var intent = new Intent();
        intent.setAction(INTENT_ACTION_STILL_IMAGE_CAMERA);

        //掃除中の表示




    }
}