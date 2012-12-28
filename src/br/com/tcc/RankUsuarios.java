package br.com.tcc;

import java.util.ArrayList;
import java.util.List; 
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class RankUsuarios extends Activity {
	

	private List<RankUsuario> lstUsuarios = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         
        setContentView(R.layout.ranktcc);
         
        ListView list = (ListView) findViewById(R.id.ListView15);
 
        //Iniciamos a lista de Estados
        //no m�todo add j� inserimos um novo registro de cada Estados desejado
        lstUsuarios = new ArrayList<RankUsuario>();
        lstUsuarios.add(new RankUsuario("Fabiana", "1500", R.drawable.fabiana));
        lstUsuarios.add(new RankUsuario("Fabiola", "1300", R.drawable.fabiola));
        lstUsuarios.add(new RankUsuario("Fernanda", "1290", R.drawable.fernanda));
        lstUsuarios.add(new RankUsuario("Kelly", "1100", R.drawable.kelly));
        lstUsuarios.add(new RankUsuario("Monique", "1000", R.drawable.monique));
        /*lstUsuarios.add(new RankUsuario("usuario", "pontua��o", R.drawable.sua foto));*/
 
        //Cria��o do Adapter e passamos a nossa lista de Estados para ele
        RankUsuarioAdapter adapter = new RankUsuarioAdapter(this, lstUsuarios);
 
        //referenciamos a fun��o que ser� invocada quando o usu�rio
        //clicar em algum item da lista
        list.setOnItemClickListener(onItemClick_List);
     
        list.setAdapter(adapter);
     
        //caso seja preciso adicionar mais algum item na lista voc�
        //pode utilizar tamb�m a forma abaixo
      //  adapter.addItem(new RankUsuario("Bahia", "Salvador", R.drawable.bahia));
    }
 
    OnItemClickListener onItemClick_List = new OnItemClickListener() {
        public void onItemClick(AdapterView<?>  arg0, View view, int position, long index) {
            //Pegar o item clicado
            showToast("Voc� clicou no Usuario: " + lstUsuarios.get(position).getUsuario() +" e sua pontua��o � "+ lstUsuarios.get(position).getCapital());
           // showToast("Sua pontua��o � : " + lstUsuarios.get(position).getCapital());
        }
    };
     
    //Quando tecla no bot�o voltar o sistema ir� apresentar
    //uma caixa de di�logo quetionando se realmente desej sair
    /*
    @Override
    public void onBackPressed() {     
        AlertDialog.Builder builder = new AlertDialog.Builder(this);     
        builder.setMessage("Deseja sair?")            
        .setCancelable(false)        
        .setIcon(android.R.drawable.ic_dialog_alert) // �cone de alerta
        .setTitle("Aten��o:") //t�tulo do caixa de di�logo
                 
        //Evento disparado se clicar no bot�o Sim
        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {               
            public void onClick(DialogInterface dialog, int id) {                     
            	RankUsuarios.this.finish(); //Fecha o Activity     
            }            
        })            
   
        //Event disparado se clicar no bot�o N�o
        .setNegativeButton("N�o", new DialogInterface.OnClickListener() {                
            public void onClick(DialogInterface dialog, int id) {                     
                dialog.cancel(); //Cancela a caixa de di�logo e volta a tela anterior
            }            
        });     
        AlertDialog alert = builder.create();     
        alert.show(); //Chama a caixa de di�logo
    } 
    
    */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }        
    
    

}
