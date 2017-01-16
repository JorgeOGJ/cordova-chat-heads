package com.wardman.chatheads;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
* This class echoes a string called from JavaScript.
*/
public class ChatHeads extends CordovaPlugin {
	
	private CallbackContext callbackContext = null;
	private MainActivity activity = null;
	
	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView)
	{
		super.initialize(cordova,webView);
		this.activity = (MainActivity) cordova.getActivity();
	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("test")) {
			String message = args.getString(0);
			this.test(message, callbackContext);
			return true;
		}else if (action.equals("open")) {
			this.open();
			return true;
		}else if (action.equals("close")) {
			this.open();
			return true;
		}else if (action.equals("start")) {
			this.startService();
			return true;
		}else if (action.equals("stop")) {
			this.stopHeadService();
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
	
	private void open(String message, CallbackContext callbackContext) {
		this.addToWindowManager();
	}
	
	private void close(String message, CallbackContext callbackContext) {
		this.destroy();
	}
	
	private void startService(String message, CallbackContext callbackContext) {
		this.startHeadService();
	}
	
	private void stopService(String message, CallbackContext callbackContext) {
		this.stopHeadService();
	}
}