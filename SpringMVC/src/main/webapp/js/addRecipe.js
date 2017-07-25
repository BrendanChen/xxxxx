/**
 * 
 */
window.onload = function() {
	
	// 加入食材
	document.querySelector('#addFoodBtn').addEventListener('click',
			function(event) {

		var addFoodBtn = document.querySelector('#groupName');   
		
		addFoodBtn.insertAdjacentHTML('afterend', "<div class='foodDiv'><div class='form-inline ingredient clearfix'><div class='form-group required maxlen'><input type='text'class='form-control ingredient-name required maxlen'placeholder='食材' name='iname' required='' value=''></div><div class='form-group required maxlen'><input type='text'class='form-control ingredient-unit required maxlen'placeholder='份量' name='quantity' required='' value=''></div><div class='pull-left edit-fn'><a class='btn btn-remove destroy removebtn'></a></div></div></div>");
		
		//刪除食材
		initFoodBlock();
		
		initFoodGroupBlock();
	})
}


function initFoodBlock(){
	
	var removebtn = document.getElementsByClassName("removebtn");
	
	var myFunction = function(event) {
		
		var parent = event.target.parentElement.parentElement.parentElement;
		
		parent.innerHTML = "";
		
	};
	
	for (var i = 0; i < removebtn.length; i++) {
		removebtn[i].addEventListener('click', myFunction, false);
	}
}


function initFoodGroupBlock(){
	
	console.log("init initFoodGroupBlock....");
	
	
	
	
}
