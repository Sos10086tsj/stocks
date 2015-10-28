stocks.register = {
	registerForm : null,
	
	initRegisterPanel : function(){
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
		
		stocks.register.registerForm = Ext.create("Ext.form.Panel",{
			title : '<font style="font-size: 18px;">' + stocks.registerLabel.panelTitleLabel + '</font>',
			frame : true,
			buttonAlign: 'center',
			width : 250,
			minWidth : 250,
			height : 250,
			minHeight : 150,
			renderTo : 'register_panel',
			layout : {
				type : 'vbox',
				padding : '5',
				pack : 'center',
				align : 'center'
			},
			margin : margin,
			items : [
				stocks.registerItem.initUsername(),
				stocks.registerItem.initPassword(),
				stocks.registerItem.initConfirmPassword(),
				stocks.registerItem.initInvitationCode()
			],
			buttons : [
				stocks.registerItem.initRegisterBtn()
			]
		});
	}
};

$(function(){
	Ext.onReady(function () {
		Ext.QuickTips.init();
		stocks.register.initRegisterPanel();
	}); 
});