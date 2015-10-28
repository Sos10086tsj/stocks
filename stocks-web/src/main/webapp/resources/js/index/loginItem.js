stocks.loginItem = {
	//登录框用户名
	initUsername : function(){
		var username = new Ext.form.TextField({
			width : 200,
			allowBlank : false,
			maxLength : 20,
			name : 'username',
			fieldLabel : stocks.loginLabel.usernameLable,
			labelWidth : 45,
			labelAlign : 'right',
			blankText : stocks.loginLabel.usernameBlankText,
			maxLengthText : stocks.loginLabel.usernameMaxLengthText,
			margin : '10 0 10 0'
		});
		return username;
	},

	//登录框密码
	initPassword : function(){
		var pass = new Ext.form.TextField({
			width : 200,
			allowBlank : false,
			maxLength : 20,
			name : 'password',
			fieldLabel : stocks.loginLabel.passLabel,
			labelWidth : 45,
			labelAlign : 'right',
			blankText : stocks.loginLabel.passBlankText,
			inputType : 'password'
		});
		return pass;
	},
	
	//登陆按钮
	initLoginBtn : function(){
		var loginBtn = new Ext.Button({
			text: stocks.loginLabel.loginText,
			handler: function(){
				if (stocks.login.loginForm.getForm().isValid()){
					stocks.login.loginForm.submit({
						url : ctx + '/login',
						method : 'POST',
						waitMsg : stocks.loginLabel.waitingMsg,
						timeout : 60000,
						success : function(form, action){
							alert("success")
						},
						failure : function(form, action){
							alert("failure")
						}
					});
				}else{
					alert("else");
				}
			}
		});
		return loginBtn;
	},
	
	//注册按钮
	initRegisterBtn : function(){
		var registerBtn = new Ext.Button({
			text: stocks.loginLabel.registerText,
			handler: function(){
				window.open("register");
			}
		});
		return registerBtn;
	}
};