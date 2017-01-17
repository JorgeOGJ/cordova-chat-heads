package com.wardman.chatheads;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;

/**
* This class echoes a string called from JavaScript.
*/
public class ChatHeads extends CordovaPlugin {
	
	public SettingsFragment settingsfragment = null;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		this.callbackContext = callbackContext;
		if (action.equals("test")) {
			String message = args.getString(0);
			this.test(message, callbackContext);
			return true;
		}else if (action.equals("open")) {
			//this.open();
			return true;
		}else if (action.equals("close")) {
			//this.open();
			return true;
		}else if (action.equals("start")) {
			startChatHeads();
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
		settingsfragment = new SettingsFragment(this);
	}
	
	private void openChatHeads(String message, CallbackContext callbackContext) {
		settingsfragment.startHeadService();
	}
	
	//private void stopService(String message, CallbackContext callbackContext) {
	//	this.activity.stopHeadService();
	//}
}