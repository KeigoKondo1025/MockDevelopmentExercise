window.addEventListener('DOMContentLoaded', () => {

	// 「送信」ボタンの要素を取得
	const submit = document.querySelector('.submit');

	// 「送信」ボタンの要素にクリックイベントを設定する
	submit.addEventListener('click', (e) => {
		// デフォルトアクションをキャンセル
		e.preventDefault();

		// 「ユーザー名」入力欄の空欄チェック
		// フォームの要素を取得
		const userName = document.querySelector('#user-name');
		// エラーメッセージを表示させる要素を取得
		const errMsgUserName = document.querySelector('.err-msg-user-name');
		if(!userName.value){
			// クラスを追加(エラーメッセージを表示する)
			errMsgUserName.classList.add('form-invalid');
			// エラーメッセージのテキスト
			errMsgUserName.textContent = 'ユーザー名が入力されていません';
			// クラスを追加(フォームの枠線を赤くする)
			userName.classList.add('input-invalid');
			// 後続の処理を止める
			return;
		}else{
			// エラーメッセージのテキストに空文字を代入
			errMsgUserName.textContent ='';
			// クラスを削除
			userName.classList.remove('input-invalid');
		}



		// 「email」入力欄の空欄チェック
		// フォームの要素を取得
		const email = document.querySelector('#email');
		// エラーメッセージを表示させる要素を取得
		const errMsgEmail = document.querySelector('.err-msg-email');
		if(!email.value){
			// クラスを追加(エラーメッセージを表示する)
			errMsgEmail.classList.add('form-invalid');
			// エラーメッセージのテキスト
			errMsgEmail.textContent = 'メールアドレスが入力されていません';
			// クラスを追加(フォームの枠線を赤くする)
			email.classList.add('input-invalid');
			// 後続の処理を止める
			return;
		}else{
			// エラーメッセージのテキストに空文字を代入
			errMsgEmail.textContent ='';
			// クラスを削除
			email.classList.remove('input-invalid');
		}


		// 「password」入力欄の空欄チェック
		// フォームの要素を取得
		const password = document.querySelector('#password');
		// エラーメッセージを表示させる要素を取得
		const errMsgPassword = document.querySelector('.err-msg-password');
		if(!password.value){
			// クラスを追加(エラーメッセージを表示する)
			errMsgPassword.classList.add('form-invalid');
			// エラーメッセージのテキスト
			errMsgPassword.textContent = 'パスワードが入力されていません';
			// クラスを追加(フォームの枠線を赤くする)
			password.classList.add('input-invalid');
			// 後続の処理を止める
			return;
		}else{
			// エラーメッセージのテキストに空文字を代入
			errMsgPassword.textContent ='';
			// クラスを削除
			password.classList.remove('input-invalid');
		}

		// 「パスワード」入力欄の形式チェック
		// パスワードが5文字以上の半角英数字であるかどうかのチェック
		if(!password.value.match(/^([a-zA-Z0-9]{5,})$/)){
			errMsgPassword.classList.add('form-invalid');
			errMsgPassword.textContent = '半角英数字5文字以上で入力してください';
			password.classList.add('input-invalid');
			return;
		}else{
			errMsgPassword.textContent ='';
			password.classList.remove('input-invalid');
		}

		// 「password(確認用)」入力欄の空欄チェック
		// フォームの要素を取得
		const againPassword = document.querySelector('#again-password');
		// エラーメッセージを表示させる要素を取得
		const errMsgAgainPassword = document.querySelector('.err-msg-again-password');
		if(!againPassword.value){
			// クラスを追加(エラーメッセージを表示する)
			errMsgAgainPassword.classList.add('form-invalid');
			// エラーメッセージのテキスト
			errMsgAgainPassword.textContent = 'パスワード(確認用)が入力されていません';
			// クラスを追加(フォームの枠線を赤くする)
			againPassword.classList.add('input-invalid');
			// 後続の処理を止める
			return;
		}else{
			// エラーメッセージのテキストに空文字を代入
			errMsgAgainPassword.textContent ='';
			// クラスを削除
			againPassword.classList.remove('input-invalid');
		}

		// 「パスワード」と「パスワード再入力」が一致しているかどうかのチェック
		if(password.value !== againPassword.value){
			errMsgAgainPassword.classList.add('form-invalid');
			errMsgAgainPassword.textContent = 'パスワードとパスワード再入力が一致していません';
			againPassword.classList.add('input-invalid');
			return;
		}else{
			errMsgAgainPassword.textContent ='';
			againPassword.classList.remove('input-invalid');
		}


		// 「苗字」入力欄の空欄チェック
		// フォームの要素を取得
		const familyName = document.querySelector('#family-name');
		// エラーメッセージを表示させる要素を取得
		const errMsgFamilyName = document.querySelector('.err-msg-family-name');
		if(!familyName.value){
			// クラスを追加(エラーメッセージを表示する)
			errMsgFamilyName.classList.add('form-invalid');
			// エラーメッセージのテキスト
			errMsgFamilyName.textContent = '苗字が入力されていません';
			// クラスを追加(フォームの枠線を赤くする)
			familyName.classList.add('input-invalid');
			// 後続の処理を止める
			return;
		}else{
			// エラーメッセージのテキストに空文字を代入
			errMsgFamilyName.textContent ='';
			// クラスを削除
			familyName.classList.remove('input-invalid');
		}



		const givenName = document.querySelector('#given-name');
		// エラーメッセージを表示させる要素を取得
		const errMsgGivenName = document.querySelector('.err-msg-given-name');
		if(!givenName.value){
			// クラスを追加(エラーメッセージを表示する)
			errMsgGivenName.classList.add('form-invalid');
			// エラーメッセージのテキスト
			errMsgGivenName.textContent = '名前が入力されていません';
				// クラスを追加(フォームの枠線を赤くする
			givenName.classList.add('input-invalid');
			// 後続の処理を止める
			return;
		}else{
			// エラーメッセージのテキストに空文字を代入
			errMsgGivenName.textContent ='';
			// クラスを削除
			givenName.classList.remove('input-invalid');
		}


		const birthday = document.querySelector('#birthday');
		// エラーメッセージを表示させる要素を取得
		const errMsgBirthday = document.querySelector('.err-msg-birthday');
		if(!birthday.value){
			// クラスを追加(エラーメッセージを表示する)
			errMsgBirthday.classList.add('form-invalid');
			// エラーメッセージのテキスト
			errMsgBirthday.textContent = '生年月日が入力されていません';
				// クラスを追加(フォームの枠線を赤くする
			birthday.classList.add('input-invalid');
			// 後続の処理を止める
			return;
		}else{
			// エラーメッセージのテキストに空文字を代入
			errMsgBirthday.textContent ='';
			// クラスを削除
			birthday.classList.remove('input-invalid');
		}

		const tel = document.querySelector('#tel');
		// エラーメッセージを表示させる要素を取得
		const errMsgTel = document.querySelector('.err-msg-tel');
		if(!tel.value){
			// クラスを追加(エラーメッセージを表示する)
			errMsgTel.classList.add('form-invalid');
			// エラーメッセージのテキスト
			errMsgTel.textContent = '電話番号が入力されていません';
				// クラスを追加(フォームの枠線を赤くする
			tel.classList.add('input-invalid');
			// 後続の処理を止める
			return;
		}else{
			// エラーメッセージのテキストに空文字を代入
			errMsgTel.textContent ='';
			// クラスを削除
			tel.classList.remove('input-invalid');
		}


		if(!tel.value.match(/^([0-9]{0,})$/)){
			errMsgTel.classList.add('form-invalid');
			errMsgTel.textContent = '数字を入力してください';
			tel.classList.add('input-invalid');
			return;
		}else{
			errMsgTel.textContent ='';
			tel.classList.remove('input-invalid');
		}




		const postalCode = document.querySelector('#postal-code');
		// エラーメッセージを表示させる要素を取得
		const errMsgPostalCode = document.querySelector('.err-msg-postal-code');
		if(!postalCode.value){
			// クラスを追加(エラーメッセージを表示する)
			errMsgPostalCode.classList.add('form-invalid');
			// エラーメッセージのテキスト
			errMsgPostalCode.textContent = '郵便番号が入力されていません';
				// クラスを追加(フォームの枠線を赤くする
			postalCode.classList.add('input-invalid');
			// 後続の処理を止める
			return;
		}else{
			// エラーメッセージのテキストに空文字を代入
			errMsgPostalCode.textContent ='';
			// クラスを削除
			postalCode.classList.remove('input-invalid');
		}


		if(!postalCode.value.match(/^([0-9]{7,7})$/)){
			errMsgPostalCode.classList.add('form-invalid');
			errMsgPostalCode.textContent = '正しい郵便番号を入力してください';
			postalCode.classList.add('input-invalid');
			return;
		}else{
			errMsgPostalCode.textContent ='';
			postalCode.classList.remove('input-invalid');
		}

		const address = document.querySelector('#address1');
		// エラーメッセージを表示させる要素を取得
		const errMsgAddress = document.querySelector('.err-msg-address1');
		if(!address.value){
			// クラスを追加(エラーメッセージを表示する)
			errMsgAddress.classList.add('form-invalid');
			// エラーメッセージのテキスト
			errMsgAddress.textContent = '市区町村が入力されていません';
				// クラスを追加(フォームの枠線を赤くする
			address.classList.add('input-invalid');
			// 後続の処理を止める
			return;
		}else{
			// エラーメッセージのテキストに空文字を代入
			errMsgAddress.textContent ='';
			// クラスを削除
			address.classList.remove('input-invalid');
		}


		document.signUpForm.submit();
		console.log("clear!");


	}, false);
}, false);
