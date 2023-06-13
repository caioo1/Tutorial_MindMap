package com.example.tutorial_mindmap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.jagar.mindmappingandroidlibrary.Views.ConnectionTextMessage
import me.jagar.mindmappingandroidlibrary.Views.Item
import me.jagar.mindmappingandroidlibrary.Views.ItemLocation
import me.jagar.mindmappingandroidlibrary.Views.MindMappingView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mindMappingView = findViewById<MindMappingView>(R.id.mind_mapping_view)

        val item = Item(this@MainActivity, "Root", "This is an root item", true)
        mindMappingView.addCentralItem(item, false) //I didn't want to make the root drag able

        val child = Item(this@MainActivity, "Child", "This is a child", true)
        /*mindMappingView.addItem(
            child,
            item,
            200,
            10,
            ItemLocation.TOP,
            true,
            null
        ) *///It will be drag able but there will not be a text on the connection between the root and the child

        val connectionTextMessage = ConnectionTextMessage(this@MainActivity)
        connectionTextMessage.text =
            "This message will be displayed\non the connection between Child and Root"
        mindMappingView.addItem(
            child,
            item,
            200,
            10,
            ItemLocation.TOP,
            true,
            connectionTextMessage
        ) //It will be drag able and there will be a text on the connection between the root and the child

    }
}