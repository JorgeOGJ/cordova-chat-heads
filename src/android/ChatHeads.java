package co.wardman.chatheads;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.View;

//import android.content.Intent;

/**
* This class echoes a string called from JavaScript.
*/
public class ChatHeads extends CordovaPlugin {
	
	private CallbackContext callbackContext = null;
	public SettingsFragment settingsfragment = null;
	public HeadLayer headlayer = null;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		//this.callbackContext = callbackContext;
		String message = args.getString(0);
		if (action.equals("test")) {
			//String message = args.getString(0);
			this.test(message, callbackContext);
			return true;
		}else if (action.equals("open")) {
			//this.open();
			return true;
		}else if (action.equals("close")) {
			this.openChatHeads(message,callbackContext);
			return true;
		}else if (action.equals("start")) {
			this.startChatHeads(message,callbackContext);
			return true;
		}else if (action.equals("stop")) {
			//this.stopHeadService();
			return true;
		}
		return false;
	}
	
	private void test(String message, CallbackContext callbackContext) {
		if (message != null && message.length() > 0) {
			callbackContext.success(message);
		} else {
			callbackContext.error("Expected one non-empty string argument.");
		}
	}
	
	//private void open(String message, CallbackContext callbackContext) {
	//	this.activity.addToWindowManager();
	//}
	
	//private void close(String message, CallbackContext callbackContext) {
	//	this.activity.destroy();
	//}
	
	private void startChatHeads(String message, CallbackContext callbackContext) {
		Activity context = cordova.getActivity();
        Intent intent = new Intent(
                context, HeadService.class);
        try {
            context.bindService(intent,connection, Context.BIND_AUTO_CREATE);
			fireEvent(Event.ACTIVATE, null);
			context.startService(intent);
        } catch (Exception e) {
            fireEvent(Event.FAILURE, e.getMessage());
        }
		//this.settingsfragment = new SettingsFragment();
		//this.settingsfragment.externalStartHeadService();
		callbackContext.success("ChatHeads Service Hopefully Started");
	}
	
	private void openChatHeads(String message, CallbackContext callbackContext) {
		this.headlayer = new HeadLayer(this.cordova.getActivity().getApplicationContext());
		callbackContext.success("ChatHeads Should be open?");
	}
	
	//private void stopService(String message, CallbackContext callbackContext) {
	//	this.activity.stopHeadService();
	//}
}