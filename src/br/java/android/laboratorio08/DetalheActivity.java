package br.java.android.laboratorio08;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Essa Activity ser� criada a partir de um Fragment
 *
 */
public class DetalheActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Quando o celular estiver na orienta��o de paisagem, esse c�digo n�o
		// ser� utilizado, pois quando o telefone rotaciona, o Android recria a
		// Activity
		// Quando o Android recriar, o codigo abaixo indica que deve-se ser
		// usado um Fragment e n�o uma Activity
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			finish();
			return;
		}

		setContentView(R.layout.activity_detalhe);

		// Aqui � possivel fazer com que o texto seja atualizado
		// Estamos pegando uma String de uma Activity externa a essa aqui
		Bundle extras = getIntent().getExtras(); 
		if (extras != null) {
			String s = extras.getString("stringEnviada");
			TextView view = (TextView) findViewById(R.id.detalheTextView);
			view.setText(s);
		}

	}
}
