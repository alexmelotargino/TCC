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
        //no método add já inserimos um novo registro de cada Estados desejado
        lstUsuarios = new ArrayList<RankUsuario>();
        lstUsuarios.add(new RankUsuario("Fabiana", "1500", R.drawable.fabiana));
        lstUsuarios.add(new RankUsuario("Fabiola", "1300", R.drawable.fabiola));
        lstUsuarios.add(new RankUsuario("Fernanda", "1290", R.drawable.fernanda));
        lstUsuarios.add(new RankUsuario("Kelly", "1100", R.drawable.kelly));
        lstUsuarios.add(new RankUsuario("Monique", "1000", R.drawable.monique));
        /*lstUsuarios.add(new RankUsuario("usuario", "pontuação", R.drawable.sua foto));*/
 
        //Criação do Adapter e passamos a nossa lista de Estados para ele
        RankUsuarioAdapter adapter = new RankUsuarioAdapter(this, lstUsuarios);
 
        //referenciamos a função que será invocada quando o usuário
        //clicar em algum item da lista
        list.setOnItemClickListener(onItemClick_List);
     
        list.setAdapter(adapter);
     
        //caso seja preciso adicionar mais algum item na lista você
        //pode utilizar também a forma abaixo
      //  adapter.addItem(new RankUsuario("Bahia", "Salvador", R.drawable.bahia));
    }
 
    OnItemClickListener onItemClick_List = new OnItemClickListener() {
        public void onItemClick(AdapterView<?>  arg0, View view, int position, long index) {
            //Pegar o item clicado
            showToast("Você clicou no Usuario: " + lstUsuarios.get(position).getUsuario() +" e sua pontuação é "+ lstUsuarios.get(position).getCapital());
           // showToast("Sua pontuação é : " + lstUsuarios.get(position).getCapital());
        }
    };
     
    //Quando tecla no botão voltar o sistema irá apresentar
    //uma caixa de diálogo quetionando se realmente desej sair
    /*
    @Override
    public void onBackPressed() {     
        AlertDialog.Builder builder = new AlertDialog.Builder(this);     
        builder.setMessage("Deseja sair?")            
        .setCancelable(false)        
        .setIcon(android.R.drawable.ic_dialog_alert) // ícone de alerta
        .setTitle("Atenção:") //título do caixa de diálogo
                 
        //Evento disparado se clicar no botão Sim
        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {               
            public void onClick(DialogInterface dialog, int id) {                     
            	RankUsuarios.this.finish(); //Fecha o Activity     
            }            
        })            
   
        //Event disparado se clicar no botão Não
        .setNegativeButton("Não", new DialogInterface.OnClickListener() {                
            public void onClick(DialogInterface dialog, int id) {                     
                dialog.cancel(); //Cancela a caixa de diálogo e volta a tela anterior
            }            
        });     
        AlertDialog alert = builder.create();     
        alert.show(); //Chama a caixa de diálogo
    } 
    
    */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }        
    
    

}
