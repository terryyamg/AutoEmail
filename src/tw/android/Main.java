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
        /* �[�JStrictMode�קK�o�� android.os.NetworkOnMainThreadException */  
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()  
          .detectDiskReads().detectDiskWrites().detectNetwork()  
          .penaltyLog().build());  
        try {     
            GMailSender sender = new GMailSender("xxxx@gmail.com", "xxxx"); //�H���(�}�o��)�b���P�K�X  
            sender.sendMail("�Ӧۦ۰ʵo�e�H��app",   //�H����D  
                    "���\?",   //�H�󤺮e  
                    "xxxx@gmail.com",   //�H���  
                    "xxxx@gmail.com");   //�����  
        } catch (Exception e) {     
            Log.e("SendMail", e.getMessage(), e);     
        }   
    }
}