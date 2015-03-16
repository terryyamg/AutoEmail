package tw.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @SuppressLint("NewApi")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        /* 加入StrictMode避免發生 android.os.NetworkOnMainThreadException */  
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()  
          .detectDiskReads().detectDiskWrites().detectNetwork()  
          .penaltyLog().build());  
        try {     
            GMailSender sender = new GMailSender("xxxx@gmail.com", "xxxx"); //寄件者(開發方)帳號與密碼  
            sender.sendMail("來自自動發送信件app",   //信件標題  
                    "成功?",   //信件內容  
                    "xxxx@gmail.com",   //寄件者  
                    "xxxx@gmail.com");   //收件者  
        } catch (Exception e) {     
            Log.e("SendMail", e.getMessage(), e);     
        }   
    }
}