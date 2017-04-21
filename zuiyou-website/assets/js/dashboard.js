$(function() {
    var $data_table = jq.table({
        url:zuiyou.investHistoryList,
        fields:["id","loanId","remarks","updatedTime"],
        columnDefs: [{
            targets: 3,
            createdCell: function (td, cellData, rowData, row, col) {
                if(cellData)
                    $(td).text(format(cellData));
            }
        }]
    });

    function add0(m){return m<10?'0'+m:m }

    function format(shijianchuo)
    {
        //shijianchuo是整数，否则要parseInt转换
        var time = new Date(shijianchuo);
        var y = time.getFullYear();
        var m = time.getMonth()+1;
        var d = time.getDate();
        var h = time.getHours();
        var mm = time.getMinutes();
        var s = time.getSeconds();
        return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
    }

    var $switch_state = $('#switch-state');

	jq.ajax(zuiyou.authInfo,{},function(res){
        if(res.code){
            var user = res.data;
            $('#username').text(user.username);
            $('#user-pdu').text(user.pdu);
            $('#user-balance').text(user.balance);

            $switch_state.bootstrapSwitch('state', user.isOpen);
            $switch_state.on('switchChange.bootstrapSwitch', function(event, state) {
              //console.log(this); // DOM element
              //console.log(event); // jQuery event
              //console.log(state); // true | false
              if(state){
                jq.ajax(zuiyou.bidOpen,{},function(res){});
              }else{
                jq.ajax(zuiyou.bidClose,{},function(res){});
              }
            });

            // 表单赋值
            var rule = res.data.rule;
            for (var key in rule) {
                var $el = $('[name="'+key+'"]');
                if ($el) {
                    $el.val(rule[key]);
                }
            }
        }
	});

	var $rule_form = $('#rule-form');
	$rule_form.attr('action',zuiyou.ruleSave);
	jq.form($rule_form,function(){return true;},function(res){
        if (res.code){
            $switch_state.bootstrapSwitch('state',false);
        }
	})

    // 定时检测登录状态
    setInterval(function() {
        jq.ajax(zuiyou.session,{},function(res){});
    }, 30 * 1000);
});


