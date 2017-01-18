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
	
	private CallbackContext callbackContext = null;
	public SettingsFragment settingsfragment = null;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		this.callbackContext = callbackContext;
		String message = args.getString(0);
		if (action.equals("test")) {
			//String message = args.getString(0);
			test(message, callbackContext);
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
		this.settingsfragment = new SettingsFragment();
	}
	
	private void openChatHeads(String message, CallbackContext callbackContext) {
		this.settingsfragment.externalStartHeadService();
	}
	
	//private void stopService(String message, CallbackContext callbackContext) {
	//	this.activity.stopHeadService();
	//}
}