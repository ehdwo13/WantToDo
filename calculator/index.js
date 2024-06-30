const button = document.querySelectorAll('.btn');
const operator = document.querySelectorAll('.operator');
const clear = document.querySelector('.clear');
const display = document.getElementById('display');

let prevVal = 0;

document.querySelector('.clear').addEventListener('click',()=>{
    prevVal = 0;
    display.innerText = 0;
})