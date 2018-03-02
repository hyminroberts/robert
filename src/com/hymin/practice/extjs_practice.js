  Ext.application({
      name: 'huihui',
      launch: function(){
          Ext.create('Ext.container.Viewpoint',{
              layout: 'fit',
              items: [
                  {
                      xtype: 'panel',
                      title: 'Dear Fanghui,',
                      html: 'I love you!'
                  }
              ]
          });
      }
  });