package ocean.dicegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
    ImageView   imgView2;
    Button  btn;
    Button  btn2;
    TextView    txtView;
    final int[]images={R.mipmap.dice1,R.mipmap.dice2,R.mipmap.dice3,R.mipmap.dice4,R.mipmap.dice5,R.mipmap.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView=(ImageView)findViewById(R.id.imgView);
        imgView2=(ImageView)findViewById(R.id.imgView2);
        btn=(Button)findViewById(R.id.btn);
        btn2=(Button)findViewById(R.id.btn2);
        txtView=(TextView)findViewById(R.id.txtView);

        btn2.setEnabled(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn2.setEnabled(true);
                Random RandomNumber = new Random();
                int num1 = RandomNumber.nextInt(6);
                int num2 = RandomNumber.nextInt(6);
                imgView.setImageResource(images[num1]);
                imgView2.setImageResource(images[num2]);
                btn.setEnabled(false);
                if (num1 == num2) {
                    txtView.setText("Congrats! Player1 won!!!!");
                    Intent player1 = new Intent(MainActivity.this, afterwin.class);
                    player1.putExtra("Number","1");
                    startActivity(player1);
                } else {
                    txtView.setText("");
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setEnabled(true);
                Random  RandomNumber    = new Random();
                int num1= RandomNumber.nextInt(6);
                int num2= RandomNumber.nextInt(6);
                imgView.setImageResource(images [num1]);
                imgView2.setImageResource(images [num2]);
                btn2.setEnabled(false);
                if (num1==num2) {
                    txtView.setText("Congrats! Player2 won!!!!");
                    Intent player2 = new Intent(MainActivity.this, afterwin.class);
                    player2.putExtra("Number","2");
                    startActivity(player2);
                }
                else {
                    txtView.setText("");
                }

            }
        });
        }
    }


