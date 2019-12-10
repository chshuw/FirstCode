package com.wang.firstcode.recycleview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.wang.materialdesign.R;
import com.wang.firstcode.materialdesign.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecycleViewActivity2 extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        initFruits();
        RecyclerView recyclerview = findViewById(R.id.recycler_view);
        //瀑布流布局
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerview.setAdapter(adapter);

    }

    private void initFruits() {
        for (int i = 0; i < 2; i++){
            Fruit apple = new Fruit(getRandomLengName("Apple"), R.drawable.apple);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengName("Banana"), R.drawable.banana);
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengName("Orange"), R.drawable.orange);
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengName("Watermelon"), R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengName("Pear"), R.drawable.pear);
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengName("Grape"), R.drawable.grape);
            fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomLengName("Pineapple"), R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengName("Strawberry"), R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit(getRandomLengName("Cherry"), R.drawable.cherry);
            fruitList.add(cherry);
            Fruit mango = new Fruit(getRandomLengName("Mango"), R.drawable.mango);
            fruitList.add(mango);
        }
    }

    private String getRandomLengName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i ++){
            builder.append(name);
        }
        return builder.toString();
    }
}
