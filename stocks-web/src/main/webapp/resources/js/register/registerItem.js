stocks.registerItem = {
	//注册用户名
	initUsername : function(){
		var username = new Ext.form.TextField({
			width : 200,
			allowBlank : false,
			maxLength : 20,
			name : 'username',
			fieldLabel : stocks.registerLabel.usernameLable,
			labelWidth : 60,
			labelAlign : 'right',
			blankText : stocks.registerLabel.usernameBlankText,
			maxLengthText : stocks.registerLabel.usernameMaxLengthText,
			margin : '10 0 10 0',
			vtype : 'email',
			vtypeText: stocks.registerLabel.usernameIllegalText,
			listeners : {
				change : function(comp, newValue, oldValue, options){
					if(comp.isValid()){
						Ext.Ajax.request({
							url: ctx + '/register/checkUsernameExist',
					        params: { username: newValue },
					        success: function(response){
					        	if (!response.responseText){
					        		comp.markInvalid('用户名已经存在');
					        	}
					        }
						});
					}
				}
			}
		});
		return username;
	},

	//密码
	initPassword : function(){
		var pass = new Ext.form.TextField({
			width : 200,
			allowBlank : false,
			maxLength : 20,
			id : 'js_register_pass_id',
			name : 'password',
			fieldLabel : stocks.registerLabel.passLabel,
			labelWidth : 60,
			labelAlign : 'right',
			blankText : stocks.registerLabel.passBlankText,
			inputType : 'password'
		});
		return pass;
	},
	
	//确认密码
	initConfirmPassword : function(){
		Ext.apply(Ext.form.field.VTypes,{
			registerConfirmPass : function(){
				var pass = Ext.getCmp('js_register_pass_id').getValue();
				var confrimPass = Ext.getCmp('js_register_confirm_pass_id').getValue();
				if(pass.length > 0 && confrimPass.length > 0 && pass != confrimPass){
					return false;
				}
				return true;
			},
			registerConfirmPassText : '两次输入密码不同'
		});
		
		var confirmPass = new Ext.form.TextField({
			width : 200,
			allowBlank : false,
			maxLength : 20,
			id : 'js_register_confirm_pass_id',
			name : 'confirmPassword',
			fieldLabel : stocks.registerLabel.confirmPassLabel,
			labelWidth : 60,
			labelAlign : 'right',
			blankText : stocks.registerLabel.confirmPassBlankText,
			inputType : 'password',
			vtype : 'registerConfirmPass'
		});
		return confirmPass;
	},
	
	//邀请码
	initInvitationCode : function(){
		var invitationCode = new Ext.form.TextField({
			width : 200,
			allowBlank : false,
			maxLength : 20,
			name : 'invitationCode',
			fieldLabel : stocks.registerLabel.invitationCodeLabel,
			labelWidth : 60,
			labelAlign : 'right',
			blankText : stocks.registerLabel.invitationCodeBlankText
		});
		return invitationCode;
	},
	
	//注册按钮
	initRegisterBtn : function(){
		var registerBtn = new Ext.Button({
			text: stocks.registerLabel.registerText,
			handler: function(){
				if (stocks.register.registerForm.getForm().isValid()){
					stocks.register.registerForm.submit({
						url : ctx + '/register',
						method : 'POST',
						waitMsg : stocks.registerLabel.waitingMsg,
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
		return registerBtn;
	}
};