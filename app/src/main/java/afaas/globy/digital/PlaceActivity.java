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
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class PlaceActivity extends  AppCompatActivity  { 
	
	
	private String lat = "";
	private String lng = "";
	private String site = "";
	private String phone = "";
	private String promo = "";
	private String position = "";
	private String Base64String = "";
	
	private LinearLayout linear11;
	private LinearLayout linear2;
	private LinearLayout linear8;
	private ImageView imageview1;
	private TextView text;
	private TextView nom;
	private LinearLayout linear14;
	private LinearLayout linear9;
	private ScrollView vscroll2;
	private TextView textview5;
	private TextView type;
	private LinearLayout linear13;
	private TextView description;
	
	private Intent s = new Intent();
	private Intent is = new Intent();
	private Intent ib = new Intent();
	private AlertDialog.Builder dd;
	private Intent v = new Intent();
	private SharedPreferences test;
	private Intent w = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.place);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		text = (TextView) findViewById(R.id.text);
		nom = (TextView) findViewById(R.id.nom);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		textview5 = (TextView) findViewById(R.id.textview5);
		type = (TextView) findViewById(R.id.type);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		description = (TextView) findViewById(R.id.description);
		dd = new AlertDialog.Builder(this);
		test = getSharedPreferences("test", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				w.setClass(getApplicationContext(), SaryActivity.class);
				w.putExtra("img", getIntent().getStringExtra("pic"));
				startActivity(w);
			}
		});
	}
	
	private void initializeLogic() {
		if (getIntent().getStringExtra("pic").equals("")) {
			
		}
		else {
			_imgtoB64(getIntent().getStringExtra("pic"), imageview1);
		}
		nom.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/innocent.ttf"), 3);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		
		type.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		
		description.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		nom.setText(getIntent().getStringExtra("nom").toUpperCase());
		description.setText(getIntent().getStringExtra("description"));
		type.setText(getIntent().getStringExtra("type"));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _rounded (final View _view, final double _ab, final String _color, final double _shadow) {
		android.graphics.drawable.GradientDrawable s = new android.graphics.drawable.GradientDrawable();
		s.setColor(Color.parseColor(_color));
		s.setCornerRadius((float)_ab);
		_view.setBackground(s);
		_view.setElevation((float)_shadow);
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