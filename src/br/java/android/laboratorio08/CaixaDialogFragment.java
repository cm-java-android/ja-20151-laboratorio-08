package br.java.android.laboratorio08;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CaixaDialogFragment extends DialogFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View visao = inflater.inflate(R.layout.caixa_dialog, container, false);
		
		((TextView)visao.findViewById(R.id.tituloDialogTextView)).setText("Atenção");
		((TextView)visao.findViewById(R.id.dialogTextView)).setText("Mensagem para você?");
				
		return visao;
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setStyle(STYLE_NO_TITLE, getTheme());
	}
}
