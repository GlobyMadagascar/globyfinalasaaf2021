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
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.content.Intent;
import android.content.ClipData;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.io.InputStream;
import android.net.Uri;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.view.View;
import android.widget.AdapterView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.text.DecimalFormat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class AddActivity extends  AppCompatActivity  { 
	
	public final int REQ_CD_FPIC = 101;
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double Lat = 0;
	private double Lng = 0;
	private String Pic = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String type = "";
	private double net = 0;
	private String latitude = "";
	private String longitude = "";
	private double Dll = 0;
	private String usern = "";
	private String promo = "";
	private String position = "";
	private String Base64String = "";
	
	private ArrayList<String> datalist = new ArrayList<>();
	private ArrayList<String> oti = new ArrayList<>();
	private ArrayList<String> Ls = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lm = new ArrayList<>();
	
	private ScrollView vscroll2;
	private LinearLayout linear1;
	private LinearLayout linear4;
	private TextView reg;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView textview16;
	private EditText edittext1;
	private TextView textview5;
	private Spinner spinnerreg;
	private TextView textview2;
	private EditText nom;
	private TextView textview3;
	private Spinner spinner2ype;
	private EditText edittext2;
	private TextView textview4;
	private EditText phone;
	private TextView textview8;
	private EditText site;
	private TextView textview6;
	private EditText details;
	private TextView textview9;
	private ImageView imageview2;
	private Button button2;
	private TextView textview7;
	private ImageView imageview4;
	private TextView textview17;
	private ImageView imageview3;
	private TextView textview12;
	private TextView textview10;
	private TextView textview11;
	private TextView textview15;
	private TextView lt;
	private TextView lg;
	
	private LocationManager Gps;
	private LocationListener _Gps_location_listener;
	private Intent fpic = new Intent(Intent.ACTION_GET_CONTENT);
	private FirebaseAuth fauth;
	private OnCompleteListener<Void> fauth_updateEmailListener;
	private OnCompleteListener<Void> fauth_updatePasswordListener;
	private OnCompleteListener<Void> fauth_emailVerificationSentListener;
	private OnCompleteListener<Void> fauth_deleteUserListener;
	private OnCompleteListener<Void> fauth_updateProfileListener;
	private OnCompleteListener<AuthResult> fauth_phoneAuthListener;
	private OnCompleteListener<AuthResult> fauth_googleSignInListener;
	private OnCompleteListener<AuthResult> _fauth_create_user_listener;
	private OnCompleteListener<AuthResult> _fauth_sign_in_listener;
	private OnCompleteListener<Void> _fauth_reset_password_listener;
	private DatabaseReference user = _firebase.getReference("users");
	private ChildEventListener _user_child_listener;
	private AlertDialog.Builder D;
	private SharedPreferences pref;
	private Intent v = new Intent();
	private AlertDialog.Builder oi;
	private Calendar cal = Calendar.getInstance();
	private Intent u = new Intent();
	private SharedPreferences test;
	private Intent o = new Intent();
	private SharedPreferences lieu;
	private AlertDialog.Builder vd;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.add);
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
		
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		reg = (TextView) findViewById(R.id.reg);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview16 = (TextView) findViewById(R.id.textview16);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview5 = (TextView) findViewById(R.id.textview5);
		spinnerreg = (Spinner) findViewById(R.id.spinnerreg);
		textview2 = (TextView) findViewById(R.id.textview2);
		nom = (EditText) findViewById(R.id.nom);
		textview3 = (TextView) findViewById(R.id.textview3);
		spinner2ype = (Spinner) findViewById(R.id.spinner2ype);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		textview4 = (TextView) findViewById(R.id.textview4);
		phone = (EditText) findViewById(R.id.phone);
		textview8 = (TextView) findViewById(R.id.textview8);
		site = (EditText) findViewById(R.id.site);
		textview6 = (TextView) findViewById(R.id.textview6);
		details = (EditText) findViewById(R.id.details);
		textview9 = (TextView) findViewById(R.id.textview9);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		button2 = (Button) findViewById(R.id.button2);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview17 = (TextView) findViewById(R.id.textview17);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview10 = (TextView) findViewById(R.id.textview10);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview15 = (TextView) findViewById(R.id.textview15);
		lt = (TextView) findViewById(R.id.lt);
		lg = (TextView) findViewById(R.id.lg);
		Gps = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		fpic.setType("image/*");
		fpic.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		fauth = FirebaseAuth.getInstance();
		D = new AlertDialog.Builder(this);
		pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
		oi = new AlertDialog.Builder(this);
		test = getSharedPreferences("test", Activity.MODE_PRIVATE);
		lieu = getSharedPreferences("lieu", Activity.MODE_PRIVATE);
		vd = new AlertDialog.Builder(this);
		
		spinnerreg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					reg.setText("");
				}
				if (_position == 1) {
					reg.setText("Diana");
				}
				if (_position == 2) {
					reg.setText("Sava");
				}
				if (_position == 3) {
					reg.setText("Sofia");
				}
				if (_position == 4) {
					reg.setText("Analanjirofo");
				}
				if (_position == 5) {
					reg.setText("Boeny");
				}
				if (_position == 6) {
					reg.setText("Betsiboka");
				}
				if (_position == 7) {
					reg.setText("Melaky");
				}
				if (_position == 8) {
					reg.setText("Alaotra Mangoro");
				}
				if (_position == 9) {
					reg.setText("Bongolava");
				}
				if (_position == 10) {
					reg.setText("Analamanga");
				}
				if (_position == 11) {
					reg.setText("Atsinanana");
				}
				if (_position == 12) {
					reg.setText("Itasy");
				}
				if (_position == 13) {
					reg.setText("Menabe");
				}
				if (_position == 14) {
					reg.setText("Vakinankaratra");
				}
				if (_position == 15) {
					reg.setText("Amiron'i Mania");
				}
				if (_position == 16) {
					reg.setText("Vatovavy - fitovinany");
				}
				if (_position == 17) {
					reg.setText("Matsiatra ambony");
				}
				if (_position == 18) {
					reg.setText("Atsimo - andrefana");
				}
				if (_position == 19) {
					reg.setText("Ihorombe");
				}
				if (_position == 20) {
					reg.setText("Atsimo - atsinanana");
				}
				if (_position == 21) {
					reg.setText("Anosy");
				}
				if (_position == 22) {
					reg.setText("Androy");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		spinner2ype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					type = "";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 1) {
					type = "Toilettes";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 2) {
					type = "Église";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 3) {
					type = "Commissariat";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 4) {
					type = "Eau potable";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 5) {
					type = "Centre de santé";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 6) {
					type = "Hébergement";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 7) {
					type = "Bac à ordure";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 8) {
					type = "Office du tourisme";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 9) {
					type = "Marché";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 10) {
					type = "Lieu sportif";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 11) {
					type = "Pharmacie";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 12) {
					type = "Banque";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 13) {
					type = "Discothèque-Bar-Karaoké";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 14) {
					type = "Bâtiment public";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 15) {
					type = "Lieu touristique";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 16) {
					type = "Banque";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 17) {
					type = "Lieu commercial";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 18) {
					type = "Parc d'attraction";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 19) {
					type = "Zone industrielle";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 20) {
					type = "Hotel";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 21) {
					type = "Restaurant";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 22) {
					type = "Professionnel";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 23) {
					type = "Gare/ Port/ Aeroport/ Stationnement";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 24) {
					type = "Lieu interdit";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 25) {
					type = "Commercant";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 26) {
					type = "Etablissement";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 27) {
					type = "Siege social";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 28) {
					type = "Voie publique";
					edittext2.setVisibility(View.GONE);
					edittext2.setText("");
				}
				if (_position == 29) {
					type = "Autre";
					edittext2.setVisibility(View.VISIBLE);
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fpic, REQ_CD_FPIC);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				cal = Calendar.getInstance();
				if (!(lt.getText().toString().equals("0") || (lg.getText().toString().equals("0") || (type.equals("") || (reg.getText().toString().equals("") || (details.getText().toString().equals("") || nom.getText().toString().equals(""))))))) {
					map = new HashMap<>();
					map.put("nom", nom.getText().toString());
					map.put("phone", phone.getText().toString());
					map.put("description", details.getText().toString());
					map.put("site", site.getText().toString());
					map.put("reg", reg.getText().toString());
					if (edittext2.getText().toString().equals("")) {
						map.put("type", type);
					}
					else {
						map.put("type", edittext2.getText().toString());
					}
					map.put("lat", lt.getText().toString());
					map.put("lng", lg.getText().toString());
					map.put("username", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map.put("pic", Base64String);
					map.put("promo", "");
					map.put("id", FirebaseAuth.getInstance().getCurrentUser().getUid().concat(new SimpleDateFormat("ddMMyyHHmmss").format(cal.getTime())));
					map.put("plus1", "");
					map.put("plus2", "");
					map.put("plus3", "");
					map.put("plus4", "");
					map.put("plus5", "");
					map.put("ville", edittext1.getText().toString());
					lm.add(map);
					lieu.edit().putString("lieu", new Gson().toJson(lm)).commit();
					o.setClass(getApplicationContext(), UgdActivity.class);
					o.putExtra("x", "retour");
					startActivity(o);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Veuillez remplir les champs obligatoires !");
				}
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				o.setClass(getApplicationContext(), TownActivity.class);
				startActivity(o);
			}
		});
		
		textview17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				o.setClass(getApplicationContext(), TownActivity.class);
				startActivity(o);
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				oi.setTitle("Aide");
				oi.setMessage("● Dans la description: donnez le plus d'infos possible pour que les autres utilisateurs puissent retrouver le lieu que vous enregistrez.\n\n● Une photo n'est pas obligatoire mais est fortement conseillé.");
				oi.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				oi.create().show();
			}
		});
		
		textview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.setClass(getApplicationContext(), MapActivity.class);
				startActivity(u);
			}
		});
		
		textview11.setOnClickListener(new View.OnClickListener() {
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
		
		_Gps_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				textview11.setVisibility(View.VISIBLE);
				Lat = _lat;
				Lng = _lng;
				Gps.removeUpdates(_Gps_location_listener);
			}
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			@Override
			public void onProviderEnabled(String provider) {}
			@Override
			public void onProviderDisabled(String provider) {}
		};
		
		_user_child_listener = new ChildEventListener() {
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
		user.addChildEventListener(_user_child_listener);
		
		fauth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fauth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fauth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		if (!lieu.getString("lieu", "").equals("")) {
			lm = new Gson().fromJson(lieu.getString("lieu", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		edittext2.setVisibility(View.GONE);
		textview11.setVisibility(View.GONE);
		type = "";
		Dll = 1;
		Lat = 0;
		Lng = 0;
		if (ContextCompat.checkSelfPermission(AddActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			Gps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1, _Gps_location_listener);
		}
		_Bory(nom, "#ffffff", "#e0e0e0", 15);
		_Bory(phone, "#ffffff", "#e0e0e0", 15);
		_Bory(spinnerreg, "#ffffff", "#e0e0e0", 15);
		_Bory(details, "#ffffff", "#e0e0e0", 15);
		_Bory(spinner2ype, "#ffffff", "#e0e0e0", 15);
		_Bory(site, "#ffffff", "#e0e0e0", 15);
		_Bory(textview10, "#263238", "#e0e0e0", 15);
		_Bory(textview11, "#263238", "#e0e0e0", 15);
		_Bory(edittext1, "#ffffff", "#e0e0e0", 15);
		datalist.add("Choisir votre région");
		datalist.add("Diana");
		datalist.add("Sava");
		datalist.add("Sofia");
		datalist.add("Analanjirofo");
		datalist.add("Boeny");
		datalist.add("Betsiboka");
		datalist.add("Melaky");
		datalist.add("Alaotra Mangoro");
		datalist.add("Bongolava");
		datalist.add("Analamanga");
		datalist.add("Atsinanana");
		datalist.add("Itasy");
		datalist.add("Menabe");
		datalist.add("Vakinankaratra");
		datalist.add("Amiron'i Mania");
		datalist.add("Vatovavy - fitovinany");
		datalist.add("Matsiatra ambony");
		datalist.add("Atsimo - andrefana");
		datalist.add("Ihorombe");
		datalist.add("Atsimo - atsinanana");
		datalist.add("Anosy");
		datalist.add("Androy");
		spinnerreg.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, datalist));
		((ArrayAdapter)spinnerreg.getAdapter()).notifyDataSetChanged();
		oti.add("Choisir le type de lieu");
		oti.add("Toilettes");
		oti.add("Église");
		oti.add("Commissariat");
		oti.add("Eau potable");
		oti.add("Centre de santé");
		oti.add("Hébergement");
		oti.add("Bac à ordure");
		oti.add("Office du tourisme");
		oti.add("Marché");
		oti.add("Lieu sportif");
		oti.add("Pharmacie");
		oti.add("Banque");
		oti.add("Discothèque-Bar-Karaoké");
		oti.add("Bâtiment public");
		oti.add("Lieu touristique");
		oti.add("Banque");
		oti.add("Lieu commercial");
		oti.add("Parc d'attraction");
		oti.add("Zone industrielle");
		oti.add("Hotel");
		oti.add("Restaurant");
		oti.add("Professionnel");
		oti.add("Gare/ Port/ Aeroport/ Stationnement");
		oti.add("Lieu interdit");
		oti.add("Commercant");
		oti.add("Établissement");
		oti.add("Siège social");
		oti.add("Voie publique");
		oti.add("Autre");
		spinner2ype.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, oti));
		((ArrayAdapter)spinner2ype.getAdapter()).notifyDataSetChanged();
		net = 1;
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FPIC:
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
				FileUtil.resizeBitmapFileRetainRatio(_filePath.get((int)(0)), _filePath.get((int)(0)), 320);
				imageview2.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(_filePath.get((int)(0)), 1024, 1024));
				_imageToBase64(imageview2);
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
	public void onResume() {
		super.onResume();
		if (ContextCompat.checkSelfPermission(AddActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			Gps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, _Gps_location_listener);
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		Gps.removeUpdates(_Gps_location_listener);
	}
	public void _Bory (final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
		_view.setBackground(gd);
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