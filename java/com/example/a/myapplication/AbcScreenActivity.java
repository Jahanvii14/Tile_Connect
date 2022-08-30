package com.example.a.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AbcScreenActivity extends ActionBarActivity {
    private static int alpha[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
     R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,
     R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,
     R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z};
    private static int alphaimages[]={R.drawable.apple,R.drawable.bee,R.drawable.cat,R.drawable.dog,
            R.drawable.elephant,R.drawable.frog,R.drawable.giraffe,R.drawable.hat,R.drawable.icecream,
            R.drawable.jam,R.drawable.key,R.drawable.lamp,R.drawable.monkey,R.drawable.nest,
            R.drawable.owl,R.drawable.pen,R.drawable.queen,R.drawable.rabbit,R.drawable.sun,
            R.drawable.tomato,R.drawable.umbrella,R.drawable.van,R.drawable.watch,R.drawable.xmas,
            R.drawable.yarnball,R.drawable.zoo};
    ImageView img1,img2,img3,img4,img5,img6,img7,img8;
    private static int value=4;
    List<ImageView> img = new ArrayList<ImageView>();
    MediaPlayer ring;
    ImageButton ib;
    public static boolean flag=false,click=false;
    public static String fbtn="",sbtn="";
    public static int btn1;
    public static int btn2;
    public static int sc=0;
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc_screen);
        ib=(ImageButton)findViewById(R.id.ib_sound);
        img.add((ImageView)findViewById(R.id.imageView7));
        img.add((ImageView)findViewById(R.id.imageView8));
        img.add((ImageView)findViewById(R.id.imageView9));
        img.add((ImageView)findViewById(R.id.imageView10));
        img.add((ImageView)findViewById(R.id.imageView11));
        img.add((ImageView)findViewById(R.id.imageView12));
        img.add((ImageView)findViewById(R.id.imageView13));
        img.add((ImageView)findViewById(R.id.imageView14));
        score=(TextView)findViewById(R.id.score);
        score.setText(String.valueOf(sc));
        List<Integer> obj = new ArrayList<Integer>();
        obj.add(0);
        obj.add(1);
        obj.add(2);
        obj.add(3);
        Collections.shuffle(obj);
        for(int i=0;i<4;i++)
        {
            img.get(i).setImageDrawable(getResources().getDrawable(alpha[obj.get(i)]));
            img.get(i+4).setImageDrawable(getResources().getDrawable(alphaimages[obj.get(i)]));
            refresh(getCurrentFocus());

        }
        ring=MediaPlayer.create(AbcScreenActivity.this,R.raw.bellsound);

    }
    public void home(View v)
    {
        Intent i=new Intent(getBaseContext(),MenuScreenActivity.class);
        startActivity(i);
        finish();
    }
    public void sound(View v)
    {
        if(flag==false)
        {
            ib.setImageResource(R.drawable.nosound);
            flag=true;
            ring.release();
            ring=null;
        }
        else
        {
            ib.setImageResource(R.drawable.soundon);
            flag=false;
            ring=MediaPlayer.create(AbcScreenActivity.this,R.raw.bellsound);
       //     ring.start();

        }
    }
    public void back(View v)
    {
        Intent i=new Intent(getBaseContext(),HomeScreenActivity.class);
        startActivity(i);
        finish();
    }
    public void refresh(View v)
    {
        List<Integer> obj = new ArrayList<Integer>();
        List<Integer> obj1 = new ArrayList<Integer>();
        List<Integer> obj2 = new ArrayList<Integer>();
        obj1.add(0);obj1.add(1);obj1.add(2);obj1.add(3);
        Collections.shuffle(obj1);
        obj2.add(4);obj2.add(5);obj2.add(6);obj2.add(7);
        Collections.shuffle(obj2);
        for(int i=value;i>=value-4;i--)
        {
            obj.add(i);
        }
        Collections.shuffle(obj);
        for(int i=0;i<4;i++)
        {
            img.get(obj1.get(i)).setImageDrawable(getResources().getDrawable(alpha[obj.get(i)]));
            img.get(obj2.get(i)).setImageDrawable(getResources().getDrawable(alphaimages[obj.get(i)]));
            img.get(obj1.get(i)).setTag(i);
            img.get(obj2.get(i)).setTag(i);
            img.get(obj1.get(i)).setVisibility(View.VISIBLE);
            img.get(obj2.get(i)).setVisibility(View.VISIBLE);
             }
        if(value==24)
        {
            value=4;
        }
        else
        {
            value = value + 4;
        }
    }
    public void submit(View v)
    {
        if(ring!=null) {
            ring=MediaPlayer.create(AbcScreenActivity.this,R.raw.bellsound);
            ring.start();
        }
        ImageView iv=(ImageView)v;
        if(click==false)
        {
            fbtn =String.valueOf(iv.getTag());
            click=true;
            btn1=iv.getId();
        }
        else
        {
            sbtn=String.valueOf(iv.getTag());
            click=false;
            btn2=iv.getId();
            if(fbtn.equals(sbtn))
            {
               for(int i=0;i<8;i++)
               {
                   if(img.get(i).getId()==btn1)
                   {
                     img.get(i).setVisibility(View.INVISIBLE);
                   }
                   if(img.get(i).getId()==btn2)
                   {
                      img.get(i).setVisibility(View.INVISIBLE);
                   }
               }
                fbtn="";
                sbtn="";
                sc=sc+50;
                score.setText(String.valueOf(sc));
            }
            else
            {
                Thread thread = new Thread() {
                    public void run() {
                        try {
                            sleep(1* 1000);
                            if(ring!=null) {
                                ring = MediaPlayer.create(AbcScreenActivity.this, R.raw.wrong);
                                ring.start();
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
                fbtn="";
                sbtn="";
               // Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();

            }

        }
    }
}
