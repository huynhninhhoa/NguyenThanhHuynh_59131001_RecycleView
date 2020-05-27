package vn.edu.ntu.nguyenthanhhuynh_59131001.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiverInfoActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnXNDonHang, btnHuyDatHang;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiverinfo);
        addViews();
    }

    private void addViews() {
        //
        btnXNDonHang = findViewById(R.id.btnXNDonHang);
        btnHuyDatHang = findViewById(R.id.btnHuyDatHang);

        btnXNDonHang.setOnClickListener(this);
        btnHuyDatHang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnXNDonHang:
                submit();
                break;
            case R.id.btnHuyDatHang:
                cancel();
                break;
        }
    }

    public void submit() {
        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
    }

    private void cancel(){
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }
}
