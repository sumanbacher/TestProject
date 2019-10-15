package com.test.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.test.demo.adapter.CustomAdapter;
import com.test.demo.model.CustomModel;
import com.test.demo.others.APILinks;
import com.test.demo.parsers.GetDataParserArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    private ArrayList<CustomModel> arrayList=new ArrayList<CustomModel>();
    private CustomAdapter customAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view=findViewById(R.id.recycler_view);
        recycler_view.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(layoutManager);
        customAdapter=new CustomAdapter(arrayList,this);
        recycler_view.setAdapter(customAdapter);
        getlist(APILinks.GET_LIST);
    }

    private void getlist(String url){
        new GetDataParserArray(MainActivity.this, url, true, new GetDataParserArray.OnGetResponseListener() {
            @Override
            public void onGetResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try{
                        JSONObject jsonObject=response.getJSONObject(i);
                        String mName=jsonObject.getString("Name");
                        String mEmail=jsonObject.getString("Email");
                        String mPhone=jsonObject.getString("Phone");
                        String mDateOfJoin=jsonObject.getString("DateOfJoin");
                        arrayList.add(new CustomModel(mName,mEmail,mPhone,mDateOfJoin));
                    }catch (JSONException e){e.printStackTrace();}
                }
                customAdapter.notifyDataSetChanged();
            }
        });
    }
}
