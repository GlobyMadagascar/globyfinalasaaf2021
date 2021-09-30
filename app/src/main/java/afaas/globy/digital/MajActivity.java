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
import android.widget.ProgressBar;
import android.widget.Button;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.google.gson.Gson;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class MajActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String date = "";
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> lmlieu = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lmquiz = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lmgarde = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> adslist = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lmd = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> shoplm = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> magasinlm = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear13;
	private ImageView imageview1;
	private TextView textview13;
	private TextView textview10;
	private ProgressBar progressbar1;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private TextView textview7;
	private LinearLayout linear10;
	private TextView textview1;
	private TextView textview3;
	private TextView textview5;
	private TextView textview8;
	private LinearLayout linear11;
	private TextView lieu;
	private TextView quiz;
	private TextView pharmacie;
	private LinearLayout linear14;
	private TextView textview12;
	private TextView textview11;
	private Button button1;
	
	private SharedPreferences locationdata;
	private DatabaseReference lieudb = _firebase.getReference("lieudb");
	private ChildEventListener _lieudb_child_listener;
	private Calendar datelieu = Calendar.getInstance();
	private Calendar daterec = Calendar.getInstance();
	private SharedPreferences sp;
	private SharedPreferences data;
	private Calendar dategarde = Calendar.getInstance();
	private Calendar y = Calendar.getInstance();
	private SharedPreferences pharma;
	private DatabaseReference ads = _firebase.getReference("ads");
	private ChildEventListener _ads_child_listener;
	private SharedPreferences ad;
	private TimerTask u;
	private Intent i = new Intent();
	private DatabaseReference event = _firebase.getReference("event");
	private ChildEventListener _event_child_listener;
	private SharedPreferences spevent;
	private SharedPreferences shop;
	private SharedPreferences magasin;
	private DatabaseReference agri = _firebase.getReference("agri");
	private ChildEventListener _agri_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.maj);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview10 = (TextView) findViewById(R.id.textview10);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		textview7 = (TextView) findViewById(R.id.textview7);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview8 = (TextView) findViewById(R.id.textview8);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		lieu = (TextView) findViewById(R.id.lieu);
		quiz = (TextView) findViewById(R.id.quiz);
		pharmacie = (TextView) findViewById(R.id.pharmacie);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview11 = (TextView) findViewById(R.id.textview11);
		button1 = (Button) findViewById(R.id.button1);
		locationdata = getSharedPreferences("locationdata", Activity.MODE_PRIVATE);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		pharma = getSharedPreferences("pharma", Activity.MODE_PRIVATE);
		ad = getSharedPreferences("ad", Activity.MODE_PRIVATE);
		spevent = getSharedPreferences("spevent", Activity.MODE_PRIVATE);
		shop = getSharedPreferences("shop", Activity.MODE_PRIVATE);
		magasin = getSharedPreferences("magasin", Activity.MODE_PRIVATE);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				lieudb.addChildEventListener(_lieudb_child_listener);
				ads.addChildEventListener(_ads_child_listener);
				event.addChildEventListener(_event_child_listener);
				u = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								agri.addChildEventListener(_agri_child_listener);
							}
						});
					}
				};
				_timer.schedule(u, (int)(3000));
			}
		});
		
		_lieudb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				datelieu = Calendar.getInstance();
				lieudb.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lmlieu = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lmlieu.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						locationdata.edit().putString("locationdata", new Gson().toJson(lmlieu)).commit();
						locationdata.edit().putString("date", new SimpleDateFormat("dd/MM/yyyy").format(datelieu.getTime())).commit();
						progressbar1.setVisibility(View.VISIBLE);
						button1.setVisibility(View.GONE);
						lieu.setText("✓");
						lieu.setTextColor(0xFF4CAF50);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		lieudb.addChildEventListener(_lieudb_child_listener);
		
		_ads_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				ads.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						adslist = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								adslist.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						ad.edit().putString("ads", _childValue.get("advertisement").toString()).commit();
						ad.edit().putString("adslink", _childValue.get("advertisementlink").toString()).commit();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		ads.addChildEventListener(_ads_child_listener);
		
		_event_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				dategarde = Calendar.getInstance();
				event.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lmd = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lmd.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						spevent.edit().putString("spevent", new Gson().toJson(lmd)).commit();
						data.edit().putString("dategarde", new SimpleDateFormat("dd/MM/yyyy").format(dategarde.getTime())).commit();
						pharmacie.setText("✓");
						pharmacie.setTextColor(0xFF4CAF50);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		event.addChildEventListener(_event_child_listener);
		
		_agri_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				daterec = Calendar.getInstance();
				agri.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lmquiz = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lmquiz.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						sp.edit().putString("jsone", new Gson().toJson(lmquiz)).commit();
						sp.edit().putString("datequiz", new SimpleDateFormat("dd/MM/yyyy").format(daterec.getTime())).commit();
						quiz.setText("✓");
						quiz.setTextColor(0xFF4CAF50);
						i.setClass(getApplicationContext(), UgdActivity.class);
						i.putExtra("x", "retour");
						startActivity(i);
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		agri.addChildEventListener(_agri_child_listener);
	}
	
	private void initializeLogic() {
		progressbar1.setVisibility(View.GONE);
		lieudb.removeEventListener(_lieudb_child_listener);
		agri.removeEventListener(_agri_child_listener);
		ads.removeEventListener(_ads_child_listener);
		event.removeEventListener(_event_child_listener);
		y = Calendar.getInstance();
		date = new SimpleDateFormat("dd/MM/yyyy").format(y.getTime());
		textview13.setText(new SimpleDateFormat("dd/MM/yyyy").format(y.getTime()));
		if (!data.getString("dategarde", "").equals("")) {
			if (date.equals(data.getString("dategarde", ""))) {
				textview11.setText("AUJOURD'HUI");
				textview11.setTextColor(0xFF4CAF50);
			}
			else {
				textview11.setText(data.getString("dategarde", ""));
			}
		}
		else {
			
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
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