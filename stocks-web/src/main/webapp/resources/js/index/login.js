stocks.login = {
	loginForm : null,
	
	initLoginPanel : function(){
		var height = $(window).height();
		var width = $(window).width();
		var marginLeft = (width - 250) / 2;
		if(marginLeft <= 0) {
			marginLeft = 0;
		}
		var marginTop = (height - 150) / 2;
		if(marginTop <= 0) {
			marginTop = 0;
		}
		
		var margin = marginTop + ' auto auto ' + marginLeft;
		
		stocks.login.loginForm = Ext.create("Ext.form.Panel",{
			title : '<font style="font-size: 18px;">' + stocks.loginLabel.panelTitleLabel + '</font>',
			frame : true,
			buttonAlign: 'center',
			width : 250,
			minWidth : 250,
			height : 150,
			minHeight : 150,
			renderTo : 'login_panel',
			layout : {
				type : 'vbox',
				padding : '5',
				pack : 'center',
				align : 'center'
			},
			margin : margin,
			items : [
				stocks.loginItem.initUsername(),
				stocks.loginItem.initPassword()
			],
			buttons : [
				stocks.loginItem.initLoginBtn()
			]
		});
	}
};

$(function(){
	Ext.onReady(function () {
		Ext.QuickTips.init();
		stocks.login.initLoginPanel();
	}); 
});