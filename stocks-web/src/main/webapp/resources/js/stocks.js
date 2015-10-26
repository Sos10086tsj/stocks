var stocks = {
	progressBar : function(msg){
		var progress = new Ext.LoadMask(Ext.getBody(),{
			msg : msg,
			removeMask : true
		});
		return progress;
	},
		
	warningResult : function(title,msg){
		Ext.Msg.show({
			title : title,
			msg : msg,
			buttons : Ext.Msg.YES,
			icon : Ext.Msg.WARNING
		});
	},
	
	init : function(){
		Ext.override(Ext.grid.RowEditor, {  
    		addFieldsForColumn: function(column, initial) {  
        		var me = this,  
        		i, length, field;  
        		if (Ext.isArray(column)) {  
            		for (i = 0, length = column.length; i < length; i++) {  
               	 	me.addFieldsForColumn(column[i], initial);  
            		}  
            		return;  
        		}  
        		if (column.getEditor) {  
            		field = column.getEditor(null, {  
                	xtype: 'displayfield',  
                	getModelData: function() {  
                    	return null;  
                	}  
            	});  
            	if (column.align === 'right') {  
                	field.fieldStyle = 'text-align:right';  
            	}  
            	if (column.xtype === 'actioncolumn') {  
                	field.fieldCls += ' ' + Ext.baseCSSPrefix + 'form-action-col-field';  
            	}  
            	if (me.isVisible() && me.context) {  
                	if (field.is('displayfield')) {  
                    	me.renderColumnData(field, me.context.record, column);  
                	} else {  
                    	field.suspendEvents();  
                    	field.setValue(me.context.record.get(column.dataIndex));  
                    	field.resumeEvents();  
                	}  
            	}  
            	if (column.hidden) {  
                	me.onColumnHide(column);  
            	} else if (column.rendered && !initial) {  
                	me.onColumnShow(column);  
            	}  
  
            	// -- start edit  
            	me.mon(field, 'change', me.onFieldChange, me);  
            	// -- end edit  
        		}  
    		}  
		});  
	}
};

$(function(){
	stocks.init();
});