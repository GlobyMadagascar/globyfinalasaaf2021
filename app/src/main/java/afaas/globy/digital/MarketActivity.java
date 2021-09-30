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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class MarketActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	
	private String yu = "";
	private double length = 0;
	private double n = 0;
	private double srcLat = 0;
	private double srcLng = 0;
	private double i = 0;
	private double def_lat = 0;
	private double def_lon = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private double desLat = 0;
	private double desLng = 0;
	private double perKm = 0;
	private double earthRadius = 0;
	private double dLat = 0;
	private double dLng = 0;
	private double a = 0;
	private double c = 0;
	private double b = 0;
	private double dist = 0;
	private double meterConv = 0;
	private double resultDist = 0;
	private String date = "";
	
	private ArrayList<HashMap<String, Object>> lm = new ArrayList<>();
	private ArrayList<String> lss = new ArrayList<>();
	private ArrayList<String> oti = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> shoplist = new ArrayList<>();
	
	private LinearLayout linear1;
	private ImageView imageview1;
	private TextView textview2;
	private LinearLayout linear2;
	private MapView mapview1;
	private GoogleMapController _mapview1_controller;
	
	private TimerTask p;
	private Intent s = new Intent();
	private SharedPreferences spevent;
	private LocationManager mob;
	private LocationListener _mob_location_listener;
	private AlertDialog.Builder d;
	private Intent pm = new Intent();
	private Calendar cal = Calendar.getInstance();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.market);
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
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		mapview1 = (MapView) findViewById(R.id.mapview1);
		mapview1.onCreate(_savedInstanceState);
		
		spevent = getSharedPreferences("spevent", Activity.MODE_PRIVATE);
		mob = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		d = new AlertDialog.Builder(this);
		
		_mapview1_controller = new GoogleMapController(mapview1, new OnMapReadyCallback() {
			@Override
			public void onMapReady(GoogleMap _googleMap) {
				_mapview1_controller.setGoogleMap(_googleMap);
				_mapview1_controller.moveCamera(-18.759d, 46.7256d);
				_mapview1_controller.zoomTo(5);
				if (ContextCompat.checkSelfPermission(MarketActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
					mob.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _mob_location_listener);
				}
				i = 0;
				def_lat = 0;
				def_lon = 0;
				if (!spevent.getString("spevent", "").equals("")) {
					shoplist = new Gson().fromJson(spevent.getString("spevent", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				}
				if (shoplist.size() > 0) {
					for(int _repeat128 = 0; _repeat128 < (int)(shoplist.size()); _repeat128++) {
						map = shoplist.get((int)i);
						_mapview1_controller.setMapType(GoogleMap.MAP_TYPE_NORMAL);
						_mapview1_controller.addMarker(map.get("titre").toString(), Double.parseDouble(map.get("lat").toString()), Double.parseDouble(map.get("lng").toString()));
						if (map.get("type").toString().equals("flood")) {
							_mapview1_controller.setMarkerIcon(map.get("titre").toString(), R.drawable.flood_128);
						}
						if (map.get("type").toString().equals("pluie")) {
							_mapview1_controller.setMarkerIcon(map.get("titre").toString(), R.drawable.pluie_128);
						}
						if (map.get("type").toString().equals("canicule")) {
							_mapview1_controller.setMarkerIcon(map.get("titre").toString(), R.drawable.canicule_128);
						}
						_mapview1_controller.setMarkerInfo(map.get("titre").toString(), map.get("titre").toString(), map.get("type").toString());
						_mapview1_controller.setMarkerVisible(map.get("titre").toString().concat(String.valueOf((long)(i))), true);
						if (map.get("date").toString().equals(date)) {
							_mapview1_controller.setMarkerVisible(map.get("titre").toString(), true);
						}
						else {
							_mapview1_controller.setMarkerVisible(map.get("titre").toString(), false);
						}
						map.clear();
						i++;
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Pas d'alerte");
				}
				textview2.setText("ALERTES EXISTANTS: ".concat(String.valueOf((long)(shoplist.size()))));
			}
		});
		
		_mapview1_controller.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
			@Override
			public boolean onMarkerClick(Marker _param1) {
				final String _id = _param1.getTag().toString();
				i = 0;
				def_lat = 0;
				def_lon = 0;
				if (!spevent.getString("spevent", "").equals("")) {
					shoplist = new Gson().fromJson(spevent.getString("spevent", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				}
				if (shoplist.size() > 0) {
					for(int _repeat122 = 0; _repeat122 < (int)(shoplist.size()); _repeat122++) {
						map = shoplist.get((int)i);
						if (map.get("titre").toString().equals(_id)) {
							pm.setClass(getApplicationContext(), TelActivity.class);
							pm.putExtra("map", new Gson().toJson(map));
							startActivity(pm);
						}
						map.clear();
						i++;
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Pas d'évènement");
				}
				return false;
			}
		});
		
		_mob_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				_mapview1_controller.moveCamera(_lat, _lng);
				_mapview1_controller.zoomTo(14);
				mob.removeUpdates(_mob_location_listener);
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
		linear2.setVisibility(View.GONE);
		p = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						imageview1.setVisibility(View.GONE);
						textview2.setVisibility(View.GONE);
						linear2.setVisibility(View.VISIBLE);
					}
				});
			}
		};
		_timer.schedule(p, (int)(2000));
		cal = Calendar.getInstance();
		date = new SimpleDateFormat("d/M/yyyy").format(cal.getTime());
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
	public void onResume() {
		super.onResume();
		if (ContextCompat.checkSelfPermission(MarketActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			mob.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _mob_location_listener);
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		mob.removeUpdates(_mob_location_listener);
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
	public void _Bory (final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(4, Color.parseColor(_sc));
		
		_view.setBackground(gd);
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