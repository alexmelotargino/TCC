package br.com.tcc;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RankUsuarioAdapter extends BaseAdapter {

	 private List<RankUsuario> listUsuarios;
	 
	    //Classe utilizada para instanciar os objetos do XML
	    private LayoutInflater inflater;
	     
	    public RankUsuarioAdapter(Context context, List<RankUsuario> plistRankUsuarios) {
	        this.listUsuarios = plistRankUsuarios;
	        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    }
	 
	    public void addItem(final RankUsuario item) {
	        this.listUsuarios.add(item);
	        //Atualizar a lista caso seja adicionado algum item
	        notifyDataSetChanged();
	    }    
	     
	    @Override
	    public int getCount() {
	        return listUsuarios.size();
	    }
	 
	    @Override
	    public Object getItem(int position) {
	        return listUsuarios.get(position);
	    }
	 
	    @Override
	    public long getItemId(int position) {
	        return position;
	    }
	 
	    @Override
	    public View getView(int position, View convertView, ViewGroup viewGroup) {
	        //Pega o registro da lista e trasnfere para o objeto estadoVO
	        RankUsuario usuarioVO = listUsuarios.get(position);
	         
	        //Utiliza o XML ranktcc_row para apresentar na tela
	        convertView = inflater.inflate(R.layout.ranktcc_row, null);
	         
	        //Instância os objetos do XML
	        ImageView bandeira = (ImageView)convertView.findViewById(R.id.bandeira);
	        TextView tvEstado = (TextView)convertView.findViewById(R.id.tvUsuario);
	        TextView tvCapital = (TextView)convertView.findViewById(R.id.tvCapital);
	             
	        //pega os dados que estão no objeto estadoVO e transfere para os objetos do XML
	        bandeira.setImageResource(usuarioVO.getBandeira());
	        tvEstado.setText(usuarioVO.getUsuario());
	        tvCapital.setText(usuarioVO.getCapital());
	         
	        return convertView;
	    }
	    
}
