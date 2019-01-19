package com.paulojuniore.beeradviser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class FindBeerActivity extends AppCompatActivity {

	BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view) {
    	Spinner beer_spinner = (Spinner) findViewById(R.id.spinner);
    	TextView brands = (TextView) findViewById(R.id.brands);
    	String beer_type = String.valueOf(beer_spinner.getSelectedItem());

    	// Obtém recomendações de cervejas da Classe BeerExpert
    	List<String> brandsList = expert.getBrands(beer_type);
    	StringBuilder brandsFormatted = new StringBuilder();
    	for (String brand : brandsList) {
    		brandsFormatted.append(brand).append('\n');
    	}

    	// Exibe as cervejas
    	brands.setText(brandsFormatted);
    }

}
