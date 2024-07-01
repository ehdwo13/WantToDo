const display = document.getElementById('display');

let currentVal = '';
let prevVal = '';
let operator = '';
let isNewVal = false; // 새 값을 입력하는 중인지 여부

// clear 버튼 클릭 이벤트
document.querySelector('.clear').addEventListener('click', () => {
    currentVal = '';
    prevVal = '';
    operator = '';
    display.innerText = 0;
    isNewVal = false;
});

// buttons 클릭 이벤트
document.querySelector('.buttons').addEventListener('click', (e) => {
    const target = e.target;
    const value = target.innerText;

    if (target.classList.contains('btn') && !target.classList.contains('clear')) { // clear 버튼은 제외
        if (target.classList.contains('operator')) {
            handleOperator(value);
        } else if (target.classList.contains('calc')) {
            calculate();
        } else {
            handleNumber(value);
        }
    }
});

// 숫자 버튼 처리 함수
function handleNumber(value) {
    if (isNewVal) {
        currentVal = value === '.' ? '0.' : value;
        isNewVal = false;
    } else {
        if (value === '.' && currentVal.includes('.')) return;
        currentVal += value;
    }
    display.innerText = currentVal;
}

// 연산자 버튼 처리 함수
function handleOperator(value) {
    if (currentVal === '' && value !== '-') return; // 음수 처리를 위한 조건
    if (operator !== '') calculate();
    prevVal = currentVal;
    currentVal = '';
    operator = value;
    isNewVal = true;
}

// 계산 함수
function calculate() {
    if (prevVal === '' || currentVal === '') return;

    let result;
    const prev = parseFloat(prevVal);
    const current = parseFloat(currentVal);

    switch (operator) {
        case '+':
            result = prev + current;
            break;
        case '-':
            result = prev - current;
            break;
        case '*':
            result = prev * current;
            break;
        case '/':
            result = prev / current;
            break;
        default:
            return;
    }

    currentVal = result.toString();
    operator = '';
    display.innerText = currentVal;
    isNewVal = true;
}
