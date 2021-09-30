package afaas.globy.digital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.text.DecimalFormat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class MapActivity extends  AppCompatActivity  { 
	
	
	private double lat1 = 0;
	private double lng1 = 0;
	private double lat = 0;
	private double lng = 0;
	private double mlat = 0;
	private double mlng = 0;
	private double O = 0;
	
	private MapView mapview1;
	private GoogleMapController _mapview1_controller;
	
	private LocationManager mob;
	private LocationListener _mob_location_listener;
	private SharedPreferences pref;
	private AlertDialog.Builder g;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.map);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		mapview1 = (MapView) findViewById(R.id.mapview1);
		mapview1.onCreate(_savedInstanceState);
		
		mob = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
		g = new AlertDialog.Builder(this);
		
		_mapview1_controller = new GoogleMapController(mapview1, new OnMapReadyCallback() {
			@Override
			public void onMapReady(GoogleMap _googleMap) {
				_mapview1_controller.setGoogleMap(_googleMap);
				gmap = _googleMap;
			}
		});
		
		_mapview1_controller.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
			@Override
			public boolean onMarkerClick(Marker _param1) {
				final String _id = _param1.getTag().toString();
				
				return false;
			}
		});
		
		_mob_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				if (O == 0) {
					_mapview1_controller.moveCamera(_lat, _lng);
					_mapview1_controller.zoomTo(14);
					O++;
				}
				else {
					
				}
			}
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			@Override
			public void onProviderEnabled(String provider) {}
			@Override
			public void onProviderDisabled(String provider) {}
		};
	}
	
	private void initializeLogic() {
		pref.edit().putString("msg", "").commit();
		O = 0;
		if (ContextCompat.checkSelfPermission(MapActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			mob.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _mob_location_listener);
		}
		mlat = -18.57072464d;
		mlng = 47.253498d;
		g.setTitle("RECHERCHE D'ADRESSE SUR LA CARTE");
		g.setIcon(R.drawable.ic_public_black);
		g.setMessage("Veuillez APPUYER SUR LE BOUTON RETOUR quand vous avez retrouver l'adresse.");
		g.setPositiveButton("VUE SATELLITE", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				_mapview1_controller.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			}
		});
		g.setNegativeButton("VUE CARTE", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				_mapview1_controller.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			}
		});
		g.create().show();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		mob.removeUpdates(_mob_location_listener);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (ContextCompat.checkSelfPermission(MapActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			mob.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _mob_location_listener);
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mapview1.onDestroy();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		mapview1.onStart();
	}
	
	@Override
	public void onStop() {
		super.onStop();
		mapview1.onStop();
	}
	public void _extra () {
	}
	
	com.google.android.gms.maps.GoogleMap gmap;
	com.google.android.gms.maps.Projection proj;
	 @Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		int actionType = ev.getAction();
		
		switch (actionType) {
			case MotionEvent.ACTION_UP:
			
			proj = gmap.getProjection();
			com.google.android.gms.maps.model.LatLng loc = proj.fromScreenLocation(new Point ((int)ev.getX(), (int)ev.getY()));
			
			lat1 = loc.latitude;
			lng1 = loc.longitude;
			_mapview1_controller.setMarkerVisible("t", false);
			_mapview1_controller.addMarker("t", lat1, lng1);
			_mapview1_controller.setMarkerIcon("t", R.drawable.desy);
			pref.edit().putString("lat", String.valueOf(lat1)).commit();
			pref.edit().putString("lng", String.valueOf(lng1)).commit();
			pref.edit().putString("location", "true").commit();
		}
		return super.dispatchTouchEvent(ev);
	}
	{
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}