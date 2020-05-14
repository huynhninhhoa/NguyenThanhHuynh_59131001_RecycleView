package vn.edu.ntu.nguyenthanhhuynh_59131001.recycleview.Controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.nguyenthanhhuynh_59131001.recycleview.Model.Product;

public class CartController extends Application implements ICartController {
    List<Product> listProducts = new ArrayList<>();

    public CartController(){
        listProducts.add(new Product("Khoai Lang", 25000, "Đây là khoai lang"));
        listProducts.add(new Product("Khoai Tây", 35000, "Đây là khoai Tây"));
        listProducts.add(new Product("Khoai Mì", 15000, "Đây là khoai Mì"));
        listProducts.add(new Product("Khoai Tím", 20000, "Đây là khoai Tím"));
        listProducts.add(new Product("Khoai Tím", 20000, "Đây là khoai Tím"));
        listProducts.add(new Product("Khoai Tím", 20000, "Đây là khoai Tím"));
        listProducts.add(new Product("Khoai Tím", 20000, "Đây là khoai Tím"));
        listProducts.add(new Product("Khoai Tím", 20000, "Đây là khoai Tím"));
        listProducts.add(new Product("Khoai Tím", 20000, "Đây là khoai Tím"));
    }

    @Override
    public List<Product> getAllProducts() {
        return listProducts;
    }
}
