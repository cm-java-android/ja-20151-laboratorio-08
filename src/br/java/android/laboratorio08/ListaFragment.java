package br.java.android.laboratorio08;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListaFragment extends ListFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		String[] valores = new String[] { "Java Android", "Java JPA",
				"Java JSF", "Java EE" };

		// Aqui ira receber um vetor de Strings e adaptar para a exibição na
		// tela do usuário
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
				getActivity(), android.R.layout.simple_list_item_1, valores);
		// Aqui ja indico qual será a classe que irá "desenhar a lista"
		setListAdapter(adaptador);
	}

	/**
	 * Esse método será chamado sempre que um dos ítens da lista for clicado
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		// Vamos pegar uma String na posição que foi clicado
		String item = (String) getListAdapter().getItem(position);

		DetalheFragment fragment = (DetalheFragment) getFragmentManager().findFragmentById(R.id.detalheFragment);

		// Como existe a possibilidade de retornar nulo, caso não seja encontrado o Fragment
		// Assim como pode ter outro fragment por cima
		if (fragment != null && fragment.isInLayout()) {
			// Se estiver no layout, basta fazer um setText
			fragment.setText(item);
		} else {
			// caso contrario, está no modo de orientação Retrato
			// Sendo necessário lançar uma nova Activity
			Intent intent = new Intent(getActivity(), DetalheActivity.class);
			intent.putExtra("stringEnviada", item);
			startActivity(intent);
			// Isso será explicado na aula de Intents
		}
	}

}
