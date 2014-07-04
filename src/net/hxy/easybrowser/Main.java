package net.hxy.easybrowser;



import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
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
	mWebView.loadUrl(cur_url);
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
