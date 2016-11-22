package com.jikexueyuan.mucapture;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCapture;
    private ImageView ivCapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCapture = (Button) findViewById(R.id.btnCapture);
        ivCapture = (ImageView) findViewById(R.id.ivCapture);

        btnCapture.setOnClickListener(this);

    }

    private final int TAKE_CAPTURE = 1;
    private Uri outPutUri;
    private File file;

    @Override
    public void onClick(View v) {

        file = new File(Environment.getExternalStorageDirectory(), "my.png");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        outPutUri = Uri.fromFile(file);

        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(MediaStore.EXTRA_OUTPUT, outPutUri);
        startActivityForResult(i, TAKE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == TAKE_CAPTURE) {
                if (data != null) {
                    if (data.hasExtra("data")) {
                        Bitmap bitmap = data.getParcelableExtra("data");
                        ivCapture.setImageBitmap(bitmap);
                    }
                } else {

                        int width = ivCapture.getWidth();
                        int height = ivCapture.getHeight();

                        BitmapFactory.Options options = new BitmapFactory.Options();//缩放拍照的图片以便于显示
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(outPutUri.getPath(), options);

                        int imgWidth = options.outWidth;
                        int imgHetght = options.outHeight;

                        int scale = Math.min(imgWidth / width, imgHetght / height);
                        scale = scale == 0 ? 1 : scale;//缩放比例

                        options.inJustDecodeBounds = false;
                        options.inSampleSize = scale;

                        Bitmap bitmap = BitmapFactory.decodeFile(outPutUri.getPath(),options);
                        ivCapture.setImageBitmap(bitmap);


                }
            }
        }
    }
}
