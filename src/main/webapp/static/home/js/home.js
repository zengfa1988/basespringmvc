$(function() {
	menuInit();
});

function menuInit() {
	loadHomePage();
	tabOpenEven();
}

function tabOpenEven() {
	$('.addTab').on("click", "a", function() {
		$('.addTab li').removeClass("click");
		$(this).closest("li").toggleClass("click");
		var $this = $(this);
		var href = $this.attr('src');
		var title = $this.text();
		if (href) {
			addTab(title, href);
		}
	});
}

function loadHomePage() {
	var iframe = "";
	// height>600
	// iframe+='<br><iframe id="welcome_iframe" src="" frameborder="0"
	// style="width:560px;height:320px;border:0;"></iframe>';
	iframe += '<iframe id="welcome_iframe" src="" frameborder="0"  style="width:560px;height:320px;border:0;overflow-y:hidden;vertical-align:top;margin-right:20px;"></iframe>';
	iframe += '<iframe id="welcome_iframe" src="" frameborder="0"  style="width:560px;height:320px;border:0;overflow-y:hidden;vertical-align:top;margin-right:20px;"></iframe>';
	iframe += '<iframe id="welcome_iframe" src="" frameborder="0"  style="width:560px;height:320px;border:0;overflow-y:hidden;vertical-align:top;margin-right:20px;"></iframe>';
	iframe += '<iframe id="welcome_iframe" src="" frameborder="0"  style="width:560px;height:320px;border:0;overflow-y:hidden;vertical-align:top;margin-right:20px;"></iframe>';
	$("#welcome_auc").html(iframe);
}

function addTab(title, url) {
	if ($('#tabs').tabs('exists', title)) {
		$('#tabs').tabs('select', title);// 选中并刷新
		var currTab = $('#tabs').tabs('getSelected');
		// var url = $(currTab.panel('options').content).attr('src');
		if (url != undefined && currTab.panel('options').title != 'Home') {
			$('#tabs').tabs('update', {
				tab : currTab,
				options : {
					content : createFrame(url)
				}
			});
		}
	} else {
		var content = createFrame(url);
		$('#tabs').tabs('add', {
			title : title,
			content : content,
			closable : true
		});
	}
	tabClose();
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="'
			+ url
			+ '" style="width:100%;height:100%;overflow-y : hidden;   "></iframe>';
	return s;
}

function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	});
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		$('#mm').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
	tabCloseEven();// 关闭菜单事件
}

/**
 * 绑定右键菜单事件
 */
function tabCloseEven() {
	// 刷新
	$('#mm-tabupdate').click(function() {
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if (url != undefined && currTab.panel('options').title != '首页') {
			$('#tabs').tabs('update', {
				tab : currTab,
				options : {
					content : createFrame(url)
				}
			});
		}
	});
	// 关闭当前
	$('#mm-tabclose').click(function() {
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close', currtab_title);
	});
	// 全部关闭
	$('#mm-tabcloseall').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			if (t != '首页') {
				$('#tabs').tabs('close', t);
			}
		});
	});
	// 关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		var nextall = $('.tabs-selected').nextAll();
		if (prevall.length > 0) {
			prevall.each(function(i, n) {
				var t = $('a:eq(0) span', $(n)).text();
				if (t != '首页') {
					$('#tabs').tabs('close', t);
				}
			});
		}
		if (nextall.length > 0) {
			nextall.each(function(i, n) {
				var t = $('a:eq(0) span', $(n)).text();
				if (t != '首页') {
					$('#tabs').tabs('close', t);
				}
			});
		}
		return false;
	});
	// 关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			// msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});
	// 关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 0) {
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});

	// 退出
	$("#mm-exit").click(function() {
		$('#mm').menu('hide');
	});

}
