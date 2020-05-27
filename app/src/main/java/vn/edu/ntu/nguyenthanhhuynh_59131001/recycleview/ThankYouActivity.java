package vn.edu.ntu.nguyenthanhhuynh_59131001.recycleview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThankYouActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        addViews();
    }

    private void addViews() {
        //Toast.makeText(this, "Cảm ơn bạn đã mua hàng !", Toast.LENGTH_SHORT).show();
    }
}
