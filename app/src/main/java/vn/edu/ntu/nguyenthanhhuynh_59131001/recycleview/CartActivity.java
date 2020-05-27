package vn.edu.ntu.nguyenthanhhuynh_59131001.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.edu.ntu.nguyenthanhhuynh_59131001.recycleview.Controller.ICartController;
import vn.edu.ntu.nguyenthanhhuynh_59131001.recycleview.Model.Product;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtShoppingCart;
    Button btnSubmit, btnCancel;
    String message;
    int productNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        addViews();
        this.message = "Không có mặt hàng nào trong giỏ hàng của bạn";
    }

    private void addViews(){
        txtShoppingCart = findViewById(R.id.txtShoppingCart);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        btnSubmit.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        showShoppingCart();
    }

    public void showShoppingCart(){
        ICartController controller = (ICartController) getApplication();
        List<Product> products = controller.getShoppingCart();
        StringBuilder builder = new StringBuilder();

        productNumber = 0;
        for (Product p : products) {
            productNumber++;
            builder.append(p.getName())
                    .append(": \t\t\t")
                    .append(p.getPrice())
                    .append("\n");
        }

        if(builder.length() > 0)
            txtShoppingCart.setText(builder.toString());
        else
            txtShoppingCart.setText(this.message);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnSubmit:
                submit();
                break;
            case R.id.btnCancel:
                cancel();
                break;
        }
    }

    public void submit() {
        if(productNumber > 0){
            Intent intent = new Intent(this, ReceiverInfoActivity.class);
            startActivity(intent);
        }
        else{
            txtShoppingCart.setText(this.message);
        }

    }

    private void cancel(){
        productNumber = 0;

        txtShoppingCart.setText(this.message);
        Toast.makeText(this, "Xóa giỏ hàng thành công", Toast.LENGTH_SHORT).show();
    }
}
