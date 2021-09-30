package afaas.globy.digital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import java.util.Timer;
import java.util.TimerTask;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.view.View;
import android.widget.AdapterView;
import android.text.Editable;
import android.text.TextWatcher;
import android.graphics.Typeface;
import java.text.DecimalFormat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class UgdActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private FloatingActionButton _fab;
	private double net = 0;
	private String nst = "";
	private double ki = 0;
	private double ty = 0;
	private double n = 0;
	private double lat = 0;
	private double lng = 0;
	private double latmob = 0;
	private double lngmob = 0;
	private String encrypted = "";
	private double x1 = 0;
	private double x2 = 0;
	private double y1 = 0;
	private double y2 = 0;
	private String num = "";
	private String tel = "";
	private String strAdd = "";
	private String strCity = "";
	private String strCountry = "";
	private String strPC = "";
	private String strKN = "";
	private String strState = "";
	private double length = 0;
	private double r = 0;
	private String value = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String date = "";
	private String Base64String = "";
	private String notif_path = "";
	private String user_path = "";
	private double ui = 0;
	private String val = "";
	private HashMap<String, Object> map1 = new HashMap<>();
	private String weatherString = "";
	private double i = 0;
	private String laststring = "";
	private String mainString = "";
	private String dates = "";
	private String saison = "";
	
	private ArrayList<HashMap<String, Object>> lm = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lmm = new ArrayList<>();
	private ArrayList<String> countries = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Lmmm = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> carte = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> adsmp = new ArrayList<>();
	private ArrayList<String> uids = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lsev = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lsm = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> research = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lmrec = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lmsem = new ArrayList<>();
	
	private LinearLayout linear30;
	private LinearLayout linear31;
	private LinearLayout fong;
	private TextView textview15;
	private LinearLayout linear34;
	private ImageView imageview19;
	private LinearLayout linear33;
	private LinearLayout linear35;
	private ImageView imageview23;
	private LinearLayout linear14topbar;
	private LinearLayout v1;
	private LinearLayout view2;
	private ImageView imageview26;
	private TextView textview8;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private TextView textview19;
	private TextView textview2;
	private LinearLayout v11;
	private LinearLayout linear20;
	private ImageView imageview25;
	private LinearLayout linear53;
	private ImageView imageview11;
	private TextView daty;
	private TextView volana;
	private TextView taona;
	private LinearLayout linear15;
	private LinearLayout linear4;
	private LinearLayout linear10;
	private LinearLayout background;
	private LinearLayout view1;
	private LinearLayout v2;
	private TextView msg;
	private TextView text_encrypted;
	private TextView txt_title;
	private TextView txt_msg;
	private LinearLayout linear82;
	private LinearLayout linear83;
	private LinearLayout linear84;
	private LinearLayout linear58;
	private TextView jour;
	private TextView moisannee;
	private EditText edittexttaona;
	private EditText edittextvolana;
	private EditText edittextdaty;
	private ImageView imageview31;
	private LinearLayout linear85;
	private LinearLayout linear90;
	private LinearLayout linear92;
	private LinearLayout linear91;
	private LinearLayout linear86;
	private TextView textview44;
	private ImageView imageview29;
	private LinearLayout linear94;
	private LinearLayout linear88;
	private ListView listviewsemence;
	private LinearLayout linear93;
	private LinearLayout linear87;
	private TextView textview46;
	private ImageView imageview30;
	private LinearLayout linear95;
	private LinearLayout linear89;
	private ListView listviewrecolte;
	private LinearLayout linear13;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private LinearLayout linear75;
	private LinearLayout linear23;
	private LinearLayout linear24;
	private LinearLayout linear25;
	private LinearLayout linear39;
	private ImageView imageview12;
	private TextView textview9;
	private LinearLayout linear37;
	private ImageView imageview13;
	private TextView textview10;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private LinearLayout linear41;
	private ImageView imageview14;
	private TextView textview11;
	private LinearLayout linear43;
	private ImageView imageview15;
	private TextView textview12;
	private LinearLayout linear76;
	private LinearLayout linear77;
	private LinearLayout linear79;
	private ImageView imageview27;
	private TextView textview42;
	private LinearLayout linear81;
	private ImageView imageview28;
	private TextView textview43;
	private LinearLayout linear28;
	private LinearLayout linear29;
	private LinearLayout linear45;
	private ImageView imageview16;
	private TextView textview13;
	private LinearLayout linear47;
	private ImageView imageview17;
	private TextView textview14;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout li;
	private LinearLayout linear6;
	private LinearLayout linear55;
	private ImageView imageview2;
	private LinearLayout linear9;
	private LinearLayout ri;
	private LinearLayout linear8;
	private LinearLayout linear54;
	private ImageView imageview4;
	
	private TimerTask t;
	private LocationManager gps;
	private LocationListener _gps_location_listener;
	private LocationManager mob;
	private LocationListener _mob_location_listener;
	private AlertDialog.Builder dacc;
	private AlertDialog.Builder dcrim;
	private AlertDialog.Builder dcamb;
	private AlertDialog.Builder dag;
	private AlertDialog.Builder din;
	private AlertDialog.Builder dm;
	private Intent z = new Intent();
	private Calendar u = Calendar.getInstance();
	private TimerTask time;
	private ObjectAnimator oa = new ObjectAnimator();
	private ObjectAnimator oaa = new ObjectAnimator();
	private AlertDialog.Builder d;
	private Intent call = new Intent();
	private Intent dv = new Intent();
	private Intent lieu = new Intent();
	private Intent prf = new Intent();
	private Intent srch = new Intent();
	private DatabaseReference connex = _firebase.getReference("connex");
	private ChildEventListener _connex_child_listener;
	private SharedPreferences data;
	private SharedPreferences sp;
	private SharedPreferences locationdata;
	private ObjectAnimator oa_d = new ObjectAnimator();
	private AlertDialog.Builder f;
	private SharedPreferences region;
	private Intent crim = new Intent();
	private Intent cmb = new Intent();
	private Intent agr = new Intent();
	private Intent inc = new Intent();
	private Intent mef = new Intent();
	private Intent acc = new Intent();
	private TimerTask g;
	private TimerTask g1;
	private ObjectAnimator ovi = new ObjectAnimator();
	private ObjectAnimator de = new ObjectAnimator();
	private ObjectAnimator iu = new ObjectAnimator();
	private ObjectAnimator ool = new ObjectAnimator();
	private Intent cam = new Intent();
	private Calendar c = Calendar.getInstance();
	private AlertDialog.Builder send;
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
	private Calendar dt = Calendar.getInstance();
	private Calendar poi = Calendar.getInstance();
	private Intent des = new Intent();
	private DatabaseReference chat = _firebase.getReference("chat_path");
	private ChildEventListener _chat_child_listener;
	private SharedPreferences ad;
	private DatabaseReference ads = _firebase.getReference("ads");
	private ChildEventListener _ads_child_listener;
	private Intent aads = new Intent();
	private DatabaseReference notif = _firebase.getReference("notifications");
	private ChildEventListener _notif_child_listener;
	private AlertDialog.Builder noti;
	private Intent no = new Intent();
	private Intent bk = new Intent();
	private Intent sms = new Intent();
	private SharedPreferences phones;
	private Intent sn = new Intent();
	private Intent sh = new Intent();
	private SharedPreferences spevent;
	private Intent uii = new Intent();
	private Intent trc = new Intent();
	private Intent desg = new Intent();
	private Intent okl = new Intent();
	private AlertDialog.Builder dialog;
	private AlertDialog.Builder o;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ugd);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
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
		
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear30 = (LinearLayout) findViewById(R.id.linear30);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		fong = (LinearLayout) findViewById(R.id.fong);
		textview15 = (TextView) findViewById(R.id.textview15);
		linear34 = (LinearLayout) findViewById(R.id.linear34);
		imageview19 = (ImageView) findViewById(R.id.imageview19);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		imageview23 = (ImageView) findViewById(R.id.imageview23);
		linear14topbar = (LinearLayout) findViewById(R.id.linear14topbar);
		v1 = (LinearLayout) findViewById(R.id.v1);
		view2 = (LinearLayout) findViewById(R.id.view2);
		imageview26 = (ImageView) findViewById(R.id.imageview26);
		textview8 = (TextView) findViewById(R.id.textview8);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview19 = (TextView) findViewById(R.id.textview19);
		textview2 = (TextView) findViewById(R.id.textview2);
		v11 = (LinearLayout) findViewById(R.id.v11);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		imageview25 = (ImageView) findViewById(R.id.imageview25);
		linear53 = (LinearLayout) findViewById(R.id.linear53);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		daty = (TextView) findViewById(R.id.daty);
		volana = (TextView) findViewById(R.id.volana);
		taona = (TextView) findViewById(R.id.taona);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		background = (LinearLayout) findViewById(R.id.background);
		view1 = (LinearLayout) findViewById(R.id.view1);
		v2 = (LinearLayout) findViewById(R.id.v2);
		msg = (TextView) findViewById(R.id.msg);
		text_encrypted = (TextView) findViewById(R.id.text_encrypted);
		txt_title = (TextView) findViewById(R.id.txt_title);
		txt_msg = (TextView) findViewById(R.id.txt_msg);
		linear82 = (LinearLayout) findViewById(R.id.linear82);
		linear83 = (LinearLayout) findViewById(R.id.linear83);
		linear84 = (LinearLayout) findViewById(R.id.linear84);
		linear58 = (LinearLayout) findViewById(R.id.linear58);
		jour = (TextView) findViewById(R.id.jour);
		moisannee = (TextView) findViewById(R.id.moisannee);
		edittexttaona = (EditText) findViewById(R.id.edittexttaona);
		edittextvolana = (EditText) findViewById(R.id.edittextvolana);
		edittextdaty = (EditText) findViewById(R.id.edittextdaty);
		imageview31 = (ImageView) findViewById(R.id.imageview31);
		linear85 = (LinearLayout) findViewById(R.id.linear85);
		linear90 = (LinearLayout) findViewById(R.id.linear90);
		linear92 = (LinearLayout) findViewById(R.id.linear92);
		linear91 = (LinearLayout) findViewById(R.id.linear91);
		linear86 = (LinearLayout) findViewById(R.id.linear86);
		textview44 = (TextView) findViewById(R.id.textview44);
		imageview29 = (ImageView) findViewById(R.id.imageview29);
		linear94 = (LinearLayout) findViewById(R.id.linear94);
		linear88 = (LinearLayout) findViewById(R.id.linear88);
		listviewsemence = (ListView) findViewById(R.id.listviewsemence);
		linear93 = (LinearLayout) findViewById(R.id.linear93);
		linear87 = (LinearLayout) findViewById(R.id.linear87);
		textview46 = (TextView) findViewById(R.id.textview46);
		imageview30 = (ImageView) findViewById(R.id.imageview30);
		linear95 = (LinearLayout) findViewById(R.id.linear95);
		linear89 = (LinearLayout) findViewById(R.id.linear89);
		listviewrecolte = (ListView) findViewById(R.id.listviewrecolte);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		linear75 = (LinearLayout) findViewById(R.id.linear75);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		linear39 = (LinearLayout) findViewById(R.id.linear39);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear37 = (LinearLayout) findViewById(R.id.linear37);
		imageview13 = (ImageView) findViewById(R.id.imageview13);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		linear41 = (LinearLayout) findViewById(R.id.linear41);
		imageview14 = (ImageView) findViewById(R.id.imageview14);
		textview11 = (TextView) findViewById(R.id.textview11);
		linear43 = (LinearLayout) findViewById(R.id.linear43);
		imageview15 = (ImageView) findViewById(R.id.imageview15);
		textview12 = (TextView) findViewById(R.id.textview12);
		linear76 = (LinearLayout) findViewById(R.id.linear76);
		linear77 = (LinearLayout) findViewById(R.id.linear77);
		linear79 = (LinearLayout) findViewById(R.id.linear79);
		imageview27 = (ImageView) findViewById(R.id.imageview27);
		textview42 = (TextView) findViewById(R.id.textview42);
		linear81 = (LinearLayout) findViewById(R.id.linear81);
		imageview28 = (ImageView) findViewById(R.id.imageview28);
		textview43 = (TextView) findViewById(R.id.textview43);
		linear28 = (LinearLayout) findViewById(R.id.linear28);
		linear29 = (LinearLayout) findViewById(R.id.linear29);
		linear45 = (LinearLayout) findViewById(R.id.linear45);
		imageview16 = (ImageView) findViewById(R.id.imageview16);
		textview13 = (TextView) findViewById(R.id.textview13);
		linear47 = (LinearLayout) findViewById(R.id.linear47);
		imageview17 = (ImageView) findViewById(R.id.imageview17);
		textview14 = (TextView) findViewById(R.id.textview14);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		li = (LinearLayout) findViewById(R.id.li);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear55 = (LinearLayout) findViewById(R.id.linear55);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		ri = (LinearLayout) findViewById(R.id.ri);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear54 = (LinearLayout) findViewById(R.id.linear54);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		gps = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		mob = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		dacc = new AlertDialog.Builder(this);
		dcrim = new AlertDialog.Builder(this);
		dcamb = new AlertDialog.Builder(this);
		dag = new AlertDialog.Builder(this);
		din = new AlertDialog.Builder(this);
		dm = new AlertDialog.Builder(this);
		d = new AlertDialog.Builder(this);
		data = getSharedPreferences("lieu", Activity.MODE_PRIVATE);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		locationdata = getSharedPreferences("locationdata", Activity.MODE_PRIVATE);
		f = new AlertDialog.Builder(this);
		region = getSharedPreferences("region", Activity.MODE_PRIVATE);
		send = new AlertDialog.Builder(this);
		fauth = FirebaseAuth.getInstance();
		ad = getSharedPreferences("ad", Activity.MODE_PRIVATE);
		noti = new AlertDialog.Builder(this);
		phones = getSharedPreferences("phones", Activity.MODE_PRIVATE);
		spevent = getSharedPreferences("spevent", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		o = new AlertDialog.Builder(this);
		
		textview15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear31.setVisibility(View.GONE);
				ui = 0;
				_ARGHOZALITapTarget(imageview25, "Synchronisation", "Pour le bon fonctionnement de l'application, veillez à la synchroniser régulièrement.\nCliquez ici pour mettre à jour la base de donnée de l'application Ideal", "#03a9f4");
			}
		});
		
		imageview23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				aads.setClass(getApplicationContext(), PubActivity.class);
				aads.putExtra("link", ad.getString("adslink", ""));
				startActivity(aads);
			}
		});
		
		imageview26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview26.setVisibility(View.GONE);
				
				no.putExtra("user1name", data.getString("username", ""));
				startActivity(no);
			}
		});
		
		imageview25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog success_dialog = new AlertDialog.Builder(UgdActivity.this).create();
				LayoutInflater inflater = getLayoutInflater();
				
				View convertView = (View) inflater.inflate(R.layout.success_dialog, null);
				success_dialog.setView(convertView);
				
				success_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);  success_dialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
				LinearLayout s_bg = (LinearLayout) convertView.findViewById(R.id.linear_bg);
				
				LinearLayout s_div = (LinearLayout) convertView.findViewById(R.id.linear_div);
				
				Button s_ok = (Button) convertView.findViewById(R.id.okay_button);
				
				Button s_cancel = (Button) convertView.findViewById(R.id.cancel_button);
				
				ImageView s_header = (ImageView) convertView.findViewById(R.id.img_header);
				
				TextView s_title = (TextView) convertView.findViewById(R.id.txt_title);
				
				TextView s_msg = (TextView) convertView.findViewById(R.id.txt_msg);
				
				_setBgCorners(s_bg, 18, "#FFFFFF");
				_setBgCorners(s_ok, 18, "#03A9F4");
				_setBgCorners(s_cancel, 18, "#68CFFD");
				s_header.setElevation(5);
				s_ok.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						success_dialog.dismiss();
						call.setAction(Intent.ACTION_CALL);
						call.setData(Uri.parse("tel:".concat(num)));
						startActivity(call);
					}});
				s_cancel.setOnClickListener(new View.OnClickListener(){
					    public void onClick(View v){
						success_dialog.dismiss();
						des.setClass(getApplicationContext(), MajActivity.class);
						des.putExtra("x", "view");
						des.putExtra("net", String.valueOf((long)(net)));
						startActivity(des);
					}});
				success_dialog.show();
				_bounce(s_header);
			}
		});
		
		imageview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				send.setTitle("Infos sur ma recherche");
				send.setMessage("CE BOUTON MONTRERA LES INFOS CONCERNANT MA RECHERCHE SUR LA BARRE DE RECHERCHE.\nPar manque de temps nous n'avons pas pu acheminer ce projet.");
				send.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				send.create().show();
			}
		});
		
		linear58.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_DatePicker_Dark("Choisir une date", edittextdaty, edittextvolana, edittexttaona);
				SketchwareUtil.showMessage(getApplicationContext(), "PROJET PAS ACHEVÉ DÛ AU MANQUE DE TEMPS");
			}
		});
		
		edittexttaona.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.equals("")) {
					
				}
				else {
					saison = edittextvolana.getText().toString().trim().concat(edittexttaona.getText().toString().trim());
					SketchwareUtil.showMessage(getApplicationContext(), edittextvolana.getText().toString().trim().concat(edittexttaona.getText().toString().trim()));
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittextvolana.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.equals("")) {
					
				}
				else {
					saison = edittextvolana.getText().toString().trim().concat(edittexttaona.getText().toString().trim());
					SketchwareUtil.showMessage(getApplicationContext(), edittextvolana.getText().toString().trim().concat(edittexttaona.getText().toString().trim()));
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittextdaty.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.equals("")) {
					
				}
				else {
					saison = edittextvolana.getText().toString().trim().concat(edittexttaona.getText().toString().trim());
					SketchwareUtil.showMessage(getApplicationContext(), edittextvolana.getText().toString().trim().concat(edittexttaona.getText().toString().trim()));
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		listviewsemence.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				bk.setClass(getApplicationContext(), DetailsActivity.class);
				bk.putExtra("nom", lmsem.get((int)_position).get("nom").toString());
				bk.putExtra("semence", lmsem.get((int)_position).get("semence").toString());
				bk.putExtra("recolte", lmsem.get((int)_position).get("recolte").toString());
				bk.putExtra("pluie", lmsem.get((int)_position).get("pluie").toString());
				bk.putExtra("soleil", lmsem.get((int)_position).get("soleil").toString());
				bk.putExtra("vent", lmsem.get((int)_position).get("vent").toString());
				bk.putExtra("chaleur", lmsem.get((int)_position).get("chaleur").toString());
				bk.putExtra("eau", lmsem.get((int)_position).get("eau").toString());
				bk.putExtra("sols", lmsem.get((int)_position).get("sols").toString());
				bk.putExtra("énergie", lmsem.get((int)_position).get("energie").toString());
				bk.putExtra("génétique", lmsem.get((int)_position).get("genetique").toString());
				bk.putExtra("pic", lmsem.get((int)_position).get("pic").toString());
				bk.putExtra("ville", lmsem.get((int)_position).get("ville").toString());
				bk.putExtra("pays", lmsem.get((int)_position).get("pays").toString());
				bk.putExtra("détails", lmsem.get((int)_position).get("details").toString());
				startActivity(bk);
			}
		});
		
		listviewrecolte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				bk.setClass(getApplicationContext(), DetailsActivity.class);
				bk.putExtra("nom", lmrec.get((int)_position).get("nom").toString());
				bk.putExtra("semence", lmrec.get((int)_position).get("semence").toString());
				bk.putExtra("recolte", lmrec.get((int)_position).get("recolte").toString());
				bk.putExtra("pluie", lmrec.get((int)_position).get("pluie").toString());
				bk.putExtra("soleil", lmrec.get((int)_position).get("soleil").toString());
				bk.putExtra("vent", lmrec.get((int)_position).get("vent").toString());
				bk.putExtra("chaleur", lmrec.get((int)_position).get("chaleur").toString());
				bk.putExtra("eau", lmrec.get((int)_position).get("eau").toString());
				bk.putExtra("sols", lmrec.get((int)_position).get("sols").toString());
				bk.putExtra("énergie", lmrec.get((int)_position).get("energie").toString());
				bk.putExtra("génétique", lmrec.get((int)_position).get("genetique").toString());
				bk.putExtra("pic", lmrec.get((int)_position).get("pic").toString());
				bk.putExtra("ville", lmrec.get((int)_position).get("ville").toString());
				bk.putExtra("pays", lmrec.get((int)_position).get("pays").toString());
				bk.putExtra("détails", lmrec.get((int)_position).get("details").toString());
				startActivity(bk);
			}
		});
		
		linear24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				msg.setText(data.getString("phone", "").concat("\nACCIDENT".concat("\nlat:".concat(String.valueOf(lat).concat("\nlng:".concat(String.valueOf(lng).concat("\nlatmob:".concat(String.valueOf(latmob).concat("\nlngmob:".concat(String.valueOf(lngmob)))))))))));
				_EncryptString(msg.getText().toString(), "02793");
				if (lat == 0.0d) {
					dacc = new AlertDialog.Builder(UgdActivity.this,AlertDialog.THEME_TRADITIONAL);
					//dacc = new AlertDialog.Builder(UgdActivity.this,AlertDialog.THEME_TRADITIONAL);
					dacc.setTitle("SOS ACCIDENT");
					dacc.setMessage("Connexion GPS impossible.\nUn agent de Globy vous appelera dans quelques secondes pour confirmer l'urgence et votre localisation.\n\nNB: ENVOYEZ LE SMS DIRECTEMENT SANS MODIFICATION.");
					dacc.setPositiveButton("APPELER SECOURS", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							SketchwareUtil.showMessage(getApplicationContext(), "CLIQUEZ SUR ENVOYER SMS");
							acc.setAction(Intent.ACTION_VIEW);
							acc.setData(Uri.parse("smsto:".concat(num)));
							acc.putExtra("sms_body", encrypted);
							startActivity(acc);
						}
					});
					dacc.create().show();
				}
				else {
					if (net == 0) {
						c = Calendar.getInstance();
						map = new HashMap<>();
						map.put("username", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("text", data.getString("phone", "").concat("\nACCIDENT".concat("\nlat:".concat(String.valueOf(lat).concat("\nlng:".concat(String.valueOf(lng).concat("\nlatmob:".concat(String.valueOf(latmob).concat("\nlngmob:".concat(String.valueOf(lngmob)))))))))));
						map.put("villemag", data.getString("ville", ""));
						map.put("phone", data.getString("data", ""));
						map.put("date", new SimpleDateFormat("dd MMMM yyyy").format(c.getTime()));
						map.put("heure", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
						map.put("lat", String.valueOf(lat));
						map.put("lng", String.valueOf(lng));
						map.put("nbplace", "");
						map.put("promo", "");
						map.put("type", "accident".concat(data.getString("reg", "")));
						map.put("titre", "");
						map.put("cate", "");
						map.put("prix", "");
						map.put("time", String.valueOf((long)(c.getTimeInMillis())));
						map.put("plus1", String.valueOf(latmob));
						map.put("plus2", String.valueOf(lngmob));
						map.put("plus3", "");
						map.put("plus4", "");
						map.put("plus5", "");
						map.put("plus6", "");
						map.put("plus7", "");
						map.put("plus8", "");
						map.put("plus9", "");
						map.put("plus10", "");
						chat.push().updateChildren(map);
						map.clear();
						if (_fab.getRotation()==0) {
							oaa.setTarget(background);
							oaa.setPropertyName("translationX");
							oaa.setFloatValues((float)(0), (float)(2000));
							oaa.setDuration((int)(200));
							oaa.start();
							background.setVisibility(View.GONE);
							oa.setTarget(view1);
							oa.setPropertyName("translationX");
							oa.setFloatValues((float)(-2000), (float)(0));
							oa.setDuration((int)(200));
							oa.start();
							view1.setVisibility(View.VISIBLE);
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#2196f3")));
							_fab.animate().setDuration(200).rotation(180);
						} else {
							_fab.animate().setDuration(200).rotation(0);
							view1.setVisibility(View.GONE);
							oa.setTarget(view1);
							oa.setPropertyName("translationX");
							oa.setFloatValues((float)(0), (float)(-2000));
							oa.setDuration((int)(200));
							oa.start();
							background.setVisibility(View.VISIBLE);
							oaa.setTarget(background);
							oaa.setPropertyName("translationX");
							oaa.setFloatValues((float)(2000), (float)(0));
							oaa.setDuration((int)(200));
							oaa.start();
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#ff0000")));
						};
						send.setTitle("Signalement envoyé");
						send.create().show();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "CLIQUEZ SUR ENVOYER SMS");
						acc.setAction(Intent.ACTION_VIEW);
						acc.setData(Uri.parse("smsto:".concat(num)));
						acc.putExtra("sms_body", encrypted);
						startActivity(acc);
					}
				}
			}
		});
		
		linear25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				msg.setText(data.getString("phone", "").concat("\nCAMBRIOLAGE".concat("\nlat:".concat(String.valueOf(lat).concat("\nlng:".concat(String.valueOf(lng).concat("\nlatmob:".concat(String.valueOf(latmob).concat("\nlngmob:".concat(String.valueOf(lngmob)))))))))));
				_EncryptString(msg.getText().toString(), "02793");
				if (lat == 0.0d) {
					dcamb = new AlertDialog.Builder(UgdActivity.this,AlertDialog.THEME_TRADITIONAL);
					//dcamb = new AlertDialog.Builder(UgdActivity.this,AlertDialog.THEME_TRADITIONAL);
					dcamb.setTitle("SOS CAMBRIOLAGE");
					dcamb.setMessage("Connexion GPS impossible.\nUn agent de Globy vous appelera dans quelques secondes pour confirmer l'urgence et votre localisation. Pensez à mettre votre téléphone en ''MODE SILENCE'' si nécessaire.\n\nNB: ENVOYEZ LE SMS SANS MODIFICATIONS");
					dcamb.setPositiveButton("APPELER SECOURS", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							SketchwareUtil.showMessage(getApplicationContext(), "CLIQUEZ SUR ENVOYER SMS");
							cmb.setAction(Intent.ACTION_VIEW);
							cmb.setData(Uri.parse("smsto:".concat(num)));
							cmb.putExtra("sms_body", encrypted);
							startActivity(cmb);
						}
					});
					dcamb.create().show();
				}
				else {
					if (net == 0) {
						c = Calendar.getInstance();
						map = new HashMap<>();
						map.put("username", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("text", data.getString("phone", "").concat("\nCAMBRIOLAGE".concat("\nlat:".concat(String.valueOf(lat).concat("\nlng:".concat(String.valueOf(lng).concat("\nlatmob:".concat(String.valueOf(latmob).concat("\nlngmob:".concat(String.valueOf(lngmob)))))))))));
						map.put("villemag", data.getString("ville", ""));
						map.put("phone", data.getString("data", ""));
						map.put("date", new SimpleDateFormat("dd MMMM yyyy").format(c.getTime()));
						map.put("heure", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
						map.put("lat", String.valueOf(lat));
						map.put("lng", String.valueOf(lng));
						map.put("nbplace", "");
						map.put("promo", "");
						map.put("type", "cambriolage".concat(data.getString("reg", "")));
						map.put("titre", "");
						map.put("cate", "");
						map.put("prix", "");
						map.put("time", String.valueOf((long)(c.getTimeInMillis())));
						map.put("plus1", String.valueOf(latmob));
						map.put("plus2", String.valueOf(lngmob));
						map.put("plus3", "");
						map.put("plus4", "");
						map.put("plus5", "");
						map.put("plus6", "");
						map.put("plus7", "");
						map.put("plus8", "");
						map.put("plus9", "");
						map.put("plus10", "");
						chat.push().updateChildren(map);
						map.clear();
						if (_fab.getRotation()==0) {
							oaa.setTarget(background);
							oaa.setPropertyName("translationX");
							oaa.setFloatValues((float)(0), (float)(2000));
							oaa.setDuration((int)(200));
							oaa.start();
							background.setVisibility(View.GONE);
							oa.setTarget(view1);
							oa.setPropertyName("translationX");
							oa.setFloatValues((float)(-2000), (float)(0));
							oa.setDuration((int)(200));
							oa.start();
							view1.setVisibility(View.VISIBLE);
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#2196f3")));
							_fab.animate().setDuration(200).rotation(180);
						} else {
							_fab.animate().setDuration(200).rotation(0);
							view1.setVisibility(View.GONE);
							oa.setTarget(view1);
							oa.setPropertyName("translationX");
							oa.setFloatValues((float)(0), (float)(-2000));
							oa.setDuration((int)(200));
							oa.start();
							background.setVisibility(View.VISIBLE);
							oaa.setTarget(background);
							oaa.setPropertyName("translationX");
							oaa.setFloatValues((float)(2000), (float)(0));
							oaa.setDuration((int)(200));
							oaa.start();
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#ff0000")));
						};
						send.setTitle("Signalement envoyé");
						send.create().show();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "CLIQUEZ SUR ENVOYER SMS");
						cmb.setAction(Intent.ACTION_VIEW);
						cmb.setData(Uri.parse("smsto:".concat(num)));
						cmb.putExtra("sms_body", encrypted);
						startActivity(cmb);
					}
				}
			}
		});
		
		linear39.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				send.setTitle("TECHNIQUE ET APPROCHE");
				send.setMessage("CE BOUTON MONTRERA LES TECHNIQUES ET APPROCHES ET CONNAISSANCE SUR L' AIC\nPar manque de temps nous n'avons pas pu acheminer ce projet.");
				send.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				send.create().show();
			}
		});
		
		linear37.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				send.setTitle("TECHNIQUE ET APPROCHE");
				send.setMessage("CE BOUTON MONTRERA LES TECHNIQUES ET APPROCHES ET CONNAISSANCE SUR L' AIC\nPar manque de temps nous n'avons pas pu acheminer ce projet.");
				send.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				send.create().show();
			}
		});
		
		linear26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				msg.setText(data.getString("phone", "").concat("\nMALAISE".concat("\nlat:".concat(String.valueOf(lat).concat("\nlng:".concat(String.valueOf(lng).concat("\nlatmob:".concat(String.valueOf(latmob).concat("\nlngmob:".concat(String.valueOf(lngmob)))))))))));
				_EncryptString(msg.getText().toString(), "02793");
				if (lat == 0.0d) {
					dm = new AlertDialog.Builder(UgdActivity.this,AlertDialog.THEME_TRADITIONAL);
					//dm = new AlertDialog.Builder(UgdActivity.this,AlertDialog.THEME_TRADITIONAL);
					dm.setTitle("SOS MÉDICAL");
					dm.setMessage("Connexion GPS impossible.\nUn agent de Globy vous appelera dans quelques secondes pour confirmer l'urgence et votre localisation.\n\nNB: ENVOYEZ LE SMS DIRECTEMENT SANS MODIFICATIONS.");
					dm.setPositiveButton("APPELER SECOURS", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							SketchwareUtil.showMessage(getApplicationContext(), "CLIQUEZ SUR ENVOYER SMS");
							mef.setAction(Intent.ACTION_VIEW);
							mef.setData(Uri.parse("smsto:".concat(num)));
							mef.putExtra("sms_body", encrypted);
							startActivity(mef);
						}
					});
					dm.create().show();
				}
				else {
					if (net == 0) {
						c = Calendar.getInstance();
						map = new HashMap<>();
						map.put("username", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("text", data.getString("phone", "").concat("\nMALAISE".concat("\nlat:".concat(String.valueOf(lat).concat("\nlng:".concat(String.valueOf(lng).concat("\nlatmob:".concat(String.valueOf(latmob).concat("\nlngmob:".concat(String.valueOf(lngmob)))))))))));
						map.put("villemag", data.getString("ville", ""));
						map.put("phone", data.getString("data", ""));
						map.put("date", new SimpleDateFormat("dd MMMM yyyy").format(c.getTime()));
						map.put("heure", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
						map.put("lat", String.valueOf(lat));
						map.put("lng", String.valueOf(lng));
						map.put("nbplace", "");
						map.put("promo", "");
						map.put("type", "malaise".concat(data.getString("reg", "")));
						map.put("titre", "");
						map.put("cate", "");
						map.put("prix", "");
						map.put("time", String.valueOf((long)(c.getTimeInMillis())));
						map.put("plus1", String.valueOf(latmob));
						map.put("plus2", String.valueOf(lngmob));
						map.put("plus3", "");
						map.put("plus4", "");
						map.put("plus5", "");
						map.put("plus6", "");
						map.put("plus7", "");
						map.put("plus8", "");
						map.put("plus9", "");
						map.put("plus10", "");
						chat.push().updateChildren(map);
						map.clear();
						if (_fab.getRotation()==0) {
							oaa.setTarget(background);
							oaa.setPropertyName("translationX");
							oaa.setFloatValues((float)(0), (float)(2000));
							oaa.setDuration((int)(200));
							oaa.start();
							background.setVisibility(View.GONE);
							oa.setTarget(view1);
							oa.setPropertyName("translationX");
							oa.setFloatValues((float)(-2000), (float)(0));
							oa.setDuration((int)(200));
							oa.start();
							view1.setVisibility(View.VISIBLE);
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#2196f3")));
							_fab.animate().setDuration(200).rotation(180);
						} else {
							_fab.animate().setDuration(200).rotation(0);
							view1.setVisibility(View.GONE);
							oa.setTarget(view1);
							oa.setPropertyName("translationX");
							oa.setFloatValues((float)(0), (float)(-2000));
							oa.setDuration((int)(200));
							oa.start();
							background.setVisibility(View.VISIBLE);
							oaa.setTarget(background);
							oaa.setPropertyName("translationX");
							oaa.setFloatValues((float)(2000), (float)(0));
							oaa.setDuration((int)(200));
							oaa.start();
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#ff0000")));
						};
						send.setTitle("Signalement envoyé");
						send.create().show();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "CLIQUEZ SUR ENVOYER SMS");
						mef.setAction(Intent.ACTION_VIEW);
						mef.setData(Uri.parse("smsto:".concat(num)));
						mef.putExtra("sms_body", encrypted);
						startActivity(mef);
					}
				}
			}
		});
		
		linear27.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				msg.setText(data.getString("phone", "").concat("\nAGRESSION".concat("\nlat:".concat(String.valueOf(lat).concat("\nlng:".concat(String.valueOf(lng).concat("\nlatmob:".concat(String.valueOf(latmob).concat("\nlngmob:".concat(String.valueOf(lngmob)))))))))));
				_EncryptString(msg.getText().toString(), "02793");
				if (lat == 0.0d) {
					dag = new AlertDialog.Builder(UgdActivity.this,AlertDialog.THEME_TRADITIONAL);
					//dag = new AlertDialog.Builder(UgdActivity.this,AlertDialog.THEME_TRADITIONAL);
					dag.setTitle("SOS AGRESSION/VIOL");
					dag.setMessage("\nConnexion GPS impossible.\nUn agent de Globy vous appelera dans quelques secondes pour confirmer l'urgence et votre localisation. Pensez à mettre votre téléphone en ''MODE SILENCE'' si nécessaire.\n\nNB: ENVOYEZ LE SMS SANS MODIFICATIONS");
					dag.setPositiveButton("APPELER SECOURS", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							SketchwareUtil.showMessage(getApplicationContext(), "CLIQUEZ SUR ENVOYER SMS");
							agr.setAction(Intent.ACTION_VIEW);
							agr.setData(Uri.parse("smsto:".concat(num)));
							agr.putExtra("sms_body", encrypted);
							startActivity(agr);
						}
					});
					dag.create().show();
				}
				else {
					if (net == 0) {
						c = Calendar.getInstance();
						map = new HashMap<>();
						map.put("username", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("text", data.getString("phone", "").concat("\nAGRESSION".concat("\nlat:".concat(String.valueOf(lat).concat("\nlng:".concat(String.valueOf(lng).concat("\nlatmob:".concat(String.valueOf(latmob).concat("\nlngmob:".concat(String.valueOf(lngmob)))))))))));
						map.put("villemag", data.getString("ville", ""));
						map.put("phone", data.getString("data", ""));
						map.put("date", new SimpleDateFormat("dd MMMM yyyy").format(c.getTime()));
						map.put("heure", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
						map.put("lat", String.valueOf(lat));
						map.put("lng", String.valueOf(lng));
						map.put("nbplace", "");
						map.put("promo", "");
						map.put("type", "agression".concat(data.getString("reg", "")));
						map.put("titre", "");
						map.put("cate", "");
						map.put("prix", "");
						map.put("time", String.valueOf((long)(c.getTimeInMillis())));
						map.put("plus1", String.valueOf(latmob));
						map.put("plus2", String.valueOf(lngmob));
						map.put("plus3", "");
						map.put("plus4", "");
						map.put("plus5", "");
						map.put("plus6", "");
						map.put("plus7", "");
						map.put("plus8", "");
						map.put("plus9", "");
						map.put("plus10", "");
						chat.push().updateChildren(map);
						map.clear();
						if (_fab.getRotation()==0) {
							oaa.setTarget(background);
							oaa.setPropertyName("translationX");
							oaa.setFloatValues((float)(0), (float)(2000));
							oaa.setDuration((int)(200));
							oaa.start();
							background.setVisibility(View.GONE);
							oa.setTarget(view1);
							oa.setPropertyName("translationX");
							oa.setFloatValues((float)(-2000), (float)(0));
							oa.setDuration((int)(200));
							oa.start();
							view1.setVisibility(View.VISIBLE);
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#2196f3")));
							_fab.animate().setDuration(200).rotation(180);
						} else {
							_fab.animate().setDuration(200).rotation(0);
							view1.setVisibility(View.GONE);
							oa.setTarget(view1);
							oa.setPropertyName("translationX");
							oa.setFloatValues((float)(0), (float)(-2000));
							oa.setDuration((int)(200));
							oa.start();
							background.setVisibility(View.VISIBLE);
							oaa.setTarget(background);
							oaa.setPropertyName("translationX");
							oaa.setFloatValues((float)(2000), (float)(0));
							oaa.setDuration((int)(200));
							oaa.start();
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#ff0000")));
						};
						send.setTitle("Signalement envoyé");
						send.create().show();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "CLIQUEZ SUR ENVOYER SMS");
						agr.setAction(Intent.ACTION_VIEW);
						agr.setData(Uri.parse("smsto:".concat(num)));
						agr.putExtra("sms_body", encrypted);
						startActivity(agr);
					}
				}
			}
		});
		
		linear41.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				send.setTitle("TECHNIQUE ET APPROCHE");
				send.setMessage("CE BOUTON MONTRERA LES TECHNIQUES ET APPROCHES ET CONNAISSANCE SUR L' AIC\nPar manque de temps nous n'avons pas pu acheminer ce projet.");
				send.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				send.create().show();
			}
		});
		
		linear43.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				send.setTitle("TECHNIQUE ET APPROCHE");
				send.setMessage("CE BOUTON MONTRERA LES TECHNIQUES ET APPROCHES ET CONNAISSANCE SUR L' AIC\nPar manque de temps nous n'avons pas pu acheminer ce projet.");
				send.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				send.create().show();
			}
		});
		
		linear79.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				send.setTitle("TECHNIQUE ET APPROCHE");
				send.setMessage("CE BOUTON MONTRERA LES TECHNIQUES ET APPROCHES ET CONNAISSANCE SUR L' AIC\nPar manque de temps nous n'avons pas pu acheminer ce projet.");
				send.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				send.create().show();
			}
		});
		
		linear81.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				send.setTitle("TECHNIQUE ET APPROCHE");
				send.setMessage("CE BOUTON MONTRERA LES TECHNIQUES ET APPROCHES ET CONNAISSANCE SUR L' AIC\nPar manque de temps nous n'avons pas pu acheminer ce projet.");
				send.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				send.create().show();
			}
		});
		
		linear28.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				msg.setText(data.getString("phone", "").concat("\nINCENDIE".concat("\nlat:".concat(String.valueOf(lat).concat("\nlng:".concat(String.valueOf(lng).concat("\nlatmob:".concat(String.valueOf(latmob).concat("\nlngmob:".concat(String.valueOf(lngmob)))))))))));
				_EncryptString(msg.getText().toString(), "02793");
				if (lat == 0.0d) {
					din = new AlertDialog.Builder(UgdActivity.this,AlertDialog.THEME_TRADITIONAL);
					//din = new AlertDialog.Builder(UgdActivity.this,AlertDialog.THEME_TRADITIONAL);
					din.setTitle("SOS INCENDIE");
					din.setMessage("Connexion GPS impossible.\nUn agent de Globy vous appelera dans quelques secondes pour confirmer l'urgence et votre localisation.\n\nNB: ENVOYEZ LE SMS DIRECTEMENT SANS MODIFICATION.");
					din.setPositiveButton("APPELER SECOURS", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							SketchwareUtil.showMessage(getApplicationContext(), "CLIQUEZ SUR ENVOYER SMS");
							inc.setAction(Intent.ACTION_VIEW);
							inc.setData(Uri.parse("smsto:".concat(num)));
							inc.putExtra("sms_body", encrypted);
							startActivity(inc);
						}
					});
					din.create().show();
				}
				else {
					if (net == 0) {
						c = Calendar.getInstance();
						map = new HashMap<>();
						map.put("username", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("text", data.getString("phone", "").concat("\nINCENDIE".concat("\nlat:".concat(String.valueOf(lat).concat("\nlng:".concat(String.valueOf(lng).concat("\nlatmob:".concat(String.valueOf(latmob).concat("\nlngmob:".concat(String.valueOf(lngmob)))))))))));
						map.put("villemag", data.getString("ville", ""));
						map.put("phone", data.getString("data", ""));
						map.put("date", new SimpleDateFormat("dd MMMM yyyy").format(c.getTime()));
						map.put("heure", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
						map.put("lat", String.valueOf(lat));
						map.put("lng", String.valueOf(lng));
						map.put("nbplace", "");
						map.put("promo", "");
						map.put("type", "feu".concat(data.getString("reg", "")));
						map.put("titre", "");
						map.put("cate", "");
						map.put("prix", "");
						map.put("time", String.valueOf((long)(c.getTimeInMillis())));
						map.put("plus1", String.valueOf(latmob));
						map.put("plus2", String.valueOf(lngmob));
						map.put("plus3", "");
						map.put("plus4", "");
						map.put("plus5", "");
						map.put("plus6", "");
						map.put("plus7", "");
						map.put("plus8", "");
						map.put("plus9", "");
						map.put("plus10", "");
						chat.push().updateChildren(map);
						map.clear();
						if (_fab.getRotation()==0) {
							oaa.setTarget(background);
							oaa.setPropertyName("translationX");
							oaa.setFloatValues((float)(0), (float)(2000));
							oaa.setDuration((int)(200));
							oaa.start();
							background.setVisibility(View.GONE);
							oa.setTarget(view1);
							oa.setPropertyName("translationX");
							oa.setFloatValues((float)(-2000), (float)(0));
							oa.setDuration((int)(200));
							oa.start();
							view1.setVisibility(View.VISIBLE);
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#2196f3")));
							_fab.animate().setDuration(200).rotation(180);
						} else {
							_fab.animate().setDuration(200).rotation(0);
							view1.setVisibility(View.GONE);
							oa.setTarget(view1);
							oa.setPropertyName("translationX");
							oa.setFloatValues((float)(0), (float)(-2000));
							oa.setDuration((int)(200));
							oa.start();
							background.setVisibility(View.VISIBLE);
							oaa.setTarget(background);
							oaa.setPropertyName("translationX");
							oaa.setFloatValues((float)(2000), (float)(0));
							oaa.setDuration((int)(200));
							oaa.start();
							_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#ff0000")));
						};
						send.setTitle("Signalement envoyé");
						send.create().show();
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "CLIQUEZ SUR ENVOYER SMS");
						inc.setAction(Intent.ACTION_VIEW);
						inc.setData(Uri.parse("smsto:".concat(num)));
						inc.putExtra("sms_body", encrypted);
						startActivity(inc);
					}
				}
			}
		});
		
		linear29.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				cam.putExtra("lat", String.valueOf(lat));
				cam.putExtra("lng", String.valueOf(lng));
				cam.putExtra("latmob", String.valueOf(latmob));
				cam.putExtra("lngmob", String.valueOf(lngmob));
				cam.putExtra("num", num);
				startActivity(cam);
			}
		});
		
		linear45.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				send.setTitle("TECHNIQUE ET APPROCHE");
				send.setMessage("CE BOUTON MONTRERA LES TECHNIQUES ET APPROCHES ET CONNAISSANCE SUR L' AIC\nPar manque de temps nous n'avons pas pu acheminer ce projet.");
				send.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				send.create().show();
			}
		});
		
		linear47.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				send.setTitle("TECHNIQUE ET APPROCHE");
				send.setMessage("CE BOUTON MONTRERA LES TECHNIQUES ET APPROCHES ET CONNAISSANCE SUR L' AIC\nPar manque de temps nous n'avons pas pu acheminer ce projet.");
				send.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				send.create().show();
			}
		});
		
		linear55.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				z.setClass(getApplicationContext(), TownActivity.class);
				z.putExtra("net", String.valueOf((long)(net)));
				z.putExtra("user1name", data.getString("username", ""));
				z.putExtra("user1pic", "");
				startActivity(z);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				z.setClass(getApplicationContext(), TownActivity.class);
				z.putExtra("net", String.valueOf((long)(net)));
				z.putExtra("user1name", data.getString("username", ""));
				z.putExtra("user1pic", "");
				startActivity(z);
			}
		});
		
		linear54.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sh.setClass(getApplicationContext(), MarketActivity.class);
				startActivity(sh);
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (_fab.getRotation()==0) {
					oaa.setTarget(background);
					oaa.setPropertyName("translationX");
					oaa.setFloatValues((float)(0), (float)(2000));
					oaa.setDuration((int)(200));
					oaa.start();
					background.setVisibility(View.GONE);
					oa.setTarget(view1);
					oa.setPropertyName("translationX");
					oa.setFloatValues((float)(-2000), (float)(0));
					oa.setDuration((int)(200));
					oa.start();
					view1.setVisibility(View.VISIBLE);
					_fab.animate().setDuration(200).rotation(360);
				} else {
					_fab.animate().setDuration(200).rotation(0);
					view1.setVisibility(View.GONE);
					oa.setTarget(view1);
					oa.setPropertyName("translationX");
					oa.setFloatValues((float)(0), (float)(-2000));
					oa.setDuration((int)(200));
					oa.start();
					background.setVisibility(View.VISIBLE);
					oaa.setTarget(background);
					oaa.setPropertyName("translationX");
					oaa.setFloatValues((float)(2000), (float)(0));
					oaa.setDuration((int)(200));
					oaa.start();
				};
			}
		});
		
		_gps_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				mob.removeUpdates(_mob_location_listener);
				if (n == 0) {
					
					
				}
				n++;
				_getLocation(_lat, _lng);
				ty = 420;
				lat = _lat;
				lng = _lng;
				textview4.setText("ON");
				if (!(lat == 0)) {
					time = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									
									
									nst = String.valueOf((long)(Double.parseDouble(nst) + 1));
									
									
									
								}
							});
						}
					};
					_timer.scheduleAtFixedRate(time, (int)(0), (int)(30000));
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
		
		_mob_location_listener = new LocationListener() {
			@Override
			public void onLocationChanged(Location _param1) {
				final double _lat = _param1.getLatitude();
				final double _lng = _param1.getLongitude();
				final double _acc = _param1.getAccuracy();
				
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								dt = Calendar.getInstance();
								if (new SimpleDateFormat("HH:mm").format(dt.getTime()).equals("07:00")) {
									val = "1";
									
								}
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(t, (int)(0), (int)(10000));
				if (!(ty == 420)) {
					_getLocation(_lat, _lng);
					latmob = _lat;
					lngmob = _lng;
					textview6.setText("ON");
				}
			}
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			@Override
			public void onProviderEnabled(String provider) {}
			@Override
			public void onProviderDisabled(String provider) {}
		};
		
		_connex_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				textview8.setText("☻ ONLINE");
				textview8.setTextColor(0xFF4CAF50);
				net = 0;
				connex.removeEventListener(_connex_child_listener);
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
		
		_chat_child_listener = new ChildEventListener() {
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
		chat.addChildEventListener(_chat_child_listener);
		
		_ads_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				ads.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						adsmp = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								adsmp.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						ad.edit().putString("adslink", _childValue.get("advertisementlink").toString()).commit();
						ad.edit().putString("ads", _childValue.get("advertisement").toString()).commit();
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
		
		_notif_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				notif.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						maplist = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								maplist.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						uids.add(_childKey);
						if (maplist.size() > 0) {
							imageview26.setVisibility(View.VISIBLE);
							noti.setTitle("Nouveau message");
							noti.setPositiveButton("Ouvrir", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
									no.putExtra("user1name", data.getString("username", ""));
									startActivity(no);
								}
							});
							noti.setNegativeButton("Retour", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							noti.create().show();
						}
						else {
							imageview26.setVisibility(View.GONE);
						}
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
		notif.addChildEventListener(_notif_child_listener);
		
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
		if (!sp.getString("jsone", "").equals("")) {
			lmsem = new Gson().fromJson(sp.getString("jsone", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listviewsemence.setAdapter(new ListviewsemenceAdapter(lmsem));
			((BaseAdapter)listviewsemence.getAdapter()).notifyDataSetChanged();
			lmrec = new Gson().fromJson(sp.getString("jsone", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listviewrecolte.setAdapter(new ListviewrecolteAdapter(lmsem));
			((BaseAdapter)listviewrecolte.getAdapter()).notifyDataSetChanged();
		}
		_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#ffffff")));
		_fab.setCompatElevation(60); 
		c = Calendar.getInstance();
		saison = new SimpleDateFormat("MMyyyy").format(c.getTime());
		jour.setText(new SimpleDateFormat("dd").format(c.getTime()));
		moisannee.setText(new SimpleDateFormat("MMMM yyyy").format(c.getTime()));
		_Bory(linear90, "#f5f5f5", "#ff9300", 30);
		_Bory(linear92, "#f5f5f5", "#ff9300", 30);
		jour.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		moisannee.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview43.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview42.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		android.graphics.drawable.GradientDrawable gd91u = new android.graphics.drawable.GradientDrawable();
		gd91u.setColor(Color.parseColor("#ff9300"));
		gd91u.setCornerRadii(new float[] { 30, 30, 30, 30, 0, 0, 0, 0 });
		linear91.setBackground(gd91u);
		android.graphics.drawable.GradientDrawable gd918u = new android.graphics.drawable.GradientDrawable();
		gd918u.setColor(Color.parseColor("#ff9300"));
		gd918u.setCornerRadii(new float[] { 30, 30, 30, 30, 0, 0, 0, 0 });
		linear93.setBackground(gd918u);
		if (getIntent().getStringExtra("x").equals("retour")) {
			de.setTarget(linear35);
			de.setPropertyName("alpha");
			de.setFloatValues((float)(0), (float)(1));
			de.setDuration((int)(2000));
			de.setInterpolator(new DecelerateInterpolator());
			de.start();
			ovi.setTarget(imageview19);
			ovi.setPropertyName("translationY");
			ovi.setFloatValues((float)(2000), (float)(0));
			ovi.setDuration((int)(1000));
			ovi.setInterpolator(new DecelerateInterpolator());
			ovi.start();
			g = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							if (ui == 1) {
								_ARGHOZALITapTarget(_fab, "MODULES TECHNIQUES", "Cliquez ici pour consulter les techniques et approches améliorées pour la gestion durable des exploitations agricoles", "#ff0000");
								iu.setTarget(linear31);
								iu.setPropertyName("translationY");
								iu.setFloatValues((float)(0), (float)(-3000));
								iu.setDuration((int)(1000));
								iu.setInterpolator(new AccelerateInterpolator());
								iu.start();
								linear31.setVisibility(View.GONE);
							}
						}
					});
				}
			};
			_timer.schedule(g, (int)(10000));
		}
		else {
			linear31.setVisibility(View.GONE);
		}
		net = 1;
		nst = "1";
		ki = 0;
		ty = 0;
		n = 0;
		lat = 0;
		lng = 0;
		latmob = 0;
		lngmob = 0;
		view1.setVisibility(View.GONE);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/harabaravrai.ttf"), 1);
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						u = Calendar.getInstance();
						textview2.setText(new SimpleDateFormat("HH:mm").format(u.getTime()));
						textview19.setText(new SimpleDateFormat("dd MMMM yyyy").format(u.getTime()));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(60000));
		android.graphics.drawable.GradientDrawable gd91 = new android.graphics.drawable.GradientDrawable();
		gd91.setColor(Color.parseColor("#ffffff"));
		gd91.setCornerRadii(new float[] { 0, 0, 90, 90, 90, 90, 0, 0 });
		imageview11.setBackground(gd91);
		android.graphics.drawable.GradientDrawable gd901 = new android.graphics.drawable.GradientDrawable();
		gd901.setColor(Color.parseColor("#424242"));
		gd901.setCornerRadii(new float[] { 90, 90, 0, 0, 0, 0, 90, 90 });
		linear53.setBackground(gd901);
		android.graphics.drawable.GradientDrawable gd2 = new android.graphics.drawable.GradientDrawable();
		gd2.setColor(Color.parseColor("#86bd00"));
		gd2.setCornerRadii(new float[] { 20, 20, 0, 0, 0, 0, 0, 0 });
		ri.setBackground(gd2);
		android.graphics.drawable.GradientDrawable gd1 = new android.graphics.drawable.GradientDrawable();
		gd1.setColor(Color.parseColor("#86bd00"));
		gd1.setCornerRadii(new float[] { 0, 0, 20, 20, 0, 0, 0, 0 });
		li.setBackground(gd1);
		android.graphics.drawable.GradientDrawable gd11 = new android.graphics.drawable.GradientDrawable();
		gd11.setColor(Color.parseColor("#ffffff"));
		gd11.setCornerRadii(new float[] { 0, 0, 0, 0, 360, 360, 360, 360 });
		linear9.setBackground(gd11);
		android.graphics.drawable.GradientDrawable gd11y1 = new android.graphics.drawable.GradientDrawable();
		gd11y1.setColor(Color.parseColor("#ffffff"));
		gd11y1.setCornerRadii(new float[] { 60, 60, 60, 60, 0, 0, 0, 0 });
		linear13.setBackground(gd11y1);
		notif.removeEventListener(_notif_child_listener);
		notif_path = "users/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/notifications"));
		notif = _firebase.getReference(notif_path);
		notif.addChildEventListener(_notif_child_listener);
		_Bory(textview15, "#000000", "#ffffff", 360);
		_Bory(v2, "#f5f5f5", "#e0e0e0", 15);
		if (ContextCompat.checkSelfPermission(UgdActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			gps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, _gps_location_listener);
		}
		if (ContextCompat.checkSelfPermission(UgdActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			mob.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _mob_location_listener);
		}
		if (!locationdata.getString("locationdata", "").equals("")) {
			lmm = new Gson().fromJson(locationdata.getString("locationdata", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		length = lmm.size();
		r = length - 1;
		for(int _repeat302 = 0; _repeat302 < (int)(length); _repeat302++) {
			countries.add(lmm.get((int)r).get("nom").toString());
			r--;
		}
		edittext = new
		AutoCompleteTextView(this);
		
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
		
		edittext.setLayoutParams(layoutParams);
		edittext.setHint("      Ce que vous voulez planter...");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		
		R.layout.custom_view,
		R.id.textview1, countries);
		edittext.setAdapter(adapter);
		edittext.setThreshold(1);
		linear53.addView(edittext);
		edittext.setTextSize(14);
		edittext.setTextColor(Color.WHITE);
		edittext.setHintTextColor(Color.parseColor("#ffffff"));
		edittext.getBackground().setColorFilter(Color.parseColor("#424242"), PorterDuff.Mode.SRC_ATOP); 
		_fab.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#4caf50")));
				z.setAction(Intent.ACTION_CALL);
				z.setData(Uri.parse("tel:".concat(num)));
				startActivity(z);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#ffffff")));
							}
						});
					}
				};
				_timer.schedule(t, (int)(5000));
				return true;
			}
		});
		_Bory(imageview27, "#ffffff", "#009fe3", 360);
		_Bory(imageview28, "#ffffff", "#009fe3", 360);
		_Bory(imageview17, "#ffffff", "#009fe3", 360);
		_Bory(imageview16, "#ffffff", "#009fe3", 360);
		_Bory(imageview15, "#ffffff", "#009fe3", 360);
		_Bory(imageview14, "#ffffff", "#009fe3", 360);
		_Bory(imageview13, "#ffffff", "#009fe3", 360);
		_Bory(imageview12, "#ffffff", "#009fe3", 360);
		_rounded(linear82, 15, "#e0e0e0", 20);
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
	public void onBackPressed() {
		
		startActivity(bk);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (ContextCompat.checkSelfPermission(UgdActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			gps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, _gps_location_listener);
		}
		if (ContextCompat.checkSelfPermission(UgdActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			mob.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _mob_location_listener);
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		gps.removeUpdates(_gps_location_listener);
		mob.removeUpdates(_mob_location_listener);
	}
	public void _xxc () {
		_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#ff0000")));
		RelativeLayout rl = new RelativeLayout(this); RelativeLayout.LayoutParams lparams = new RelativeLayout.LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT); rl.setLayoutParams(lparams); background.removeAllViews(); rl.addView(v2); rl.addView(v1); background.addView(rl);
		net = 1;
		nst = "1";
		ki = 0;
		ty = 0;
		n = 0;
		lat = 0;
		lng = 0;
		latmob = 0;
		lngmob = 0;
		view1.setVisibility(View.GONE);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/harabaravrai.ttf"), 1);
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						u = Calendar.getInstance();
						textview2.setText(new SimpleDateFormat("HH:mm").format(u.getTime()));
						
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(60000));
		_fab.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#4caf50")));
				z.setAction(Intent.ACTION_CALL);
				z.setData(Uri.parse("tel:0346746540"));
				startActivity(z);
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#ff0000")));
							}
						});
					}
				};
				_timer.schedule(t, (int)(5000));
				return true;
			}
		});
		android.graphics.drawable.GradientDrawable gd2 = new android.graphics.drawable.GradientDrawable();
		gd2.setColor(Color.parseColor("#03A9F4"));
		gd2.setCornerRadii(new float[] { 20, 20, 0, 0, 0, 0, 0, 0 });
		ri.setBackground(gd2);
		android.graphics.drawable.GradientDrawable gd1 = new android.graphics.drawable.GradientDrawable();
		gd1.setColor(Color.parseColor("#03A9F4"));
		gd1.setCornerRadii(new float[] { 0, 0, 20, 20, 0, 0, 0, 0 });
		li.setBackground(gd1);
		android.graphics.drawable.GradientDrawable gd11 = new android.graphics.drawable.GradientDrawable();
		gd11.setColor(Color.parseColor("#ffffff"));
		gd11.setCornerRadii(new float[] { 0, 0, 0, 0, 360, 360, 360, 360 });
		linear9.setBackground(gd11);
		android.graphics.drawable.GradientDrawable gd11y1 = new android.graphics.drawable.GradientDrawable();
		gd11y1.setColor(Color.parseColor("#ffffff"));
		gd11y1.setCornerRadii(new float[] { 60, 60, 60, 60, 0, 0, 0, 0 });
		linear13.setBackground(gd11y1);
		_Bory(v1, "#f5f5f5", "#e0e0e0", 15);
		_Bory(linear20, "#ffffff", "#e0e0e0", 360);
		_Bory(imageview11, "#03A9F4", "#e0e0e0", 360);
		_Bory(v2, "#f5f5f5", "#e0e0e0", 15);
		_rounded(linear29, 20, "#00e676", 15);
		_rounded(linear24, 20, "#212121", 15);
		_rounded(linear25, 20, "#9c27b0", 15);
		_rounded(linear26, 20, "#3f51b5", 15);
		_rounded(linear27, 20, "#607d8b", 15);
		_rounded(linear28, 20, "#ef5350", 15);
		if (ContextCompat.checkSelfPermission(UgdActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			gps.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, _gps_location_listener);
		}
		if (ContextCompat.checkSelfPermission(UgdActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
			mob.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, _mob_location_listener);
		}
	}
	
	
	public void _Bory (final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
		_view.setBackground(gd);
	}
	
	
	public void _rounded (final View _view, final double _ab, final String _color, final double _shadow) {
		android.graphics.drawable.GradientDrawable s = new android.graphics.drawable.GradientDrawable();
		s.setColor(Color.parseColor(_color));
		s.setCornerRadius((float)_ab);
		_view.setBackground(s);
		_view.setElevation((float)_shadow);
	}
	
	
	public void _Encrypt_and_Decrypt () {
		
	}
	
	private javax.crypto.SecretKey generateKey(String pwd) throws Exception {
		
		final java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
		
		byte[] b = pwd.getBytes("UTF-8");
		
		digest.update(b,0,b.length);
		
		byte[] key = digest.digest();
		
		javax.crypto.spec.SecretKeySpec sec = new javax.crypto.spec.SecretKeySpec(key, "AES");
		
		return sec;
	}
	
	
	public void _EncryptString (final String _string, final String _key) {
		try {
			javax.crypto.SecretKey key = generateKey(_key); 
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES"); 
			c.init(javax.crypto.Cipher.ENCRYPT_MODE, key); 
			byte[] encVal = c.doFinal(_string.getBytes());
			encrypted = android.util.Base64.encodeToString(encVal,android.util.Base64.DEFAULT);
			text_encrypted.setText(encrypted);
		} catch (Exception ex) {
			showMessage(String.valueOf(ex));
		}
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
	
	
	public void _bounce (final View _view) {
		oa_d.setTarget(_view);
		oa_d.setPropertyName("rotation");
		oa_d.setFloatValues((float)(90), (float)(0));
		oa_d.setDuration((int)(1000));
		oa_d.setInterpolator(new BounceInterpolator());
		oa_d.start();
	}
	
	
	public void _setBgCorners (final View _view, final double _radius, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
		gd.setColor(Color.parseColor("#" + _color.replace("#", ""))); /* color */
		gd.setCornerRadius((int)_radius); /* radius */
		gd.setStroke(0, Color.WHITE); /* stroke heigth and color */
		_view.setBackground(gd);
	}
	
	
	public void _ARGHOZALITapTarget (final View _view, final String _title, final String _msg, final String _bgcolor) {
		TapTargetView.showFor(UgdActivity.this,
		TapTarget.forView(_view, _title, _msg)
		.outerCircleColorInt(Color.parseColor(_bgcolor))
		.outerCircleAlpha(0.96f)
		.targetCircleColorInt(Color.parseColor("#FFFFFF"))
		.titleTextSize(25)
		.titleTextColorInt(Color.parseColor("#FFFFFF"))
		.descriptionTextSize(18)
		.descriptionTextColor(android.R.color.white)
		.textColorInt(Color.parseColor("#FFFFFF"))
		.textTypeface(Typeface.SANS_SERIF)
		.dimColor(android.R.color.black)
		.drawShadow(true)
		.cancelable(true)
		.tintTarget(true)
		.transparentTarget(true)
		//.icon(Drawable)
		.targetRadius(60),
		
		//LISTENER//
		
		new TapTargetView.Listener() {
			@Override
			public void onTargetClick(TapTargetView view) {
				//ON CLICKED//
				super.onTargetClick(view);
			}
		});
	}
	static class UiUtil {
		    UiUtil() {
			    }
		    static int dp(Context context, int val) {
			        return (int) TypedValue.applyDimension(
			                TypedValue.COMPLEX_UNIT_DIP, val, context.getResources().getDisplayMetrics());
			    }
		    static int sp(Context context, int val) {
			        return (int) TypedValue.applyDimension(
			                TypedValue.COMPLEX_UNIT_SP, val, context.getResources().getDisplayMetrics());
			    }
		    static int themeIntAttr(Context context, String attr) {
			        final android.content.res.Resources.Theme theme = context.getTheme();
			        if (theme == null) {
				            return -1;
				        }
			        final TypedValue value = new TypedValue();
			        final int id = context.getResources().getIdentifier(attr, "attr", context.getPackageName());
			
			        if (id == 0) {
				            // Not found
				            return -1;
				        }
			        theme.resolveAttribute(id, value, true);
			        return value.data;
			    }
		    static int setAlpha(int argb, float alpha) {
			        if (alpha > 1.0f) {
				            alpha = 1.0f;
				        } else if (alpha <= 0.0f) {
				            alpha = 0.0f;
				        }
			        return ((int) ((argb >>> 24) * alpha) << 24) | (argb & 0x00FFFFFF);
			    }
	}
	static class FloatValueAnimatorBuilder {
		
		    private final ValueAnimator animator;
		
		    private EndListener endListener;
		
		    interface UpdateListener {
			        void onUpdate(float lerpTime);
			    }
		    interface EndListener {
			        void onEnd();
			    }
		    protected FloatValueAnimatorBuilder() {
			        this(false);
			    }
		    FloatValueAnimatorBuilder(boolean reverse) {
			        if (reverse) {
				            this.animator = ValueAnimator.ofFloat(1.0f, 0.0f);
				        } else {
				            this.animator = ValueAnimator.ofFloat(0.0f, 1.0f);
				        }
			    }
		    public FloatValueAnimatorBuilder delayBy(long millis) {
			        animator.setStartDelay(millis);
			        return this;
			    }
		    public FloatValueAnimatorBuilder duration(long millis) {
			        animator.setDuration(millis);
			        return this;
			    }
		    public FloatValueAnimatorBuilder interpolator(TimeInterpolator lerper) {
			        animator.setInterpolator(lerper);
			        return this;
			    }
		    public FloatValueAnimatorBuilder repeat(int times) {
			        animator.setRepeatCount(times);
			        return this;
			    }
		    public FloatValueAnimatorBuilder onUpdate(final UpdateListener listener) {
			        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
				            @Override
				            public void onAnimationUpdate(ValueAnimator animation) {
					                listener.onUpdate((float) animation.getAnimatedValue());
					            }
				        });
			        return this;
			    }
		    public FloatValueAnimatorBuilder onEnd(final EndListener listener) {
			        this.endListener = listener;
			        return this;
			    }
		    public ValueAnimator build() {
			        if (endListener != null) {
				            animator.addListener(new AnimatorListenerAdapter() {
					                @Override
					                public void onAnimationEnd(Animator animation) {
						                    endListener.onEnd();
						                }
					            });
				        }
			        return animator;
			    }
	}
	
	static class ReflectUtil {
		    ReflectUtil() {
			    }
		    static Object getPrivateField(Object source, String fieldName)
		            throws NoSuchFieldException, IllegalAccessException {
			        final java.lang.reflect.Field objectField = source.getClass().getDeclaredField(fieldName);
			        objectField.setAccessible(true);
			        return objectField.get(source);
			    }
	}
	static class TapTarget extends Activity {
		    final CharSequence title;
		    final CharSequence description;
		    float outerCircleAlpha = 0.96f;
		    int targetRadius = 44;
		    Rect bounds;
		    android.graphics.drawable.Drawable icon;
		    Typeface titleTypeface;
		    Typeface descriptionTypeface;
		
		
		    private int outerCircleColorRes = -1;
		    private int targetCircleColorRes = -1;
		    private int dimColorRes = -1;
		    private int titleTextColorRes = -1;
		    private int descriptionTextColorRes = -1;
		
		    private Integer outerCircleColor = null;
		    private Integer targetCircleColor = null;
		    private Integer dimColor = null;
		    private Integer titleTextColor = null;
		    private Integer descriptionTextColor = null;
		
		    private int titleTextDimen = -1;
		    private int descriptionTextDimen = -1;
		    private int titleTextSize = 20;
		    private int descriptionTextSize = 18;
		    int id = -1;
		    boolean drawShadow = false;
		    boolean cancelable = true;
		    boolean tintTarget = true;
		    boolean transparentTarget = false;
		    float descriptionTextAlpha = 0.54f;
		public static TapTarget forView(View view, CharSequence title) {
			        return forView(view, title, null);
			    }
		    public static TapTarget forView(View view, CharSequence title, CharSequence description) {
			        return new ViewTapTarget(view, title, description);
			    }
		    public static TapTarget forBounds(Rect bounds, CharSequence title) {
			        return forBounds(bounds, title, null);
			    }
		    public static TapTarget forBounds(Rect bounds, CharSequence title,  CharSequence description) {
			        return new TapTarget(bounds, title, description);
			    }
		    protected TapTarget(Rect bounds, CharSequence title,  CharSequence description) {
			        this(title, description);
			        if (bounds == null) {
				            throw new IllegalArgumentException("Cannot pass null bounds or title");
				        }
			        this.bounds = bounds;
			    }
		    protected TapTarget(CharSequence title,  CharSequence description) {
			        if (title == null) {
				            throw new IllegalArgumentException("Cannot pass null title");
				        }
			        this.title = title;
			        this.description = description;
			    }
		    public TapTarget transparentTarget(boolean transparent) {
			        this.transparentTarget = transparent;
			        return this;
			    }
		    public TapTarget outerCircleColor( int color) {
			        this.outerCircleColorRes = color;
			        return this;
			    }
		    public TapTarget outerCircleColorInt( int color) {
			        this.outerCircleColor = color;
			        return this;
			    }
		    public TapTarget outerCircleAlpha(float alpha) {
			        if (alpha < 0.0f || alpha > 1.0f) {
				            throw new IllegalArgumentException("Given an invalid alpha value: " + alpha);
				        }
			        this.outerCircleAlpha = alpha;
			        return this;
			    }
		    public TapTarget targetCircleColor( int color) {
			        this.targetCircleColorRes = color;
			        return this;
			    }
		    public TapTarget targetCircleColorInt( int color) {
			        this.targetCircleColor = color;
			        return this;
			    }
		    public TapTarget textColor( int color) {
			        this.titleTextColorRes = color;
			        this.descriptionTextColorRes = color;
			        return this;
			    }
		    public TapTarget textColorInt( int color) {
			        this.titleTextColor = color;
			        this.descriptionTextColor = color;
			        return this;
			    }
		    public TapTarget titleTextColor( int color) {
			        this.titleTextColorRes = color;
			        return this;
			    }
		    public TapTarget titleTextColorInt( int color) {
			        this.titleTextColor = color;
			        return this;
			    }
		    public TapTarget descriptionTextColor( int color) {
			        this.descriptionTextColorRes = color;
			        return this;
			    }
		    public TapTarget descriptionTextColorInt( int color) {
			        this.descriptionTextColor = color;
			        return this;
			    }
		    public TapTarget textTypeface(Typeface typeface) {
			        if (typeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
			        titleTypeface = typeface;
			        descriptionTypeface = typeface;
			        return this;
			    }
		    public TapTarget titleTypeface(Typeface titleTypeface) {
			        if (titleTypeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
			        this.titleTypeface = titleTypeface;
			        return this;
			    }
		    public TapTarget descriptionTypeface(Typeface descriptionTypeface) {
			        if (descriptionTypeface == null) throw new IllegalArgumentException("Cannot use a null typeface");
			        this.descriptionTypeface = descriptionTypeface;
			        return this;
			    }
		    public TapTarget titleTextSize(int sp) {
			        if (sp < 0) throw new IllegalArgumentException("Given negative text size");
			        this.titleTextSize = sp;
			        return this;
			    }
		    public TapTarget descriptionTextSize(int sp) {
			        if (sp < 0) throw new IllegalArgumentException("Given negative text size");
			        this.descriptionTextSize = sp;
			        return this;
			    }
		    public TapTarget titleTextDimen( int dimen) {
			        this.titleTextDimen = dimen;
			        return this;
			    }
		    public TapTarget descriptionTextAlpha(float descriptionTextAlpha) {
			        if (descriptionTextAlpha < 0 || descriptionTextAlpha > 1f) {
				            throw new IllegalArgumentException("Given an invalid alpha value: " + descriptionTextAlpha);
				        }
			        this.descriptionTextAlpha = descriptionTextAlpha;
			        return this;
			    }
		    public TapTarget descriptionTextDimen( int dimen) {
			        this.descriptionTextDimen = dimen;
			        return this;
			    }
		    public TapTarget dimColor( int color) {
			        this.dimColorRes = color;
			        return this;
			    }
		    public TapTarget dimColorInt( int color) {
			        this.dimColor = color;
			        return this;
			    }
		    public TapTarget drawShadow(boolean draw) {
			        this.drawShadow = draw;
			        return this;
			    }
		    public TapTarget cancelable(boolean status) {
			        this.cancelable = status;
			        return this;
			    }
		    public TapTarget tintTarget(boolean tint) {
			        this.tintTarget = tint;
			        return this;
			    }
		    public TapTarget icon(android.graphics.drawable.Drawable icon) {
			        return icon(icon, false);
			    }
		    public TapTarget icon(android.graphics.drawable.Drawable icon, boolean hasSetBounds) {
			        if (icon == null) throw new IllegalArgumentException("Cannot use null drawable");
			        this.icon = icon;
			        if (!hasSetBounds) {
				            this.icon.setBounds(new Rect(0, 0, this.icon.getIntrinsicWidth(), this.icon.getIntrinsicHeight()));
				        }
			        return this;
			    }
		    public TapTarget id(int id) {
			        this.id = id;
			        return this;
			    }
		    public TapTarget targetRadius(int targetRadius) {
			        this.targetRadius = targetRadius;
			        return this;
			    }
		    public int id() {
			        return id;
			    }
		    public void onReady(Runnable runnable) {
			        runnable.run();
			    }
		    public Rect bounds() {
			        if (bounds == null) {
				            throw new IllegalStateException("Requesting bounds that are not set! Make sure your target is ready");
				        }
			        return bounds;
			    }
		    Integer outerCircleColorInt(Context context) {
			        return colorResOrInt(context, outerCircleColor, outerCircleColorRes);
			    }
		    Integer targetCircleColorInt(Context context) {
			        return colorResOrInt(context, targetCircleColor, targetCircleColorRes);
			    }
		    Integer dimColorInt(Context context) {
			        return colorResOrInt(context, dimColor, dimColorRes);
			    }
		    Integer titleTextColorInt(Context context) {
			        return colorResOrInt(context, titleTextColor, titleTextColorRes);
			    }
		
		    Integer descriptionTextColorInt(Context context) {
			        return colorResOrInt(context, descriptionTextColor, descriptionTextColorRes);
			    }
		    int titleTextSizePx(Context context) {
			        return dimenOrSize(context, titleTextSize, titleTextDimen);
			    }
		    int descriptionTextSizePx(Context context) {
			        return dimenOrSize(context, descriptionTextSize, descriptionTextDimen);
			    }
		
		    private Integer colorResOrInt(Context context, Integer value,  int resource) {
			        if (resource != -1) {
				            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
					                return context.getColor(resource);
					            }
				        }
			        return value;
			    }
		    private int dimenOrSize(Context context, int size,  int dimen) {
			        if (dimen != -1) {
				            return context.getResources().getDimensionPixelSize(dimen);
				        }
			        return UiUtil.sp(context, size);
			    }
	}
	static class TapTargetView extends View {
		    private boolean isDismissed = false;
		    private boolean isDismissing = false;
		    private boolean isInteractable = true;
		
		    final int TARGET_PADDING;
		    final int TARGET_RADIUS;
		    final int TARGET_PULSE_RADIUS;
		    final int TEXT_PADDING;
		    final int TEXT_SPACING;
		    final int TEXT_MAX_WIDTH;
		    final int TEXT_POSITIONING_BIAS;
		    final int CIRCLE_PADDING;
		    final int GUTTER_DIM;
		    final int SHADOW_DIM;
		    final int SHADOW_JITTER_DIM;
		
		
		    final ViewGroup boundingParent;
		    final ViewManager parent;
		    final TapTarget target;
		    final Rect targetBounds;
		
		    final TextPaint titlePaint;
		    final TextPaint descriptionPaint;
		    final Paint outerCirclePaint;
		    final Paint outerCircleShadowPaint;
		    final Paint targetCirclePaint;
		    final Paint targetCirclePulsePaint;
		
		    CharSequence title;
		
		    StaticLayout titleLayout;
		
		    CharSequence description;
		
		    StaticLayout descriptionLayout;
		    boolean isDark;
		    boolean debug;
		    boolean shouldTintTarget;
		    boolean shouldDrawShadow;
		    boolean cancelable;
		    boolean visible;
		
		    // Debug related variables
		
		    SpannableStringBuilder debugStringBuilder;
		
		    DynamicLayout debugLayout;
		
		    TextPaint debugTextPaint;
		
		    Paint debugPaint;
		
		    // Drawing properties
		    Rect drawingBounds;
		    Rect textBounds;
		
		    Path outerCirclePath;
		    float outerCircleRadius;
		    int calculatedOuterCircleRadius;
		    int[] outerCircleCenter;
		    int outerCircleAlpha;
		
		    float targetCirclePulseRadius;
		    int targetCirclePulseAlpha;
		
		    float targetCircleRadius;
		    int targetCircleAlpha;
		
		    int textAlpha;
		    int dimColor;
		
		    float lastTouchX;
		    float lastTouchY;
		
		    int topBoundary;
		    int bottomBoundary;
		
		    Bitmap tintedTarget;
		
		    Listener listener;
		
		
		    ViewOutlineProvider outlineProvider;
		
		    public static TapTargetView showFor(Activity activity, TapTarget target) {
			        return showFor(activity, target, null);
			    }
		
		    public static TapTargetView showFor(Activity activity, TapTarget target, Listener listener) {
			        if (activity == null) throw new IllegalArgumentException("Activity is null");
			
			        final ViewGroup decor = (ViewGroup) activity.getWindow().getDecorView();
			        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
			                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
			        final ViewGroup content = (ViewGroup) decor.findViewById(android.R.id.content);
			        final TapTargetView tapTargetView = new TapTargetView(activity, decor, content, target, listener);
			        decor.addView(tapTargetView, layoutParams);
			
			        return tapTargetView;
			    }
		
		    public static TapTargetView showFor(Dialog dialog, TapTarget target) {
			        return showFor(dialog, target, null);
			    }
		
		    public static TapTargetView showFor(Dialog dialog, TapTarget target, Listener listener) {
			        if (dialog == null) throw new IllegalArgumentException("Dialog is null");
			
			        final Context context = dialog.getContext();
			        final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
			        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
			        params.type = WindowManager.LayoutParams.TYPE_APPLICATION;
			        params.format = PixelFormat.RGBA_8888;
			        params.flags = 0;
			        params.gravity = Gravity.START | Gravity.TOP;
			        params.x = 0;
			        params.y = 0;
			        params.width = WindowManager.LayoutParams.MATCH_PARENT;
			        params.height = WindowManager.LayoutParams.MATCH_PARENT;
			
			        final TapTargetView tapTargetView = new TapTargetView(context, windowManager, null, target, listener);
			        windowManager.addView(tapTargetView, params);
			
			        return tapTargetView;
			    }
		public static class Listener {
			        /** Signals that the user has clicked inside of the target **/
			        public void onTargetClick(TapTargetView view) {
				            view.dismiss(true);
				        }
			
			        /** Signals that the user has long clicked inside of the target **/
			        public void onTargetLongClick(TapTargetView view) {
				            onTargetClick(view);
				        }
			
			        /** If cancelable, signals that the user has clicked outside of the outer circle **/
			        public void onTargetCancel(TapTargetView view) {
				            view.dismiss(false);
				        }
			
			        /** Signals that the user clicked on the outer circle portion of the tap target **/
			        public void onOuterCircleClick(TapTargetView view) {
				            // no-op as default
				        }
			
			        /**
         * Signals that the tap target has been dismissed
         * @param userInitiated Whether the user caused this action
         *
         *
         */
			        public void onTargetDismissed(TapTargetView view, boolean userInitiated) {
				        }
			    }
		
		    final FloatValueAnimatorBuilder.UpdateListener expandContractUpdateListener = new FloatValueAnimatorBuilder.UpdateListener() {
			        @Override
			        public void onUpdate(float lerpTime) {
				            final float newOuterCircleRadius = calculatedOuterCircleRadius * lerpTime;
				            final boolean expanding = newOuterCircleRadius > outerCircleRadius;
				            if (!expanding) {
					                // When contracting we need to invalidate the old drawing bounds. Otherwise
					                // you will see artifacts as the circle gets smaller
					                calculateDrawingBounds();
					            }
				
				            final float targetAlpha = target.outerCircleAlpha * 255;
				            outerCircleRadius = newOuterCircleRadius;
				            outerCircleAlpha = (int) Math.min(targetAlpha, (lerpTime * 1.5f * targetAlpha));
				            outerCirclePath.reset();
				            outerCirclePath.addCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, Path.Direction.CW);
				
				            targetCircleAlpha = (int) Math.min(255.0f, (lerpTime * 1.5f * 255.0f));
				
				            if (expanding) {
					                targetCircleRadius = TARGET_RADIUS * Math.min(1.0f, lerpTime * 1.5f);
					            } else {
					                targetCircleRadius = TARGET_RADIUS * lerpTime;
					                targetCirclePulseRadius *= lerpTime;
					            }
				
				            textAlpha = (int) (delayedLerp(lerpTime, 0.7f) * 255);
				
				            if (expanding) {
					                calculateDrawingBounds();
					            }
				
				            invalidateViewAndOutline(drawingBounds);
				        }
			    };
		
		    final ValueAnimator expandAnimation = new FloatValueAnimatorBuilder()
		            .duration(250)
		            .delayBy(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    expandContractUpdateListener.onUpdate(lerpTime);
				                }
			            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
			                @Override
			                public void onEnd() {
				                    pulseAnimation.start();
				                    isInteractable = true;
				                }
			            })
		            .build();
		
		    final ValueAnimator pulseAnimation = new FloatValueAnimatorBuilder()
		            .duration(1000)
		            .repeat(ValueAnimator.INFINITE)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    final float pulseLerp = delayedLerp(lerpTime, 0.5f);
				                    targetCirclePulseRadius = (1.0f + pulseLerp) * TARGET_RADIUS;
				                    targetCirclePulseAlpha = (int) ((1.0f - pulseLerp) * 255);
				                    targetCircleRadius = TARGET_RADIUS + halfwayLerp(lerpTime) * TARGET_PULSE_RADIUS;
				
				                    if (outerCircleRadius != calculatedOuterCircleRadius) {
					                        outerCircleRadius = calculatedOuterCircleRadius;
					                    }
				
				                    calculateDrawingBounds();
				                    invalidateViewAndOutline(drawingBounds);
				                }
			            })
		            .build();
		
		    final ValueAnimator dismissAnimation = new FloatValueAnimatorBuilder(true)
		            .duration(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    expandContractUpdateListener.onUpdate(lerpTime);
				                }
			            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
			                @Override
			                public void onEnd() {
				                    onDismiss(true);
				                    ViewUtil.removeView(parent, TapTargetView.this);
				                }
			            })
		            .build();
		
		    private final ValueAnimator dismissConfirmAnimation = new FloatValueAnimatorBuilder()
		            .duration(250)
		            .interpolator(new AccelerateDecelerateInterpolator())
		            .onUpdate(new FloatValueAnimatorBuilder.UpdateListener() {
			                @Override
			                public void onUpdate(float lerpTime) {
				                    final float spedUpLerp = Math.min(1.0f, lerpTime * 2.0f);
				                    outerCircleRadius = calculatedOuterCircleRadius * (1.0f + (spedUpLerp * 0.2f));
				                    outerCircleAlpha = (int) ((1.0f - spedUpLerp) * target.outerCircleAlpha * 255.0f);
				                    outerCirclePath.reset();
				                    outerCirclePath.addCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, Path.Direction.CW);
				                    targetCircleRadius = (1.0f - lerpTime) * TARGET_RADIUS;
				                    targetCircleAlpha = (int) ((1.0f - lerpTime) * 255.0f);
				                    targetCirclePulseRadius = (1.0f + lerpTime) * TARGET_RADIUS;
				                    targetCirclePulseAlpha = (int) ((1.0f - lerpTime) * targetCirclePulseAlpha);
				                    textAlpha = (int) ((1.0f - spedUpLerp) * 255.0f);
				                    calculateDrawingBounds();
				                    invalidateViewAndOutline(drawingBounds);
				                }
			            })
		            .onEnd(new FloatValueAnimatorBuilder.EndListener() {
			                @Override
			                public void onEnd() {
				                    onDismiss(true);
				                    ViewUtil.removeView(parent, TapTargetView.this);
				                }
			            })
		            .build();
		
		    private ValueAnimator[] animators = new ValueAnimator[]
		            {expandAnimation, pulseAnimation, dismissConfirmAnimation, dismissAnimation};
		
		    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
		    public TapTargetView(final Context context,
		                         final ViewManager parent,
		                          final ViewGroup boundingParent,
		                         final TapTarget target,
		                          final Listener userListener) {
			        super(context);
			        if (target == null) throw new IllegalArgumentException("Target cannot be null");
			
			        this.target = target;
			        this.parent = parent;
			        this.boundingParent = boundingParent;
			        this.listener = userListener != null ? userListener : new Listener();
			        this.title = target.title;
			        this.description = target.description;
			
			        TARGET_PADDING = UiUtil.dp(context, 20);
			        CIRCLE_PADDING = UiUtil.dp(context, 40);
			        TARGET_RADIUS = UiUtil.dp(context, target.targetRadius);
			        TEXT_PADDING = UiUtil.dp(context, 40);
			        TEXT_SPACING = UiUtil.dp(context, 8);
			        TEXT_MAX_WIDTH = UiUtil.dp(context, 360);
			        TEXT_POSITIONING_BIAS = UiUtil.dp(context, 20);
			        GUTTER_DIM = UiUtil.dp(context, 88);
			        SHADOW_DIM = UiUtil.dp(context, 8);
			        SHADOW_JITTER_DIM = UiUtil.dp(context, 1);
			        TARGET_PULSE_RADIUS = (int) (0.1f * TARGET_RADIUS);
			
			        outerCirclePath = new Path();
			        targetBounds = new Rect();
			        drawingBounds = new Rect();
			
			        titlePaint = new TextPaint();
			        titlePaint.setTextSize(target.titleTextSizePx(context));
			        titlePaint.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
			        titlePaint.setAntiAlias(true);
			
			        descriptionPaint = new TextPaint();
			        descriptionPaint.setTextSize(target.descriptionTextSizePx(context));
			        descriptionPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL));
			        descriptionPaint.setAntiAlias(true);
			        descriptionPaint.setAlpha((int) (0.54f * 255.0f));
			
			        outerCirclePaint = new Paint();
			        outerCirclePaint.setAntiAlias(true);
			        outerCirclePaint.setAlpha((int) (target.outerCircleAlpha * 255.0f));
			
			        outerCircleShadowPaint = new Paint();
			        outerCircleShadowPaint.setAntiAlias(true);
			        outerCircleShadowPaint.setAlpha(50);
			        outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
			        outerCircleShadowPaint.setStrokeWidth(SHADOW_JITTER_DIM);
			        outerCircleShadowPaint.setColor(Color.BLACK);
			
			        targetCirclePaint = new Paint();
			        targetCirclePaint.setAntiAlias(true);
			
			        targetCirclePulsePaint = new Paint();
			        targetCirclePulsePaint.setAntiAlias(true);
			
			        applyTargetOptions(context);
			
			        globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
				            @Override
				            public void onGlobalLayout() {
					                if (isDismissing) {
						                    return;
						                }
					                updateTextLayouts();
					                target.onReady(new Runnable() {
						                    @Override
						                    public void run() {
							                        final int[] offset = new int[2];
							
							                        targetBounds.set(target.bounds());
							
							                        getLocationOnScreen(offset);
							                        targetBounds.offset(-offset[0], -offset[1]);
							
							                        if (boundingParent != null) {
								                            final WindowManager windowManager
								                                    = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
								                            final DisplayMetrics displayMetrics = new DisplayMetrics();
								                            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
								
								                            final Rect rect = new Rect();
								                            boundingParent.getWindowVisibleDisplayFrame(rect);
								
								                            // We bound the boundaries to be within the screen's coordinates to
								                            // handle the case where the layout bounds do not match
								                            // (like when FLAG_LAYOUT_NO_LIMITS is specified)
								                            topBoundary = Math.max(0, rect.top);
								                            bottomBoundary = Math.min(rect.bottom, displayMetrics.heightPixels);
								                        }
							
							                        drawTintedTarget();
							                        requestFocus();
							                        calculateDimensions();
							
							                        startExpandAnimation();
							                    }
						                });
					            }
				        };
			
			        getViewTreeObserver().addOnGlobalLayoutListener(globalLayoutListener);
			
			        setFocusableInTouchMode(true);
			        setClickable(true);
			        setOnClickListener(new OnClickListener() {
				            @Override
				            public void onClick(View v) {
					                if (listener == null || outerCircleCenter == null || !isInteractable) return;
					
					                final boolean clickedInTarget =
					                        distance(targetBounds.centerX(), targetBounds.centerY(), (int) lastTouchX, (int) lastTouchY) <= targetCircleRadius;
					                final double distanceToOuterCircleCenter = distance(outerCircleCenter[0], outerCircleCenter[1],
					                        (int) lastTouchX, (int) lastTouchY);
					                final boolean clickedInsideOfOuterCircle = distanceToOuterCircleCenter <= outerCircleRadius;
					
					                if (clickedInTarget) {
						                    isInteractable = false;
						                    listener.onTargetClick(TapTargetView.this);
						                } else if (clickedInsideOfOuterCircle) {
						                    listener.onOuterCircleClick(TapTargetView.this);
						                } else if (cancelable) {
						                    isInteractable = false;
						                    listener.onTargetCancel(TapTargetView.this);
						                }
					            }
				        });
			
			        setOnLongClickListener(new OnLongClickListener() {
				            @Override
				            public boolean onLongClick(View v) {
					                if (listener == null) return false;
					
					                if (targetBounds.contains((int) lastTouchX, (int) lastTouchY)) {
						                    listener.onTargetLongClick(TapTargetView.this);
						                    return true;
						                }
					
					                return false;
					            }
				        });
			    }
		
		    private void startExpandAnimation() {
			        if (!visible) {
				            isInteractable = false;
				            expandAnimation.start();
				            visible = true;
				        }
			    }
		
		    protected void applyTargetOptions(Context context) {
			        shouldTintTarget = target.tintTarget;
			        shouldDrawShadow = target.drawShadow;
			        cancelable = target.cancelable;
			
			        // We can't clip out portions of a view outline, so if the user specified a transparent
			        // target, we need to fallback to drawing a jittered shadow approximation
			        if (shouldDrawShadow && Build.VERSION.SDK_INT >= 21 && !target.transparentTarget) {
				            outlineProvider = new ViewOutlineProvider() {
					                @Override
					                public void getOutline(View view, Outline outline) {
						                    if (outerCircleCenter == null) return;
						                    outline.setOval(
						                            (int) (outerCircleCenter[0] - outerCircleRadius), (int) (outerCircleCenter[1] - outerCircleRadius),
						                            (int) (outerCircleCenter[0] + outerCircleRadius), (int) (outerCircleCenter[1] + outerCircleRadius));
						                    outline.setAlpha(outerCircleAlpha / 255.0f);
						                    if (Build.VERSION.SDK_INT >= 22) {
							                        outline.offset(0, SHADOW_DIM);
							                    }
						                }
					            };
				
				            setOutlineProvider(outlineProvider);
				            setElevation(SHADOW_DIM);
				        }
			
			        if (shouldDrawShadow && outlineProvider == null && Build.VERSION.SDK_INT < 18) {
				            setLayerType(LAYER_TYPE_SOFTWARE, null);
				        } else {
				            setLayerType(LAYER_TYPE_HARDWARE, null);
				        }
			
			        final android.content.res.Resources.Theme theme = context.getTheme();
			        isDark = UiUtil.themeIntAttr(context, "isLightTheme") == 0;
			
			        final Integer outerCircleColor = target.outerCircleColorInt(context);
			        if (outerCircleColor != null) {
				            outerCirclePaint.setColor(outerCircleColor);
				        } else if (theme != null) {
				            outerCirclePaint.setColor(UiUtil.themeIntAttr(context, "colorPrimary"));
				        } else {
				            outerCirclePaint.setColor(Color.WHITE);
				        }
			
			        final Integer targetCircleColor = target.targetCircleColorInt(context);
			        if (targetCircleColor != null) {
				            targetCirclePaint.setColor(targetCircleColor);
				        } else {
				            targetCirclePaint.setColor(isDark ? Color.BLACK : Color.WHITE);
				        }
			
			        if (target.transparentTarget) {
				            targetCirclePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
				        }
			
			        targetCirclePulsePaint.setColor(targetCirclePaint.getColor());
			
			        final Integer targetDimColor = target.dimColorInt(context);
			        if (targetDimColor != null) {
				            dimColor = UiUtil.setAlpha(targetDimColor, 0.3f);
				        } else {
				            dimColor = -1;
				        }
			
			        final Integer titleTextColor = target.titleTextColorInt(context);
			        if (titleTextColor != null) {
				            titlePaint.setColor(titleTextColor);
				        } else {
				            titlePaint.setColor(isDark ? Color.BLACK : Color.WHITE);
				        }
			
			        final Integer descriptionTextColor = target.descriptionTextColorInt(context);
			        if (descriptionTextColor != null) {
				            descriptionPaint.setColor(descriptionTextColor);
				        } else {
				            descriptionPaint.setColor(titlePaint.getColor());
				        }
			
			        if (target.titleTypeface != null) {
				            titlePaint.setTypeface(target.titleTypeface);
				        }
			
			        if (target.descriptionTypeface != null) {
				            descriptionPaint.setTypeface(target.descriptionTypeface);
				        }
			    }
		
		    @Override
		    protected void onDetachedFromWindow() {
			        super.onDetachedFromWindow();
			        onDismiss(false);
			    }
		
		    void onDismiss(boolean userInitiated) {
			        if (isDismissed) return;
			
			        isDismissing = false;
			        isDismissed = true;
			
			        for (final ValueAnimator animator : animators) {
				            animator.cancel();
				            animator.removeAllUpdateListeners();
				        }
			        ViewUtil.removeOnGlobalLayoutListener(getViewTreeObserver(), globalLayoutListener);
			        visible = false;
			
			        if (listener != null) {
				            listener.onTargetDismissed(this, userInitiated);
				        }
			    }
		
		    @Override
		    protected void onDraw(Canvas c) {
			        if (isDismissed || outerCircleCenter == null) return;
			
			        if (topBoundary > 0 && bottomBoundary > 0) {
				            c.clipRect(0, topBoundary, getWidth(), bottomBoundary);
				        }
			
			        if (dimColor != -1) {
				            c.drawColor(dimColor);
				        }
			
			        int saveCount;
			        outerCirclePaint.setAlpha(outerCircleAlpha);
			        if (shouldDrawShadow && outlineProvider == null) {
				            saveCount = c.save();
				            {
					                c.clipPath(outerCirclePath, Region.Op.DIFFERENCE);
					                drawJitteredShadow(c);
					            }
				            c.restoreToCount(saveCount);
				        }
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], outerCircleRadius, outerCirclePaint);
			
			        targetCirclePaint.setAlpha(targetCircleAlpha);
			        if (targetCirclePulseAlpha > 0) {
				            targetCirclePulsePaint.setAlpha(targetCirclePulseAlpha);
				            c.drawCircle(targetBounds.centerX(), targetBounds.centerY(),
				                    targetCirclePulseRadius, targetCirclePulsePaint);
				        }
			        c.drawCircle(targetBounds.centerX(), targetBounds.centerY(),
			                targetCircleRadius, targetCirclePaint);
			
			        saveCount = c.save();
			        {
				            c.translate(textBounds.left, textBounds.top);
				            titlePaint.setAlpha(textAlpha);
				            if (titleLayout != null) {
					                titleLayout.draw(c);
					            }
				
				            if (descriptionLayout != null && titleLayout != null) {
					                c.translate(0, titleLayout.getHeight() + TEXT_SPACING);
					                descriptionPaint.setAlpha((int) (target.descriptionTextAlpha * textAlpha));
					                descriptionLayout.draw(c);
					            }
				        }
			        c.restoreToCount(saveCount);
			
			        saveCount = c.save();
			        {
				            if (tintedTarget != null) {
					                c.translate(targetBounds.centerX() - tintedTarget.getWidth() / 2,
					                        targetBounds.centerY() - tintedTarget.getHeight() / 2);
					                c.drawBitmap(tintedTarget, 0, 0, targetCirclePaint);
					            } else if (target.icon != null) {
					                c.translate(targetBounds.centerX() - target.icon.getBounds().width() / 2,
					                        targetBounds.centerY() - target.icon.getBounds().height() / 2);
					                target.icon.setAlpha(targetCirclePaint.getAlpha());
					                target.icon.draw(c);
					            }
				        }
			        c.restoreToCount(saveCount);
			
			        if (debug) {
				            drawDebugInformation(c);
				        }
			    }
		
		    @Override
		    public boolean onTouchEvent(MotionEvent e) {
			        lastTouchX = e.getX();
			        lastTouchY = e.getY();
			        return super.onTouchEvent(e);
			    }
		
		    @Override
		    public boolean onKeyDown(int keyCode, KeyEvent event) {
			        if (isVisible() && cancelable && keyCode == KeyEvent.KEYCODE_BACK) {
				            event.startTracking();
				            return true;
				        }
			
			        return false;
			    }
		
		    @Override
		    public boolean onKeyUp(int keyCode, KeyEvent event) {
			        if (isVisible() && isInteractable && cancelable
			                && keyCode == KeyEvent.KEYCODE_BACK && event.isTracking() && !event.isCanceled()) {
				            isInteractable = false;
				
				            if (listener != null) {
					                listener.onTargetCancel(this);
					            } else {
					                new Listener().onTargetCancel(this);
					            }
				
				            return true;
				        }
			
			        return false;
			    }
		
		    /**
     * Dismiss this view
     * @param tappedTarget If the user tapped the target or not
     *                     (results in different dismiss animations)
     */
		    public void dismiss(boolean tappedTarget) {
			        isDismissing = true;
			        pulseAnimation.cancel();
			        expandAnimation.cancel();
			        if (tappedTarget) {
				            dismissConfirmAnimation.start();
				        } else {
				            dismissAnimation.start();
				        }
			    }
		
		    /** Specify whether to draw a wireframe around the view, useful for debugging **/
		    public void setDrawDebug(boolean status) {
			        if (debug != status) {
				            debug = status;
				            postInvalidate();
				        }
			    }
		
		    /** Returns whether this view is visible or not **/
		    public boolean isVisible() {
			        return !isDismissed && visible;
			    }
		
		    void drawJitteredShadow(Canvas c) {
			        final float baseAlpha = 0.20f * outerCircleAlpha;
			        outerCircleShadowPaint.setStyle(Paint.Style.FILL_AND_STROKE);
			        outerCircleShadowPaint.setAlpha((int) baseAlpha);
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1] + SHADOW_DIM, outerCircleRadius, outerCircleShadowPaint);
			        outerCircleShadowPaint.setStyle(Paint.Style.STROKE);
			        final int numJitters = 7;
			        for (int i = numJitters - 1; i > 0; --i) {
				            outerCircleShadowPaint.setAlpha((int) ((i / (float) numJitters) * baseAlpha));
				            c.drawCircle(outerCircleCenter[0], outerCircleCenter[1] + SHADOW_DIM ,
				                    outerCircleRadius + (numJitters - i) * SHADOW_JITTER_DIM , outerCircleShadowPaint);
				        }
			    }
		
		    void drawDebugInformation(Canvas c) {
			        if (debugPaint == null) {
				            debugPaint = new Paint();
				            debugPaint.setARGB(255, 255, 0, 0);
				            debugPaint.setStyle(Paint.Style.STROKE);
				            debugPaint.setStrokeWidth(UiUtil.dp(getContext(), 1));
				        }
			
			        if (debugTextPaint == null) {
				            debugTextPaint = new TextPaint();
				            debugTextPaint.setColor(0xFFFF0000);
				            debugTextPaint.setTextSize(UiUtil.sp(getContext(), 16));
				        }
			
			        // Draw wireframe
			        debugPaint.setStyle(Paint.Style.STROKE);
			        c.drawRect(textBounds, debugPaint);
			        c.drawRect(targetBounds, debugPaint);
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], 10, debugPaint);
			        c.drawCircle(outerCircleCenter[0], outerCircleCenter[1], calculatedOuterCircleRadius - CIRCLE_PADDING, debugPaint);
			        c.drawCircle(targetBounds.centerX(), targetBounds.centerY(), TARGET_RADIUS + TARGET_PADDING, debugPaint);
			
			        // Draw positions and dimensions
			        debugPaint.setStyle(Paint.Style.FILL);
			        final String debugText =
			                "Text bounds: " + textBounds.toShortString() + "\n" + "Target bounds: " + targetBounds.toShortString() + "\n" + "Center: " + outerCircleCenter[0] + " " + outerCircleCenter[1] + "\n" + "View size: " + getWidth() + " " + getHeight() + "\n" + "Target bounds: " + targetBounds.toShortString();
			
			        if (debugStringBuilder == null) {
				            debugStringBuilder = new SpannableStringBuilder(debugText);
				        } else {
				            debugStringBuilder.clear();
				            debugStringBuilder.append(debugText);
				        }
			
			        if (debugLayout == null) {
				            debugLayout = new DynamicLayout(debugText, debugTextPaint, getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
				        }
			
			        final int saveCount = c.save();
			        {
				            debugPaint.setARGB(220, 0, 0, 0);
				            c.translate(0.0f, topBoundary);
				            c.drawRect(0.0f, 0.0f, debugLayout.getWidth(), debugLayout.getHeight(), debugPaint);
				            debugPaint.setARGB(255, 255, 0, 0);
				            debugLayout.draw(c);
				        }
			        c.restoreToCount(saveCount);
			    }
		
		    void drawTintedTarget() {
			        final android.graphics.drawable.Drawable icon = target.icon;
			        if (!shouldTintTarget || icon == null) {
				            tintedTarget = null;
				            return;
				        }
			
			        if (tintedTarget != null) return;
			
			        tintedTarget = Bitmap.createBitmap(icon.getIntrinsicWidth(), icon.getIntrinsicHeight(),
			                Bitmap.Config.ARGB_8888);
			        final Canvas canvas = new Canvas(tintedTarget);
			        icon.setColorFilter(new PorterDuffColorFilter(
			                outerCirclePaint.getColor(), PorterDuff.Mode.SRC_ATOP));
			        icon.draw(canvas);
			        icon.setColorFilter(null);
			    }
		
		    void updateTextLayouts() {
			        final int textWidth = Math.min(getWidth(), TEXT_MAX_WIDTH) - TEXT_PADDING * 2;
			        if (textWidth <= 0) {
				            return;
				        }
			
			        titleLayout = new StaticLayout(title, titlePaint, textWidth,
			                Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
			
			        if (description != null) {
				            descriptionLayout = new StaticLayout(description, descriptionPaint, textWidth,
				                    Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
				        } else {
				            descriptionLayout = null;
				        }
			    }
		
		    float halfwayLerp(float lerp) {
			        if (lerp < 0.5f) {
				            return lerp / 0.5f;
				        }
			
			        return (1.0f - lerp) / 0.5f;
			    }
		
		    float delayedLerp(float lerp, float threshold) {
			        if (lerp < threshold) {
				            return 0.0f;
				        }
			
			        return (lerp - threshold) / (1.0f - threshold);
			    }
		
		    void calculateDimensions() {
			        textBounds = getTextBounds();
			        outerCircleCenter = getOuterCircleCenterPoint();
			        calculatedOuterCircleRadius = getOuterCircleRadius(outerCircleCenter[0], outerCircleCenter[1], textBounds, targetBounds);
			    }
		
		    void calculateDrawingBounds() {
			        if (outerCircleCenter == null) {
				            // Called dismiss before we got a chance to display the tap target
				            // So we have no center -> cant determine the drawing bounds
				            return;
				        }
			        drawingBounds.left = (int) Math.max(0, outerCircleCenter[0] - outerCircleRadius);
			        drawingBounds.top = (int) Math.min(0, outerCircleCenter[1] - outerCircleRadius);
			        drawingBounds.right = (int) Math.min(getWidth(),
			                outerCircleCenter[0] + outerCircleRadius + CIRCLE_PADDING);
			        drawingBounds.bottom = (int) Math.min(getHeight(),
			                outerCircleCenter[1] + outerCircleRadius + CIRCLE_PADDING);
			    }
		
		    int getOuterCircleRadius(int centerX, int centerY, Rect textBounds, Rect targetBounds) {
			        final int targetCenterX = targetBounds.centerX();
			        final int targetCenterY = targetBounds.centerY();
			        final int expandedRadius = (int) (1.1f * TARGET_RADIUS);
			        final Rect expandedBounds = new Rect(targetCenterX, targetCenterY, targetCenterX, targetCenterY);
			        expandedBounds.inset(-expandedRadius, -expandedRadius);
			
			        final int textRadius = maxDistanceToPoints(centerX, centerY, textBounds);
			        final int targetRadius = maxDistanceToPoints(centerX, centerY, expandedBounds);
			        return Math.max(textRadius, targetRadius) + CIRCLE_PADDING;
			    }
		
		    Rect getTextBounds() {
			        final int totalTextHeight = getTotalTextHeight();
			        final int totalTextWidth = getTotalTextWidth();
			
			        final int possibleTop = targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight;
			        final int top;
			        if (possibleTop > topBoundary) {
				            top = possibleTop;
				        } else {
				            top = targetBounds.centerY() + TARGET_RADIUS + TARGET_PADDING;
				        }
			
			        final int relativeCenterDistance = (getWidth() / 2) - targetBounds.centerX();
			        final int bias = relativeCenterDistance < 0 ? -TEXT_POSITIONING_BIAS : TEXT_POSITIONING_BIAS;
			        final int left = Math.max(TEXT_PADDING, targetBounds.centerX() - bias - totalTextWidth);
			        final int right = Math.min(getWidth() - TEXT_PADDING, left + totalTextWidth);
			        return new Rect(left, top, right, top + totalTextHeight);
			    }
		
		    int[] getOuterCircleCenterPoint() {
			        if (inGutter(targetBounds.centerY())) {
				            return new int[]{targetBounds.centerX(), targetBounds.centerY()};
				        }
			
			        final int targetRadius = Math.max(targetBounds.width(), targetBounds.height()) / 2 + TARGET_PADDING;
			        final int totalTextHeight = getTotalTextHeight();
			
			        final boolean onTop = targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight > 0;
			
			        final int left = Math.min(textBounds.left, targetBounds.left - targetRadius);
			        final int right = Math.max(textBounds.right, targetBounds.right + targetRadius);
			        final int titleHeight = titleLayout == null ? 0 : titleLayout.getHeight();
			        final int centerY = onTop ?
			                targetBounds.centerY() - TARGET_RADIUS - TARGET_PADDING - totalTextHeight + titleHeight
			                :
			                targetBounds.centerY() + TARGET_RADIUS + TARGET_PADDING + titleHeight;
			
			        return new int[] { (left + right) / 2, centerY };
			    }
		
		    int getTotalTextHeight() {
			        if (titleLayout == null) {
				            return 0;
				        }
			
			        if (descriptionLayout == null) {
				            return titleLayout.getHeight() + TEXT_SPACING;
				        }
			
			        return titleLayout.getHeight() + descriptionLayout.getHeight() + TEXT_SPACING;
			    }
		
		    int getTotalTextWidth() {
			        if (titleLayout == null) {
				            return 0;
				        }
			
			        if (descriptionLayout == null) {
				            return titleLayout.getWidth();
				        }
			
			        return Math.max(titleLayout.getWidth(), descriptionLayout.getWidth());
			    }
		    boolean inGutter(int y) {
			        if (bottomBoundary > 0) {
				            return y < GUTTER_DIM || y > bottomBoundary - GUTTER_DIM;
				        } else {
				            return y < GUTTER_DIM || y > getHeight() - GUTTER_DIM;
				        }
			    }
		    int maxDistanceToPoints(int x1, int y1, Rect bounds) {
			        final double tl = distance(x1, y1, bounds.left, bounds.top);
			        final double tr = distance(x1, y1, bounds.right, bounds.top);
			        final double bl = distance(x1, y1, bounds.left, bounds.bottom);
			        final double br = distance(x1, y1, bounds.right, bounds.bottom);
			        return (int) Math.max(tl, Math.max(tr, Math.max(bl, br)));
			    }
		    double distance(int x1, int y1, int x2, int y2) {
			        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
			    }
		    void invalidateViewAndOutline(Rect bounds) {
			        invalidate(bounds);
			        if (outlineProvider != null && Build.VERSION.SDK_INT >= 21) {
				            invalidateOutline();
				        }
			    }
	}
	
	static class ViewUtil {
		
		    ViewUtil() {}
		
		    private static boolean isLaidOut(View view) {
			        return true;
			    }
		    static void onLaidOut(final View view, final Runnable runnable) {
			        if (isLaidOut(view)) {
				            runnable.run();
				            return;
				        }
			        final ViewTreeObserver observer = view.getViewTreeObserver();
			        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
				            @Override
				            public void onGlobalLayout() {
					                final ViewTreeObserver trueObserver;
					                if (observer.isAlive()) {
						                    trueObserver = observer;
						                } else {
						                    trueObserver = view.getViewTreeObserver();
						                }
					                removeOnGlobalLayoutListener(trueObserver, this);
					                runnable.run();
					            }
				        });
			    }
		    @SuppressWarnings("deprecation")
		    static void removeOnGlobalLayoutListener(ViewTreeObserver observer,
		                                             ViewTreeObserver.OnGlobalLayoutListener listener) {
			        if (Build.VERSION.SDK_INT >= 16) {
				            observer.removeOnGlobalLayoutListener(listener);
				        } else {
				            observer.removeGlobalOnLayoutListener(listener);
				        }
			    }
		    static void removeView(ViewManager parent, View child) {
			        if (parent == null || child == null) {
				            return;
				        }
			        try {
				            parent.removeView(child);
				        } catch (Exception ignored) {
				        }
			    }
	}
	
	static class ViewTapTarget extends TapTarget {
		    final View view;
		
		    ViewTapTarget(View view, CharSequence title,  CharSequence description) {
			        super(title, description);
			        if (view == null) {
				            throw new IllegalArgumentException("Given null view to target");
				        }
			        this.view = view;
			    }
		
		    @Override
		    public void onReady(final Runnable runnable) {
			        ViewUtil.onLaidOut(view, new Runnable() {
				            @Override
				            public void run() {
					                // Cache bounds
					                final int[] location = new int[2];
					                view.getLocationOnScreen(location);
					                bounds = new Rect(location[0], location[1],
					                        location[0] + view.getWidth(), location[1] + view.getHeight());
					
					                if (icon == null && view.getWidth() > 0 && view.getHeight() > 0) {
						                    final Bitmap viewBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
						                    final Canvas canvas = new Canvas(viewBitmap);
						                    view.draw(canvas);
						                    icon = new android.graphics.drawable.BitmapDrawable(view.getContext().getResources(), viewBitmap);
						                    icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
						                }
					
					                runnable.run();
					            }
				        });
			    }
	}
	
	
	public void _extra () {
	}
	AutoCompleteTextView edittext;
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
	
	
	public void _DatePicker_Dark (final String _title, final TextView _day, final TextView _month, final TextView _year) {
		dark_day_1 = _day;
		dark_month_1 = _month;
		dark_year_1 = _year;
		dark_title_1 = _title;
		showDatePickerDialogDark_1();
		
	}
	private TextView dark_day_1;
	private TextView dark_month_1;
	private TextView dark_year_1;
	private String dark_title_1;
	
	public void showDatePickerDialogDark_1() {
		    Calendar c = Calendar.getInstance();
		    int year = c.get(Calendar.YEAR);
		    int mon = c.get(Calendar.MONTH);
		    int day = c.get(Calendar.DAY_OF_MONTH);
		
		    DatePickerDialog dialogdark;
		    dialogdark = new DatePickerDialog(this,android.R.style.Theme_Holo_Dialog, new DatePickerDialog.OnDateSetListener() {
			        @Override
			        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
				            int mon = month + 1;
				            dark_day_1.setText(String.format("%5d",day));
				            dark_month_1.setText(String.format("%5d",mon));
				            dark_year_1.setText(String.format("%5d",year));
				        }
			    }, year, mon, day);
		
		    dialogdark.setTitle(dark_title_1);
		    dialogdark.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		    dialogdark.show();
	}
	{
	}
	
	
	public class ListviewsemenceAdapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public ListviewsemenceAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.ghg, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			
			if (lmsem.get((int)_position).get("semence").toString().equals(saison)) {
				linear1.setVisibility(View.VISIBLE);
				if (!lmsem.get((int)_position).get("pic").toString().equals("")) {
					_imgtoB64(lmsem.get((int)_position).get("pic").toString(), imageview1);
				}
				else {
					
				}
				textview2.setText(lmsem.get((int)_position).get("nom").toString());
			}
			else {
				linear1.setVisibility(View.GONE);
			}
			
			return _view;
		}
	}
	
	public class ListviewrecolteAdapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public ListviewrecolteAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.ghg, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			
			if (lmsem.get((int)_position).get("recolte").toString().equals(saison)) {
				linear1.setVisibility(View.VISIBLE);
				if (!lmrec.get((int)_position).get("pic").toString().equals("")) {
					_imgtoB64(lmrec.get((int)_position).get("pic").toString(), imageview1);
				}
				else {
					
				}
				textview2.setText(lmrec.get((int)_position).get("nom").toString());
			}
			else {
				linear1.setVisibility(View.GONE);
			}
			
			return _view;
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