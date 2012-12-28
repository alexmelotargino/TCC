package br.com.tcc;

//import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
	private Button btMenuRank, bttela2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btMenuRank = (Button) findViewById(R.id.button1); 
		btMenuRank.setOnClickListener(new OnClickListener() {
			
					public void onClick(View v) {
						Intent myIntent = new Intent(getApplicationContext(),
								RankUsuarios.class);
						startActivity(myIntent);
					}
					
				});

		bttela2 = (Button) findViewById(R.id.button2);
		bttela2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {

				Intent myIntent = new Intent(getApplicationContext(),
						PontuacaoAtual.class);
				startActivity(myIntent);
			}

		});
	}
}
