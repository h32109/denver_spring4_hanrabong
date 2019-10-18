"use strict";
var auth = auth || {};
auth = (()=>{
	let _, js, authvuejs
	let init = ()=>{
		_ = $.ctx()
		js = $.js()
		authvuejs = js+'/vue/auth_vue.js'
	}
	let onCreate =()=>{
		init()
		$.getScript(authvuejs)
		$('#a_go_join').click(()=>{
			alert('회원가입 클릭!!')
			$('head')
		.html(auth_vue.join_head)
			$('body')
		.html(auth_vue.join_body)
				
		$('<button>',{
			href : '#',
			text : 'join',
			click : e=>{
				e.preventDefault();
				let data = { cid : $('#userid').val(), 
						cpw : $('#password').val() }
				$.ajax({
					url : _+'/hcust/join',
					type : 'POST',
					dataType : 'json',
					data : JSON.stringify(data),
					contentType : 'application/json',
					success : d => {
						alert('AJAX 성공' +d.cid+', '+d.cpw)
						$('head')
						.html(auth_vue.login_head)
						$('body').addClass('text-center')
						.html(auth_vue.login_body)
					},
					error : e =>{
						alert('AJAX 실패' + url);
					}
				})
				
			}
		})
		.addClass('btn btn-primary btn-lg btn-block')
		.appendTo('#btn_join_test')


		});
	}
	return {onCreate : onCreate}
})();