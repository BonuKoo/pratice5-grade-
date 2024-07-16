//학생용 등록 유효성 검사
function registStudent() {
        const form = document.studentForm;

        //학년
        const syear = form.syear.value;
        //반
        const sclass = form.sclass.value;
        //번호
        const sno = form.sno.value;
        //이름
        const sname = form.sname.value;
        //생년월일
        const birth = form.birth.value;
        //성별
        const gender = form.gender.value;

        //전화번호

        //전화번호1
        const tel1 = form.tel1.value;
        //전화번호2
        const tel2 = form.tel2.value;
        //전화번호3
        const tel3 = form.tel3.value;

        //학년
        if (syear === "") {
            alert("학년정보가 입력되지 않았습니다!");
            form.syear.focus();
            return;
        }//반
        if (sclass === "") {
            alert("반정보가 입력되지 않았습니다!");
            form.sclass.focus();
            return;
        }//번호
        if (sno === "") {
            alert("번호정보가 선택되지 않았습니다!");
            form.sno.focus();
            return;
        }//이름
        if (sname === "") {
            alert("이름이 입력되지 않았습니다!");
            form.sname.focus();
            return;
        }//생년월일
        if (birth === "") {
            alert("생년월일이 입력되지 않았습니다!");
            form.birth.focus();
            return;
        }//성별
        if (gender === "") {
            alert("성별을 선택하세요!");
            form.gender.focus();
            return;
        }//전화번호
        if (tel1 === "" || tel2 === "" || tel3 === "") {
            alert("전화번호가 입력되지 않았습니다");
            form.tel1.focus();
            return;
        }

        alert("성적입력이 정상적으로 등록되었습니다.");
        form.submit();
    }
//학생용 등록 다시쓰기
function resetStudent(){
	const form = document.studentForm;
	window.alert("정보를 지우고 처음부터 다시 입력 합니다.")
	studentForm.reset();
	studentForm.syear.focus();
}


//점수 등록 유효성 검사
function registScore() {
        const form = document.scoreForm;

        //학년
        const syear = form.syear.value;
        //반
        const sclass = form.sclass.value;
        //번호
        const sno = form.sno.value;
        //국어
        const kor = form.kor.value;
        //영어
        const eng = form.eng.value;
        //수학
        const mat = form.mat.value;

        //학년
        if (syear === "") {
            alert("학년정보가 입력되지 않았습니다");
            form.syear.focus();
            return;
        }//반
        if (sclass === "") {
            alert("반정보가 입력되지 않았습니다");
            form.sclass.focus();
            return;
        }//번호
        if (sno === "") {
            alert("번호정보가 선택되지 않았습니다");
            form.sno.focus();
            return;
        }//국어
        if (kor === "") {
            alert("국어성적이 입력되지 않았습니다");
            form.kor.focus();
            return;
        }//영어
        if (eng === "") {
            alert("영어성적 선택하세요!");
            form.eng.focus();
            return;
        }//수학
        if (mat === "") {
           alert("수학성적 선택하세요!");
           form.mat.focus();
           return;
        }

        alert("성적입력이 정상적으로 등록되었습니다.");
        form.submit();
    }
//점수 등록 다시쓰기
function resetScore(){
	const form = document.scoreForm;
	window.alert("정보를 지우고 처음부터 다시 입력 합니다.")
	scoreForm.reset();
	scoreForm.syear.focus();
}