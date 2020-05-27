package vn.edu.ntu.nguyenthanhhuynh_59131001.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;
import java.util.Locale;

import vn.edu.ntu.nguyenthanhhuynh_59131001.recycleview.Controller.ICartController;
import vn.edu.ntu.nguyenthanhhuynh_59131001.recycleview.Model.Product;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListProduct;
    ProductAdapter adapter;
    List<Product> listProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
    }

    public void addViews(){
        rvListProduct = findViewById(R.id.rvListProduct);
        rvListProduct.setLayoutManager(new LinearLayoutManager(this));
        ICartController cartController = (ICartController) getApplication();
        listProducts = cartController.getAllProducts();
        adapter = new ProductAdapter(listProducts);
        rvListProduct.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mnu_mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.mnuClose:
                finish();
            case R.id.mnuGioHang:
                showShoppingCart();
        }
        return super.onOptionsItemSelected(item);
    }

    //Phương thức show giao diện giỏ hàng
    public void showShoppingCart(){
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    //Adapter
    private class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtName, txtPrice, txtDesc;
        ImageView imvAddToCart;
        Product p;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtName);
            txtPrice = this.itemView.findViewById(R.id.txtPrice);
            txtDesc = this.itemView.findViewById(R.id.txtDesc);
            imvAddToCart = this.itemView.findViewById(R.id.imvAddToCart);
            imvAddToCart.setOnClickListener(this);
        }

        public void bind(Product p){
            this.p = p;
            txtName.setText(p.getName());
            txtPrice.setText(new Integer(p.getPrice()).toString() + " VND");
            txtDesc.setText(p.getDesc());
        }

        @Override
        public void onClick(View v) {
            int sum = 0;
            ICartController controller = (ICartController) getApplication();
            if(controller.addToCart(p)){
                sum =  sum + this.txtPrice.length();
                Toast.makeText(MainActivity.this, "Thêm " + p.getName() + " vào giỏ hàng", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(MainActivity.this, p.getName() + " đã tồn tại trong giỏ hàng của bạn", Toast.LENGTH_SHORT).show();
        }
    }

    private class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

        List<Product> listProducts;

        private ProductAdapter(List<Product> listProduct) {
            this.listProducts = listProduct;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.product, parent,false);
            //Product.xml
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(listProducts.get(position));
        }

        @Override
        public int getItemCount() {
            return listProducts.size();
        }
    }
}
