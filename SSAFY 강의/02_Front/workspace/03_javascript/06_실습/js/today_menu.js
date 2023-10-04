// 데이터
// 파일이름과 음식이름을 빈 칸을 띄고 하나로 관리
let foods = [
    "burger 햄버거",
    "cake 케이크",
    "sandwich 샌드위치",
    "steak 스테이크"
];


// init
// 처음에 thumbnail 표시
function init(){
    let html = ""; // 빈 문자열
    let imgThumb = document.querySelector(".img-thumb");

    for(let i=0; i<foods.length; i++){
        let data = foods[i].split(" ");
        let fileName = data[0];
        let foodName = data[1];
        console.log(fileName);
        html += `<img src="./images/${fileName}.jpg" data-index="${i}">`;
    }
    imgThumb.innerHTML = html;

    // 0번째 이미지를 클릭한 경우. => 초기화
    chooseImg(0);
    // chooseImg(1);

    // thumbnails에다가 클릭 이벤트 핸들러 달기
    let thumbnails = document.querySelectorAll("div.img-thumb > img");
    for(let i=0; i<thumbnails.length; i++){
        thumbnails[i].addEventListener("click", function(){
            // chooseImg(i);
            chooseImg(this.getAttribute("data-index"));
        })
    }

    // 랜덤 선택 버튼 구현
    let btn = document.querySelector("#addBtn");
    btn.addEventListener("click", function(){
        // random으로 하나 선택하기
        // Math.random() => 0<  <1
        // Math.random() * 4 => 0< <4
        // window.parseInt(Math.random()*4) => 0, 1, 2, 3
        chooseImg(window.parseInt(Math.random()*4));
    });
}

init();

function chooseImg(index){
    let food = foods[index];
    let data = food.split(" ");
    console.log(data);  
    let fileName = data[0];
    let foodName = data[1];
    
    // 1. 오늘의 메뉴 querySelector 선택
    // Text를 오늘의 메뉴 + foodName
    let span = document.querySelector("#foodName");
    span.innerText = foodName;

    // 2. Image View querySelector로 선택
    // img src 속성을 fileName
    let img = document.querySelector("div.img-view > img");
    img.setAttribute("src", `./images/${fileName}.jpg`);

    // 3. 선택된 thumbnail은 choice 클래스
    // thumbnail은 여러개니까 querySelectorAll
    // 3-1. setAttribute("class", "choice")
    // img.setAttribute("class", "choice");

    let thumbnails = document.querySelectorAll("div.img-thumb > img");
    // thumbnails[index].setAttribute("class", "choice");

    // 3-2. classList
    // 다른 thumbnail의 클래스 초기화
    for(let i=0; i<thumbnails.length; i++){
        // thumbnails[i].setAttribute("class", "");
        thumbnails[i].classList.remove("choice");
    }
    thumbnails[index].classList.add("choice");
}