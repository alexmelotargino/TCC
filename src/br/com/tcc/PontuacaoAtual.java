package br.com.tcc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import br.com.tcc.QuestionarioPerguntas;
import br.com.tcc.POJO.Gabarito;

public class PontuacaoAtual extends Activity {
	double ponatual;
	private Button bttela2, btnatualizar;
	TextView pontucaoAtual;
	Gabarito gab = new Gabarito();
	String ggg;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pontuacaoatual);

		bttela2 = (Button) findViewById(R.Butao.btnquestionario);
		bttela2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				Intent myIntent = new Intent(getApplicationContext(),
						QuestionarioPerguntas.class);
				startActivity(myIntent);

			}
		});
		btnatualizar = (Button) findViewById(R.Butao.btnatualizarpontos);
		btnatualizar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				recuperaGabarito(gab.getGabarito());
				
				AlertDialog.Builder caixadeAlerta = new AlertDialog.Builder(
						PontuacaoAtual.this);
				caixadeAlerta.setMessage(" Gabarito Atual : \n" + ggg);
				caixadeAlerta.setTitle("Gabarito");
				caixadeAlerta.setNeutralButton("OK", null);
				caixadeAlerta.show();
				
				//atualizarPontuacao();
			}
		});
		pontucaoAtual = (TextView) findViewById(R.TextView.tvpontuacao);
		
	}

	public void atualizarPontuacao() {
		ponatual = 1800;
		pontucaoAtual.setText(String.valueOf(ponatual));

		// MOSTRA O GABARITO FEITO
		AlertDialog.Builder caixadeAlerta = new AlertDialog.Builder(
				PontuacaoAtual.this);
		caixadeAlerta.setMessage(" Gabarito Atual : \n" + ggg);
		caixadeAlerta.setTitle("Gabarito");
		caixadeAlerta.setNeutralButton("OK", null);
		caixadeAlerta.show();
	}

	public void recuperaGabarito(String GAB) {
		gab.setGabarito(GAB);
		ggg = gab.getGabarito();	
		
	}
	
}
