"use strict";
var auth = auth || {};
auth = (()=>{
	const WHEN_ERR = '호출하는 JS파일을 찾지 못했습니다.'
	let _, js, authvuejs
	let init = ()=>{
		_ = $.ctx()
		js = $.js()
		authvuejs = js+'/vue/auth_vue.js'
	}
	let onCreate =()=>{
		init()
		$.getScript(authvuejs).done(()=>{
			setContentView()
			$('#a_go_join').click(()=>{
				join()
			})
		}).fail(()=>{alert(WHEN_ERR)})
	}
	
	let setContentView =()=>{
		login()
	}
	
	let join =()=>{
		$('head')
		.html(auth_vue.join_head)
			$('body')
		.html(auth_vue.join_body)
		$('<button>',{
          text : 'Continue to checkout' ,
          href: '#' ,
          click : e=>{
          e.preventDefault();
          let data = { cid :  $('#cid').val() ,
          cpw : $('#cpw').val(),
          cnum : $('#cnum').val()}
           $.ajax({
           url : _+'/hcust/join',
           type : 'POST',
           dataType : 'json',
           data: JSON.stringify(data) ,
           contentType : 'application/json',
           success : d =>{
        	   alert(d.cid +'님의 가입을 환영합니다.')
                  login()
           },
          error : e =>{alert('AJAX실패' + url)}
           
         })
          }
		})
         .addClass('btn btn-primary btn-lg btn-block')
         .appendTo('#btn_join_test')}
	
	
	let login =()=>{
		let x = {css : $.css(), img : $.img()}
        $('head').html(auth_vue.login_head(x))        
        $('body').addClass('text-center').html(auth_vue.login_body(x))     
        $('<button>',{
       	 text : 'Sign in',
       	 href : '#',
       	 click : e=>{
       		 e.preventDefault();
       		 let data = { cid : $('#cid').val(),
       		 		cpw : $('#cpw').val()}
       		 $.ajax({
       			 url : _+'/hcust/login',
       			 type : 'POST',
       			 dataType : 'json',
       			 data : JSON.stringify(data),
       			 contentType : 'application/json',
       			 success : d =>{
       				 alert(d.cnum + '님 환영합니다.')
       				 mypage(d)
       			 },
       			 error : e =>{alert('AJAX실패' + url)}
       		 })
       	 }
        })
        .addClass('btn btn-lg btn-primary btn-block')
        .appendTo('#login_btn')
	}
	
	let mypage =(d)=>{
	     $('head').html(auth_vue.mypage_head())      
	     $('body').html(auth_vue.mypage_body(d))      
	}
	
	
	return {onCreate, login, mypage, join}
})();
