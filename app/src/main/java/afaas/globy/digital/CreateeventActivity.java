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
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.app.Activity;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.ClipData;
import android.view.View;
import android.widget.AdapterView;
import java.text.DecimalFormat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class CreateeventActivity extends  AppCompatActivity  { 
	
	public final int REQ_CD_PIC = 101;
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double Lat = 0;
	private double Lng = 0;
	private String latitude = "";
	private String longitude = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String Base64String = "";
	private String type = "";
	
	private ArrayList<String> ls = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear4;
	private ImageView imageview4;
	private TextView textview17;
	private LinearLayout linear5;
	private TextView textview26;
	private LinearLayout linear8;
	private TextView texto;
	private TextView text;
	private TextView textview29;
	private Spinner spinner1;
	private TextView textview18;
	private EditText edittext2;
	private TextView textview19;
	private EditText edittext3;
	private TextView textview20;
	private EditText edittext4;
	private TextView textview25;
	private EditText edittext6;
	private EditText edittext8;
	private EditText edittext7;
	private TextView textview22;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private TextView textview21;
	private EditText edittext5;
	private TextView textview30;
	private ImageView imageview5;
	private Button button1;
	private TextView jour;
	private TextView mois;
	private TextView annee;
	private TextView textview23;
	private TextView textview24;
	private TextView lt;
	private TextView lg;
	
	private SharedPreferences pref;
	private LocationManager gps;
	private LocationListener _gps_location_listener;
	private Intent i = new Intent();
	private DatabaseReference event = _firebase.getReference("event");
	private ChildEventListener _event_child_listener;
	private AlertDialog.Builder d;
	private Intent pic = new Intent(Intent.ACTION_GET_CONTENT);
	private DatabaseReference event_verification = _firebase.getReference("event_verification");
	private ChildEventListener _event_verification_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.createevent);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
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
		
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview17 = (TextView) findViewById(R.id.textview17);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview26 = (TextView) findViewById(R.id.textview26);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		texto = (TextView) findViewById(R.id.texto);
		text = (TextView) findViewById(R.id.text);
		textview29 = (TextView) findViewById(R.id.textview29);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		textview18 = (TextView) findViewById(R.id.textview18);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		textview19 = (TextView) findViewById(R.id.textview19);
		edittext3 = (EditText) findViewById(R.id.edittext3);
		textview20 = (TextView) findViewById(R.id.textview20);
		edittext4 = (EditText) findViewById(R.id.edittext4);
		textview25 = (TextView) findViewById(R.id.textview25);
		edittext6 = (EditText) findViewById(R.id.edittext6);
		edittext8 = (EditText) findViewById(R.id.edittext8);
		edittext7 = (EditText) findViewById(R.id.edittext7);
		textview22 = (TextView) findViewById(R.id.textview22);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		textview21 = (TextView) findViewById(R.id.textview21);
		edittext5 = (EditText) findViewById(R.id.edittext5);
		textview30 = (TextView) findViewById(R.id.textview30);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		button1 = (Button) findViewById(R.id.button1);
		jour = (TextView) findViewById(R.id.jour);
		mois = (TextView) findViewById(R.id.mois);
		annee = (TextView) findViewById(R.id.annee);
		textview23 = (TextView) findViewById(R.id.textview23);
		textview24 = (TextView) findViewById(R.id.textview24);
		lt = (TextView) findViewById(R.id.lt);
		lg = (TextView) findViewById(R.id.lg);
		pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
		gps = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		d = new AlertDialog.Builder(this);
		pic.setType("image/*");
		pic.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_DatePicker_Dark("Date de l'événement", jour, mois, annee);
			}
		});
		
		text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				DialogFragment newFragment = new TimePickerFragment();
				newFragment.show(getSupportFragmentManager(), "timePicker");
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					type = "";
				}
				if (_position == 1) {
					type = "Réunion d’étude";
				}
				if (_position == 2) {
					type = "Conférence et congrès";
				}
				if (_position == 3) {
					type = "Lancement de produit";
				}
				if (_position == 4) {
					type = "Festivals";
				}
				if (_position == 5) {
					type = "Salons ou expositions";
				}
				if (_position == 6) {
					type = "Événements sportifs";
				}
				if (_position == 7) {
					type = "Détente et Pique-nique";
				}
				if (_position == 8) {
					type = "Ventes & Soldes";
				}
				if (_position == 9) {
					type = "Activités touristiques";
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(pic, REQ_CD_PIC);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d.setTitle("PUBLICATION D'ÉVÉNEMENT");
				d.setMessage("Titre: ".concat(edittext2.getText().toString().concat("\nDate : ".concat(jour.getText().toString().concat("/".concat(mois.getText().toString().concat("/".concat(annee.getText().toString())))).concat(" à ".concat(text.getText().toString()))))));
				d.setPositiveButton("Publier", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (edittext2.getText().toString().equals("") || (edittext5.getText().toString().equals("") || (lt.getText().toString().equals("0.0") || (edittext6.getText().toString().equals("") || (jour.getText().toString().equals("jour") || (type.equals("") || text.getText().toString().equals(""))))))) {
							SketchwareUtil.showMessage(getApplicationContext(), "Veuillez remplir les champs obligatoires");
						}
						else {
							map = new HashMap<>();
							map.put("titre", edittext2.getText().toString());
							map.put("place", edittext3.getText().toString());
							map.put("prix", edittext4.getText().toString());
							map.put("description", edittext5.getText().toString());
							map.put("lat", lt.getText().toString());
							map.put("lng", lg.getText().toString());
							map.put("phone", edittext6.getText().toString());
							map.put("date", jour.getText().toString().trim().concat("/".concat(mois.getText().toString().trim().concat("/".concat(annee.getText().toString().trim())))));
							map.put("heure", text.getText().toString());
							map.put("mail", edittext7.getText().toString());
							map.put("site", edittext8.getText().toString());
							map.put("pic", Base64String);
							map.put("type", type);
							event_verification.push().updateChildren(map);
							map.clear();
							finish();
						}
					}
				});
				d.setNegativeButton("Modifier", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}
		});
		
		textview23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MapActivity.class);
				startActivity(i);
			}
		});
		
		textview24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Lat == 0) {
					SketchwareUtil.showMessage(getApplicationContext(), "Pas de connexion GPS");
				}
				else {
					lt.setText(String.valueOf(Lat));
					lg.setText(String.valueOf(Lng));
				}
			}
		});
		
		_gps_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				Lat = _lat;
				Lng = _lng;
				gps.removeUpdates(_gps_location_listener);
			}
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			@Override
			public void onProviderEnabled(String provider) {}
			@Override
			public void onProviderDisabled(String provider) {}
		};
		
		_event_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		
		_event_verification_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		event_verification.addChildEventListener(_event_verification_child_listener);
	}
	
	private void initializeLogic() {
		if (ContextCompat.checkSelfPermission(CreateeventActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			gps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, _gps_location_listener);
		}
		_Bory(edittext2, "#ffffff", "#263238", 15);
		_Bory(edittext3, "#ffffff", "#263238", 15);
		_Bory(edittext4, "#ffffff", "#263238", 15);
		_Bory(edittext5, "#ffffff", "#263238", 15);
		_Bory(edittext6, "#ffffff", "#263238", 15);
		_Bory(edittext7, "#ffffff", "#263238", 15);
		_Bory(edittext8, "#ffffff", "#263238", 15);
		_Bory(spinner1, "#ffffff", "#263238", 15);
		_Bory(imageview5, "#ffffff", "#263238", 15);
		_Bory(text, "#ffffff", "#263238", 15);
		_Bory(jour, "#ffffff", "#263238", 15);
		_Bory(mois, "#ffffff", "#263238", 15);
		_Bory(annee, "#ffffff", "#263238", 15);
		_CardStyle(textview23, 10, 15, "#263238", true);
		_CardStyle(textview24, 10, 15, "#263238", true);
		Lng = 0;
		Lat = 0;
		ls.add("Choisissez le type d'événement");
		ls.add("Réunion d’étude");
		ls.add("Conférence et congrès");
		ls.add("Lancement de produit");
		ls.add("Festivals");
		ls.add("Salons ou expositions");
		ls.add("Événements sportifs");
		ls.add("Détente et Pique-nique");
		ls.add("Ventes & Soldes");
		ls.add("Activités touristiques");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, ls));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
	}
	public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			return new TimePickerDialog(getActivity(), this, hour, minute, android.text.format.DateFormat.is24HourFormat(getActivity()));
		}
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			TextView time = getActivity().findViewById(R.id.text);
			time.setText(hourOfDay + ":" + minute);
		}
	}
	{
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_PIC:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), _filePath.get((int)(0)), 256);
				imageview5.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(_filePath.get((int)(0)), 1024, 1024));
				_imageToBase64(imageview5);
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (pref.getString("location", "").equals("true")) {
			latitude = pref.getString("lat", "");
			longitude = pref.getString("lng", "");
			pref.edit().putString("location", "").commit();
			lt.setText(latitude);
			lg.setText(longitude);
		}
		else {
			latitude = "";
			longitude = "";
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		gps.removeUpdates(_gps_location_listener);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (ContextCompat.checkSelfPermission(CreateeventActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			gps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, _gps_location_listener);
		}
	}
	public void _Bory (final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
		_view.setBackground(gd);
	}
	
	
	public void _CardStyle (final View _view, final double _shadow, final double _radius, final String _color, final boolean _touch) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_radius);
		_view.setBackground(gd);
		
		if (Build.VERSION.SDK_INT >= 21){
			_view.setElevation((int)_shadow);}
	}
	
	
	public void _DatePicker_Dark (final String _title, final TextView _day, final TextView _month, final TextView _year) {
		dark_day = _day;
		dark_month = _month;
		dark_year = _year;
		dark_title = _title;
		showDatePickerDialogDark();
		
	}
	private TextView dark_day;
	private TextView dark_month;
	private TextView dark_year;
	private String dark_title;
	
	public void showDatePickerDialogDark() {
		    Calendar c = Calendar.getInstance();
		    int year = c.get(Calendar.YEAR);
		    int mon = c.get(Calendar.MONTH);
		    int day = c.get(Calendar.DAY_OF_MONTH);
		
		    DatePickerDialog dialogdark;
		    dialogdark = new DatePickerDialog(this,android.R.style.Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {
			        @Override
			        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
				            int mon = month + 1;
				            dark_day.setText(String.format("%5d",day));
				            dark_month.setText(String.format("%5d",mon));
				            dark_year.setText(String.format("%5d",year));
				        }
			    }, year, mon, day);
		
		    dialogdark.setTitle(dark_title);
		    dialogdark.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		    dialogdark.show();
	}
	{
	}
	
	
	public void _imageToBase64 (final ImageView _view) {
		if(_view.getDrawable() instanceof android.graphics.drawable.BitmapDrawable ){
			android.graphics.drawable.BitmapDrawable bd = (android.graphics.drawable.BitmapDrawable) _view.getDrawable();
			Bitmap bm = bd.getBitmap(); 
			java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
			BitmapFactory.Options opts = new BitmapFactory.Options();
			opts.inPreferredConfig = Bitmap.Config.ARGB_8888;         bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
			byte[] imageBytes = baos.toByteArray();
			String imageString = android.util.Base64.encodeToString(imageBytes, android.util.Base64.DEFAULT);
			Base64String = imageString;
			 }
	}
	
	
	public void _imgtoB64 (final String _Base64String, final ImageView _view) {
		byte[] decoded= android.util.Base64.decode(_Base64String, android.util.Base64.DEFAULT);
		android.graphics.Bitmap bmp = android.graphics.BitmapFactory.decodeByteArray(decoded, 0, decoded.length);
		android.graphics.drawable.BitmapDrawable bd = new android.graphics.drawable.BitmapDrawable(bmp); 
		_view.setImageDrawable(bd);
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