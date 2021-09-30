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
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
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


public class TelActivity extends  AppCompatActivity  { 
	
	
	private HashMap<String, Object> map = new HashMap<>();
	private String Base64String = "";
	
	private LinearLayout linear1;
	private LinearLayout linear10;
	private LinearLayout linear4;
	private LinearLayout linear2;
	private ImageView imageview1;
	private LinearLayout linear3;
	private TextView horaire;
	private LinearLayout linear13;
	private LinearLayout linear11;
	private TextView type;
	private TextView place;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private ScrollView vscroll1;
	private LinearLayout linear7;
	private LinearLayout linear12;
	private TextView details;
	private TextView titre;
	private TextView textview1;
	private TextView telephone;
	private TextView email;
	private TextView site;
	private ImageView imageviewcall;
	
	private Intent e = new Intent();
	private Intent di = new Intent();
	private Intent w = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.tel);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 1000);
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
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		horaire = (TextView) findViewById(R.id.horaire);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		type = (TextView) findViewById(R.id.type);
		place = (TextView) findViewById(R.id.place);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		details = (TextView) findViewById(R.id.details);
		titre = (TextView) findViewById(R.id.titre);
		textview1 = (TextView) findViewById(R.id.textview1);
		telephone = (TextView) findViewById(R.id.telephone);
		email = (TextView) findViewById(R.id.email);
		site = (TextView) findViewById(R.id.site);
		imageviewcall = (ImageView) findViewById(R.id.imageviewcall);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				w.setClass(getApplicationContext(), SaryActivity.class);
				w.putExtra("img", map.get("pic").toString());
				startActivity(w);
			}
		});
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear5.setVisibility(View.VISIBLE);
				linear6.setVisibility(View.GONE);
				_CardStyle(textview1, 15, 15, "#e0e0e0", true);
				textview1.setTextColor(0xFF263238);
				
			}
		});
		
		imageviewcall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				di.setAction(Intent.ACTION_CALL);
				di.setData(Uri.parse("tel:".concat(map.get("phone").toString())));
				startActivity(di);
			}
		});
	}
	
	private void initializeLogic() {
		map = new Gson().fromJson(getIntent().getStringExtra("map"), new TypeToken<HashMap<String, Object>>(){}.getType());
		_CardStyle(textview1, 15, 15, "#03a9f4", true);
		titre.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/annette.ttf"), 0);
		details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		type.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		horaire.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		place.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		telephone.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		email.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		site.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		
		
		titre.setText(map.get("titre").toString());
		details.setText("DÉTAILS :\n\n".concat(map.get("description").toString()));
		type.setText("Type : ".concat(map.get("type").toString().toUpperCase()));
		if (!map.get("pic").toString().equals("")) {
			_imgtoB64(map.get("pic").toString(), imageview1);
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
	
	public void _CardStyle (final View _view, final double _shadow, final double _radius, final String _color, final boolean _touch) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_radius);
		_view.setBackground(gd);
		
		if (Build.VERSION.SDK_INT >= 21){
			_view.setElevation((int)_shadow);}
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
	
	
	public void _Bory (final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
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