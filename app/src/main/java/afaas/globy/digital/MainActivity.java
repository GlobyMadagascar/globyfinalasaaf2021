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
import android.widget.ScrollView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
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
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.app.Activity;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.AdapterView;
import java.text.DecimalFormat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class MainActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String username = "";
	private boolean emailVerified = false;
	private String phone = "";
	private String Sex = "";
	private String pin = "";
	private String strAdd = "";
	private String strState = "";
	private String strCity = "";
	private String strPC = "";
	private String strKN = "";
	private String strCountry = "";
	private double lat = 0;
	private double lng = 0;
	private double latmob = 0;
	private double lngmob = 0;
	private String Verif = "";
	private HashMap<String, Object> Veriff = new HashMap<>();
	private double n = 0;
	private double length = 0;
	private double lengths = 0;
	private double ns = 0;
	private String value = "";
	
	private ArrayList<String> Sx = new ArrayList<>();
	private ArrayList<String> datalist = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lieulm = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lmquz = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lmph = new ArrayList<>();
	private ArrayList<String> ls = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lpays = new ArrayList<>();
	private ArrayList<String> lsville = new ArrayList<>();
	private ArrayList<String> countries = new ArrayList<>();
	
	private LinearLayout linear29;
	private LinearLayout linear24;
	private LinearLayout linear19;
	private LinearLayout linear30;
	private ImageView imageview12;
	private LinearLayout linear25;
	private TextView textview14;
	private LinearLayout linear31;
	private LinearLayout linear33;
	private LinearLayout linear34;
	private LinearLayout linear35;
	private ImageView imageview23;
	private TextView textview18;
	private ImageView imageview24;
	private TextView textview19;
	private ImageView imageview25;
	private TextView textview20;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private ImageView imageview14;
	private TextView textview16;
	private ImageView imageview13;
	private TextView textview15;
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private LinearLayout linear28;
	private ImageView imageview1;
	private ImageView imageview18;
	private LinearLayout linear1;
	private TextView textview3;
	private LinearLayout linearcode;
	private TextView reg;
	private TextView mydevice;
	private EditText annee;
	private EditText mois;
	private EditText date;
	private LinearLayout lineardata;
	private TextView textview7;
	private TextView textview8;
	private Button button1;
	private LinearLayout linear3;
	private TextView textview10;
	private LinearLayout linear13;
	private TextView textview11;
	private LinearLayout linear14;
	private TextView textview13;
	private LinearLayout linear20;
	private Button button3;
	private LinearLayout linear36;
	private LinearLayout linear18;
	private TextView textview9;
	private LinearLayout linear12;
	private LinearLayout linear11;
	private ImageView imageview8;
	private EditText edit_email;
	private LinearLayout linear4;
	private EditText nom;
	private LinearLayout linear5;
	private EditText prenom;
	private LinearLayout linear21;
	private EditText edittext1;
	private TextView textview12;
	private LinearLayout linear15;
	private LinearLayout linear7;
	private EditText ville;
	private Spinner spinner3;
	private LinearLayout linear23;
	private LinearLayout linear22;
	private Button login;
	private Button button2;
	private CheckBox checkbox1;
	private TextView textview4;
	
	private Intent i = new Intent();
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
	private DatabaseReference connex = _firebase.getReference("connex");
	private ChildEventListener _connex_child_listener;
	private DatabaseReference phonehistoric = _firebase.getReference("phonehistoric");
	private ChildEventListener _phonehistoric_child_listener;
	private DatabaseReference pointsdbs = _firebase.getReference("pointsdbs");
	private ChildEventListener _pointsdbs_child_listener;
	private DatabaseReference pointsdb = _firebase.getReference("pointsdb");
	private ChildEventListener _pointsdb_child_listener;
	private Calendar cal = Calendar.getInstance();
	private SharedPreferences data;
	private LocationManager Mob;
	private LocationListener _Mob_location_listener;
	private LocationManager Gps;
	private LocationListener _Gps_location_listener;
	private AlertDialog.Builder H;
	private SharedPreferences sos;
	private TimerTask O;
	private TimerTask t;
	private DatabaseReference Verificationdb = _firebase.getReference("Verificationdb");
	private ChildEventListener _Verificationdb_child_listener;
	private SharedPreferences sp;
	private SharedPreferences region;
	private SharedPreferences locationdata;
	private Calendar ca = Calendar.getInstance();
	private SharedPreferences pharma;
	private Intent u = new Intent();
	private SharedPreferences phones;
	private SharedPreferences langue;
	private DatabaseReference pays = _firebase.getReference("pays");
	private ChildEventListener _pays_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
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
		
		linear29 = (LinearLayout) findViewById(R.id.linear29);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear30 = (LinearLayout) findViewById(R.id.linear30);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		textview14 = (TextView) findViewById(R.id.textview14);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		linear34 = (LinearLayout) findViewById(R.id.linear34);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		imageview23 = (ImageView) findViewById(R.id.imageview23);
		textview18 = (TextView) findViewById(R.id.textview18);
		imageview24 = (ImageView) findViewById(R.id.imageview24);
		textview19 = (TextView) findViewById(R.id.textview19);
		imageview25 = (ImageView) findViewById(R.id.imageview25);
		textview20 = (TextView) findViewById(R.id.textview20);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		imageview14 = (ImageView) findViewById(R.id.imageview14);
		textview16 = (TextView) findViewById(R.id.textview16);
		imageview13 = (ImageView) findViewById(R.id.imageview13);
		textview15 = (TextView) findViewById(R.id.textview15);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear28 = (LinearLayout) findViewById(R.id.linear28);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		imageview18 = (ImageView) findViewById(R.id.imageview18);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview3 = (TextView) findViewById(R.id.textview3);
		linearcode = (LinearLayout) findViewById(R.id.linearcode);
		reg = (TextView) findViewById(R.id.reg);
		mydevice = (TextView) findViewById(R.id.mydevice);
		annee = (EditText) findViewById(R.id.annee);
		mois = (EditText) findViewById(R.id.mois);
		date = (EditText) findViewById(R.id.date);
		lineardata = (LinearLayout) findViewById(R.id.lineardata);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);
		button1 = (Button) findViewById(R.id.button1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		textview11 = (TextView) findViewById(R.id.textview11);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		textview13 = (TextView) findViewById(R.id.textview13);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		button3 = (Button) findViewById(R.id.button3);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		edit_email = (EditText) findViewById(R.id.edit_email);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		nom = (EditText) findViewById(R.id.nom);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		prenom = (EditText) findViewById(R.id.prenom);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview12 = (TextView) findViewById(R.id.textview12);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		ville = (EditText) findViewById(R.id.ville);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		login = (Button) findViewById(R.id.login);
		button2 = (Button) findViewById(R.id.button2);
		checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
		textview4 = (TextView) findViewById(R.id.textview4);
		fauth = FirebaseAuth.getInstance();
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		Mob = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Gps = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		H = new AlertDialog.Builder(this);
		sos = getSharedPreferences("sos", Activity.MODE_PRIVATE);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		region = getSharedPreferences("region", Activity.MODE_PRIVATE);
		locationdata = getSharedPreferences("locationdata", Activity.MODE_PRIVATE);
		pharma = getSharedPreferences("pharma", Activity.MODE_PRIVATE);
		phones = getSharedPreferences("phones", Activity.MODE_PRIVATE);
		langue = getSharedPreferences("langue", Activity.MODE_PRIVATE);
		
		linear33.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear30.setVisibility(View.GONE);
				imageview12.setVisibility(View.VISIBLE);
				langue.edit().putString("langue", "fr").commit();
				SketchwareUtil.showMessage(getApplicationContext(), "Bienvenue");
			}
		});
		
		linear34.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear30.setVisibility(View.GONE);
				imageview12.setVisibility(View.VISIBLE);
				langue.edit().putString("langue", "mg").commit();
				SketchwareUtil.showMessage(getApplicationContext(), "Tongasoa");
			}
		});
		
		linear35.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear30.setVisibility(View.GONE);
				imageview12.setVisibility(View.VISIBLE);
				langue.edit().putString("langue", "en").commit();
				SketchwareUtil.showMessage(getApplicationContext(), "Welcome");
			}
		});
		
		linear26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear24.setVisibility(View.GONE);
				button2.setVisibility(View.GONE);
				linear19.setVisibility(View.VISIBLE);
				button3.setVisibility(View.VISIBLE);
			}
		});
		
		linear27.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear24.setVisibility(View.GONE);
				textview10.setVisibility(View.GONE);
				linear13.setVisibility(View.GONE);
				textview12.setVisibility(View.GONE);
				linear15.setVisibility(View.GONE);
				login.setVisibility(View.GONE);
				linear19.setVisibility(View.VISIBLE);
				linear20.setVisibility(View.GONE);
				button3.setVisibility(View.GONE);
				textview13.setVisibility(View.GONE);
			}
		});
		
		imageview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear19.setVisibility(View.GONE);
				linear24.setVisibility(View.VISIBLE);
				textview10.setVisibility(View.VISIBLE);
				linear13.setVisibility(View.VISIBLE);
				textview12.setVisibility(View.VISIBLE);
				linear15.setVisibility(View.VISIBLE);
				textview13.setVisibility(View.VISIBLE);
				linear20.setVisibility(View.VISIBLE);
				login.setVisibility(View.VISIBLE);
				button2.setVisibility(View.VISIBLE);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), UgdActivity.class);
				i.putExtra("x", "retour");
				i.putExtra("username", username);
				i.putExtra("profile_pic", "");
				startActivity(i);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear36.setVisibility(View.VISIBLE);
				lsville.clear();
				if (!sp.getString("pays", "").equals("")) {
					lmph = new Gson().fromJson(sp.getString("pays", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					length = lmph.size();
					n = length - 1;
					for(int _repeat52 = 0; _repeat52 < (int)(length); _repeat52++) {
						if (edittext1.getText().toString().equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Veuillez insérer votre Pays");
						}
						else {
							if (lmph.get((int)n).get("pays").toString().equals(edittext1.getText().toString())) {
								lsville.add(lmph.get((int)n).get("ville").toString());
							}
							else {
								
							}
							n--;
						}
					}
					spinner3.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, lsville));
					((ArrayAdapter)spinner3.getAdapter()).notifyDataSetChanged();
				}
				else {
					
				}
			}
		});
		
		spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				ville.setText(lsville.get((int)(_position)));
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!(edit_email.getText().toString().equals("") || (edittext1.getText().toString().equals("") || (prenom.getText().toString().equals("") || (ville.getText().toString().equals("") || nom.getText().toString().equals("")))))) {
					H.setTitle("Vérification de vos infos");
					H.setMessage("Votre Nom complet : ".concat(nom.getText().toString().concat("\nVotre téléphone : ".concat(edit_email.getText().toString().concat("\n\nNB : Vous devez être actuellement en possession de ce numéro pour une vérification.")))));
					H.setPositiveButton("Continuer", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							username = edit_email.getText().toString();
							textview3.setText(username);
							fauth.createUserWithEmailAndPassword(edit_email.getText().toString().concat("_@globy.digital"), prenom.getText().toString()).addOnCompleteListener(MainActivity.this, _fauth_create_user_listener);
							SketchwareUtil.showMessage(getApplicationContext(), "Vérification en cours...");
						}
					});
					H.setNegativeButton("Rectifier mes infos", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					H.create().show();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Tous les champs sont obligatoires.");
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!(edit_email.getText().toString().equals("") || prenom.getText().toString().equals(""))) {
					fauth.signInWithEmailAndPassword(edit_email.getText().toString().concat("_@afaas_globy.digital"), prenom.getText().toString()).addOnCompleteListener(MainActivity.this, _fauth_sign_in_listener);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Tous les champs sont obligatoires.");
				}
			}
		});
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					linear23.setVisibility(View.VISIBLE);
				}
				else {
					linear23.setVisibility(View.GONE);
				}
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				u.setClass(getApplicationContext(), CndActivity.class);
				startActivity(u);
			}
		});
		
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
		
		_connex_child_listener = new ChildEventListener() {
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
		connex.addChildEventListener(_connex_child_listener);
		
		_phonehistoric_child_listener = new ChildEventListener() {
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
		phonehistoric.addChildEventListener(_phonehistoric_child_listener);
		
		_pointsdbs_child_listener = new ChildEventListener() {
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
		pointsdbs.addChildEventListener(_pointsdbs_child_listener);
		
		_pointsdb_child_listener = new ChildEventListener() {
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
		pointsdb.addChildEventListener(_pointsdb_child_listener);
		
		_Mob_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				_getLocation(_lat, _lng);
				latmob = _lat;
				lngmob = _lng;
				
				
				Mob.removeUpdates(_Mob_location_listener);
			}
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			@Override
			public void onProviderEnabled(String provider) {}
			@Override
			public void onProviderDisabled(String provider) {}
		};
		
		_Gps_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				lat = _lat;
				lng = _lng;
				Gps.removeUpdates(_Gps_location_listener);
				Mob.removeUpdates(_Mob_location_listener);
			}
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			@Override
			public void onProviderEnabled(String provider) {}
			@Override
			public void onProviderDisabled(String provider) {}
		};
		
		_Verificationdb_child_listener = new ChildEventListener() {
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
		Verificationdb.addChildEventListener(_Verificationdb_child_listener);
		
		_pays_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				pays.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lpays = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lpays.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						sp.edit().putString("pays", new Gson().toJson(lpays)).commit();
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
		pays.addChildEventListener(_pays_child_listener);
		
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
				if (_success) {
					region.edit().putString("region", "").commit();
					sp.edit().putString("scores", "0").commit();
					sp.edit().putString("jsone", "").commit();
					data.edit().putString("pass", "").commit();
					data.edit().putString("pay", "off").commit();
					data.edit().putString("rec", "off").commit();
					sos.edit().putString("sos", "off").commit();
					cal = Calendar.getInstance();
					map = new HashMap<>();
					map.put("username", username);
					map.put("G-compte", "0");
					map.put("assrect", "");
					map.put("assvers", "");
					map.put("chauffeur", "");
					map.put("cinrect", "");
					map.put("cinvers", "");
					map.put("couleurvoiture", "");
					map.put("ctcturg", "");
					map.put("dateden", "");
					map.put("imagecar", "");
					map.put("imei", "");
					map.put("nip", pin);
					map.put("nom", nom.getText().toString());
					map.put("numerovoiture", "");
					map.put("pay", "");
					map.put("perdu", "");
					map.put("permrect", "");
					map.put("permvers", "");
					map.put("phone", edit_email.getText().toString());
					map.put("prenom", prenom.getText().toString());
					map.put("visio", "");
					map.put("vocal", "");
					map.put("sexe", Sex);
					map.put("typevoiture", "");
					map.put("adresse", ville.getText().toString());
					map.put("region", reg.getText().toString());
					map.put("ville", strCity);
					map.put("id", FirebaseAuth.getInstance().getCurrentUser().getUid());
					user.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
					map = new HashMap<>();
					map.put("username", username);
					map.put("points", "0");
					map.put("prenom", prenom.getText().toString());
					map.put("id", FirebaseAuth.getInstance().getCurrentUser().getUid());
					pointsdbs.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
					map = new HashMap<>();
					map.put("username", username);
					map.put("points", "0");
					map.put("prenom", prenom.getText().toString());
					map.put("id", FirebaseAuth.getInstance().getCurrentUser().getUid());
					pointsdb.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
					Veriff = new HashMap<>();
					Veriff.put("phone", edit_email.getText().toString());
					Veriff.put("nom", nom.getText().toString());
					Verificationdb.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(Veriff);
					Veriff.clear();
					map = new HashMap<>();
					map.put("phone", edit_email.getText().toString());
					map.put("phonestate", mydevice.getText().toString());
					map.put("ville", strCity);
					map.put("time", new SimpleDateFormat("HH:mm").format(cal.getTime()));
					map.put("lat", String.valueOf(lat));
					map.put("lng", String.valueOf(lng));
					map.put("latmob", String.valueOf(latmob));
					map.put("lngmob", String.valueOf(lngmob));
					phonehistoric.child(new SimpleDateFormat("ddMMMMyyyy").format(cal.getTime()).concat(FirebaseAuth.getInstance().getCurrentUser().getUid())).updateChildren(map);
					phones.edit().putString("phones", edit_email.getText().toString()).commit();
					region.edit().putString("region", reg.getText().toString()).commit();
					sp.edit().putString("Cal", "").commit();
					data.edit().putString("reg", reg.getText().toString()).commit();
					data.edit().putString("ville", strCity).commit();
					data.edit().putString("phone", edit_email.getText().toString()).commit();
					data.edit().putString("username", edit_email.getText().toString()).commit();
					data.edit().putString("pass", pin).commit();
					data.edit().putString("pay", "off").commit();
					data.edit().putString("rec", "off").commit();
					sos.edit().putString("sos", "off").commit();
					linearcode.setVisibility(View.VISIBLE);
					lineardata.setVisibility(View.GONE);
					textview8.setText(pin);
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									data.edit().putString("pin", pin).commit();
									data.edit().putString("username", username).commit();
									i.setClass(getApplicationContext(), UgdActivity.class);
									i.putExtra("x", "retour");
									i.putExtra("pin", pin);
									i.putExtra("username", username);
									i.putExtra("profile_pic", "");
									startActivity(i);
								}
							});
						}
					};
					_timer.schedule(t, (int)(10000));
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_fauth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				cal = Calendar.getInstance();
				if (_success) {
					map = new HashMap<>();
					map.put("phone", edit_email.getText().toString());
					map.put("phonestate", mydevice.getText().toString());
					map.put("ville", strCity);
					map.put("time", new SimpleDateFormat("HH:mm").format(cal.getTime()));
					map.put("lat", String.valueOf(lat));
					map.put("lng", String.valueOf(lng));
					map.put("latmob", String.valueOf(latmob));
					map.put("lngmob", String.valueOf(lngmob));
					map.put("id", FirebaseAuth.getInstance().getCurrentUser().getUid());
					phonehistoric.child(new SimpleDateFormat("ddMMMMyyyy").format(cal.getTime()).concat(FirebaseAuth.getInstance().getCurrentUser().getUid())).updateChildren(map);
					phones.edit().putString("phones", edit_email.getText().toString()).commit();
					sp.edit().putString("scores", "0").commit();
					sp.edit().putString("jsone", "").commit();
					data.edit().putString("phone", edit_email.getText().toString()).commit();
					data.edit().putString("reg", reg.getText().toString()).commit();
					data.edit().putString("username", edit_email.getText().toString()).commit();
					data.edit().putString("pin", pin).commit();
					data.edit().putString("username", username).commit();
					i.setClass(getApplicationContext(), UgdActivity.class);
					i.putExtra("x", "retour");
					i.putExtra("username", username);
					i.putExtra("profile_pic", "");
					startActivity(i);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
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
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			i.setClass(getApplicationContext(), UgdActivity.class);
			i.putExtra("x", "retour");
			startActivity(i);
		}
		_ViewFadeIn(linear31, 1500);
		
		linear36.setVisibility(View.GONE);
		imageview12.setVisibility(View.GONE);
		lineardata.setVisibility(View.VISIBLE);
		linearcode.setVisibility(View.GONE);
		linear23.setVisibility(View.GONE);
		textview15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			Mob.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _Mob_location_listener);
		}
		if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			Gps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, _Gps_location_listener);
		}
		edit_email.setFilters(new InputFilter[] {new InputFilter.LengthFilter(10)});
		
		_showDeviceInfo_to_(mydevice);
		lat = 0;
		lng = 0;
		latmob = 0;
		lngmob = 0;
		
		pin = String.valueOf((long)(SketchwareUtil.getRandom((int)(1111), (int)(9999))));
		_Bory(edit_email, "#ffffff", "#ffc107", 15);
		_Bory(nom, "#ffffff", "#ffc107", 15);
		_Bory(prenom, "#ffffff", "#ffc107", 15);
		_Bory(spinner3, "#ffffff", "#ffc107", 15);
		_Bory(edittext1, "#ffffff", "#ffc107", 15);
		_Bory(imageview23, "#ffffff", "#009fe3", 360);
		_Bory(imageview24, "#ffffff", "#009fe3", 360);
		_Bory(imageview25, "#ffffff", "#009fe3", 360);
		_Bory(imageview13, "#ffffff", "#009fe3", 360);
		_Bory(imageview14, "#ffffff", "#009fe3", 360);
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
	public void onStop() {
		super.onStop();
		Mob.removeUpdates(_Mob_location_listener);
		Gps.removeUpdates(_Gps_location_listener);
	}
	public void _Bory (final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
		_view.setBackground(gd);
	}
	
	
	public void _showDeviceInfo_to_ (final TextView _tv) {
		DisplayMetrics dm = new DisplayMetrics(); getWindowManager().getDefaultDisplay().getMetrics(dm); int width = dm.widthPixels; int height = dm.heightPixels;
		
		_tv.setText( "SERIAL: " + Build.SERIAL + "\n\n" + "MODEL: " + Build.MODEL + "\n\n" + "ID: " + Build.ID + "\n\n" + "Manufacture: " + Build.MANUFACTURER + "\n\n" + "Brand: " + Build.BRAND + "\n\n" +
		"Device Language: " + Locale.getDefault().getDisplayLanguage() + "\n\n" +
		"Screen Resolution: " + width + "x" + height + "\n\n" +
		"Type: " + Build.TYPE + "\n\n" + "User: " + Build.USER + "\n\n" + "BASE: " + Build.VERSION_CODES.BASE + "\n\n" + "INCREMENTAL: " + Build.VERSION.INCREMENTAL + "\n\n" + "SDK: " + Build.VERSION.SDK + "\n\n" + "BOARD: " + Build.BOARD + "\n\n" + "BRAND: " + Build.BRAND + "\n\n" + "HOST: " + Build.HOST + "\n\n" + "FINGERPRINT: "+Build.FINGERPRINT + "\n\n" + "Version Code: " + Build.VERSION.RELEASE );
	}
	
	
	public void _getLocation (final double _LATITUDE, final double _LONGITUDE) {
		android.location.Geocoder geocoder = new android.location.Geocoder(getApplicationContext(), Locale.getDefault());
		
		try {
			List<android.location.Address> addresses = geocoder.getFromLocation(_LATITUDE, _LONGITUDE, 1);
			if (addresses != null) {
				android.location.Address returnedAddress = addresses.get(0);
				StringBuilder strReturnedAddress = new StringBuilder("");
				StringBuilder strReturnedCity = new StringBuilder("");
				StringBuilder strReturnedState = new StringBuilder("");
				StringBuilder strReturnedCountry = new StringBuilder("");
				StringBuilder strReturnedPC = new StringBuilder("");
				StringBuilder strReturnedKN = new StringBuilder("");
				for (int i = 0; i <= returnedAddress.getMaxAddressLineIndex(); i++) {
					strReturnedAddress.append(returnedAddress.getAddressLine(i));
					strReturnedCity.append(returnedAddress.getLocality()); 
					strReturnedState.append(returnedAddress.getAdminArea());
					strReturnedCountry.append(returnedAddress.getCountryName());
					strReturnedPC.append(returnedAddress.getPostalCode());
					strReturnedKN.append(returnedAddress.getFeatureName());
				}
				strAdd = strReturnedAddress.toString();
				strCity = strReturnedCity.toString();
				strState = strReturnedState.toString();
				strCountry = strReturnedCountry.toString();
				strPC = strReturnedPC.toString();
				strKN = strReturnedKN.toString();
			}
			else
			{
				strAdd = "No Address Found";
				strCity = "No City Found";
				strState = "No State returned";
				strCountry = "No Country Found";
				strPC = "No Postal Code Found";
				strKN = "No Know Name Found";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			strAdd = "Can't get Address";
			strCity = "Can't get City";
			strState = "Can't get State";
			strCountry = "Can't get Country";
			strPC = "Can't get Postal Code";
			strKN = "Can't get Name";
		}
	}
	
	
	public void _ViewFadeIn (final View _viewFadeIn, final double _viewFadeInSetTime) {
		long x = (long)_viewFadeInSetTime;
		
		Animation fadeIn = new AlphaAnimation(0, 1); 
		fadeIn.setDuration(x);
		AnimationSet animation = new AnimationSet(true); animation.addAnimation(fadeIn);
		_viewFadeIn.startAnimation(animation);
	}
	
	
	public void _CardStyle (final View _view, final double _shadow, final double _radius, final String _color, final boolean _touch) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_radius);
		_view.setBackground(gd);
		
		if (Build.VERSION.SDK_INT >= 21){
			_view.setElevation((int)_shadow);}
	}
	
	
	public void _datePicker (final TextView _day, final TextView _mon, final TextView _year) {
		in_tv_dateDay = _day;
		in_tv_dateMon = _mon;
		in_tv_dateYear = _year;
		showDatePickerDialog();
	}
	
	private TextView in_tv_dateDay;
	private TextView in_tv_dateMon;
	private TextView in_tv_dateYear;
	
	public void showDatePickerDialog() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int mon = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		DatePickerDialog mDP;
		mDP = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker datePicker, int year, int month, int day) {
				int mon = month + 1;
				in_tv_dateDay.setText(String.format("%02d",day));
				in_tv_dateMon.setText(String.format("%02d",mon));
				in_tv_dateYear.setText(String.format("%04d",year));
			}
		}, year, mon, day);
		
		mDP.setTitle("Дата");
		mDP.show();
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