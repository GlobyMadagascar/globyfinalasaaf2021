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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ImageView;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class DetailsActivity extends  AppCompatActivity  { 
	
	
	private String Base64String = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private LinearLayout linear3;
	private TextView nom;
	private ImageView imageview1;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private LinearLayout linear12;
	private LinearLayout linear15;
	private LinearLayout linear18;
	private LinearLayout linear21;
	private LinearLayout linear24;
	private LinearLayout linear33;
	private LinearLayout linear34;
	private LinearLayout linear35;
	private LinearLayout linear36;
	private LinearLayout linear37;
	private LinearLayout linear30;
	private LinearLayout linear13;
	private TextView textview6;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private TextView textview7;
	private TextView pluie;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private TextView textview9;
	private TextView soleil;
	private LinearLayout linear22;
	private LinearLayout linear23;
	private TextView textview11;
	private TextView vent;
	private LinearLayout linear25;
	private LinearLayout linear26;
	private TextView textview13;
	private TextView chaleur;
	private LinearLayout linear39;
	private TextView textview19;
	private LinearLayout linear41;
	private LinearLayout linear42;
	private TextView textview22;
	private TextView eau;
	private LinearLayout linear43;
	private LinearLayout linear44;
	private TextView textview23;
	private TextView sols;
	private LinearLayout linear45;
	private LinearLayout linear46;
	private TextView textview26;
	private TextView energie;
	private LinearLayout linear49;
	private LinearLayout linear50;
	private TextView textview28;
	private TextView genetique;
	private LinearLayout linear31;
	private LinearLayout linear32;
	private TextView textview17;
	private TextView details;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.details);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		nom = (TextView) findViewById(R.id.nom);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		linear34 = (LinearLayout) findViewById(R.id.linear34);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		linear37 = (LinearLayout) findViewById(R.id.linear37);
		linear30 = (LinearLayout) findViewById(R.id.linear30);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		textview6 = (TextView) findViewById(R.id.textview6);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		textview7 = (TextView) findViewById(R.id.textview7);
		pluie = (TextView) findViewById(R.id.pluie);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		textview9 = (TextView) findViewById(R.id.textview9);
		soleil = (TextView) findViewById(R.id.soleil);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		textview11 = (TextView) findViewById(R.id.textview11);
		vent = (TextView) findViewById(R.id.vent);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		textview13 = (TextView) findViewById(R.id.textview13);
		chaleur = (TextView) findViewById(R.id.chaleur);
		linear39 = (LinearLayout) findViewById(R.id.linear39);
		textview19 = (TextView) findViewById(R.id.textview19);
		linear41 = (LinearLayout) findViewById(R.id.linear41);
		linear42 = (LinearLayout) findViewById(R.id.linear42);
		textview22 = (TextView) findViewById(R.id.textview22);
		eau = (TextView) findViewById(R.id.eau);
		linear43 = (LinearLayout) findViewById(R.id.linear43);
		linear44 = (LinearLayout) findViewById(R.id.linear44);
		textview23 = (TextView) findViewById(R.id.textview23);
		sols = (TextView) findViewById(R.id.sols);
		linear45 = (LinearLayout) findViewById(R.id.linear45);
		linear46 = (LinearLayout) findViewById(R.id.linear46);
		textview26 = (TextView) findViewById(R.id.textview26);
		energie = (TextView) findViewById(R.id.energie);
		linear49 = (LinearLayout) findViewById(R.id.linear49);
		linear50 = (LinearLayout) findViewById(R.id.linear50);
		textview28 = (TextView) findViewById(R.id.textview28);
		genetique = (TextView) findViewById(R.id.genetique);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		linear32 = (LinearLayout) findViewById(R.id.linear32);
		textview17 = (TextView) findViewById(R.id.textview17);
		details = (TextView) findViewById(R.id.details);
	}
	
	private void initializeLogic() {
		nom.setText(getIntent().getStringExtra("nom"));
		pluie.setText(getIntent().getStringExtra("pluie"));
		soleil.setText(getIntent().getStringExtra("soleil"));
		vent.setText(getIntent().getStringExtra("vent"));
		chaleur.setText(getIntent().getStringExtra("chaleur"));
		eau.setText(getIntent().getStringExtra("eau"));
		energie.setText(getIntent().getStringExtra("énergie"));
		sols.setText(getIntent().getStringExtra("sols"));
		genetique.setText(getIntent().getStringExtra("génétique"));
		details.setText(getIntent().getStringExtra("détails"));
		if (!getIntent().getStringExtra("pic").equals("")) {
			_imgtoB64(getIntent().getStringExtra("pic"), imageview1);
		}
		nom.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		pluie.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		soleil.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		vent.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		chaleur.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		eau.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		sols.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		energie.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		genetique.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		details.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview19.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview22.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview23.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview26.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview28.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
		textview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/abelregular.ttf"), 1);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
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