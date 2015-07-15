package br.java.android.laboratorio08;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetalheFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View visao = inflater.inflate(R.layout.detalhe, container, false);
		// Agora vou colocar um tratamento para abrir a caixa de Dialog
		visao.findViewById(R.id.detalheTextView).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						exibirDialogFragment();
					}
				});

		return visao;
	}

	protected void exibirDialogFragment() {
		// Primeiro eu pego a instância de fragmentManager
		FragmentManager gerenteFragment = getFragmentManager();
		// Depois pego uma instância de FragmentTransaction
		// Essa instância é a transação de um Fragment para outro
		// Vamos pegar um Fragment e colocar por cima do outro
		FragmentTransaction transacao = gerenteFragment.beginTransaction();
		// Defino um alvo para saber qual Fragment irá sobrepor sobre o outro
		Fragment destino = gerenteFragment
				.findFragmentById(R.id.detalheFragment);
		// Agora invoco o Fragment
		DialogFragment df = new CaixaDialogFragment();
		// E mando exibir-lo, usando aquela transação que criamos
		df.show(transacao, destino.getTag());
	}

	/**
	 * Permite que o layout detalhe.xml tenha o seu texto alterado externamente
	 * 
	 * @param texto
	 *            que é o texto a ser alterado
	 */
	public void setText(CharSequence texto) {
		TextView textoTextView = (TextView) getView().findViewById(
				R.id.detalheTextView);
		textoTextView.setText(texto);
	}
}

// Depois pego uma instância de FragmentTransaction
// Essa instância é a transação de um Fragment para outro
// Vamos pegar um Fragment e colocar por cima do outro
// Defino um alvo para saber qual Fragment irá sobrepor sobre o outro
// Agora invoco o Fragment

