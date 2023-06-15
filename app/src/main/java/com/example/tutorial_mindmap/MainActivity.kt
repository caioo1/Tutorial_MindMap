package com.example.tutorial_mindmap

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import me.jagar.mindmappingandroidlibrary.Views.ConnectionTextMessage
import me.jagar.mindmappingandroidlibrary.Views.Item
import me.jagar.mindmappingandroidlibrary.Views.ItemLocation
import me.jagar.mindmappingandroidlibrary.Views.MindMappingView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.mindmappingview)

        var mindMappingView = findViewById<MindMappingView>(R.id.mind_mapping_view)

        //var btAddItem: Button = findViewById<Button>(R.id.btAddItem)

        //btAddItem.setOnClickListener {

        //}

        val rootItem = Item(this@MainActivity, "Root", "This is an root item", true)
        mindMappingView.addCentralItem(rootItem, false) //I didn't want to make the root drag able

        val child = Item(this@MainActivity, "Child 0", "This is a child 0", true)
        /*mindMappingView.addItem(
            child,
            item,
            200,
            10,
            ItemLocation.TOP,
            true,
            null
        ) *///It will be drag able but there will not be a text on the connection between the root and the child
        val connectionTextMessage0 = ConnectionTextMessage(this@MainActivity)
        connectionTextMessage0.text = "0 This message will be displayed\non the connection between Child and Root"

        mindMappingView.addItem(
            child,
            rootItem,
            200,
            10,
            ItemLocation.TOP,
            true,
            connectionTextMessage0
        )


        val child1 = Item(this@MainActivity, "Child 1", "This is a child 1", true)

        /*val connectionTextMessage1 = ConnectionTextMessage(this@MainActivity)
        connectionTextMessage1.text = "1 This message will be displayed\non the connection between Child and Root"
        mindMappingView.addItem(
            child1,
            rootItem,
            200,
            10,
            ItemLocation.TOP,
            true,
            connectionTextMessage1
        )*/ //It will be drag able and there will be a text on the connection between the root and the child

        mindMappingView.setOnItemClicked { item ->
            //item.isPressed
            // = true
            /*if (item.equals(child)) {
                Toast.makeText(this@MainActivity, "child is clicked", Toast.LENGTH_LONG)
                    .show()
            } else if (item.equals(rootItem)) {
                Toast.makeText(this@MainActivity, "root is clicked", Toast.LENGTH_LONG)
                    .show()
            }*/
            //Toast.makeText(this@MainActivity, item.title.text.toString(), Toast.LENGTH_SHORT).show()

            val childItem = Item(this@MainActivity, "Child Item", "Child Item", true)

            mindMappingView.addItem(
                childItem,
                item,
                200,
                10,
                ItemLocation.BOTTOM,
                true,
                null
            )
        }

    }
}