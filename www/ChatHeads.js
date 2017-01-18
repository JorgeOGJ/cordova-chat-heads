var argscheck = require('cordova/argscheck'),
    exec = require('cordova/exec');
	
var ChatHeads = {};

ChatHeads.start = function(successCallback, errorCallback){
	console.log("ChatHeads Start");
	var args = {};
	exec(successCallback, errorCallback, "ChatHeads", "startChatHeads", args);
};

ChatHeads.openHead = function(successCallback, errorCallback){
	console.log("ChatHeads Open");
	var args = {};
	exec(successCallback, errorCallback, "ChatHeads", "openChatHeads", args);
};

module.exports = ChatHeads;