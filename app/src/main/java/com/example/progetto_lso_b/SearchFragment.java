package com.example.progetto_lso_b;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    Location location;
    private double latitudine, longitudine;
    private MapView map = null;
    private static final String[] permessi = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private final static int requestcode = 1;



    public SearchFragment() {
    }


    private Location getLocation() {

        Location bestLocation = null;
        Location l;

        LocationManager locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        //ottengo tutti i provider disponibili dal manager di locazione (gps, network etc..)
        List<String> providers = locationManager.getProviders(true);
        /*
         *controllo se sono stati dati i permessi:
         *se sono stati dati: procede con l'esecuzione e carica la locazione
         * se non sono stati dati non carica la mappa fino a quando non si accetteranno e richieded stesso i permessi non dati
         */
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),permessi,requestcode);
                return null;
            }
            else {
                /*
                 *Per ogni provider così ottenuto, ne ottengo l'ultima mia "posizione" nota a questi e li confronto con gli altri provider ottenuti.
                 *La locazione più precisa verrà salvata in una variabile di tipo Location per poi essere ritornata dal metodo.
                 */
                for (String provider : providers) {
                    l = locationManager.getLastKnownLocation(provider);
                    if(l!=null && (bestLocation==null || l.getAccuracy() < bestLocation.getAccuracy())){
                        bestLocation = l;
                    }
                }
            }
        return bestLocation;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        //anche qui controllo se sono stati dati i permessi; qualora non siano dati non carico la mappa ma richiedo l'autorizzazione dei permessi
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),MainActivity.getPermessi(),MainActivity.getRequestcode());
            return view;
        }else {
            /*invoco il metodo sopra-implementato che ci consente di ricavare la miglior locazione tra i vari provider;
             *qualora la locazione sia nulla verrà mostrato un Toasr con un messaggio di avvertimento che la posizione è nulla e ritornerà la view senza aver caricato la mappa.
             *Invece, qualora venga allocata la locazione, si ottengono la latitudine e la longitudine della posizione.
             */
            location = getLocation();
            if (location != null) {
                latitudine = location.getLatitude();
                longitudine = location.getLongitude();
            } else {
                Toast.makeText(getContext(), "locazione nulla", Toast.LENGTH_SHORT);
                return view;
            }
            //si inizializza la configurazione in osmdroid
            Configuration.getInstance().load(getContext(), PreferenceManager.getDefaultSharedPreferences(getContext()));
            //si "carica la mappa" dalla view, assegnandone il tipo e le varie funzionalità come ad esempio la possibilità di usare il multi-touch
            map =view.findViewById(R.id.map);
            map.setTileSource(TileSourceFactory.MAPNIK);
            map.setMultiTouchControls(true);
            //si ottiene il controller per potter settare alcune caratteristiche come lo zoom iniziale e la locazione geografica che verrà mostrata all'inizio
            IMapController mapController = map.getController();
            mapController.setZoom(18.5);
            //si istanzia un oggetto GeoPoint per poter stabilire un punto da segnare sulla mappa
            GeoPoint startPoint = new GeoPoint(latitudine, longitudine);
            //si setta la posizione iniziale da mostrare nella mappa
            mapController.setCenter(startPoint);
            //si crea un marker da mostrare alla mappa, utile per capire visivamente dove si trova il punto
            Marker myMarker = new Marker(map);
            myMarker.setPosition(startPoint);
            myMarker.setDraggable(false);
            myMarker.setAnchor(Marker.ANCHOR_TOP,Marker.ANCHOR_LEFT);
            map.getOverlays().add(myMarker);
            return view;
        }
    }


}