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
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.widget.AdapterView;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class SearchActivity extends  AppCompatActivity  { 
	
	
	private FloatingActionButton _fab;
	private double earthRadius = 0;
	private double dLat = 0;
	private double desLat = 0;
	private double srcLat = 0;
	private double dLng = 0;
	private double desLng = 0;
	private double srcLng = 0;
	private double a = 0;
	private double c = 0;
	private double b = 0;
	private double dist = 0;
	private double meterConv = 0;
	private double resultDist = 0;
	private double perKm = 0;
	private double Net = 0;
	private String yu = "";
	private double length = 0;
	private double n = 0;
	private String typ = "";
	private String type = "";
	private String typs = "";
	private String Base64String = "";
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> lm = new ArrayList<>();
	private ArrayList<String> oti = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lms = new ArrayList<>();
	private ArrayList<String> lss = new ArrayList<>();
	private ArrayList<String> post_keys = new ArrayList<>();
	private ArrayList<String> keys = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView reg;
	private ListView listview1;
	private TextView textview1;
	private Spinner spinner2;
	private Spinner spinner1;
	
	private SharedPreferences locationdata;
	private Intent p = new Intent();
	private SharedPreferences region;
	private Intent s = new Intent();
	private Intent sg = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.search);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		reg = (TextView) findViewById(R.id.reg);
		listview1 = (ListView) findViewById(R.id.listview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		locationdata = getSharedPreferences("locationdata", Activity.MODE_PRIVATE);
		region = getSharedPreferences("region", Activity.MODE_PRIVATE);
		
		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					reg.setText(region.getString("region", ""));
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
				typ = reg.getText().toString().trim();
				if (reg.getText().toString().length() > 0) {
					length = lm.size();
					n = length - 1;
					for(int _repeat116 = 0; _repeat116 < (int)(length); _repeat116++) {
						if (lm.get((int)n).get("type").toString().toLowerCase().contains(typs.toLowerCase()) && lm.get((int)n).get("reg").toString().toLowerCase().contains(typ.toLowerCase())) {
							textview1.setVisibility(View.GONE);
						}
						else {
							lm.remove((int)(n));
							textview1.setVisibility(View.VISIBLE);
						}
						n--;
					}
					listview1.setAdapter(new Listview1Adapter(lm));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
				
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
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
					type = "Toilettes";
				}
				if (_position == 2) {
					type = "Église";
				}
				if (_position == 3) {
					type = "Commissariat";
				}
				if (_position == 4) {
					type = "Eau potable";
				}
				if (_position == 5) {
					type = "Centre de santé";
				}
				if (_position == 6) {
					type = "Hébergement";
				}
				if (_position == 7) {
					type = "Bac à ordure";
				}
				if (_position == 8) {
					type = "Office du tourisme";
				}
				if (_position == 9) {
					type = "Marché";
				}
				if (_position == 10) {
					type = "Lieu sportif";
				}
				if (_position == 11) {
					type = "Pharmacie";
				}
				if (_position == 12) {
					type = "Banque";
				}
				if (_position == 13) {
					type = "Discothèque-Bar-Karaoké";
				}
				if (_position == 14) {
					type = "Bâtiment public";
				}
				if (_position == 15) {
					type = "Lieu touristique";
				}
				if (_position == 16) {
					type = "Banque";
				}
				if (_position == 17) {
					type = "Lieu commercial";
				}
				if (_position == 18) {
					type = "Parc d'attraction";
				}
				if (_position == 19) {
					type = "Zone industrielle";
				}
				if (_position == 20) {
					type = "Hotel";
				}
				if (_position == 21) {
					type = "Restaurant";
				}
				if (_position == 22) {
					type = "Professionnel";
				}
				if (_position == 23) {
					type = "Gare/ Port/ Aeroport/ Stationnement";
				}
				if (_position == 24) {
					type = "Lieu interdit";
				}
				if (_position == 25) {
					type = "Commercant";
				}
				if (_position == 26) {
					type = "Etablissement";
				}
				if (_position == 27) {
					type = "Siege social";
				}
				if (_position == 28) {
					type = "Voie publique";
				}
				typs = type.trim();
				if (typs.length() > 0) {
					length = lm.size();
					n = length - 1;
					for(int _repeat360 = 0; _repeat360 < (int)(length); _repeat360++) {
						if (lm.get((int)n).get("type").toString().toLowerCase().contains(typs.toLowerCase())) {
							textview1.setVisibility(View.GONE);
						}
						else {
							lm.remove((int)(n));
							textview1.setVisibility(View.VISIBLE);
						}
						n--;
					}
					listview1.setAdapter(new Listview1Adapter(lm));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				spinner1.setSelection((int)(0));
				((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
				spinner2.setSelection((int)(0));
				((ArrayAdapter)spinner2.getAdapter()).notifyDataSetChanged();
				lm = new Gson().fromJson(locationdata.getString("locationdata", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				listview1.setAdapter(new Listview1Adapter(lm));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		});
	}
	
	private void initializeLogic() {
		_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#03a9f4")));
		listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
		listview1.setStackFromBottom(true);
		Net = 1;
		if (!locationdata.getString("locationdata", "").equals("")) {
			lm = new Gson().fromJson(locationdata.getString("locationdata", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(lm));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}
		else {
			s.setClass(getApplicationContext(), MajActivity.class);
			s.putExtra("x", "view");
			startActivity(s);
			SketchwareUtil.showMessage(getApplicationContext(), "Veuillez mettre à jour la base de donnée !");
		}
		yu = getIntent().getStringExtra("key").trim();
		lm = new Gson().fromJson(locationdata.getString("locationdata", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		if (yu.length() > 0) {
			length = lm.size();
			n = length - 1;
			for(int _repeat94 = 0; _repeat94 < (int)(length); _repeat94++) {
				if (lm.get((int)n).get("description").toString().toLowerCase().contains(getIntent().getStringExtra("key").toLowerCase())) {
					textview1.setVisibility(View.GONE);
				}
				else {
					if (lm.get((int)n).get("nom").toString().toLowerCase().contains(getIntent().getStringExtra("key").toLowerCase())) {
						textview1.setVisibility(View.GONE);
					}
					else {
						if (lm.get((int)n).get("type").toString().toLowerCase().contains(getIntent().getStringExtra("key").toLowerCase())) {
							textview1.setVisibility(View.GONE);
						}
						else {
							lm.remove((int)(n));
							textview1.setVisibility(View.VISIBLE);
						}
					}
				}
				n--;
			}
			listview1.setAdapter(new Listview1Adapter(lm));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}
		_Bory(spinner1, "#ffffff", "#e0e0e0", 360);
		_Bory(spinner2, "#ffffff", "#e0e0e0", 360);
		lss.add("Votre région");
		lss.add("Diana");
		lss.add("Sava");
		lss.add("Sofia");
		lss.add("Analanjirofo");
		lss.add("Boeny");
		lss.add("Betsiboka");
		lss.add("Melaky");
		lss.add("Alaotra Mangoro");
		lss.add("Bongolava");
		lss.add("Analamanga");
		lss.add("Atsinanana");
		lss.add("Itasy");
		lss.add("Menabe");
		lss.add("Vakinankaratra");
		lss.add("Amiron'i Mania");
		lss.add("Vatovavy - fitovinany");
		lss.add("Matsiatra ambony");
		lss.add("Atsimo - andrefana");
		lss.add("Ihorombe");
		lss.add("Atsimo - atsinanana");
		lss.add("Anosy");
		lss.add("Androy");
		spinner2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, lss));
		((ArrayAdapter)spinner2.getAdapter()).notifyDataSetChanged();
		oti.add("Type de lieu");
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
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, oti));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _calc_distance () {
		/*
source code reference:
https://github.com/jayadevjd/Android-Calc-Distance-Gps
*/
		earthRadius = 3958.76d;
		dLat = Math.toRadians(desLat - srcLat);
		dLng = Math.toRadians(desLng - srcLng);
		a = Math.sin(dLat / 2) * (Math.sin(dLat / 2) + (Math.cos(Math.toRadians(srcLat)) * (Math.cos(Math.toRadians(desLat)) * (Math.sin(dLng / 2) * Math.sin(dLng / 2)))));
		b = Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		c = 2 * b;
		dist = earthRadius * c;
		meterConv = 1609;
		resultDist = dist * meterConv;
		perKm = resultDist / 1000;
	}
	
	
	public void _Bory (final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
		_view.setBackground(gd);
	}
	
	
	public void _SortNumber (final ArrayList<Double> _listNumber, final boolean _Ascending) {
		Collections.sort(_listNumber);
		if (!_Ascending) {
			Collections.reverse(_listNumber);
		}
	}
	
	
	public void _sort_list_map (final ArrayList<HashMap<String, Object>> _map, final String _key) {
		Collections.sort(_map,new Comparator<HashMap<String,Object>>(){ public int compare(HashMap<String,Object> mapping1, HashMap<String,Object> mapping2){ return mapping1.get(_key).toString().compareToIgnoreCase(mapping2.get(_key).toString()); }});
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
	
	
	public void _sss () {
		
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.prtc, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final TextView region = (TextView) _view.findViewById(R.id.region);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final TextView titre = (TextView) _view.findViewById(R.id.titre);
			final TextView description = (TextView) _view.findViewById(R.id.description);
			final ImageView imageview2 = (ImageView) _view.findViewById(R.id.imageview2);
			final TextView textview4 = (TextView) _view.findViewById(R.id.textview4);
			
			_sort_list_map(lm, "promo");
			_Bory(linear1, "#ffffff", "#e0e0e0", 15);
			_Bory(linear3, "#f5f5f5", "#e0e0e0", 15);
			titre.setText(lm.get((int)_position).get("nom").toString().toUpperCase());
			textview4.setText(lm.get((int)_position).get("type").toString());
			region.setText(lm.get((int)_position).get("reg").toString());
			description.setText(lm.get((int)_position).get("description").toString());
			map = lm.get((int)_position);
			SketchwareUtil.getAllKeysFromMap(map, post_keys);
			if (!lm.get((int)_position).get("pic").toString().equals("")) {
				_imgtoB64(lm.get((int)_position).get("pic").toString(), imageview1);
			}
			else {
				
			}
			if (lm.get((int)_position).get("promo").toString().equals("")) {
				imageview2.setVisibility(View.GONE);
			}
			else {
				imageview2.setVisibility(View.VISIBLE);
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (lm.get((int)_position).get("type").toString().equals("Professionnel")) {
						
						map = lm.get((int)_position);
						sg.putExtra("post", new Gson().toJson(map));
						startActivity(sg);
					}
					else {
						p.setClass(getApplicationContext(), PlaceActivity.class);
						p.putExtra("net", getIntent().getStringExtra("net"));
						p.putExtra("nom", lm.get((int)_position).get("nom").toString());
						p.putExtra("type", lm.get((int)_position).get("type").toString());
						p.putExtra("reg", lm.get((int)_position).get("reg").toString());
						p.putExtra("description", lm.get((int)_position).get("description").toString());
						p.putExtra("pic", lm.get((int)_position).get("pic").toString());
						p.putExtra("promo", lm.get((int)_position).get("promo").toString());
						p.putExtra("phone", lm.get((int)_position).get("phone").toString());
						p.putExtra("site", lm.get((int)_position).get("site").toString());
						p.putExtra("lat", lm.get((int)_position).get("lat").toString());
						p.putExtra("lng", lm.get((int)_position).get("lng").toString());
						p.putExtra("username", lm.get((int)_position).get("username").toString());
						startActivity(p);
					}
				}
			});
			
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