package net.hxy.easybrowser;



import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class Main extends Activity {
	EditText edit;
	ImageButton btn;
	private ImageButton forwardBtn;
	private ImageButton backBtn;
	private WebView mWebView;
	private String cur_url="http://www.baidu.com";
	protected String Tag="Main";
	private Drawable drawable;
	
	
	private final static int HISTORY_ITEM=0;
	private final static int HTTP_ITEM=1;
	private final static int SHORTCUT_ITEM=2;
	private final static int ADD_FAVORITE=3;
	private final static int FAVORATE_ITEM=4;
	private final static int PREFERENCE_ITEM=5;
	private final static int EXIT_ITEM=7;
	final Activity context=this;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		onInit();

		
	}

public void onInit(){
	setContentView(R.layout.main);
	edit=(EditText)findViewById(R.id.text_uri);
	btn=(ImageButton)findViewById(R.id.button_go);
	forwardBtn=(ImageButton)findViewById(R.id.go_forward);
	backBtn=(ImageButton)findViewById(R.id.go_back);
	//btn is ImageButton,not button,so use Button.OnClickListener()
	btn.setOnClickListener(new Button.OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			String str1=edit.getText().toString();
			Log.e(Tag,"str1:"+str1);
			Log.e(Tag,"str1.substring(0,7):"+str1.substring(0,6).toString());
			String str=null;
			//: is two byte
			if(str1.substring(0,7).equals("http://")){
				str=str1;
			}else{
				str="http://".toString()+str1;
			}
			Log.e(Tag,"str:"+str);
			//if(!str.equals(null)) 
			mWebView.loadUrl(str);
		}
		
	});
	mWebView=(WebView)findViewById(R.id.webView);
	mWebView.setWebViewClient(new WebViewClient(){
		public boolean shouldOverrideUriLoading(WebView view,String url){
			mWebView.loadUrl(url);
			return true;
		}
	});
    mWebView.setWebChromeClient(new WebChromeClient(){
    	public void onProgreeChanged(WebView view,int progress){
    		context.setProgress(progress*100);
    		if(progress>=100){
    			
    		}
    	}
    });
	
	forwardBtn.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(mWebView.canGoForward()){
				mWebView.goForward();
			}
		}
		
	});
	backBtn.setOnClickListener(new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(mWebView.canGoBack()){
				mWebView.goBack();
			}
		}
		
	});
	mWebView.loadUrl(cur_url);
	setTitle();
	
}
//preference operation
	private void setTitle(){
		Bitmap bitmap=mWebView.getFavicon();
		drawable=new BitmapDrawable(bitmap);
		drawable=this.getResources().getDrawable(R.drawable.favorite);
		edit.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
		edit.setText(cur_url);
		
	}
	private void createShortcut(){
		
	}
	private void add_favorite(){
		
	}
	private void open_favorite(){
		
	}
	private void goto_help_act(){
		
	}
	public void setBlockImage(boolean flag){
		
	}
	public void setCacheMode(boolean flag){
		
	}
	public void setJavaScripte(boolean flag){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	//database operation below
	private void insertTable(String url,int time,String title){
		
	}
	private void deleteTable(){
		
	}
	private void getHistory(){
		
	}
	
	
	
	
	public void onBackPressed(){
		Log.e(Tag,"onBackPressed--------");
		
	}
	protected void dialog(){
		AlertDialog.Builder builder=new AlertDialog.Builder(Main.this);
		builder.setIcon(R.drawable.icon);
		builder.setTitle(R.string.exit_title);
		
	}
	
	
	
	
}
