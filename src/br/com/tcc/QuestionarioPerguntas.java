package br.com.tcc;

import br.com.tcc.POJO.Gabarito;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View.OnClickListener;

public class QuestionarioPerguntas extends Activity {
	CheckBox chA, chB, chC, chD;
	Button btProximo, btProximo2;

	Gabarito gab = new Gabarito();
	PontuacaoAtual pont = new PontuacaoAtual();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// PRIMEIRO QUESTIONARIO
		setContentView(R.layout.questionario);
		
		chA = (CheckBox) findViewById(R.ChechBox.cb1);
		chB = (CheckBox) findViewById(R.ChechBox.cb2);
		chC = (CheckBox) findViewById(R.ChechBox.cb3);
		chD = (CheckBox) findViewById(R.ChechBox.cb4);

		btProximo = (Button) findViewById(R.Butao.btnproximo);
		btProximo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					pegaSelecao();
					/*
					Intent myIntent = new Intent(getApplicationContext(),
							PontuacaoAtual.class);					
					startActivity(myIntent);*/
					
					// SEGUNDO QUESTIONARIO
					setContentView(R.layout.questionario1);
				} catch (Exception e) {

				}
            
			}
		});
	}

	public void proximaView(View v) {
		// TERCEIRO QUESTIONARIO
		setContentView(R.layout.questionario2);
	}

	public void onBackPressed() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Deseja sair?")
				.setCancelable(false)
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle("Atenção:")
				.setPositiveButton("Sim",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								pegaSelecao();
								//setContentView(R.layout.main);
								 QuestionarioPerguntas.this.finish(); 
							}
							
						})
				.setNegativeButton("Não",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
		AlertDialog alert = builder.create();
		alert.show();

	}

	public void pegaSelecao() {
		if (chA.isChecked()) {
			gab.setGabarito("A");
		} else if (chB.isChecked()) {
			gab.setGabarito("B");
		} else if (chC.isChecked()) {
			gab.setGabarito("C");
		} else if (chD.isChecked()) {
			gab.setGabarito("D");
		} else {
			gab.setGabarito("");
		}
		//MANDA O ITEN QUE FOI SELECIONADO PRA CLASSE "recuperaGabarito()"
				pont.recuperaGabarito(gab.getGabarito());

		AlertDialog.Builder caixadeAlerta = new AlertDialog.Builder(
				QuestionarioPerguntas.this);

		caixadeAlerta.setMessage(" Gabarito Atual : \n" + gab.getGabarito());
		caixadeAlerta.setTitle("Gabarito");
		caixadeAlerta.setNeutralButton("OK", null);
		caixadeAlerta.show();
		
	}
	/*
	 * 
	 * 
	 * //cria o banco com as perguntas e mostra em um tela "questionario"
	 * 
	 * public void onResume(){ super.onResume();
	 * 
	 * SQLiteDatabase db = openOrCreateDatabase("perguntas.db",
	 * Context.MODE_PRIVATE, null);
	 * 
	 * // Tabela de perguntas StringBuilder sqlPerguntas = new StringBuilder();
	 * sqlPerguntas.append("CREATE TABLE IF NOT EXISTS perguntas (");
	 * sqlPerguntas.append("_id INTEGER PRIMARY KEY, ");
	 * sqlPerguntas.append("pergunta VARCHAR(500), ");
	 * sqlPerguntas.append("resposta VARCHAR(1));");
	 * db.execSQL(sqlPerguntas.toString());
	 * 
	 * Cursor cursor = db.rawQuery("SELECT * FROM perguntas", null);
	 * 
	 * 
	 * String[] from = {"pergunta","resposta"}; int[] to = {
	 * R.id.editText1,R.id.radioGroup1};
	 * 
	 * android.widget.SimpleCursorAdapter ad = new
	 * android.widget.SimpleCursorAdapter(getBaseContext(),
	 * R.layout.questionario, cursor, from, to);
	 * 
	 * //ListView ltwDados = (ListView)findViewById(R.id.ltwDados);
	 * 
	 * //ltwDados.setAdapter(ad);
	 * 
	 * /* ltwDados.setOnItemClickListener(new AdapterView.OnItemClickListener()
	 * {
	 * 
	 * public void onItemClick(AdapterView adapter, View view, int position,
	 * long id) {
	 * 
	 * SQLiteCursor c = (SQLiteCursor) adapter.getAdapter().getItem(position);
	 * 
	 * Intent it = new Intent(getBaseContext(), Editar.class); it.putExtra("id",
	 * c.getInt(0)); startActivity(it); } });
	 * 
	 * ad.close(); }
	 */

}
